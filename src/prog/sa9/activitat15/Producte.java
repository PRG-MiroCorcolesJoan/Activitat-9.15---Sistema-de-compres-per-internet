/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

import java.util.Objects;

/**
 *
 * @author joan
 */
public class Producte implements Comparable<Producte> {

    private String identificador;
    private double preu;
    private Marca marca;

    public Producte(String identificador, double preu, Marca marca) {

        assert identificador != null && !identificador.trim().isEmpty() : "L'identificador no pot ser nul ni buit";

        assert preu >= 0 : "El preu no pot ser negatiu";

        assert marca != null : "La marca no pot ser nul·la";

        this.identificador = identificador;
        this.preu = preu;
        this.marca = marca;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getPreu() {
        return preu;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setPreu(double preu) {

        assert preu >= 0 : "El preu no pot ser negatiu";

        this.preu = preu;
    }

    @Override
    public int compareTo(Producte altreProducte) {

        assert altreProducte != null : "No es pot comparar amb null";

        return this.identificador.compareToIgnoreCase(altreProducte.identificador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Producte)) {
            return false;
        }

        Producte altreProducte = (Producte) obj;
        return this.identificador.equalsIgnoreCase(altreProducte.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador.toLowerCase());
    }

    @Override
    public String toString() {
        return "Producte{" + "identificador=" + identificador
                + ", preu=" + preu
                + ", marca=" + marca + '}';
    }
}
