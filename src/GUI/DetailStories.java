/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commentaire;
import Entities.Stories;
import Entities.User;
import Services.CommentaireServices;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Imene
 */
public class DetailStories {
      Form f;
     Label description;
     Label titre;
     Label StatCom;
  
     Label StatDescription ; 
     Label StatTitre;
     TextField com;
     
    private Stories lui;
      Button Ajouter;
      Button Afficher;

    Container conte;
   Toolbar menu;
     public DetailStories() {
           f = new Form("azer",new BoxLayout(BoxLayout.Y_AXIS));
        com=new TextField();
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
      //conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
      
      CommentaireServices serviceTask=new CommentaireServices();
        ArrayList<Commentaire> lis=serviceTask.getList();
      
       
          
    
       
         Ajouter=new Button("Ajouter les Commentaires");
         Afficher= new Button("Consulter Commentaire" );
       
        StatDescription =new Label("Description :");
        description=new Label();
        
        StatTitre =new Label("Titre :");
        titre =new Label();
        
        StatCom=new Label("Votre Commentaire");
       
        
      
        
       
 
        f.add(StatDescription);
        f.add(description);
        f.add(StatTitre);
        f.add(titre);
        f.add(StatCom);
   
       f.add(com);
        f.add(Ajouter);
        f.add(Afficher);
       
        //f.add(conte);
     
       Ajouter.addActionListener((e)->{ 
          CommentaireServices ser=new CommentaireServices();
        Commentaire c = new Commentaire(com.getText());
       System.out.println(lui.getIdStorie());
       ser.ajoutCommentaire(c);
     c.setIdStorie(1);
         // ser.updatecom(238,lui.getIdStorie());  
          
 }); 
  Afficher.addActionListener((e)->{ 
     CommentaireServices ser=new CommentaireServices();
      coms c = new coms();
        ArrayList<Commentaire> lstU= ser.Commentaire();
  
      for(int k=0;k<lstU.size();k++){
            Commentaire yo=lstU.get(k);
            c.setDescription(lstU.get(0).getDescription());
          c.setDescription1(lstU.get(1).getDescription());
           // c.setDescription2(lstU.get(2).getDescription());
      }
       
       
      
       c.getF().show();
  
  });
        

     }
    public Label getDescription() {
        return description;
    }

    public void setDescription(String description) {
       this.description.setText(description);
    }

    public Label getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
       this.titre.setText(titre);
    }
     
 public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Stories getLui() {
        return lui;
    }

    public void setLui(Stories lui) {
        this.lui = lui;
    }

   
}
