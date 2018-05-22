/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import Entities.Partcipation;
import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author skan
 */
public class UserServices {
    
    
     public ArrayList<User> getUserPourLogin(String username) {
        ArrayList<User> listUsers = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/loginMobile/"+username+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        User e = new User();
                        Double d = (Double) obj.get("id");
Integer i = d.intValue();
                     e.setId(i);
                        e.setSalt((String) obj.get("salt"));
                       e.setPassword((String) obj.get("password"));
                        Double d2 = (Double) obj.get("age");
                        Integer i2 = d.intValue();
                       e.setAge(i2);
                       e.setEmail((String) obj.get("email"));
                       e.setImage((String) obj.get("image"));
                       e.setSexe((String) obj.get("sexe"));
                       e.setEtat((String) obj.get("etat"));
                       e.setUsername((String) obj.get("username"));
                       e.setNom((String) obj.get("nom"));
                       e.setPrenom((String) obj.get("prenom"));
                       e.setTel((String) obj.get("tel"));
                        Map<String, Object> date = (Map<String, Object>) obj.get("datedenaissance");
                       
                       double batch_date = (double) date.get("timestamp"); 
    Date dt = new Date ((long) (batch_date * 1000)); 
    
    e.setDateDeNaissance(dt);
                        listUsers.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUsers;
    }
 
     
      public ArrayList<User> getParticipants(int idEv) {
        ArrayList<User> listUsers = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/ParticipationsMobile/"+idEv+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                    for (Map<String, Object> obj : list) {
                        User e = new User();
                        Double d = (Double) obj.get("id");
Integer i = d.intValue();
                     e.setId(i);
                      
                      
                       e.setUsername((String) obj.get("username"));
                       e.setTel((String) obj.get("tel"));
                        listUsers.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUsers;
    }
 
      public  ArrayList<User> Inscription(String username,String email,String password,String nom,String prenom,String image,int age,String tel,String etat,String sexe,String date,String salt) {
        ArrayList<User> listEvenements = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/InscriptionMobile?nom=" + nom + "&prenom=" + prenom
                + "&username=" + username + "&email=" + email + "&password=" + password + "&image=" + image +
                 "&age=" + age + "&ladate=" + date + "&tel=" + tel +"&etat=" +etat + "&sexe=" + sexe + "&salt=" +salt );
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          User e = new User();
                        
                        listEvenements.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }
     
     
     
}
