////////////////////////////////////////////////////////////////////
// [GABRIELE] [MANTOAN][1216746]
// [RAFFAELE] [OLIVIERO] [1216748]
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

import it.unipd.mtss.model.itemType;

public class EItem{
    private String name;
    private double price;
    private itemType itemType;

    public EItem(String nome, double prezzo, itemType tipo){
        name=nome;
        price=prezzo;
        itemType=tipo;
    }

    public double getPrice() {
        return price;
    }

    public it.unipd.mtss.model.itemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }
}