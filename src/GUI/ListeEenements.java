/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.User;
import Services.EvenementServices;
import Services.UserServices;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;

import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;

import java.util.ArrayList;


/**
 *
 * @author skan
 */
public class ListeEenements {
     Form f;
     Label StatDate;
     Label StatLieu;
     Label date;
     Label lieu;
    List lstEv;
    EncodedImage enc;
    Image img;
    ImageViewer imv;
    Button plus;
    Container conte;
   Toolbar menu;
        
        
     public ListeEenements() {
        
        f = new Form("Evenements à venir",new BoxLayout(BoxLayout.Y_AXIS));
     
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
      
        
        EvenementServices serviceTask=new EvenementServices();
        ArrayList<Evenement> lis=serviceTask.getListEventsFuturs();
        for(int i=0;i<lis.size();i++){
          
       final Evenement yo=lis.get(i);
       
       try {
                    enc = EncodedImage.create("/giphy.gif");
                } catch (IOException ex) {
                    //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                String url= "http://localhost/MySoulmates/web/images/";
               
                img = URLImage.createToStorage(enc, "img"+url+lis.get(i).getImage(), url+lis.get(i).getImage(), URLImage.RESIZE_SCALE);
                imv = new ImageViewer(img);
       conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        StatDate=new Label("Date :");
       
       date=new Label(""+lis.get(i).getDate());
      
       
       StatLieu=new Label("Lieu :");
       
       lieu=new Label(lis.get(i).getLieu());
      
      lstEv.addItem(lis.get(i)); 
       
      plus=new Button("Cosnulter");
     
     conte.add(imv);
     conte.add(StatDate);
     conte.add(date);
     conte.add(StatLieu);
     conte.add(lieu);
     conte.add(plus);
     
     f.add(conte);
     
     
   plus.addActionListener((e)->{ 
       UserServices us=new UserServices();
    DetailEvenement dev=new DetailEvenement();
    ArrayList<User> lista=us.getParticipants(yo.getIdEvenement());
      
      for(int h=0;h<lista.size();h++){
          Label lab=new Label();
          int hh=h+1;
      lab.setText(""+hh+") "+lista.get(h).getUsername());
      dev.conte.add(lab);
      }
    
        User ussr=User.getInstance();
    dev.setDesc(yo.getDescription());
     dev.setLui(yo);
   if (verifierParticipation(ussr.getId(), yo.getIdEvenement())==true) dev.participer.setEnabled(false);
   else dev.pasparticiper.setEnabled(false);
   dev.getF().show();
   });
     
       
        }
        
       
        
       
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
     
    
    public boolean verifierParticipation(int id,int idE){
    boolean verif=false;
        UserServices  us=new UserServices();
    ArrayList<User> lstU=us.getParticipants(idE);
   for(int i=0;i<lstU.size();i++){
    if (lstU.get(i).getId()==id) verif=true;
    }
    return verif;
    }
    
    
    
    
    
}
