/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Commentaire;
import Entities.User;
import Services.CommentaireServices;
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
import java.util.ArrayList;

/**
 *
 * @author Imene
 */
public class coms {
      Form f;
    
     Label description;
     Label StatDescription;
       Label description1;
     Label StatDescription1;
        Container conte;
      private Commentaire co;
      Toolbar menu;
     public coms(){
         f=new Form() ;
               
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
       CommentaireServices serviceTask=new CommentaireServices();
        ArrayList<Commentaire> lis=serviceTask.getList();
  
         StatDescription =new Label("Commentaire 1 :");
        description=new Label();
         StatDescription1 =new Label("Commentaire 2 :");
        description1=new Label();
       
    
         f.add(description);
         
       
       f.add(description1);
       

}

    public Label getDescription() {
        return description;
    }

 public void setDescription(String description) {
       this.description.setText(description);
    }
    public Label getDescription1() {
        return description1;
    }

 public void setDescription1(String description1) {
       this.description1.setText(description1);
    }
    public Commentaire getCo() {
        return co;
    }

    public void setCo(Commentaire co) {
        this.co = co;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     
}