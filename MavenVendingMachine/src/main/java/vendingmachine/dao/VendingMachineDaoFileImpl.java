/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vendingmachine.dto.Item;

/**
 *
 * @author anna
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {
public static final String INVENTORY_FILE = "Inventory.txt";
public static final String DELIMITER = "::";
	
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException{
    
        loadInventory();

return new ArrayList<Item>(items.values());
    }

    @Override
    public Item getItem(String itemId) throws VendingMachinePersistenceException{
        loadInventory();
return items.get(itemId);    
    }

    @Override
    public Item update(String itemId) throws VendingMachinePersistenceException{
        Item updateItem = items.get(itemId);
        int decrement = 1;
        int newQuantity = updateItem.getQuantity()-decrement;
        updateItem.setQuantity(newQuantity);
        writeInventory();
        return updateItem;
    }
    private Map<String, Item> items = new HashMap<>();
     private void loadInventory() throws VendingMachinePersistenceException{
	    Scanner scanner;
try{
	        scanner = new Scanner(
	                new BufferedReader(
	                        new FileReader(INVENTORY_FILE)));
}catch(FileNotFoundException e) {
	        throw new VendingMachinePersistenceException(
	                "Could not load inventory data into memory.", e);
}
 String currentLine;
    String[] currentTokens;

	    while (scanner.hasNextLine()) {
	        currentLine = scanner.nextLine();
	        currentTokens = currentLine.split(DELIMITER);
	        Item item=new Item(currentTokens[0]);
	        item.setName(currentTokens[1]);
                item.setPrice(new BigDecimal (currentTokens[2]));
	        item.setQuantity(Integer.parseInt(currentTokens[3]));
	        
	        items.put(item.getId(), item);
	    }
	   
	    scanner.close();
	}
     private void writeInventory() throws VendingMachinePersistenceException {

	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(INVENTORY_FILE));
	    } catch (IOException e) {
	        throw new VendingMachinePersistenceException(
	                "Could not update the Item data", e);
	    }

	    List<Item> items = this.getAllItems();
	    for (Item item : items) {
	        out.println(item.getId() + DELIMITER
	                + item.getName() + DELIMITER 
	                + item.getPrice() + DELIMITER
	                + item.getQuantity());
	        out.flush();
	    }
	    out.close();
	}

}
