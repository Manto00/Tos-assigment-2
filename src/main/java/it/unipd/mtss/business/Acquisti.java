////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

import it.unipd.mtss.business.Conto;
import it.unipd.mtss.model.EItem;

import java.time.temporal.ChronoUnit;
import java.util.Random;

import static java.time.temporal.ChronoUnit.DAYS;

public class Acquisti{
    private List<Conto> acquisti;

    public Acquisti(List<Conto> acquisti){
        this.acquisti=acquisti;
    }

    public Conto getConto(int i){
        return acquisti.get(i);
    }

    public void giveOmaggio(){
        Random rand= new Random();
        List<Conto> copy = new ArrayList<>();
        copy.addAll(acquisti);
        LocalDate oggi = LocalDate.now();
        for (int i=0; i<copy.size(); i++){
            long daysBetween = DAYS.between(copy.get(i).getUser().getNascita(), oggi);
            if (daysBetween>=6570){
                copy.remove(i);
                i--;
            }
        }

        for (int i=0; i<copy.size(); i++){
            if (!(copy.get(i).getOra().getHour()==18 || (copy.get(i).getOra().getHour()==19
                    && copy.get(i).getOra().getMinute()==0 && copy.get(i).getOra().getSecond()==0))){
                copy.remove(i);
                i--;
            }
        }

        for (int i=0; i<10 && copy.size()!=0; i++){
            int val=rand.nextInt(copy.size());
            copy.get(val).setOmaggio(true);
            String utente=copy.get(val).getUser().getName();
            for (int j=0; j<copy.size(); j++){
                if (copy.get(j).getUser().getName()==utente){
                    copy.remove(j);
                    j--;
                }
            }
        }

    }
}