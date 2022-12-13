/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.*;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;

    public List<Licence> licensesDelivrees = new ArrayList<>();

    public List<Embauche> employes = new ArrayList<>();

    public List<Plongee> activites = new ArrayList<>();

    public Club(Moniteur president, String nom, String telephone) {
        this.president = president;
        this.nom = nom;
        this.telephone = telephone;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() {
         Set<Plongee> nonConformes = new HashSet<>();
         for(Plongee plongee : activites){
             if(!plongee.estConforme()){
                 nonConformes.add(plongee);
             }
         }
         return nonConformes;
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
        activites.add(p);
        p.setOrganisateur(this);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

    public void ajoutEmploye(Embauche embauche){
        employes.add(embauche);
    }
}
