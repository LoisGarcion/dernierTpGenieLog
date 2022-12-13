package FFSSM;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestLicence {

    Personne p;
    Licence l,l2;
    Club c;
    Moniteur m;
    Site s;
    @BeforeEach
    public void setup(){
        p = new Plongeur("1234","Giroud","Olivier","France","0628483749", LocalDate.now(),5,GroupeSanguin.BMOINS);
        m = new Moniteur("2344","Griezman","Antoine","France","91903920",LocalDate.of(1999,10,11),7,GroupeSanguin.AMOINS,112);
        c = new Club(m,"Lloris","949339493");
        l = new Licence(p,"9392",LocalDate.of(2022,11,10),c);
        l2 = new Licence(p,"9392",LocalDate.of(2021,11,10),c);

        s = new Site("test","pas de details");
    }

    @Test
    public void testAjoutPlongees(){
        Plongee plongee = new Plongee(s,m,LocalDate.now(),14,12);
        l.ajouterPlongees(plongee);
        assertTrue(l.plongees.contains(plongee));
    }

    @Test
    public void testEstValideExpire(){
        assertFalse(l2.estValide(LocalDate.now()));
    }

    @Test
    public void testEstValidePasExpire(){
        assertTrue(l.estValide(LocalDate.now()));
    }
}
