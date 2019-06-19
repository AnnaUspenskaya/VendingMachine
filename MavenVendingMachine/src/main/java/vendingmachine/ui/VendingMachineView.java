/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

import java.math.BigDecimal;
import java.util.List;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachinePersistenceException;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoDepositException;

import vendingmachine.service.VendingMachineOutOfInventoryException;

/**
 *
 * @author anna
 */
public class VendingMachineView {

    private UserIO io;

    public VendingMachineView(UserIO io) {
        this.io = io;
    }
    VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public int printMenuAndGetSelection() {
        io.print("Press ① to PURCHASE  an item");
        io.print("Press ② to EXIT");

        return io.readInt(" ", 1, 2);
    }

    public void displayItemList(List<Item> items) {
        io.print("•━─────────≪✷≫─────────━");
        for (Item item : items) {

            io.print(item.getId() + " | "
                    + item.getName() + " | $"
                    + item.getPrice() + " | "
                    + item.getQuantity());

        }
        io.print("•━─────────≪✷≫───────────━");
    }

    public String getItemById() {
        String selectItem = io.readString("Please, select an item.  (upper or lower case.)");
        return selectItem.toUpperCase();
    }

    public void displayItem(Item item) throws VendingMachineOutOfInventoryException, VendingMachinePersistenceException {
        if (item == null) {
            throw new VendingMachinePersistenceException(" I'm sorry, but I can't read your mind. \n");
        }
        if (item.getQuantity() == 0) {
            throw new VendingMachineOutOfInventoryException("We run out of " + item.getName() + ". Sorry.\n");
        } else {
            io.print(item.getName() + " has been selected. $"
                    + item.getPrice());
            io.print("");
        }

    }

    public void displayErrorMessage(String errorMsg) {
        io.print("Oh, Noooo!!!");
        io.print(errorMsg);
    }


    public BigDecimal deposit(Item item) throws InsufficientFundsException, NoDepositException {
try{
        String money = io.readString("Please, deposit money");
        BigDecimal deposit = new BigDecimal(money);

        if (money == null || deposit.compareTo(item.getPrice()) < 0) {
            throw new InsufficientFundsException("--- Not enough money for this purchase :-( -- \n");

        }

        return deposit;
                }catch(NumberFormatException e){
            throw new NoDepositException("??? How much?! \n  ");
        }
    }

    public void change(String ItemId, Change change) throws VendingMachinePersistenceException {
        io.print("Your change is : ");
        if (change.getDollars() > 0) {
            if (change.getDollars() == 1) {
                io.print(change.getDollars() + " dollar ");
            }
            if (change.getDollars() > 1) {
                io.print(change.getDollars() + " dollars");
            }

        }
        if (change.getQuarters() > 0) {
            if (change.getQuarters() == 1) {
                io.print(change.getQuarters() + " quarter ");
            }
            if (change.getQuarters() > 1) {
                io.print(change.getQuarters() + " quarters");
            }
        }

        if (change.getDimes() > 0) {
            if (change.getDimes() == 1) {
                io.print(change.getDimes() + " dime ");
            }
            if (change.getDimes() > 1) {
                io.print(change.getDimes() + " dimes");
            }
        }
        if (change.getNickels() > 0) {
            if (change.getNickels() == 1) {
                io.print(change.getDimes() + " nickel ");
            }
            if (change.getNickels() > 1) {
                io.print(change.getNickels() + " nickels");
            }
        }

        if (change.getPennies() > 0) {
            if (change.getPennies() == 1) {
                io.print(change.getPennies() + " penny. ");
            }
            if (change.getPennies() > 1) {
                io.print(change.getPennies() + " pennies");
            }

        }
    }

    public void thanksBanner() {
        io.print(" ");
        io.print("┏━━━━━━┅┅┄┄⟞⟦✮⟧⟝┄┄┉┉━━━━━━┓\n"
                + "☆Thanks for your purchase☆"
                + "\n"
                + "┗━━━━━━┅┅┄┄⟞⟦✮⟧⟝┄┄┉┉━━━━━━┛");
        io.print(" ");
        io.readString("Hit ENTER to continue...");
    }

    public void vendingMachine() {
        io.print("◤◥◤◥◤◥◤◥◤◥◤◥◤◥◤◥◤◥◤◥◤◥\n"
                + " VENDING    MACHINE \n"
                + "◣◢◣◢◣◢◣◢◣◢◣◢◣◢◣◢◣◢◣◢◣◢");

    }

    public void vendingMachineBorder() {
        io.print(" ");

    }

    public void unknownCommand() {
        io.print("-- UNKNOWN COMMAND -- ");
    }

    public void bye() {
        io.print("~~~ GOOD BYE ~~~");

    }

}
