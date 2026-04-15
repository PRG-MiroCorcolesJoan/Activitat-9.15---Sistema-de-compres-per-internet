/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

/**
 *
 * @author joan
 */
public class Test {

    public static void main(String[] args) {
        Producte p1 = new Producte("pol a ratlles", 50, Marca.LACOSTERA);
        Producte p2 = new Producte("vestit de bany blau", 40, Marca.LACOSTERA);

        StockProducte s1 = new StockProducte(p1, 5);
        StockProducte s2 = new StockProducte(p2, 3);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("Comparació alfabètica: " + p1.compareTo(p2));
        System.out.println("Mateix producte? " + p1.equals(p2));
    }
}
