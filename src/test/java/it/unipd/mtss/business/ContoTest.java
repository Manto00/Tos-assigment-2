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
        EItem primo=new EItem(nome, 100, mouse);
        EItem secondo=new EItem(nome, 10, mouse);
        EItem terzo=new EItem(nome, 50, mouse);
        List<EItem> lista=new ArrayList<>();
        lista.add(primo);
        lista.add(secondo);
        lista.add(terzo);
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        int totale=160;
        Conto conto1=new Conto(utente, lista);
        Assert.assertEquals(totale, conto1.getOrderPrice(conto1.getList(), conto1.getUser()));
    }
}