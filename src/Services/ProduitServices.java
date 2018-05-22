/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Produit;
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
public class ProduitServices {
   
public void ajoutProduit(Produit p) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/MySoulmates/web/app_dev.php/?nom="+p.getNom()+"&description=" +p.getDescription()+"&prix=" +p.getPrix()+"&type=" +p.getType()+"&quantite=" +p.getQuantite() +"&region=" +p.getRegion()+"&image=" +p.getImage();
        con.setUrl(Url);

     

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    
    
   public ArrayList<Produit> getList2() {
        ArrayList<Produit> listProduits = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/prodmob");
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
                    Produit p = new Produit();
                    
                    p.setImage(obj.get("image").toString());
                    p.setNom(obj.get("nom").toString());
                    p.setDescription(obj.get("description").toString());
                    p.setType(obj.get("type").toString());
                    p.setRegion(obj.get("region").toString());
                  
                    float conf = Float.parseFloat(obj.get("confirmation").toString());
              p.setConfirmation((int)conf);
                    float qte = Float.parseFloat(obj.get("quantite").toString());
              p.setQuantite((int)qte);
                float px = Float.parseFloat(obj.get("prix").toString());
              p.setPrix((int)px);
                         float id = Float.parseFloat(obj.get("idproduit").toString());
              p.setIdProduit((int)id);
              if(p.getQuantite()>0 && p.getConfirmation()==1){
                  
                    listProduits.add(p);}
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
}
