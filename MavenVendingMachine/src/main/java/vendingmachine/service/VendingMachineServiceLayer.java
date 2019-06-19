/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author anna
 */
public interface VendingMachineServiceLayer {
        List<Item> getAllItems() throws 
            VendingMachinePersistenceException;
 
    Item getItem(String itemId) throws 
            VendingMachinePersistenceException;
 
    Item updateItem(String itemId) throws 
            VendingMachinePersistenceException;
    BigDecimal deposit(BigDecimal deposit);
    Change change(Item item, BigDecimal currentBlance) throws VendingMachinePersistenceException;
    
}