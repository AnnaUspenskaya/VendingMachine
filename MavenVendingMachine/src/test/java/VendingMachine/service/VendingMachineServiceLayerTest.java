/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VendingMachine.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoStubImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;

/**
 *
 * @author anna
 */
public class VendingMachineServiceLayerTest {

    Item item;
    private VendingMachineServiceLayer service;
    Change change;

    // private VendingMachineServiceLayer service;
    public VendingMachineServiceLayerTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
        service = new VendingMachineServiceLayerImpl(dao, auditDao);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayer.
     */
    
    //DOESN'T WORK
    
    
//    @Test
//    public void testZeroChange() {
//        //Act 
//        //Assert
//        assertEquals(service.deposit(BigDecimal.ZERO), BigDecimal.ZERO);
//        assertNotNull(change);
//        assertEquals(0, change.getQuarters());
//        assertEquals(0, change.getNickels());
//        assertEquals(0, change.getDimes());
//        assertEquals(0, change.getPennies());
//
//    }
    @Test
    public void tessChangeOnePenny() throws VendingMachinePersistenceException{
        
        service.deposit(new BigDecimal("0.01"));
       // Change change = service.change(item, BigDecimal.ONE);
       // assertEquals(service.deposit(BigDecimal.ZERO), BigDecimal.ZERO);
        assertNotNull(change);
        assertEquals(change.getQuarters(),  0);
        assertEquals(change.getNickels(), 0);
        assertEquals(change.getDimes(),  0);
        assertEquals(change.getPennies(),  1);
    }

    //DOESN'T WORK
//        @Test
//    public void testGetWrongItem() throws Exception {
//
//        try{
//            service.getItem("c3");
//            fail("Expected VendingMachinePersistenceException was not thrown");
//        }catch (VendingMachinePersistenceException e){
//            return;
//        }
//    }
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, service.getAllItems().size());
    }

    /**
     * Test of getItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
        Item item = service.getItem("A4");
        assertNotNull(item);
        item = service.getItem("555");
        assertNull(item);
    }

    /**
     * Test of updateItem method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testUpdateItem() throws Exception {
        Item item = service.updateItem("A4");
        assertNotNull(item);
        item = service.updateItem("555");
        assertNull(item);

//Arrange      
//        item.setId("A3");
//        item.setName("KitKat");
//        item.setPrice(new BigDecimal ("2.25"));
//        item.setQuantity(3);
//        String ItemId = item.getId();
//        //Act
//        service.updateItem(ItemId);
//        //Assert
//        assertEquals(item.getQuantity(),2);
    }

    /**
     * Test of deposit method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testDeposit() {

    }

    /**
     * Test of change method, of class VendingMachineServiceLayer.
     */
    @Test
    public void testChange() throws Exception {
        //Arrange
//        
//        Item item;
//        item.setId("A3");
//        item.setName("KitKat");
//        item.setPrice(new BigDecimal ("2.25"));
//        item.setQuantity(3);
//        BigDecimal deposit = new BigDecimal("3");
//        //Act
//        service.change(item, deposit);
//        
//        //Assert
//        assertEquals(change.getQuarters(),3);
    }

//    public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
//
//        public List<Item> getAllItems() throws VendingMachinePersistenceException {
//            return null;
//        }
//
//        public Item getItem(String itemId) throws VendingMachinePersistenceException {
//            return null;
//        }
//
//        public Item updateItem(String itemId) throws VendingMachinePersistenceException {
//            return null;
//        }
//
//        public BigDecimal deposit(BigDecimal deposit) {
//            return null;
//        }
//
//        public Change change(Item item, BigDecimal currentBlance) throws VendingMachinePersistenceException {
//            return null;
//        }
//    }
}
