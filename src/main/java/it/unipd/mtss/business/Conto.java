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

import java.util.ArrayList;
import java.util.List;

public class Conto implements Bill{
    private User utente;
    private List<EItem> lista;

    @Override
    public double getOrderPrice(List<EItem> itemsOrdered, User user)
            throws BillException {
        double finalPrezzo=0;
        int n_processori=0;
        int n_mouse=0;
        int n_tastiere=0;
        double min_processori_price=0;
        double min_mouse_price=0;
        double sconto_tastiere_mouse=0;
        boolean first_mouse=true;
        boolean first_processore=true;

        for (int i=0; i<itemsOrdered.size(); i++){

            if(itemsOrdered.get(i).getItemType()== itemType.processori)
            {
                n_processori++;
                if(first_processore){
                    min_processori_price=itemsOrdered.get(i).getPrice();
                    first_processore=false;
                } else if (itemsOrdered.get(i).getPrice()
                        <min_processori_price) {
                    min_processori_price = itemsOrdered.get(i).getPrice();
                }
            }

            if (itemsOrdered.get(i).getItemType()== itemType.mouse)
            {
                n_mouse++;
                if(first_mouse){
                    min_mouse_price=itemsOrdered.get(i).getPrice();
                    first_mouse=false;
                } else if (itemsOrdered.get(i).getPrice()
                        <min_mouse_price) {
                    min_mouse_price = itemsOrdered.get(i).getPrice();
                }
            }

            if (itemsOrdered.get(i).getItemType()== itemType.tastiere){
                n_tastiere++;
            }


            EItem temp=itemsOrdered.get(i);
            finalPrezzo+=temp.getPrice();
        }

        if (n_mouse==n_tastiere && n_mouse!=0) {
            int min_mouse_tastiera = 0;
            double min_prezzo = 0;

            for (int j = 0; j < itemsOrdered.size(); j++) {
                if ((itemsOrdered.get(j).getItemType() == itemType.mouse
                        || itemsOrdered.get(j).getItemType() == itemType.tastiere
                )   //L'oggetto è un mouse o una tastiera
                        && (itemsOrdered.get(j).getPrice() <= min_prezzo || j == 0
                )   //E costa <= l'oggetto meno caro o è il primo oggetto
                ) {
                    if (itemsOrdered.get(j).getPrice() == min_prezzo &&
                            itemsOrdered.get(j).getItemType() == itemType.tastiere &&
                            itemsOrdered.get(min_mouse_tastiera).getItemType() == itemType.mouse) {
                        //É stato trovato un oggetto con lo stesso prezzo
                        //L'oggetto meno caro attuale è un mouse
                        //Il secondo oggetto è una tastiera
                        //Il mouse rimane l'oggetto meno caro
                    }
                    min_mouse_tastiera = j;
                    min_prezzo = itemsOrdered.get(j).getPrice();
                }
            }// POST: min_mouse_tastiera indica l'oggeto meno caro, favorendo i mouse

            if (n_mouse > 10
                    && itemsOrdered.get(min_mouse_tastiera).getItemType() == itemType.mouse) {
                List<EItem> copia = new ArrayList<>(itemsOrdered);
                copia.remove(min_mouse_tastiera);
                for (int j = 0; j < copia.size(); j++) {
                    if ((copia.get(j).getItemType() == itemType.mouse
                            || copia.get(j).getItemType() == itemType.tastiere
                    )   //L'oggetto è un mouse o una tastiera
                            && (copia.get(j).getPrice() <= min_prezzo || j == 0
                    )   //E costa <= l'oggetto meno caro o è il primo oggetto
                    ) {
                        min_prezzo = copia.get(j).getPrice();
                    }
                }
            }
            sconto_tastiere_mouse = min_prezzo;
        }

        finalPrezzo-=sconto_tastiere_mouse;
        if(n_processori>5){
            finalPrezzo-=(min_processori_price/2);
        }
        if(n_mouse>10){
            finalPrezzo-=(min_mouse_price);
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