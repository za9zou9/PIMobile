/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serviices;


import Entitiies.MesAmis;
import Entitiies.MesPack;
import Entitiies.Pack;
import Entitiies.Produit;
import Entitiies.User;
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
    
    
     public ArrayList<User> Userlkol(int id) {
         
         
        ArrayList<User> listUser = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/UserLkol/"+id+"");
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
                     
                     e.setUsername(obj.get("username").toString());
                       
                        listUser.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listUser;
    }
 
    
     
      public  ArrayList<MesAmis> Ajouter(int idAmis,int id ) {
        ArrayList<MesAmis> MesAmis= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/AjouterMesAmis/"+idAmis+"/"+id+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          MesAmis e = new MesAmis();
                        
                       MesAmis.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return MesAmis;
    }
    
     
     public ArrayList<Pack> PackLkol() {
         
         
        ArrayList<Pack> listPack = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/PackLkol/");
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
                        Pack e = new Pack();
                        Double d = (Double) obj.get("idpack");
Integer i = d.intValue();
                     e.setIdPack(i);
                     
                    Double j = (Double) obj.get("aime");
                     Integer m = j.intValue();
                     e.setAime(m);
                       
                        listPack.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPack;
    }
     
     
     
     public ArrayList<Produit> PackDetails(int idPack) {
         
         
        ArrayList<Produit> listPack = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/DetailsPack/"+idPack+"");
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
                        Produit e = new Produit();
                        Double d = (Double) obj.get("idproduit");
                     Integer i = d.intValue();
                     e.setIdProduit(i);
                    
                   e.setNom(obj.get("nom").toString());
                       
                        listPack.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listPack;
    }
     
     public  ArrayList<MesPack> AjouterMesPack(int idPack,int id ) {
        ArrayList<MesPack> MesPack= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/AjouterMesPack/"+idPack+"/"+id+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          MesPack e = new MesPack();
                        
                       MesPack.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return MesPack;
    }  
     
     public  ArrayList<Pack> UpdateAime(int idPack,int aime ) {
        ArrayList<Pack> Pack= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/UpdateAime/"+idPack+"/"+aime+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          Pack e = new Pack();
                        
                       Pack.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Pack;
    }  
     
     
     
     
     
      public ArrayList<MesAmis> MesAmis(int id) {
         
         
        ArrayList<MesAmis> listAmis = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/MesAmis/"+id+"");
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
                        MesAmis e = new MesAmis();
                        Double d = (Double) obj.get("id");
Integer i = d.intValue();
                     e.setId(i);
                     
                      Double j = (Double) obj.get("idmesamis");
Integer m = j.intValue();
                     e.setIdMesAmis(m);
                      
                     e.setPseudo(obj.get("pseudo").toString());
                       
                        listAmis.add(e);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAmis;
    }
     
     
      
        public  ArrayList<MesAmis> SupprimerDe(int id ) {
        ArrayList<MesAmis> MesAmis= new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/MySoulmates/web/app_dev.php/SupprimerDe/"+id+"");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                
                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> tasks = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    

                    List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

                          MesAmis e = new MesAmis();
                        
                       MesAmis.add(e);
                     
                       
                     
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return MesAmis;
    }  
      
      
}