////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.Acquisti;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.itemType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AcquistiTest {

    @Test
    public void omaggioTest(){
        LocalTime ora1=LocalTime.of(18, 5, 6);
        LocalTime ora2=LocalTime.of(18, 5, 6);
        LocalTime ora3=LocalTime.of(19, 5, 6);
        User utente1=new User("Mario", LocalDate.of(2013, 1, 1));
        User utente2=new User("Mario", LocalDate.of(2000, 1, 1));
        User utente3=new User("Mario", LocalDate.of(2013, 1, 1));
        List<EItem> lista1=new ArrayList<>();
        List<EItem> lista2=new ArrayList<>();
        List<EItem> lista3=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista1.add(primo);
        lista2.add(primo);
        lista2.add(primo);
        Conto conto1=new Conto(utente1, lista1, ora1);
        Conto conto2=new Conto(utente2, lista2, ora2);
        Conto conto3=new Conto(utente3, lista3, ora3);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        listaConti.add(conto2);
        listaConti.add(conto3);
        Acquisti acquisto=new Acquisti(listaConti);

        acquisto.giveOmaggio();
        boolean omaggio1=acquisto.getConto(0).getOmaggio();
        boolean omaggio2=acquisto.getConto(1).getOmaggio();
        boolean omaggio3=acquisto.getConto(2).getOmaggio();

        Assert.assertTrue(omaggio1);
        Assert.assertFalse(omaggio2);
        Assert.assertFalse(omaggio3);
    }

    @Test
    public void omaggioMaggiorenniTest(){
        LocalTime ora1=LocalTime.of(18, 5, 6);
        User utente1=new User("Mario", LocalDate.of(2000, 1, 1));
        List<EItem> lista1=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista1.add(primo);
        Conto conto1=new Conto(utente1, lista1, ora1);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        Acquisti acquisto=new Acquisti(listaConti);

        acquisto.giveOmaggio();
        boolean omaggio1=acquisto.getConto(0).getOmaggio();

        Assert.assertFalse(omaggio1);
    }

    @Test
    public void omaggioFuoriOrarioTest(){
        LocalTime ora1=LocalTime.of(19, 5, 6);
        User utente1=new User("Mario", LocalDate.of(2013, 1, 1));
        List<EItem> lista1=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista1.add(primo);
        Conto conto1=new Conto(utente1, lista1, ora1);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        Acquisti acquisto=new Acquisti(listaConti);

        acquisto.giveOmaggio();
        boolean omaggio1=acquisto.getConto(0).getOmaggio();

        Assert.assertFalse(omaggio1);
    }
    @Test
    public void omaggioUtenteConPiuOrdiniTest(){
        LocalTime ora1=LocalTime.of(18, 5, 6);
        User utente1=new User("Mario", LocalDate.of(2013, 1, 1));
        User utente2=new User("Roberto", LocalDate.of(2000, 1, 1));
        List<EItem> lista1=new ArrayList<>();
        List<EItem> lista2=new ArrayList<>();
        List<EItem> lista3=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista1.add(primo);
        lista2.add(primo);
        lista3.add(primo);
        Conto conto1=new Conto(utente1, lista1, ora1);
        Conto conto2=new Conto(utente1, lista2, ora1);
        Conto conto3=new Conto(utente2, lista3, ora1);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        listaConti.add(conto2);
        listaConti.add(conto3);
        Acquisti acquisto=new Acquisti(listaConti);

        acquisto.giveOmaggio();
        boolean omaggio1=acquisto.getConto(0).getOmaggio();
        boolean omaggio2=acquisto.getConto(1).getOmaggio();
        boolean omaggio3=acquisto.getConto(2).getOmaggio();

        Assert.assertTrue((omaggio1 || omaggio2)&&(!omaggio1||!omaggio2));
        Assert.assertFalse(omaggio3);
    }
    @Test
    public void omaggioPiuUtentiTest(){
        LocalTime ora1=LocalTime.of(18, 5, 6);
        LocalTime ora2=LocalTime.of(19, 5, 6);
        User utente1=new User("Mario", LocalDate.of(2013, 1, 1));
        User utente2=new User("Roberto", LocalDate.of(2013, 1, 1));
        User utente3=new User("Tony", LocalDate.of(2013, 1, 1));
        User utente4=new User("Andrea", LocalDate.of(2013, 1, 1));
        User utente5=new User("Leonardo", LocalDate.of(2013, 1, 1));
        User utente6=new User("Guido", LocalDate.of(2013, 1, 1));
        User utente7=new User("Marco", LocalDate.of(2013, 1, 1));
        User utente8=new User("Raffaele", LocalDate.of(2013, 1, 1));
        User utente9=new User("George", LocalDate.of(2013, 1, 1));
        User utente10=new User("Christian", LocalDate.of(2013, 1, 1));
        User utente11=new User("Gabriele", LocalDate.of(2000, 1, 1));
        User utente12=new User("Giuseppe", LocalDate.of(2013, 1, 1));
        User utente13=new User("Geremia", LocalDate.of(2013, 1, 1));
        List<EItem> lista1=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista1.add(primo);
        Conto conto1=new Conto(utente1, lista1, ora1);
        Conto conto2=new Conto(utente2, lista1, ora1);
        Conto conto3=new Conto(utente3, lista1, ora1);
        Conto conto4=new Conto(utente4, lista1, ora1);
        Conto conto5=new Conto(utente5, lista1, ora1);
        Conto conto6=new Conto(utente8, lista1, ora1);
        Conto conto7=new Conto(utente6, lista1, ora1);
        Conto conto8=new Conto(utente10, lista1, ora1);
        Conto conto9=new Conto(utente12, lista1, ora2);
        Conto conto10=new Conto(utente7, lista1, ora1);
        Conto conto11=new Conto(utente9, lista1, ora1);
        Conto conto12=new Conto(utente11, lista1, ora1);
        Conto conto13=new Conto(utente13, lista1, ora1);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        listaConti.add(conto2);
        listaConti.add(conto3);
        listaConti.add(conto4);
        listaConti.add(conto5);
        listaConti.add(conto6);
        listaConti.add(conto7);
        listaConti.add(conto8);
        listaConti.add(conto9);
        listaConti.add(conto10);
        listaConti.add(conto11);
        listaConti.add(conto12);
        listaConti.add(conto13);
        Acquisti acquisto=new Acquisti(listaConti);
        int n_omaggi=0;

        acquisto.giveOmaggio();
        for(int i=0; i<13; i++) {
            if (acquisto.getConto(i).getOmaggio()) {
                n_omaggi++;
            }
        }

        Assert.assertEquals(n_omaggi, 10);
    }
}