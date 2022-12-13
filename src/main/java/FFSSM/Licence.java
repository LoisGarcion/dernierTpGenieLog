/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club emetteur;

    public List<Plongee> plongees = new ArrayList<>();

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.emetteur = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getEmetteur() {
        return emetteur;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ?
     * Une licence est valide pendant un an à compter de sa date de délivrance
     * @param d la date à tester
     * @return vrai si valide à la date d
     **/
    public boolean estValide(LocalDate d) {
         return d.isBefore(getDelivrance().plusYears(1)) && d.isAfter(getDelivrance());
    }

    public void ajouterPlongees(Plongee plongee){
        plongees.add(plongee);
    }

}
