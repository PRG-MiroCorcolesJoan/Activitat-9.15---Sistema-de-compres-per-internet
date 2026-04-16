/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.sa9.activitat15;

/**
 *
 * @author joan
 */
public class NotExistEnougthItemException extends RuntimeException {

    public NotExistEnougthItemException() {
        super("No hi ha suficients unitats del producte en l'estoc");
    }

    public NotExistEnougthItemException(String message) {
        super(message);
    }
}
