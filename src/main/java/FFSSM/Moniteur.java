/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    private List<Embauche> employeurs = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau,groupe);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        List<Embauche> listSansTermine = new ArrayList<>();
        for(Embauche embauche : employeurs){
            if(!embauche.estTerminee()){
                listSansTermine.add(embauche);
            }
        }
        if(listSansTermine.size() == 0){
            return Optional.empty();
        }
        Embauche embauche = listSansTermine.get(listSansTermine.size()-1);

        return Optional.ofNullable(embauche.getEmployeur());
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
        Embauche embauche = new Embauche(debutNouvelle,this,employeur);
    }

    public List<Embauche> emplois() {
        return employeurs;
    }

    public void ajoutEmployeur(Embauche embauche){
        employeurs.add(embauche);
    }

    @Override
    public String toString() {
        return "Moniteur{" +
                "numeroDiplome=" + numeroDiplome +
                ", numeroINSEE='" + numeroINSEE + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", naissance=" + naissance +
                '}';
    }
}
