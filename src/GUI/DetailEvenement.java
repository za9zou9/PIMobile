/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Entities.Partcipation;
import Entities.User;
import Services.EvenementServices;
import Services.UserServices;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.List;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.MultiList;
//import com.twilio.Twilio;
//import com.twilio.type.PhoneNumber;
import java.util.ArrayList;

/**
 *
 * @author skan
 */
public class DetailEvenement {
     Form f;
     Label desc;
     Label StatDesc;
    private Evenement lui;
      Button participer;
      Button pasparticiper;
    Container conte;
 Label parts;
     public static final String ACCOUNT_SID = "AC6aad8a0d0849dc11c01625b0574f7263";
    public static final String AUTH_TOKEN = "8d2943c240f49b604475ab8ca270378c";
     public DetailEvenement() {
        
         conte=new Container(new BoxLayout(BoxLayout.Y_AXIS));
        parts=new Label("Autres Participants");
         participer=new Button("Je souhaite Participer");
         pasparticiper=new Button("Je ne souhaite plus participer");
        StatDesc =new Label("Description :");
        desc=new Label();
        f = new Form();
         f.getToolbar().addCommandToRightBar("Retour", null, (ev)->{ListeEenements h=new ListeEenements();
          h.getF().show();
          });
        conte.add(StatDesc);
        conte.add(desc);
        conte.add(participer);
        conte.add(pasparticiper);
        conte.add(parts);
        f.add(conte);
        
        
        UserServices  uss=new UserServices();
        
       
  
     
       participer.addActionListener((e)->{ 
            User ussr=User.getInstance();
          EvenementServices  us=new EvenementServices();
          
    ArrayList<User> lstU=uss.getParticipants(lui.getIdEvenement());
           
    ArrayList<Partcipation> lstE=us.Participer(lui.getIdEvenement(),ussr.getId());
    int sz= lstU.size()+1;    
    for(int i=0;i<lstU.size();i++){
//         Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      //  com.twilio.rest.api.v2010.account.Message msg = com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21626186131"), new PhoneNumber("+19712056031"), "Heeeey "+lstU.get(0).getUsername()+" participe désormais à l'événement qui a lieu au "+lui.getLieu()+" , cet événement compte "+sz+" participants").create();
       
    }
    participer.setEnabled(false);
   pasparticiper.setEnabled(true);
   
    
   }); 
       
       
       pasparticiper.addActionListener((e)->{ 
     User ussr=User.getInstance();
 EvenementServices  us=new EvenementServices();
     ArrayList<Partcipation> lstE=us.PasParticiper(lui.getIdEvenement(), ussr.getId());
    pasparticiper.setEnabled(false);
    participer.setEnabled(true);
   
    
   }); 
        
 }
     
     
      
     
     

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Label getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc.setText(desc);
    }

    public Evenement getLui() {
        return lui;
    }

    public void setLui(Evenement lui) {
        this.lui = lui;
    }

   

  
   
    
     
}


