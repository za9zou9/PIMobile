/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entitiies.MesAmis;
import Entitiies.MesPack;
import Entitiies.Pack;
import Entitiies.User;
import Serviices.UserServices;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
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
 * @author Asus-PC
 */
public class DetailsPack {
          Form f;
     Label salle;
     
     Label fleurs;
     
     Label musique;
     Label aime ; 
     Label StatDesc3 ; 
     Label StatDesc;
     Label StatDesc1;
     Label StatDesc2;
    private Pack lui;
      Button Ajouter;
   Button aimes;
  private int Aimes ; 
    Container conte;
   Toolbar menu;
     public DetailsPack() {
        
      conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
       
         Ajouter=new Button("Ajouter a Mes Packs");
        aimes = new Button("J'aime "); 
       
        StatDesc =new Label("Salle :");
        salle=new Label();
        
        StatDesc1 =new Label("Musique :");
        musique =new Label();
        
        StatDesc2 =new Label("Fleurs :");
        fleurs = new Label();
        
        StatDesc3 =new Label("nombre de J'aime:");
        aime = new Label();
        
        
        f = new Form();
        
         menu=f.getToolbar();
    Entities.User ussr=Entities.User.getInstance();
        menu.addMaterialCommandToSideMenu("Profil",FontImage.MATERIAL_HOME, e->{ 
          
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
     GUI.MesAmis ma=new GUI.MesAmis();
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
     
          menu.addMaterialCommandToSideMenu("Déconnexion",FontImage.MATERIAL_CANCEL, e->{ Entities.User uu=new Entities.User();
           uu.sedeconnecter();
            HomeForm hf=new HomeForm();
             hf.getF().show();});
      
        
        
        
        conte.add(StatDesc);
        conte.add(salle);
        conte.add(StatDesc1);
        conte.add(musique);
        conte.add(StatDesc2);
        conte.add(fleurs);
         conte.add(StatDesc3);
        conte.add(aime);
        conte.add(Ajouter);
        conte.add(aimes);
       
        f.add(conte);
     
       Ajouter.addActionListener((e)->{ 
    UserServices  us=new UserServices();
    ArrayList<MesPack> lstE=us.AjouterMesPack(lui.getIdPack(), ussr.getId());
    Ajouter.setEnabled(false);
   
    
   }); 
       
       
        aimes.addActionListener((e)->{ 
    UserServices  us=new UserServices();
    Aimes = lui.getAime() + 1 ;
    ArrayList<Pack> lstE=us.UpdateAime(lui.getIdPack(), Aimes);
    aimes.setEnabled(false);
   
    
   }); 
        
 }
     
     
      
     
     

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle.setText(salle);
    }

  
public Pack getLui() {
        return lui;
    }

    public void setLui(Pack lui) {
        this.lui = lui;
    }

    public Label getFleurs() {
        return fleurs;
    }

    public void setFleurs(String fleurs) {
        this.fleurs.setText(fleurs);
    }

    public Label getMusique() {
        return musique;
    }

    public void setMusique(String musique) {
         this.musique.setText(musique);
    }

   
 public Label getAime() {
        return musique;
    }

    public void setAime(String aime) {
         this.aime.setText(aime);
    }
   
}
