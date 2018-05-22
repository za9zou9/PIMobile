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
public class Produit {
     private Integer idProduit;
    private Integer prix;
    private String type;
    private Integer quantite;
    private String nom;
    private String description;
    private Integer idCommercant;
    private String region;
    private String image;
    private Integer confirmation;

    public Produit() {
    }





    public Produit(String nom, String description,Integer prix,String type,Integer quantite,String image,String region) {
        this.nom = nom;
        this.description = description;
        this.prix=prix;
        this.type=type;
        this.image=image;
        this.quantite=quantite;
        this.region=region;
    }


  

    public Integer getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(Integer confirmation) {
        this.confirmation = confirmation;
    }

   

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdCommercant() {
        return idCommercant;
    }

    public void setIdCommercant(Integer idCommercant) {
        this.idCommercant = idCommercant;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Produit{" +" prix=" + prix + ", type=" + type + ", quantite=" + quantite + ", nom=" + nom + ", description=" + description + ", region=" + region + ", image=" + image + '}';
    }
}
