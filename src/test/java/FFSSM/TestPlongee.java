package FFSSM;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlongee {

    Plongeur p,p2;
    Licence l, l2;
    Club c;
    Moniteur m;
    Site s;
    Plongee pl;

    @BeforeEach
    public void setup() {
        p = new Plongeur("1234", "Giroud", "Olivier", "France", "0628483749", LocalDate.now(), 5, GroupeSanguin.BMOINS);
        p2 = new Plongeur("1234", "Giroud", "Olivier", "France", "0628483749", LocalDate.now().minusYears(2), 5, GroupeSanguin.BMOINS);
        m = new Moniteur("2344", "Griezman", "Antoine", "France", "91903920", LocalDate.of(1999, 10, 11), 7, GroupeSanguin.AMOINS, 112);
        c = new Club(m, "Lloris", "949339493");
        p.ajouteLicence("99302",LocalDate.of(2022, 11, 10),c);
        p2.ajouteLicence("94932",LocalDate.of(2021, 11, 10),c);
        l = new Licence(p, "9392", LocalDate.of(2022, 11, 10), c);
        l2 = new Licence(p, "9392", LocalDate.of(2021, 11, 10), c);
        s = new Site("test", "pas de details");
        pl = new Plongee(s,m,LocalDate.now(),3,3);
    }

    @Test
    public void testEstConformeTrue(){
        pl.ajouteParticipant(p);
        assertTrue(pl.estConforme());
    }

    @Test
    public void testEstConformeFalse(){
        pl.ajouteParticipant(p2);
        assertFalse(pl.estConforme());
    }
}
