////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.itemType;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import it.unipd.mtss.model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.business.Bill;

public class ContoTest {

    @Test
    public void getOrderPriceTest() throws BillException {
        String nome="esempio";
        itemType mouse=itemType.mouse;
        List<EItem> lista=new ArrayList<>();
        EItem primo=new EItem(nome, 100, mouse);
        EItem secondo=new EItem(nome, 10, mouse);
        EItem terzo=new EItem(nome, 50, mouse);
        lista.add(primo);
        lista.add(secondo);
        lista.add(terzo);
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        double totale=160;
        Conto conto1=new Conto(utente, lista);
        double prezzo=conto1.getOrderPrice(conto1.getList(), conto1.getUser());
        Assert.assertEquals(totale, prezzo, 0.01);
    }

    @Test
    public void scontoProcessoriTest() throws  BillException{
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        itemType tastiera=itemType.tastiere;
        List<EItem> lista=new ArrayList<>();
        EItem primo=new EItem(nome, 100, processore);
        EItem secondo=new EItem(nome, 10, processore);
        EItem terzo=new EItem(nome, 50, processore);
        EItem quarto=new EItem(nome, 20, processore);
        EItem quinto=new EItem(nome, 300, processore);
        EItem sesto=new EItem(nome, 30, mouse);
        EItem settimo=new EItem(nome, 60, tastiera);
        EItem ottavo=new EItem(nome, 150, processore);
        lista.add(primo);
        lista.add(secondo);
        lista.add(terzo);
        lista.add(quarto);
        lista.add(quinto);
        lista.add(sesto);
        lista.add(settimo);
        lista.add(ottavo);
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        double totale=715;
        Conto conto1=new Conto(utente, lista);
        double prezzo=conto1.getOrderPrice(conto1.getList(), conto1.getUser());
        Assert.assertEquals(totale, prezzo, 0.01);
    }

    @Test
    public void omaggioSuMouseTest() throws  BillException{
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        itemType tastiera=itemType.tastiere;
        List<EItem> lista=new ArrayList<>();
        EItem primo=new EItem(nome, 50, mouse);
        EItem secondo=new EItem(nome, 10, mouse);
        EItem terzo=new EItem(nome, 30, mouse);
        EItem quarto=new EItem(nome, 20, mouse);
        EItem quinto=new EItem(nome, 30, mouse);
        EItem sesto=new EItem(nome, 40, mouse);
        EItem settimo=new EItem(nome, 80, mouse);
        EItem ottavo=new EItem(nome, 60, mouse);
        EItem nono=new EItem(nome, 20, mouse);
        EItem decimo=new EItem(nome, 30, mouse);
        EItem undicesimo=new EItem(nome, 10, mouse);
        EItem dodicesimo=new EItem(nome, 20, tastiera);
        EItem tredicsimo=new EItem(nome, 200, processore);
        lista.add(primo);
        lista.add(secondo);
        lista.add(terzo);
        lista.add(quarto);
        lista.add(quinto);
        lista.add(sesto);
        lista.add(settimo);
        lista.add(ottavo);
        lista.add(nono);
        lista.add(decimo);
        lista.add(undicesimo);
        lista.add(dodicesimo);
        lista.add(tredicsimo);
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        double totale=590;
        Conto conto1=new Conto(utente, lista);
        double prezzo=conto1.getOrderPrice(conto1.getList(), conto1.getUser());
        Assert.assertEquals(totale, prezzo, 0.01);
    }
}