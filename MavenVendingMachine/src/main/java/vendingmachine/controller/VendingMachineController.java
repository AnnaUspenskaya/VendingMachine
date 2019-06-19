/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.controller;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoDepositException;
import vendingmachine.service.VendingMachineOutOfInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author anna
 */
public class VendingMachineController {

    VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();
    VendingMachineServiceLayer service;

    public VendingMachineController(VendingMachineServiceLayer service, VendingMachineView view) {
        this.service = service;
        this.view = view;
    }

    public void run() throws VendingMachineOutOfInventoryException, VendingMachineOutOfInventoryException, InsufficientFundsException, NoDepositException, NumberFormatException {
        view.vendingMachine();
        view.vendingMachineBorder();
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                itemList();
                view.vendingMachineBorder();
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        purchaseItem();
                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                        view.unknownCommand();
                }

            }
            view.bye();
        } catch (VendingMachinePersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void itemList() throws VendingMachinePersistenceException {
        List<Item> items = service.getAllItems();
        view.displayItemList(items);
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void purchaseItem() throws VendingMachinePersistenceException, VendingMachineOutOfInventoryException, InsufficientFundsException, NoDepositException, NumberFormatException {

        try {
            Change change = new Change();
            String itemId = view.getItemById();
            Item item = service.getItem(itemId);
            view.displayItem(item);
            BigDecimal deposit = view.deposit(item);
            BigDecimal currentBalance = service.deposit(deposit);
            change = service.change(item, currentBalance);
            view.change(itemId, change);
            view.thanksBanner();
            service.updateItem(itemId);
        } catch (VendingMachinePersistenceException | VendingMachineOutOfInventoryException | InsufficientFundsException | NoDepositException ex) {
            view.displayErrorMessage(ex.getMessage());
            purchaseItem();
        }

    }

}
