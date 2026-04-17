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
public class TestShopOnline {

    public static void main(String[] args) {
        Producte polRatlles = new Producte("pol a ratlles", 50, Marca.LACOSTERA);
        Producte vestitBanyBlau = new Producte("vestit de bany blau", 40, Marca.LACOSTERA);

        ArrayList<Producte> productesLaCostera = new ArrayList<>();
        productesLaCostera.add(polRatlles);
        productesLaCostera.add(vestitBanyBlau);

        AparadorTemporalFinsFiExistencies aparador = new AparadorTemporalFinsFiExistencies(
                "estiu LaCostera 2025",
                Marca.LACOSTERA,
                productesLaCostera,
                3
        );

        System.out.println("PRODUCTES ORDENATS ALFABETICAMENT");
        System.out.println(aparador.obtindreProductesOrdenatsAlfabeticment());

        System.out.println("UNITATS EN ESTOC");
        System.out.println(polRatlles.getIdentificador() + ": " + aparador.obtindreUnitatsDisponibles(polRatlles));
        System.out.println(vestitBanyBlau.getIdentificador() + ": " + aparador.obtindreUnitatsDisponibles(vestitBanyBlau));

        System.out.println("DIES RESTANTS");
        System.out.println(aparador.getDiesRestants());

        try {
            int unitatsPol = aparador.obtindreUnitatsDisponibles(polRatlles);
            int unitatsVestit = aparador.obtindreUnitatsDisponibles(vestitBanyBlau);

            aparador.comprarProducte(polRatlles, unitatsPol);
            aparador.comprarProducte(vestitBanyBlau, unitatsVestit);

            System.out.println("COMPRES REALITZADES CORRECTAMENT");
        } catch (ShowRoomNotOpenException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("APARADOR OBERT?");
        System.out.println(aparador.estaObert());

        Producte camisetaPepe = new Producte("camiseta pepe", 25, Marca.PEPEWEAR);
        Producte pantaloPepe = new Producte("pantalo pepe", 35, Marca.PEPEWEAR);

        ArrayList<Producte> productesPepe = new ArrayList<>();
        productesPepe.add(camisetaPepe);
        productesPepe.add(pantaloPepe);

        AparadorFinsFiExistencies aparadorPepe = new AparadorFinsFiExistencies(
                "outlet PepeWear",
                Marca.PEPEWEAR,
                productesPepe
        );

        System.out.println("APARADOR FINS FI EXISTENCIES OBERT");
        System.out.println(aparadorPepe.estaObert());

        aparadorPepe.tancar();

        System.out.println("APARADOR FINS FI EXISTENCIES TANCAT");
        System.out.println(aparadorPepe.estaObert());

        Producte taronger1 = new Producte("camisa taronger", 30, Marca.FLOR_DEL_TARONGER);
        Producte taronger2 = new Producte("falda taronger", 45, Marca.FLOR_DEL_TARONGER);

        ArrayList<Producte> productesTaronger = new ArrayList<>();
        productesTaronger.add(taronger1);
        productesTaronger.add(taronger2);

        AparadorTemporal aparadorTemporal = new AparadorTemporal(
                "promo primavera",
                Marca.FLOR_DEL_TARONGER,
                productesTaronger,
                5
        );

        System.out.println("APARADOR TEMPORAL OBERT");
        System.out.println(aparadorTemporal.estaObert());
        System.out.println("DIES RESTANTS APARADOR TEMPORAL");
        System.out.println(aparadorTemporal.getDiesRestants());

        System.out.println("CONSULTA DE PRODUCTE DISPONIBLE");
        System.out.println(aparadorTemporal.teProducte(taronger1));

        System.out.println("CONSULTA D'UNITATS DISPONIBLES");
        System.out.println(aparadorTemporal.hiHaUnitatsDisponibles(taronger1, 1));

        /*
        Producte producteMarcaIncorrecta = new Producte("error marca", 20, Marca.PEPEWEAR);
        ArrayList<Producte> llistaIncorrecta = new ArrayList<>();
        llistaIncorrecta.add(producteMarcaIncorrecta);
        AparadorTemporal errorAparador = new AparadorTemporal("error", Marca.LACOSTERA, llistaIncorrecta, 2);
        */

        /*
        try {
            aparadorTemporal.comprarProducte(taronger1, 999);
        } catch (ShowRoomNotOpenException e) {
            System.out.println(e.getMessage());
        }
        */
    }
}