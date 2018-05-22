/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Imene
 */
public class HomeForm1 {
      private Resources theme;  
Form f;
 Toolbar menu;

    Button btnaff;Button aff;

    public HomeForm1() {
        theme = UIManager.initFirstTheme("/theme");
f = new Form("My Soulmate");
btnaff=new Button("Afficher Catalogue");
aff=new Button("Afficher Stories");


Image icon = theme.getImage("icon.png"); 
  menu=f.getToolbar();


menu.addMaterialCommandToSideMenu("Acceuil", FontImage.MATERIAL_HOME, e -> {}); 
menu.addMaterialCommandToSideMenu("Produits", FontImage.MATERIAL_SHOPPING_CART, e -> {});
menu.addMaterialCommandToSideMenu("Stories", FontImage.MATERIAL_LOCAL_ACTIVITY, e -> {});
menu.addMaterialCommandToSideMenu("Packs", FontImage.MATERIAL_INFO, e -> {});

f.addComponent(new Label("My Soulmate"));
f.add(btnaff);
f.add(aff);
  btnaff.addActionListener((e)->{
  Affichage c = new Affichage();
        c.getF().show();
  });
   aff.addActionListener((e)->{
  AffichageCommentaire c = new AffichageCommentaire();
        c.getF().show();
  });
  
  
  
f.show();
 }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
