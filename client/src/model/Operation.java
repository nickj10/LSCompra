package model;

import java.io.Serializable;

public class Operation implements Serializable {
    private Producte producte;
    private String oper;

    public Operation(Producte producte, String oper) {
        this.producte = producte;
        this.oper = oper;
    }

    public Producte getProducte() {
        return producte;
    }

    public void setProducte(Producte producte) {
        this.producte = producte;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
}
