package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plongeur extends Personne {

    private int niveau;
    private GroupeSanguin groupe;
    private List<Licence> licences = new ArrayList<>();

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin groupe) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.groupe = groupe;
    }

    public void ajouteLicence(String numero, LocalDate delivrance, Club c){
        licences.add(new Licence(this,numero,delivrance,c));
    }

    public Licence derniereLicence(){
        licences.sort(Comparator.comparing(Licence::getDelivrance));
        return licences.get(licences.size()-1);
    }
}
