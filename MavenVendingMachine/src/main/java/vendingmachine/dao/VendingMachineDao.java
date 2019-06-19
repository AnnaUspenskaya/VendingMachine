/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * @author anna
 */
public interface VendingMachineDao {
    //GetAll, GetById, and Update
    	    List<Item> getAllItems() throws VendingMachinePersistenceException;
            Item getItem(String itemId)throws VendingMachinePersistenceException;
            Item update(String itemId)throws VendingMachinePersistenceException;
            ////
            

}
