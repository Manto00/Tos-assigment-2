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
        LocalTime ora=LocalTime.of(18, 5, 6);
        User utente=new User("Mario", LocalDate.of(2013, 1, 1));
        List<EItem> lista=new ArrayList<>();
        EItem primo=new EItem("Esempio", 100, itemType.mouse);
        lista.add(primo);
        Conto conto1=new Conto(utente, lista, ora);
        List<Conto> listaConti=new ArrayList<>();
        listaConti.add(conto1);
        Acquisti acquisto=new Acquisti(listaConti);

        acquisto.giveOmaggio();
        boolean omaggio=acquisto.getConto(0).getOmaggio();

        Assert.assertTrue(omaggio);
    }
}