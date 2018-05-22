/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Evenement;
import Entities.Partcipation;
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
public class EvenementServices {
    
    public ArrayList<Evenement> getListEventsFuturs() {
        ArrayList<Evenement> listEvenements = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/EventsFMobile/");
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
                        Evenement e = new Evenement();
                        
                        
                        Map<String, Object> date = (Map<String, Object>) obj.get("date");
                       
                       double batch_date = (double) date.get("timestamp"); 
    Date dt = new Date ((long) (batch_date * 1000)); 

   
    
                      e.setDate(dt);
                       e.setDescription(obj.get("description").toString());
                       
                       Double d = (Double) obj.get("idevenement");
Integer i = d.intValue(); // i becomes 5
                       e.setIdEvenement(i);
                       
                       

                        e.setImage(obj.get("image").toString());
                        e.setLieu(obj.get("lieu").toString());
                        
                       
                        listEvenements.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }
    
    
    public  ArrayList<Partcipation> Participer(int idev,int idu) {
        ArrayList<Partcipation> listEvenements = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/ParticiperMobile/"+idev+"/"+idu+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          Partcipation e = new Partcipation();
                        
                        listEvenements.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }
    
    
     public  ArrayList<Partcipation> PasParticiper(int idev,int idu) {
        ArrayList<Partcipation> listEvenements = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/PasParticiperMobile/"+idev+"/"+idu+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          Partcipation e = new Partcipation();
                        
                        listEvenements.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenements;
    }
    
    
}
