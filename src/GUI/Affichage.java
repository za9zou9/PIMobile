/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Entities.Produit;
import Entities.User;
import Services.CommandeServices;
import Services.ProduitServices;
import GUI.Panier;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Imene
 */
public class Affichage {
     public ObservableList<Produit> data2=FXCollections.observableArrayList();
    
      public ObservableList<Commande> data=FXCollections.observableArrayList();
       Form f;
     Label StatPrix;
     Label StatNom;
     Label prix;
     Label nom;
     Label StatDescription;
     Label description;
     Label type;
     Label StatType;
     Label quantite;
     Label StatQuantite;
     Label region;
     Label StatRegion;
     Label StatQ;
    com.codename1.ui.List lstEv;
    EncodedImage enc;
    Image img;
    ImageViewer imv;
    Button plus;
    Container conte;
   Toolbar menu;
   Button panier;
 public Affichage(){
       
        f = new Form("Produits",new BoxLayout(BoxLayout.Y_AXIS));
        menu=f.getToolbar();
    
        menu.addMaterialCommandToSideMenu("Profil",FontImage.MATERIAL_HOME, e->{ 
          User ussr=User.getInstance();
                 Profil p=new Profil();   
         
          p.setLusername("Pseudo: "+ussr.getUsername());
         p.setLemail("Email: "+ussr.getEmail());
           p.setLnom("Nom: "+ussr.getNom());
            p.setLprenom("Prénom: "+ussr.getPrenom());
             p.setLdate("Date de naissance: "+ussr.getDateDeNaissance());
              p.setLetat("Etat: "+ussr.getEtat());
         p.setLsexe("Sexe: "+ussr.getSexe());
         p.setLage("Age: "+ussr.getAge());
          p.setLtel("Téléphone: "+ussr.getTel());
             String url= "http://localhost/MySoulmates/web/images/";
            try {
                    p.enc = EncodedImage.create("/giphy.gif");
                } catch (IOException ex) {
                    //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
             
            
               
              
             p.img = URLImage.createToStorage(p.enc, "img"+url+ussr.getImage(), url+ussr.getImage(), URLImage.RESIZE_SCALE);
         p.imv = new ImageViewer(p.img);
         p.f.add(p.imv);
         p.f.add(p.lnom);
   
   p.f.add(p.lprenom);
   
    p.f.add(p.lage);
   
    p.f.add(p.lsexe);
   
      p.f.add(p.ldate); 
    
     p.f.add(p.lemail);
       
        p.f.add(p.ltel);
        
         p.f.add(p.letat);
         p.f.add(p.lusername);
             p.getFf().show();   });
      menu.addMaterialCommandToSideMenu("Evénements",FontImage.MATERIAL_EVENT_AVAILABLE, e->{ ListeEenements ll=new ListeEenements();
           ll.getF().show();});
    
      
      
      menu.addMaterialCommandToSideMenu("Les Packs",FontImage.MATERIAL_CARD_GIFTCARD, e->{ 
      PackLkol pckl=new PackLkol();
      pckl.getF().show();
      });
      
       menu.addMaterialCommandToSideMenu("Nos Membres",FontImage.MATERIAL_PERSON, e->{ 
      Userlkol usl=new Userlkol();
      usl.getF().show();
      });
       
        menu.addMaterialCommandToSideMenu("Mes Amis",FontImage.MATERIAL_PEOPLE, e->{ 
     MesAmis ma=new MesAmis();
     ma.getF().show();
      });
     
          menu.addMaterialCommandToSideMenu("Mes Produits",FontImage.MATERIAL_SHOP, e->{ 
    Affichage aff=new Affichage();
     aff.getF().show();
      });
          
          menu.addMaterialCommandToSideMenu("Stories",FontImage.MATERIAL_LOYALTY, e->{ 
    AffichageCommentaire aff=new AffichageCommentaire();
     aff.getF().show();
      }); 
        
        menu.addMaterialCommandToSideMenu("Déconnexion",FontImage.MATERIAL_CANCEL, e->{ User uu=new User();
           uu.sedeconnecter();
            HomeForm hf=new HomeForm();
             hf.getF().show();});
        lstEv=new List();
      
        
        ProduitServices serviceTask=new ProduitServices();
        ArrayList<Produit> lis=serviceTask.getList2();
        panier=new Button("voir mon panier");
         f.add(panier);
        for(int i=0;i<lis.size();i++){
          
       final Produit yo=lis.get(i);
       
      
      
       conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
  StatNom=new Label("Nom :");
       StatPrix=new Label("Prix :");
       nom=new Label(lis.get(i).getNom());
      prix=new Label(""+lis.get(i).getPrix());
      StatDescription=new Label("Description:");
      description=new Label(lis.get(i).getDescription());
      StatType=new Label("Type:");
      type=new Label(lis.get(i).getType());
      StatQuantite=new Label("Quantite:");
      quantite=new Label(""+lis.get(i).getQuantite());
      StatRegion=new Label("Region:");
      region=new Label(lis.get(i).getRegion());
      StatQ=new Label("Quantite:");
      TextField qte=new TextField();
      lstEv.addItem(lis.get(i)); 
       
      plus=new Button("Passer Commande");
      
     
   
     conte.add(StatNom);
     conte.add(nom);
     conte.add(StatPrix);
     conte.add(prix);
     conte.add(StatDescription);
     conte.add(description);
     conte.add(StatType);
     conte.add(type);
     conte.add(StatQuantite);
     conte.add(quantite);
     conte.add(StatRegion);
     conte.add(region);
     conte.add(StatQ);
     conte.add(qte);
     conte.add(plus);
     
     
     
     f.add(conte);
     
      
   plus.addActionListener((e)->{ 
       CommandeServices cs=new CommandeServices();
       System.out.println(yo.getIdProduit());
     
  cs.ajoutCommande(yo.getIdProduit(),Integer.parseInt(qte.getText()));
    
   });
    }
         panier.addActionListener((e)->{
          
          Panier dev=new Panier();
      CommandeServices ComTask1=new CommandeServices();
         java.util.List datavalue2 =  ComTask1.getList();
  data = FXCollections.observableArrayList(datavalue2);
  ProduitServices ps=new ProduitServices();
  java.util.List dataval=ps.getList2();
  data2=FXCollections.observableArrayList(dataval);
              int z=data.size();
              int b=data2.size();
                   dev.setNom(data2.get(0).getNom());
             dev.setPrix(""+data2.get(0).getPrix());
                  dev.setQuantite(""+data.get(0).getQuantite());
                
                  
                     dev.setNom1(data2.get(1).getNom());
             dev.setPrix1(""+data2.get(1).getPrix());
                  dev.setQuantite1(""+data.get(1).getQuantite());
 dev.getF().show();
    });
     
 }
    

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
 
       
}
