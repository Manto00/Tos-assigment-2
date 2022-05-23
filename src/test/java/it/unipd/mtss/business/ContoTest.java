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
import org.junit.Rule;
import it.unipd.mtss.model.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import it.unipd.mtss.model.EItem;
import java.time.LocalTime;
import it.unipd.mtss.business.Bill;

public class ContoTest {

    @Test
    public void getOrderPriceTest() throws BillException {
        String nome="esempio";
        LocalTime ora=LocalTime.of(1, 1, 1);
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
        Conto conto1=new Conto(utente, lista, ora);
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
        LocalTime ora=LocalTime.of(1, 1, 1);
        double totale=715;
        Conto conto1=new Conto(utente, lista, ora);
        double prezzo=conto1.getOrderPrice(conto1.getList(), conto1.getUser());
        Assert.assertEquals(totale, prezzo, 0.01);
    }

    @Test
    public void omaggioSuMouseTest() throws  BillException{
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        itemType tastiera=itemType.tastiere;
        LocalTime ora=LocalTime.of(1, 1, 1);
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
        Conto conto1=new Conto(utente, lista, ora);
        double prezzo=conto1.getOrderPrice(conto1.getList(), conto1.getUser());
        Assert.assertEquals(totale, prezzo, 0.01);
    }

    @Test
    public void omaggioMouseTastiereTestMouse() throws BillException {
        String nome = "esempio";
        itemType mouse = itemType.mouse;
        itemType tastiera = itemType.tastiere;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        //Setup Caso 1: Mouse meno caro
        List<EItem> lista1 = new ArrayList<>();
        EItem mouse1 = new EItem(nome, 30, mouse);
        EItem mouse2 = new EItem(nome, 50, mouse);
        EItem tastiera1 = new EItem(nome, 40, tastiera);
        EItem tastiera2 = new EItem(nome, 60, tastiera);
        lista1.add(mouse1);
        lista1.add(mouse2);
        lista1.add(tastiera1);
        lista1.add(tastiera2);
        Conto conto1 = new Conto(utente, lista1, ora);
        double totale1 = 150;
        double prezzo1 = conto1.getOrderPrice(conto1.getList(), conto1.getUser());

        Assert.assertEquals(totale1, prezzo1, 0.01);
    }

    @Test
    public void omaggioMouseTastiereTestTastiera() throws BillException {
        //Setup Caso 2: Tastiera meno cara
        String nome = "esempio";
        itemType mouse = itemType.mouse;
        itemType tastiera = itemType.tastiere;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        List<EItem> lista = new ArrayList<>();
        EItem mouse1 = new EItem(nome, 70, mouse);
        EItem mouse2 = new EItem(nome, 50, mouse);
        EItem tastiera1 = new EItem(nome, 40, tastiera);
        EItem tastiera2 = new EItem(nome, 60, tastiera);
        lista.add(mouse1);
        lista.add(mouse2);
        lista.add(tastiera1);
        lista.add(tastiera2);
        Conto conto = new Conto(utente, lista, ora);
        double totale = 180;
        double prezzo = conto.getOrderPrice(conto.getList(), conto.getUser());

        Assert.assertEquals(totale, prezzo, 0.01);
    }
    @Test
    public void omaggioMouseTastiereTest2Mouse() throws BillException {
        //Setup Caso 3: L'oggetto meno caro è un Mouse che viene regalato perchè più di 10 Mouse
        // ordinati, secondo oggetto meno caro Mouse
        String nome = "esempio";
        itemType mouse = itemType.mouse;
        itemType tastiera = itemType.tastiere;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        List<EItem> lista = new ArrayList<>();
        EItem mouse1 = new EItem(nome, 2, mouse);   //Mouse regalato perchè omaggio >10 Mouse
        EItem mouse2 = new EItem(nome, 3, mouse);   //Mouse regalato perchè il mouse meno caro è già stato regalato
        EItem mouse3 = new EItem(nome, 5, mouse);
        EItem mouse4 = new EItem(nome, 5, mouse);
        EItem mouse5 = new EItem(nome, 5, mouse);
        EItem mouse6 = new EItem(nome, 5, mouse);
        EItem mouse7 = new EItem(nome, 5, mouse);
        EItem mouse8 = new EItem(nome, 5, mouse);
        EItem mouse9 = new EItem(nome, 5, mouse);
        EItem mouse10 = new EItem(nome, 5, mouse);
        EItem mouse11 = new EItem(nome, 5, mouse);
        EItem tastiera1 = new EItem(nome, 5, tastiera);
        EItem tastiera2 = new EItem(nome, 5, tastiera);
        EItem tastiera3 = new EItem(nome, 5, tastiera);
        EItem tastiera4 = new EItem(nome, 5, tastiera);
        EItem tastiera5 = new EItem(nome, 5, tastiera);
        EItem tastiera6 = new EItem(nome, 5, tastiera);
        EItem tastiera7 = new EItem(nome, 5, tastiera);
        EItem tastiera8 = new EItem(nome, 5, tastiera);
        EItem tastiera9 = new EItem(nome, 5, tastiera);
        EItem tastiera10 = new EItem(nome, 5, tastiera);
        EItem tastiera11 = new EItem(nome, 5, tastiera);
        lista.add(mouse1);
        lista.add(mouse2);
        lista.add(mouse3);
        lista.add(mouse4);
        lista.add(mouse5);
        lista.add(mouse6);
        lista.add(mouse7);
        lista.add(mouse8);
        lista.add(mouse9);
        lista.add(mouse10);
        lista.add(mouse11);
        lista.add(tastiera1);
        lista.add(tastiera2);
        lista.add(tastiera3);
        lista.add(tastiera4);
        lista.add(tastiera5);
        lista.add(tastiera6);
        lista.add(tastiera7);
        lista.add(tastiera8);
        lista.add(tastiera9);
        lista.add(tastiera10);
        lista.add(tastiera11);
        Conto conto = new Conto(utente, lista, ora);
        double totale = 100;
        double prezzo3 = conto.getOrderPrice(conto.getList(), conto.getUser());    //Caso di mouse regalato, altro mouse meno caro

        Assert.assertEquals(totale, prezzo3, 0.01);
    }
    @Test
    public void omaggioMouseTastiereTest1Mouse1Tastiera() throws BillException {

        //Setup Caso 4: L'oggetto meno caro è un Mouse che viene regalato perchè più di 10 Mouse
        // ordinati, secondo oggetto meno caro Mouse
        String nome = "esempio";
        itemType mouse = itemType.mouse;
        itemType tastiera = itemType.tastiere;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        List<EItem> lista=new ArrayList<>();
        EItem mouse1=new EItem(nome, 2, mouse);   //Mouse Regalato per omaggio >10 Mouse
        EItem mouse2=new EItem(nome, 5, mouse);
        EItem mouse3=new EItem(nome, 5, mouse);
        EItem mouse4=new EItem(nome, 5, mouse);
        EItem mouse5=new EItem(nome, 5, mouse);
        EItem mouse6=new EItem(nome, 5, mouse);
        EItem mouse7=new EItem(nome, 5, mouse);
        EItem mouse8=new EItem(nome, 5, mouse);
        EItem mouse9=new EItem(nome, 5, mouse);
        EItem mouse10=new EItem(nome, 5, mouse);
        EItem mouse11=new EItem(nome, 5, mouse);
        EItem tastiera1=new EItem(nome, 3, tastiera); //Tastiera regalata perchè il mouse meno caro è già stato regalato
        EItem tastiera2=new EItem(nome, 5, tastiera);
        EItem tastiera3=new EItem(nome, 5, tastiera);
        EItem tastiera4=new EItem(nome, 5, tastiera);
        EItem tastiera5=new EItem(nome, 5, tastiera);
        EItem tastiera6=new EItem(nome, 5, tastiera);
        EItem tastiera7=new EItem(nome, 5, tastiera);
        EItem tastiera8=new EItem(nome, 5, tastiera);
        EItem tastiera9=new EItem(nome, 5, tastiera);
        EItem tastiera10=new EItem(nome, 5, tastiera);
        EItem tastiera11=new EItem(nome, 5, tastiera);
        lista.add(mouse1);
        lista.add(mouse2);
        lista.add(mouse3);
        lista.add(mouse4);
        lista.add(mouse5);
        lista.add(mouse6);
        lista.add(mouse7);
        lista.add(mouse8);
        lista.add(mouse9);
        lista.add(mouse10);
        lista.add(mouse11);
        lista.add(tastiera1);
        lista.add(tastiera2);
        lista.add(tastiera3);
        lista.add(tastiera4);
        lista.add(tastiera5);
        lista.add(tastiera6);
        lista.add(tastiera7);
        lista.add(tastiera8);
        lista.add(tastiera9);
        lista.add(tastiera10);
        lista.add(tastiera11);
        Conto conto=new Conto(utente, lista, ora);
        double totale=100;
        double prezzo=conto.getOrderPrice(conto.getList(), conto.getUser());    //Caso di mouse regalato, altra tastiera meno cara

        Assert.assertEquals(totale, prezzo, 0.01);
    }

    @Test
    public void scontoTotaleTest() throws BillException {
        String nome = "esempio";
        itemType processore = itemType.processori;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        //Setup Caso 1: Sconto del 10% senza altri sconti o omaggi
        List<EItem> lista = new ArrayList<>();
        EItem processore1 = new EItem(nome, 450, processore);
        EItem processore2 = new EItem(nome, 300, processore);
        EItem processore3 = new EItem(nome, 350, processore);
        EItem processore4 = new EItem(nome, 500, processore);
        lista.add(processore1);
        lista.add(processore2);
        lista.add(processore3);
        lista.add(processore4);
        Conto conto = new Conto(utente, lista, ora);
        double totale = 1440;
        double prezzo = conto.getOrderPrice(conto.getList(), conto.getUser());

        Assert.assertEquals(totale, prezzo, 0.01);
    }
    @Test
    public void scontoTotaleConOmaggioTest() throws BillException{
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora=LocalTime.of(1, 1, 1);

        //Setup Caso 2: prezzo totale superiore a 1000, ma viene applicato
        // l'omaggio del mouse meno caro perchè ne vengono ordinati più di 10
        //e lo sconto non viene applicato perchè il prezzo scende sotto 1000
        List<EItem> lista=new ArrayList<>();
        EItem mouse1=new EItem(nome, 20, mouse);
        EItem mouse2=new EItem(nome, 20, mouse);
        EItem mouse3=new EItem(nome, 20, mouse);
        EItem mouse4=new EItem(nome, 20, mouse);
        EItem mouse5=new EItem(nome, 20, mouse);
        EItem mouse6=new EItem(nome, 10, mouse);
        EItem mouse7=new EItem(nome, 10, mouse);
        EItem mouse8=new EItem(nome, 10, mouse);
        EItem mouse9=new EItem(nome, 10, mouse);
        EItem mouse10=new EItem(nome, 10, mouse);
        EItem mouse11=new EItem(nome, 10, mouse);
        EItem processore1= new EItem(nome, 350, processore);
        EItem processore2= new EItem(nome, 500, processore);
        lista.add(mouse1);
        lista.add(mouse2);
        lista.add(mouse3);
        lista.add(mouse4);
        lista.add(mouse5);
        lista.add(mouse6);
        lista.add(mouse7);
        lista.add(mouse8);
        lista.add(mouse9);
        lista.add(mouse10);
        lista.add(mouse11);
        lista.add(processore1);
        lista.add(processore2);
        Conto conto=new Conto(utente, lista, ora);
        double totale=1000;
        double prezzo=conto.getOrderPrice(conto.getList(), conto.getUser());    //Caso di tastiera come oggetto meno caro

        Assert.assertEquals(totale, prezzo, 0.01);
    }


    @Test
    public void Maggiore30ArticoliTest() {
        String nome="esempio";
        itemType mouse=itemType.mouse;
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora=LocalTime.of(1, 1, 1);
        List<EItem> lista=new ArrayList<>();
        EItem oggetto=new EItem(nome, 1, mouse);
        for (int i=0; i<35; i++){
            lista.add(oggetto);
        }
        Conto conto=new Conto(utente, lista, ora);

        boolean eccezione=false;
        try{
            conto.getOrderPrice(conto.getList(), conto.getUser());
        }
        catch(BillException e){
            eccezione=true;
        }
        Assert.assertTrue(eccezione);
    }

    @Test
    public void CommissioniTest() throws BillException {
        String nome = "esempio";
        itemType processore = itemType.processori;
        itemType mouse = itemType.mouse;
        itemType tastiere = itemType.tastiere;
        User utente = new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora = LocalTime.of(1, 1, 1);

        //Setup Caso 1: Il prezzo totale è inferiore a 10, quindi viene aggiunto 2
        List<EItem> lista1 = new ArrayList<>();
        EItem processore1 = new EItem(nome, 7, processore);
        lista1.add(processore1);
        Conto conto1 = new Conto(utente, lista1, ora);
        double totale1 = 9;
        double prezzo1 = conto1.getOrderPrice(conto1.getList(), conto1.getUser());    //Caso di mouse come oggetto meno caro

        Assert.assertEquals(totale1, prezzo1, 0.01);
    }
    @Test
    public void CommissioniConOmaggioTest() throws BillException {
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        itemType tastiere=itemType.tastiere;
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora=LocalTime.of(1, 1, 1);

        //Setup Caso 2: Il prezzo totale è maggiore a 10, ma tastiere e mouse sono
        // in egual numero, quindi viene regalato il meno costoso. Il prezzo totale
        // scende sotto a 10, quindi viene aggiunto 2
        List<EItem> lista2=new ArrayList<>();
        EItem mouse1=new EItem(nome, 8, mouse);
        EItem tastiera1=new EItem(nome, 9, tastiere);
        lista2.add(mouse1);
        lista2.add(tastiera1);
        Conto conto2=new Conto(utente, lista2, ora);
        double totale2=11;
        double prezzo2=conto2.getOrderPrice(conto2.getList(), conto2.getUser());    //Caso di tastiera come oggetto meno caro

        Assert.assertEquals(totale2, prezzo2, 0.01);
    }

    @Test
    public void omaggioTest() throws BillException{
        String nome="esempio";
        itemType processore=itemType.processori;
        itemType mouse=itemType.mouse;
        itemType tastiere=itemType.tastiere;
        User utente=new User("Mario", LocalDate.of(2000, 1, 1));
        LocalTime ora=LocalTime.of(1, 1, 1);
        List<EItem> lista=new ArrayList<>();
        EItem processore1=new EItem(nome, 7, processore);
        lista.add(processore1);
        Conto conto=new Conto(utente, lista, ora);
        double totale=0;

        conto.setOmaggio(true);
        double prezzo= conto.getOrderPrice(conto.getList(), conto.getUser());

        Assert.assertEquals(totale, prezzo, 0.01);
    }
}