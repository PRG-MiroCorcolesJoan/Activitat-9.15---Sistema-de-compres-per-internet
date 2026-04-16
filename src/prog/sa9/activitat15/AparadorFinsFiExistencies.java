/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

import java.util.ArrayList;

/**
 *
 * @author joan
 */
public class AparadorFinsFiExistencies extends Aparador {

    private boolean tancat;

    public AparadorFinsFiExistencies(String nom, Marca marca, ArrayList<Producte> productes) {
        super(nom, marca, productes);
        this.tancat = false;
    }

    public void tancar() {
        this.tancat = true;
    }

    @Override
    public boolean estaObert() {
        return !tancat && teStock();
    }
}
