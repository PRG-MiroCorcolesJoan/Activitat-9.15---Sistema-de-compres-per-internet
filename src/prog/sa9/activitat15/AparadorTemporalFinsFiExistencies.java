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
public class AparadorTemporalFinsFiExistencies extends AparadorTemporal {

    public AparadorTemporalFinsFiExistencies(String nom, Marca marca, ArrayList<Producte> productes, int diesObertura) {
        super(nom, marca, productes, diesObertura);
        assert diesObertura <= 3 : "Aquest aparador no pot estar obert més de 3 dies";
    }

    @Override
    public boolean estaObert() {
        return super.estaObert() && teStock();
    }
}
