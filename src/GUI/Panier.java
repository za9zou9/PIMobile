/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commande;
import Entities.Produit;
import Entities.User;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 *
 * @author Imene
 */
public class Panier {
     Form f;
      Container conte;
         private Commande comman;
         private Produit prod;
           Label nom ; 
     Label StatNom ; 
      Label nom1 ; 
     Label StatNom1 ; 
     Label prix;
     Label StatPrix;
       Label prix1;
     Label StatPrix1;
     Label quantite;
     Label StatQuantite;
      Label quantite1;
     Label StatQuantite1;
     Toolbar menu;
         public Panier(){
              
         conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
      
        StatNom =new Label("Nom :");
        nom=new Label();
         StatNom1 =new Label("Nom :");
        nom1=new Label();
        StatPrix =new Label("Prix :");
        prix=new Label();
          StatPrix1 =new Label("Prix :");
        prix1=new Label();
        f=new Form();
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
        StatQuantite =new Label("Quantite :");
        quantite=new Label();
         StatQuantite1 =new Label("Quantite :");
        quantite1=new Label();
         conte.add(StatNom);
        conte.add(nom);
       
        
         conte.add(StatPrix);
        conte.add(prix);
        
       
         conte.add(StatQuantite);
        conte.add(quantite);
         conte.add(StatNom1);
        conte.add(nom1);
         conte.add(prix1);
           conte.add(StatPrix1);
             conte.add(StatQuantite1);
        conte.add(quantite1);
        f.add(conte);
       
         }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Container getConte() {
        return conte;
    }

    public void setConte(Container conte) {
        this.conte = conte;
    }

    public Commande getComman() {
        return comman;
    }

    public void setComman(Commande comman) {
        this.comman = comman;
    }

    public Produit getProd() {
        return prod;
    }

    public void setProd(Produit prod) {
        this.prod = prod;
    }

    public Label getNom() {
        return nom;
    }

    public void setNom(String nom) {
      this.nom.setText(nom);
    }

    public Label getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix.setText(prix);
    }

   public Label getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite.setText(quantite);
    }

    public Label getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1.setText(nom1) ;
    }

    public Label getPrix1() {
        return prix1;
    }

    public void setPrix1(String prix1) {
        this.prix1.setText(prix1);
    }

    public Label getQuantite1() {
        return quantite1;
    }

    public void setQuantite1(String quantite1) {
        this.quantite1.setText(quantite1);
    }
         
}
