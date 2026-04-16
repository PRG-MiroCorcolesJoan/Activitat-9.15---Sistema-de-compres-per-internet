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
public class AparadorTemporal extends Aparador {

    private int diesObertura;
    private long instantCreacio;
    private static final long MILLIS_PER_DIA = 86400L * 1000L;

    public AparadorTemporal(String nom, Marca marca, ArrayList<Producte> productes, int diesObertura) {
        super(nom, marca, productes);
        assert diesObertura > 0 : "Els dies d'obertura han de ser positius";
        this.diesObertura = diesObertura;
        this.instantCreacio = System.currentTimeMillis();
    }

    public int getDiesObertura() {
        return diesObertura;
    }

    public double getDiesRestants() {
        long tempsTranscorregut = System.currentTimeMillis() - instantCreacio;
        long tempsTotal = diesObertura * MILLIS_PER_DIA;
        long tempsRestant = tempsTotal - tempsTranscorregut;

        if (tempsRestant <= 0) {
            return 0;
        }

        return (double) tempsRestant / MILLIS_PER_DIA;
    }

    @Override
    public boolean estaObert() {
        long tempsTranscorregut = System.currentTimeMillis() - instantCreacio;
        long tempsTotal = diesObertura * MILLIS_PER_DIA;
        return tempsTranscorregut < tempsTotal;
    }
}
