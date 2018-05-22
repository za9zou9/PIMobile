/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.MenuBar;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author skan
 */
public class Profil {
    
    private User moi;
     EncodedImage enc;
    Image img;
    ImageViewer imv;
    
     Label lusername,lemail,lnom,lprenom,ldate,limage,letat,lsexe,lage,ltel;
    Container f;
    Form ff;
Toolbar menu;
    public Profil() {
      ff = new Form("Profil",new BoxLayout(BoxLayout.Y_AXIS));
       
      menu=ff.getToolbar();
    
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
      f=new Container(new BoxLayout(BoxLayout.Y_AXIS));
      
      
     lusername=new Label();
        lemail=new Label();
       
        lnom=new Label();
        lprenom=new Label();
        ldate=new Label();
        limage=new Label();
        letat=new Label();
        lsexe=new Label();
        lage=new Label();
        ltel=new Label();
        
      
      
       
         
         ff.add(f);
         
         
         
         
       

         

         
         
         
       
    }

    public Form getFf() {
        return ff;
    }

    public void setFf(Form ff) {
        this.ff = ff;
        
        
        
    }

    public User getMoi() {
        return moi;
    }

    public void setMoi(User moi) {
        this.moi = moi;
    }

    public void setEnc(EncodedImage enc) {
        this.enc = enc;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public void setImv(ImageViewer imv) {
        this.imv = imv;
    }

    public void setLusername(String lusername) {
        this.lusername.setText(lusername);
    }

    public void setLemail(String lemail) {
        this.lemail.setText(lemail);
    }

    public void setLnom(String lnom) {
        this.lnom.setText(lnom);
    }

    public void setLprenom(String lprenom) {
        this.lprenom.setText(lprenom);
    }

    public void setLdate(String ldate) {
        this.ldate.setText(""+ldate);
    }

    public void setLimage(String limage) {
        this.limage.setText(limage);
    }

    public void setLetat(String letat) {
        this.letat.setText(letat);
    }

    public void setLsexe(String lsexe) {
        this.lsexe.setText(lsexe);
    }

    public void setLage(String lage) {
        this.lage.setText(""+lage);
    }

    public void setLtel(String ltel) {
        this.ltel.setText(ltel);
    }
    
    
    
    
}
