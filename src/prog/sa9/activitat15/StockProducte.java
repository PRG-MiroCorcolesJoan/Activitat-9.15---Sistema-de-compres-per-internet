/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

/**
 *
 * @author joan
 */
public class StockProducte {

    private Producte producte;
    private int unitatsDisponibles;

    public StockProducte(Producte producte, int unitatsDisponibles) {

        assert producte != null : "El producte no pot ser null";

        assert unitatsDisponibles > 0 : "Les unitats inicials han de ser majors que 0";

        this.producte = producte;
        this.unitatsDisponibles = unitatsDisponibles;
    }

    public Producte getProducte() {
        return producte;
    }

    public int getUnitatsDisponibles() {
        return unitatsDisponibles;
    }

    public void decrementarUnitats(int quantitat) {

        assert quantitat > 0 : "La quantitat a restar ha de ser positiva";

        assert unitatsDisponibles - quantitat >= 0 : "No es poden deixar unitats negatives en stock";

        this.unitatsDisponibles -= quantitat;
    }
    @Override
    public String toString() {
        return "StockProducte{" + "producte=" + producte
                + ", unitatsDisponibles=" + unitatsDisponibles + '}';
    }
}
