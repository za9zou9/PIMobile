/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Commande;
import Entities.Commentaire;
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

     public class CommandeServices {
      public void ajoutCommande(int id , int qte) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/MySoulmates/web/app_dev.php/ajoutcom1/"+id+"/"+qte+"";
        con.setUrl(Url);

     

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
   public ArrayList<Commande> getList() {
        ArrayList<Commande> listCommandes= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/panier1");
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
                    Commande c = new Commande();
float qte = Float.parseFloat(obj.get("quantite").toString());
             c.setQuantite((int)qte);
           listCommandes.add(c);
              c.getQuantite();
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listCommandes;
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
                    p.setConfirmation(1);
                    float qte = Float.parseFloat(obj.get("quantite").toString());
              p.setQuantite((int)qte);
                float px = Float.parseFloat(obj.get("prix").toString());
              p.setPrix((int)px);
                    
                    listProduits.add(p);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
  
   public ArrayList<Commande> getList3() {
        ArrayList<Commande> listProduits = new ArrayList<>();
          ArrayList<Produit> listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/prods");
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
                    Commande p = new Commande();
                    
                    Map<String,Object> leid= (Map<String,Object>) obj.get("idproduit");
                         Double xx=(Double) leid.get("idproduit");
                         p.setIdProduit(xx.intValue());
                    float qte = Float.parseFloat(obj.get("quantite").toString());
              p.setQuantite((int)qte);
              
                 
              
             
                    listProduits.add(p);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
   
   
   
     public ArrayList<Produit> getList4(int id) {
       
          ArrayList<Produit> listProduit = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/produitC/"+id+"");
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
             
                    listProduit.add(p);
                    
                }
            } catch (IOException ex) {
            }
        }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduit;
    }
   
}
