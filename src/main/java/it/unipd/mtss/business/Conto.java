////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN] [1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.business;
import it.unipd.mtss.business.Bill;
import it.unipd.mtss.business.exception.BillException;
import it.unipd.mtss.model.EItem;
import it.unipd.mtss.model.User;
import it.unipd.mtss.model.itemType;

import java.util.List;

public class Conto implements Bill{
    private User utente;
    private List<EItem> lista;

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user)
            throws BillException {
        double finalPrezzo=0;
        int n_processori=0;
        double min_processori_price=0;
        boolean first=false;
        for (int i=0; i<itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).getItemType()== itemType.processori)
            {
                n_processori++;
                if(!first){
                    min_processori_price=itemsOrdered.get(i).getPrice();
                    first=true;
                } else if (itemsOrdered.get(i).getPrice()
                        <min_processori_price) {
                    min_processori_price = itemsOrdered.get(i).getPrice();
                }
            }

            EItem temp=itemsOrdered.get(i);
            finalPrezzo+=temp.getPrice();
        }
        if(n_processori>5){
            finalPrezzo-=(min_processori_price/2);
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