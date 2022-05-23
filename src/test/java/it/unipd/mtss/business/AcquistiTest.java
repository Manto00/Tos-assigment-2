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
}