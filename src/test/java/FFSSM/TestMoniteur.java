package FFSSM;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.datatransfer.Clipboard;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMoniteur {

    Plongeur p, p2;
    Licence l, l2;
    Club c,c2;
    Moniteur m;
    Site s;
    Plongee pl, pl2;

    @BeforeEach
    public void setup() {
        p = new Plongeur("1234", "Giroud", "Olivier", "France", "0628483749", LocalDate.now(), 5, GroupeSanguin.BMOINS);
        p2 = new Plongeur("1234", "Giroud", "Olivier", "France", "0628483749", LocalDate.now().minusYears(2), 5, GroupeSanguin.BMOINS);
        m = new Moniteur("2344", "Griezman", "Antoine", "France", "91903920", LocalDate.of(1999, 10, 11), 7, GroupeSanguin.AMOINS, 112);
        c = new Club(m, "Lloris", "949339493");
        c2 = new Club(m, "Loris", "94433322339493");
        p.ajouteLicence("99302", LocalDate.of(2022, 11, 10), c);
        p2.ajouteLicence("94932", LocalDate.of(2021, 11, 10), c);
        l = new Licence(p, "9392", LocalDate.of(2022, 11, 10), c);
        l2 = new Licence(p, "9392", LocalDate.of(2021, 11, 10), c);
        s = new Site("test", "pas de details");
        pl = new Plongee(s, m, LocalDate.now(), 3, 3);
        pl2 = new Plongee(s, m, LocalDate.now(), 3, 3);
        pl.ajouteParticipant(p);
        pl2.ajouteParticipant(p2);
        c.organisePlongee(pl);
        c.organisePlongee(pl2);

        m.nouvelleEmbauche(c,LocalDate.of(2009,2,2));
        m.nouvelleEmbauche(c2,LocalDate.of(2018,2,2));
    }
    @Test
    public void testNouvelleEmbauchePlusRecente(){
        assertEquals(m.employeurActuel().get(), c2);
    }

    @Test
    public void testNouvelleEmbauchePlusRecente2(){
        Embauche e = new Embauche(LocalDate.of(2020,2,2),m,c);
        assertEquals(m.employeurActuel().get(), c);
    }

    @Test
    public void testNouvelleEmbauchePlusRecenteTerminee(){
        Embauche e = new Embauche(LocalDate.of(2020,2,2),m,c);
        e.terminer(LocalDate.now());
        assertEquals(m.employeurActuel().get(), c2);
    }

    @Test
    public void testEmplois(){
        Embauche e = new Embauche(LocalDate.of(2020,2,2),m,c);
        assertEquals(m.emplois().size(),3);
        assertEquals(m.emplois().get(2), e);}
}
