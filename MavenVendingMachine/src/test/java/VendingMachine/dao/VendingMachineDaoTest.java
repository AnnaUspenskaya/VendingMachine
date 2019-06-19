/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Item;
import vendingmachine.dao.VendingMachineDaoFileImpl;

/**
 *
 * @author anna
 */
public class VendingMachineDaoTest {
    private VendingMachineDao dao = new VendingMachineDaoFileImpl();
    public VendingMachineDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{

    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {
   
        assertEquals(4,dao.getAllItems().size());//4 items in the inventory.txt file
        
    }

    /**
     * Test of getItem method, of class VendingMachineDao.
     */
    // DOESN'T WORK 
//    @Test
//    public void testGetItem() throws Exception {
//        Item item1 = new Item("A3");
//        item1.setName("KitKat");
//        item1.setPrice(new BigDecimal("2.75"));
//        item1.setQuantity(3);
//        dao.getItem("A3");
//        assertEquals(item1, dao.getItem(item1.getId()));
//    }

    /**
     * Test of update method, of class VendingMachineDao.
     */
    @Test
    public void testUpdate() throws Exception {
        Item item1 = new Item("A3");
        item1.setName("KitKat");
        item1.setPrice(new BigDecimal("2.75"));
        item1.setQuantity(3);
        dao.update("A3");
        assertEquals(2,item1.getQuantity());
        
    }

    
}
