/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Stories;
import Entities.User;
import Services.StorieServices;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Imene
 */
   
public class AffichageCommentaire {
 
 TextField description;
 Button btnajout,btnaff,Choix;
Form f,hi;
     Label StatDescription;
     Label StatTitre;
     Label desc;
     Label titre;

    com.codename1.ui.List lstEv;
    EncodedImage enc;
    Image img;
    ImageViewer imv;
    Button plus;
    Container conte;
   Toolbar menu;
     
   
     
    public AffichageCommentaire() {
           f = new Form("Stories",new BoxLayout(BoxLayout.Y_AXIS));
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
        lstEv=new com.codename1.ui.List();
      
        
        StorieServices serviceTask=new StorieServices();
        ArrayList<Stories> lis=serviceTask.getList();
        for(int i=0;i<lis.size();i++){
          
       final Stories yo=lis.get(i);
       
      
              
       conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
  StatDescription=new Label("Description :");
       StatTitre=new Label("Titre :");
desc=new Label(lis.get(i).getDescription());
titre=new Label(lis.get(i).getTitre());
        

description = new TextField();
   btnajout = new Button("Consulter Storie : "+lis.get(i).getTitre()+"" );
        Choix=new Button("choisissez la musique qui correspond le mieux à notre storie");
    
         lstEv.addItem(lis.get(i)); 
  
   
 
   

       
      
        conte.add(btnajout);
            conte.add(Choix); 
     f.add(conte);
        
     btnajout.addActionListener((e) -> {
     DetailStories dev=new DetailStories();
 dev.setTitre(yo.getTitre());
 dev.setDescription(yo.getDescription());
 dev.setLui(yo);
  dev.getF().show();
   //dev.setTitre(lis.get(0).getTitre());
        });
      
        Choix.addActionListener((e)->{
         hi = new Form("Capture", BoxLayout.y());
         
hi.setToolbar(new Toolbar());
 hi.getToolbar().addCommandToRightBar("back", null, (ev)->{AffichageCommentaire h=new AffichageCommentaire(); h.getF().show();  });
Style s = UIManager.getInstance().getComponentStyle("Title");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_MIC, s);

FileSystemStorage fs = FileSystemStorage.getInstance();
String recordingsDir = fs.getAppHomePath() + "recordings/";
fs.mkdir(recordingsDir);
try {
    for(String file : fs.listFiles(recordingsDir)) {
        MultiButton mb = new MultiButton(file.substring(file.lastIndexOf("/") + 1));
        mb.addActionListener((f) -> {
            try {
                Media m = MediaManager.createMedia(recordingsDir + file, false);
                m.play();
            } catch(IOException err) {
                Log.e(err);
            }
        });
        hi.add(mb);
    }

    hi.getToolbar().addCommandToRightBar("", icon, (ev) -> {
        try {
            String file = Capture.captureAudio();
            if(file != null) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd-kk-mm");
                String fileName =sd.format(new Date());
                String filePath = recordingsDir + fileName;
                Util.copy(fs.openInputStream(file), fs.openOutputStream(filePath));
                MultiButton mb = new MultiButton(fileName);
                mb.addActionListener((f) -> {
                    try {
                        Media m = MediaManager.createMedia(filePath, false);
                        m.play();
                    } catch(IOException err) {
                        Log.e(err);
                    }
                });
                hi.add(mb);
                hi.revalidate();
            }
        } catch(IOException err) {
            Log.e(err);
        }
    });
} catch(IOException err) {
    Log.e(err);
}
hi.show();
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
