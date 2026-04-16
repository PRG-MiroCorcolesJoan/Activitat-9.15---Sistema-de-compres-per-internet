/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

/**
 *
 * @author joan
 */
public class CanNotMergeBrandsException extends RuntimeException {

    public CanNotMergeBrandsException() {
        super("No es poden mesclar productes de distintes marques en un mateix aparador");
    }

    public CanNotMergeBrandsException(String message) {
        super(message);
    }
}
