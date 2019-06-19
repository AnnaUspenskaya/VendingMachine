/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vendingmachine.dto.Item;

/**
 *
 * @author anna
 */
public class VendingMachineDaoStubImpl implements VendingMachineDao{
Item onlyItem;
List<Item>items=new ArrayList<>();

public VendingMachineDaoStubImpl(){
    onlyItem = new Item("A4");
    onlyItem.setName("Snickers");
    onlyItem.setPrice(new BigDecimal("2.50"));
    onlyItem.setQuantity(3);
    items.add(onlyItem);
}
    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
return items; 
    }

    @Override
    public Item getItem(String itemId) throws VendingMachinePersistenceException {
if (itemId.equals(onlyItem.getId())){
    return onlyItem;
} else{
    return null;
}
    }

    @Override
    public Item update(String itemId) throws VendingMachinePersistenceException {
///????
        if (itemId.equals(onlyItem.getId())){
    return onlyItem;
} else{
    return null;
}    }
    
}
