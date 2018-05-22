/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Stories;
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
public class StorieServices {
    public ArrayList<Stories> getList() {
        ArrayList<Stories> listStories= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/afficher1");
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
                    Stories s = new Stories();
                    
                   
                    s.setDescription(obj.get("description").toString());
                    s.setTitre(obj.get("titre").toString());
                    s.setImage(obj.get("image").toString());
                                            float id = Float.parseFloat(obj.get("idstorie").toString());
              s.setIdStorie((int)id);
                    
                  listStories.add(s);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listStories;
    }
}
