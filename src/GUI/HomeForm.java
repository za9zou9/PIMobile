/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entities.User;

import Services.UserServices;
import com.codename1.capture.Capture;

import com.codename1.components.ImageViewer;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;

import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;

import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;

import com.codename1.ui.layouts.BoxLayout;
import java.util.ArrayList;

import java.io.IOException;
//import rest.file.uploader.tn.FileUploader;



/**
 *
 * @author skan
 */
public class HomeForm {

    Form ff;
    TextField tusername;
    TextField tmdp;
    Label lpseudo,lmdp;
    Button btnValider,btnSignIn;
Container f;

    public HomeForm() {
        ff = new Form("MySoulmate");
        f=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        tusername = new TextField();
        tmdp = new TextField();
        tmdp.setConstraint(TextField.PASSWORD);
      
        lpseudo=new Label("Pseudo");
        lmdp=new Label("Mot de passe");
        btnValider = new Button("Valider");
        btnSignIn = new Button("S'inscrire");
        f.add(lpseudo);
        f.add(tusername);
        f.add(lmdp);
        f.add(tmdp);
        f.add(btnValider);
       f.add(btnSignIn);
       ff.add(f);
        btnValider.addActionListener((e)->{
           
        UserServices serviceTask=new UserServices();
        
       
           
            if ((tmdp.getText().equals(""))||(tusername.getText().equals(""))) 
            Dialog.show("Erreur", "Champ(s) vide(s)","OK","Cancel");
        else if ((tmdp.getText().equals("admin"))&&(tusername.getText().equals("admin"))) 
            Dialog.show("Erreur", "Informations non valides","OK","Cancel");
        
        else{
        ArrayList<User> skrra=serviceTask.getUserPourLogin(tusername.getText());
      
         if (skrra.size()==0)
           Dialog.show("Erreur", "Informations non valides","OK","Cancel"); 
        else if ((skrra.size()!=0)&&(serviceTask.getUserPourLogin(tusername.getText()).get(0).getPassword().equals(tmdp.getText()+"{"+skrra.get(0).getSalt()+"}")==false))
        Dialog.show("Erreur", "Informations non valides","OK","Cancel");  
                else {
            
       
         Profil p=new Profil();   
           User ussr=skrra.get(0);
        User.setInstance(ussr);
            
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
             p.getFf().show();
       
        }
       
        }
        });
        
        
        
        btnSignIn.addActionListener((e)->{
     SignIn s=new SignIn();
     s.getFf().show();
  
            
       
        });
        
        
        
    }

    public Form getF() {
        return ff;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public TextField getTusername() {
        return tusername;
    }

    public void setTusername(TextField tusername) {
        this.tusername = tusername;
    }

    public TextField getTmdp() {
        return tmdp;
    }

    public void setTmdp(TextField tmdp) {
        this.tmdp = tmdp;
    }

    

}
