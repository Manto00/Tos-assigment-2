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

    @Test
    public void omaggioMouseTastiereTest() throws BillException{
        String nome="esempio";
        itemType mouse=itemType.mouse;
        itemType tastiera=itemType.tastiere;
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));

        //Setup Caso 1: Mouse meno caro
        List<EItem> lista1=new ArrayList<>();
        EItem mouse1=new EItem(nome, 30, mouse);
        EItem mouse2=new EItem(nome, 50, mouse);
        EItem tastiera1=new EItem(nome, 40, tastiera);
        EItem tastiera2=new EItem(nome, 60, tastiera);
        lista1.add(mouse1);
        lista1.add(mouse2);
        lista1.add(tastiera1);
        lista1.add(tastiera2);
        Conto conto1=new Conto(utente, lista1);
        double totale1=150;

        //Setup Caso 2: Tastiera meno cara
        List<EItem> lista2=new ArrayList<>();
        mouse1=new EItem(nome, 70, mouse);
        mouse2=new EItem(nome, 50, mouse);
        tastiera1=new EItem(nome, 40, tastiera);
        tastiera2=new EItem(nome, 60, tastiera);
        lista2.add(mouse1);
        lista2.add(mouse2);
        lista2.add(tastiera1);
        lista2.add(tastiera2);
        Conto conto2=new Conto(utente, lista2);
        double totale2=180;

        //Setup Caso 3: L'oggetto meno caro è un Mouse che viene regalato perchè più di 10 Mouse
        // ordinati, secondo oggetto meno caro Mouse
        List<EItem> lista3=new ArrayList<>();
        mouse1=new EItem(nome, 2, mouse);   //Mouse regalato perchè omaggio >10 Mouse
        mouse2=new EItem(nome, 3, mouse);   //Mouse regalato perchè il mouse meno caro è già stato regalato
        EItem mouse3=new EItem(nome, 5, mouse);
        EItem mouse4=new EItem(nome, 5, mouse);
        EItem mouse5=new EItem(nome, 5, mouse);
        EItem mouse6=new EItem(nome, 5, mouse);
        EItem mouse7=new EItem(nome, 5, mouse);
        EItem mouse8=new EItem(nome, 5, mouse);
        EItem mouse9=new EItem(nome, 5, mouse);
        EItem mouse10=new EItem(nome, 5, mouse);
        EItem mouse11=new EItem(nome, 5, mouse);
        tastiera1=new EItem(nome, 5, tastiera);
        tastiera2=new EItem(nome, 5, tastiera);
        EItem tastiera3=new EItem(nome, 5, tastiera);
        EItem tastiera4=new EItem(nome, 5, tastiera);
        EItem tastiera5=new EItem(nome, 5, tastiera);
        EItem tastiera6=new EItem(nome, 5, tastiera);
        EItem tastiera7=new EItem(nome, 5, tastiera);
        EItem tastiera8=new EItem(nome, 5, tastiera);
        EItem tastiera9=new EItem(nome, 5, tastiera);
        EItem tastiera10=new EItem(nome, 5, tastiera);
        EItem tastiera11=new EItem(nome, 5, tastiera);
        lista3.add(mouse1);
        lista3.add(mouse2);
        lista3.add(mouse3);
        lista3.add(mouse4);
        lista3.add(mouse5);
        lista3.add(mouse6);
        lista3.add(mouse7);
        lista3.add(mouse8);
        lista3.add(mouse9);
        lista3.add(mouse10);
        lista3.add(mouse11);
        lista3.add(tastiera1);
        lista3.add(tastiera2);
        lista3.add(tastiera3);
        lista3.add(tastiera4);
        lista3.add(tastiera5);
        lista3.add(tastiera6);
        lista3.add(tastiera7);
        lista3.add(tastiera8);
        lista3.add(tastiera9);
        lista3.add(tastiera10);
        lista3.add(tastiera11);
        Conto conto3=new Conto(utente, lista3);
        double totale3=100;

        //Setup Caso 4: L'oggetto meno caro è un Mouse che viene regalato perchè più di 10 Mouse
        // ordinati, secondo oggetto meno caro Mouse
        List<EItem> lista4=new ArrayList<>();
        mouse1=new EItem(nome, 2, mouse);   //Mouse Regalato per omaggio >10 Mouse
        mouse2=new EItem(nome, 5, mouse);
        mouse3=new EItem(nome, 5, mouse);
        mouse4=new EItem(nome, 5, mouse);
        mouse5=new EItem(nome, 5, mouse);
        mouse6=new EItem(nome, 5, mouse);
        mouse7=new EItem(nome, 5, mouse);
        mouse8=new EItem(nome, 5, mouse);
        mouse9=new EItem(nome, 5, mouse);
        mouse10=new EItem(nome, 5, mouse);
        mouse11=new EItem(nome, 5, mouse);
        tastiera1=new EItem(nome, 3, tastiera); //Tastiera regalata perchè il mouse meno caro è già stato regalato
        tastiera2=new EItem(nome, 5, tastiera);
        tastiera3=new EItem(nome, 5, tastiera);
        tastiera4=new EItem(nome, 5, tastiera);
        tastiera5=new EItem(nome, 5, tastiera);
        tastiera6=new EItem(nome, 5, tastiera);
        tastiera7=new EItem(nome, 5, tastiera);
        tastiera8=new EItem(nome, 5, tastiera);
        tastiera9=new EItem(nome, 5, tastiera);
        tastiera10=new EItem(nome, 5, tastiera);
        tastiera11=new EItem(nome, 5, tastiera);
        lista4.add(mouse1);
        lista4.add(mouse2);
        lista4.add(mouse3);
        lista4.add(mouse4);
        lista4.add(mouse5);
        lista4.add(mouse6);
        lista4.add(mouse7);
        lista4.add(mouse8);
        lista4.add(mouse9);
        lista4.add(mouse10);
        lista4.add(mouse11);
        lista4.add(tastiera1);
        lista4.add(tastiera2);
        lista4.add(tastiera3);
        lista4.add(tastiera4);
        lista4.add(tastiera5);
        lista4.add(tastiera6);
        lista4.add(tastiera7);
        lista4.add(tastiera8);
        lista4.add(tastiera9);
        lista4.add(tastiera10);
        lista4.add(tastiera11);
        Conto conto4=new Conto(utente, lista4);
        double totale4=100;

        //Chiamata alle funzioni
        double prezzo1=conto1.getOrderPrice(conto1.getList(), conto1.getUser());    //Caso di mouse come oggetto meno caro
        double prezzo2=conto2.getOrderPrice(conto2.getList(), conto2.getUser());    //Caso di tastiera come oggetto meno caro
        double prezzo3=conto3.getOrderPrice(conto3.getList(), conto3.getUser());    //Caso di mouse regalato, altro mouse meno caro
        double prezzo4=conto4.getOrderPrice(conto4.getList(), conto4.getUser());    //Caso di mouse regalato, altra tastiera meno cara

        //Controlli
        Assert.assertEquals(totale1, prezzo1, 0.01);
        Assert.assertEquals(totale2, prezzo2, 0.01);
        Assert.assertEquals(totale3, prezzo3, 0.01);
        Assert.assertEquals(totale4, prezzo4, 0.01);
    }
}