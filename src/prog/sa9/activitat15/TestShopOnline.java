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
    }
}
