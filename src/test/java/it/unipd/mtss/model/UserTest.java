////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;
import it.unipd.mtss.model.User;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;


public class UserTest {
    @Test
    public void SingleConstructorTest(){
        User.setCount(0);
        String nome="Antonio";
        LocalDate nascita=LocalDate.of(1987, 6, 15);
        User utente=new User(nome, nascita);
        Assert.assertEquals(0, utente.getId());
        Assert.assertEquals(nome, utente.getName());
        Assert.assertEquals(nascita, utente.getNascita());
    }

    @Test
    public void IdIncrementTest(){
        User.setCount(0);
        String nome="Mario";
        LocalDate nascita=LocalDate.of(2000, 1, 1);
        User utente0=new User(nome, nascita);
        User utente1=new User(nome, nascita);
        User utente2=new User(nome, nascita);
        Assert.assertEquals(0, utente0.getId());
        Assert.assertEquals(1, utente1.getId());
        Assert.assertEquals(2, utente2.getId());
    }
}