/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

/**
 *
 * @author anna
 */
public class VendingMachinePersistenceException extends Exception {
    	    public VendingMachinePersistenceException(String message) {
	        super(message);
	    }
	    
	    public VendingMachinePersistenceException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
