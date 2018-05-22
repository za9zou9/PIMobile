/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Imene
 */
public class Commande {
     private int id ;
    private int idCommande;
    private int quantite;
    private int idPack;
    private int idProduit;
    
    private int prix;
    private String nom;

    public Commande() {
    }

    public Commande(int quantite,int idProduit) {
        this.quantite = quantite;
        this.idProduit=idProduit;
    }

    public Commande(int idProduit) {
        this.idProduit = idProduit;
    }
    
      

    public Commande(int idCommande, int quantite, int idProduit) {
        this.idCommande = idCommande;
        this.quantite = quantite;
        this.idProduit = idProduit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getIdPack() {
        return idPack;
    }

    public void setIdPack(int idPack) {
        this.idPack = idPack;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", idCommande=" + idCommande + ", quantite=" + quantite + ", idPack=" + idPack + ", idProduit=" + idProduit + '}';
    }
}
