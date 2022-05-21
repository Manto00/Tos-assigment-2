////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private LocalDate nascita;
    private static int count=0;

    public User(String name, LocalDate nascita){
        id=count++;
        this.name=name;
        this.nascita=nascita;
    }

    public static void setCount(int val){
        count=val;
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