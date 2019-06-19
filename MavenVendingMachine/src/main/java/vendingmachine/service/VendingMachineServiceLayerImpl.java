/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;
import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;


/**
 *
 * @author anna
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    private VendingMachineAuditDao auditDao;
    private UserIO io = new UserIOConsoleImpl();
    private BigDecimal currentBalance;

    VendingMachineDao dao;
    VendingMachineDaoFileImpl daoImpl;

    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
        currentBalance = new BigDecimal("0.00");
    }

    @Override
    public List<Item> getAllItems() throws VendingMachinePersistenceException {
        return dao.getAllItems();
    }

    @Override
    public Item getItem(String itemId) throws VendingMachinePersistenceException {

        return dao.getItem(itemId);
    }

    @Override
    public Item updateItem(String itemId) throws VendingMachinePersistenceException {
        Item selectedItem = dao.update(itemId);
        //auditDao.writeAuditEntry("Item " + itemId + " has been updated.");
        return selectedItem;
    }

    @Override
    public BigDecimal deposit(BigDecimal money) {
        currentBalance = currentBalance.add(money);
        return currentBalance;
    }

    @Override
    public Change change(Item item, BigDecimal currentBalance) throws VendingMachinePersistenceException {
        Change change = new Change();

        currentBalance.subtract(item.getPrice());
        BigDecimal cb = currentBalance.subtract(item.getPrice());
        cb = cb.multiply(new BigDecimal("100"));
        int changeBack = cb.intValue();

        if (changeBack / 100 != 0) {
            change.setDollars(changeBack / 100);
            changeBack = changeBack % 100;

        }
        if (changeBack / 25 != 0) {
            change.setQuarters(changeBack / 25);
            changeBack = changeBack % 25;
        }
        if (changeBack / 10 != 0) {
            change.setDimes(changeBack / 10);
            changeBack = changeBack % 10;
        }
        if (changeBack / 5 != 0) {
            change.setNickels(changeBack / 5);
            changeBack = changeBack % 5;
        }

        change.setPennies(changeBack);

        return change;

    }

}
