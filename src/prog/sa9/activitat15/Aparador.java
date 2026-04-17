/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author joan
 */
public abstract class Aparador {

    private String nom;
    private Marca marca;
    private ArrayList<StockProducte> estoc;

    public Aparador(String nom, Marca marca, ArrayList<Producte> productes) {
        assert nom != null && !nom.trim().isEmpty() : "El nom no pot ser buit";
        assert marca != null : "La marca no pot ser null";
        assert productes != null : "La llista de productes no pot ser null";

        this.nom = nom;
        this.marca = marca;
        this.estoc = new ArrayList<>();

        inicialitzarEstoc(productes);
    }

    private void inicialitzarEstoc(ArrayList<Producte> productes) {
        for (Producte producte : productes) {
            if (producte == null) {
                continue;
            }

            if (producte.getMarca() != this.marca) {
                throw new CanNotMergeBrandsException("Tots els productes de l'aparador han de ser de la marca " + this.marca);
            }

            if (!existeixProducteEnEstoc(producte)) {
                if (estoc.size() >= 20) {
                    throw new IllegalArgumentException("Un aparador no pot tindre més de 20 productes distints");
                }

                int unitats = (int) (Math.random() * 10) + 1;
                estoc.add(new StockProducte(producte, unitats));
            }
        }
    }

    private boolean existeixProducteEnEstoc(Producte producte) {
        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getProducte().equals(producte)) {
                return true;
            }
        }
        return false;
    }

    public String getNom() {
        return nom;
    }

    public Marca getMarca() {
        return marca;
    }

    public ArrayList<StockProducte> getEstoc() {
        return estoc;
    }

    public ArrayList<Producte> obtindreProductesAVenda() {
        ArrayList<Producte> productesDisponibles = new ArrayList<>();

        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getUnitatsDisponibles() > 0) {
                productesDisponibles.add(stockProducte.getProducte());
            }
        }

        return productesDisponibles;
    }

    public ArrayList<Producte> obtindreProductesOrdenatsAlfabeticment() {
        ArrayList<Producte> productesOrdenats = obtindreProductesAVenda();
        Collections.sort(productesOrdenats);
        return productesOrdenats;
    }

    public boolean teProducte(Producte producte) {
        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getProducte().equals(producte)
                    && stockProducte.getUnitatsDisponibles() > 0) {
                return true;
            }
        }

        return false;
    }

    public int obtindreUnitatsDisponibles(Producte producte) {
        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getProducte().equals(producte)) {
                return stockProducte.getUnitatsDisponibles();
            }
        }

        return 0;
    }

    public boolean hiHaUnitatsDisponibles(Producte producte, int unitats) {
        assert unitats > 0 : "Les unitats a consultar han de ser positives";

        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getProducte().equals(producte)
                    && stockProducte.getUnitatsDisponibles() >= unitats) {
                return true;
            }
        }

        return false;
    }

    public boolean teStock() {
        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getUnitatsDisponibles() > 0) {
                return true;
            }
        }

        return false;
    }

    public void comprarProducte(Producte producte, int unitats) throws ShowRoomNotOpenException {
        assert producte != null : "El producte no pot ser null";
        assert unitats > 0 : "Les unitats a comprar han de ser positives";

        if (!estaObert()) {
            throw new ShowRoomNotOpenException("L'aparador no està obert");
        }

        for (StockProducte stockProducte : estoc) {
            if (stockProducte.getProducte().equals(producte)) {
                if (stockProducte.getUnitatsDisponibles() < unitats) {
                    throw new NotExistEnougthItemException("No hi ha suficients unitats del producte " + producte.getIdentificador());
                }

                stockProducte.decrementarUnitats(unitats);
                return;
            }
        }

        throw new NotExistEnougthItemException("El producte no està disponible en l'estoc");
    }

    public abstract boolean estaObert();

    @Override
    public String toString() {
        return "Aparador{" + "nom=" + nom + ", marca=" + marca + ", estoc=" + estoc + '}';
    }
}
