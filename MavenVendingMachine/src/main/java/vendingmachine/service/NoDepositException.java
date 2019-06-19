/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

/**
 *
 * @author anna
 */
public class NoDepositException extends Exception{

    public NoDepositException(String message) {
        super(message);
    }

    public NoDepositException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
