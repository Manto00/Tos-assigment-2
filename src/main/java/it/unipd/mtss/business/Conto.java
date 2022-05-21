////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;

import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.business.bill.Bill;

import java.util.List;

public class Conto implements Bill{
    private User utente;
    private List<EItem> lista;

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user) throws BillException {
        double finalPrezzo=0;
        for (int i=0; i<itemsOrdered.size(); i++){
            EItem temp=itemsOrdered.get(i);
            finalPrezzo+=temp.getPrice();
        }
        return finalPrezzo;
    }

    public Conto(User utente, List<EItem> lista){
        this.utente=utente;
        this.lista=lista;
    }

    public User getUser(){
        return utente;
    }
    public List<EItem> getList(){
        return lista;
    }
}