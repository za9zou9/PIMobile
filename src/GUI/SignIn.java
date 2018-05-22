/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.User;
import Services.UserServices;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GroupLayout.Group;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.spinner.Picker;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.DatePicker;

//import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author skan
 */
public class SignIn {
    
     Form ff;
     TextField username,email,password,nom,prenom,image,age,tel;
     Label lusername,lemail,lpassword,lnom,lprenom,ldate,limage,letat,lsexe,lage,ltel;
   private Picker dateP;
   RadioButton genreF,genreM,etatCel,etatCoup;
     Button valider;
     Container f;
     

    public SignIn() {
        
         ff = new Form("Inscription");
        
         f=new Container(new BoxLayout(BoxLayout.Y_AXIS));
         
        lusername=new Label("Pseudo");
        lemail=new Label("Email");
        lpassword=new Label("Mot de passe");
        lnom=new Label("Nom");
        lprenom=new Label("Prenom");
        ldate=new Label("Date de Naissance");
        limage=new Label("Votre photo");
        letat=new Label("Etat");
        lsexe=new Label("Sexe");
        lage=new Label("Age");
        ltel=new Label("Téléphone");
        
        username=new TextField();
        email=new  TextField();
        password=new  TextField();
        nom= new TextField();
        prenom=new TextField();
        image=new TextField();
        age=new TextField();
        tel=new TextField();
        
        
       
        genreF=new RadioButton("Femme");
        genreF.setGroup("gender");
        genreM=new RadioButton("Homme");
         genreM.setGroup("gender");
        etatCel=new RadioButton("Célibataire");
         etatCel.setGroup("leetat");
        etatCoup=new RadioButton("En Couple");
        etatCoup.setGroup("leetat");
        
        dateP=new Picker();
        dateP.setType(Display.PICKER_TYPE_DATE);
        
        valider=new Button("Valider");
    
    f.add(lnom);
    f.add(nom);
    f.add(lprenom);
    f.add(prenom);
    f.add(lage);
    f.add(age);
    f.add(lsexe);
    f.add(genreF);
     f.add(genreM);
      f.add(ldate); 
     f.add(dateP);
     f.add(lemail);
       f.add(email);
        f.add(ltel);
         f.add(tel);
         f.add(letat);
         f.add(etatCel);
         f.add(etatCoup);
          f.add(lusername);
           f.add(username);
            f.add(lpassword);
             f.add(password);
             f.add(valider);
    
             ff.add(f);
    
    
     valider.addActionListener((e)->{
boolean test1=true; boolean test2=true; String genre = "";
String state = "";
     
    
if((genreF.isSelected()==false)&&(genreM.isSelected()==false)) test1=false;
         if((etatCel.isSelected()==false)&&(etatCoup.isSelected()==false)) test2=false;
         if (nom.getText().equals("")||prenom.getText().equals("")||age.getText().equals("")||email.getText().equals("")||tel.getText().equals("")||username.getText().equals("")||password.getText().equals("")||test1==false||test2==false||dateP.getText().equals(""))
          Dialog.show("Erreur", "Champ(s) vide(s)","OK","Cancel");
         
         
         else {
         if (genreF.isSelected()) genre="Femme";
          if (genreM.isSelected()) genre="Homme";
           if (etatCel.isSelected()) state="celib";
            if (etatCoup.isSelected()) state="encouple";
            
           String images="Facebook.jpg";
           
//            String salt=""+BCrypt.hashpw(password.getText(), BCrypt.gensalt());
            
           // String MDP=password.getText()+"{"+salt+"}";
            
           
            int ageint=Integer.parseInt(age.getText());
            
    UserServices us=new UserServices();
  
   
  // ArrayList<User> liste=us.Inscription(username.getText(),email.getText(),MDP,nom.getText(),prenom.getText(),images,ageint,tel.getText(),state,genre,dateP.getText(),salt);
            
     HomeForm h = new HomeForm();
        h.getF().show();
         }
       
        });
    
    
    
    }

    
    
    
    
    
    public Form getFf() {
        return ff;
    }

    public void setFf(Form ff) {
        this.ff = ff;
    }

   
    
    
     
}
