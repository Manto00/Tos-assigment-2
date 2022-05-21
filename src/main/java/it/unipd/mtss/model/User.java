////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private int id;
    private String name;
    private LocalDate nascita;
    private static final AtomicInteger count=new AtomicInteger(0);

    public User(String name, LocalDate nascita){
        id=count.incrementAndGet();
        this.name=name;
        this.nascita=nascita;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public LocalDate getNascita() {
        return nascita;
    }
}