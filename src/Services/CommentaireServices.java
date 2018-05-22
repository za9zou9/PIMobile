/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commentaire;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Imene
 */
public class CommentaireServices {
    
    public void ajoutCommentaire(Commentaire c) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/MySoulmates/web/app_dev.php/commobajout?description="+c.getDescription();
        con.setUrl(Url);

     

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    
   public ArrayList<Commentaire> getList() {
        ArrayList<Commentaire> listCommentaires= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/commob");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
              @Override
            public void actionPerformed(NetworkEvent evt) {
            //listTasks = getListTask(new String(con.getResponseData()));
            JSONParser jsonp = new JSONParser();
            
            try {
                //renvoi une map avec clé = root et valeur le reste
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println("roooooot:" +tasks.get("root"));
                
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                
                for (Map<String, Object> obj : list) {
                    Commentaire c = new Commentaire();
                c.setDescription(obj.get("description").toString());
                 float id = Float.parseFloat(obj.get("idcommentaire").toString());
              c.setIdCommentaire((int)id);
              listCommentaires.add(c);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaires;
    }
   
   public void updatecom(int idCommentaire , int idStorie) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/MySoulmates/web/app_dev.php/update/"+idCommentaire+"/"+idStorie+"";
        con.setUrl(Url);

     

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
   
   
   public ArrayList<Commentaire> Commentaire() {
        ArrayList<Commentaire> listCommentaires= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/Coms");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
              @Override
            public void actionPerformed(NetworkEvent evt) {
            //listTasks = getListTask(new String(con.getResponseData()));
            JSONParser jsonp = new JSONParser();
            
            try {
                //renvoi une map avec clé = root et valeur le reste
                Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                System.out.println("roooooot:" +tasks.get("root"));
                
                List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");
                
                for (Map<String, Object> obj : list) {
                    Commentaire c = new Commentaire();
                c.setDescription(obj.get("description").toString());
                c.setIdStorie(1);
                
               
              listCommentaires.add(c);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommentaires;
    }
   
   
}
