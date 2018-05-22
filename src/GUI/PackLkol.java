/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entitiies.Pack;
import Entitiies.Produit;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import java.util.ArrayList;
import Entitiies.User;
import Serviices.UserServices;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;


/**
 *
 * @author Asus-PC
 */
public class PackLkol {
    
   Form f;
     Label StatDate;
     Label StatLieu;
     Label date;
     Label id;
    List lstUser;
    EncodedImage enc;
    Image img;
    ImageViewer imv;
    Button plus;
    Container conte;
  Toolbar menu;
    public PackLkol() {
        
     
        f = new Form("Nos Pack",new BoxLayout(BoxLayout.Y_AXIS));
      
        
        menu=f.getToolbar();
    
        menu.addMaterialCommandToSideMenu("Profil",FontImage.MATERIAL_HOME, e->{ 
          Entities.User ussr=Entities.User.getInstance();
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
     
        
        menu.addMaterialCommandToSideMenu("Déconnexion",FontImage.MATERIAL_CANCEL, e->{ Entities.User uu=new Entities.User();
           uu.sedeconnecter();
            HomeForm hf=new HomeForm();
             hf.getF().show();});  
        
        
        
        
        
        
        lstUser=new List();
      
        
        UserServices serviceTask=new UserServices();
        ArrayList<Pack> lis=serviceTask.PackLkol();
        for(int i=0;i<lis.size();i++){
          
       final Pack yo=lis.get(i);
       
  
                
              
       conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        StatDate=new Label("Date :");
       
   
      
       
       StatLieu=new Label("Lieu :");
       
      id=new Label();
      
      lstUser.addItem(lis.get(i)); 
       
      plus=new Button("Cosnulter "+lis.get(i).getIdPack()+" ");
     

     conte.add(id);
     conte.add(plus);
     
     f.add(conte);
     
     
   plus.addActionListener((e)->{ 
    UserServices  us=new UserServices();
      
    ArrayList<Produit> lstU=us.PackDetails(yo.getIdPack());
       
    DetailsPack dev=new DetailsPack();
    
   dev.setSalle(lstU.get(0).getNom());
    dev.setMusique(lstU.get(1).getNom());
     dev.setFleurs(lstU.get(2).getNom());
    dev.setAime(""+yo.getAime());
   
    

    dev.setLui(yo);
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
    
}
