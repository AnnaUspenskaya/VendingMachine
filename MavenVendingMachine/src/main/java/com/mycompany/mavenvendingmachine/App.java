package com.mycompany.mavenvendingmachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoFileImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoFileImpl;
import vendingmachine.service.InsufficientFundsException;
import vendingmachine.service.NoDepositException;
import vendingmachine.service.VendingMachineOutOfInventoryException;
import vendingmachine.service.VendingMachineServiceLayer;
import vendingmachine.service.VendingMachineServiceLayerImpl;
import vendingmachine.ui.UserIO;
import vendingmachine.ui.UserIOConsoleImpl;
import vendingmachine.ui.VendingMachineView;

/**
 *
 * @author anna
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws VendingMachineOutOfInventoryException, InsufficientFundsException, NoDepositException, NumberFormatException{
      
//        UserIO myIo = new UserIOConsoleImpl();
//        VendingMachineView myView = new VendingMachineView(myIo);
//        VendingMachineDao myDao = new VendingMachineDaoFileImpl();
//        VendingMachineAuditDao myAuditDao = new VendingMachineAuditDaoFileImpl();
//        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(myDao, myAuditDao);
//        VendingMachineController controller = new VendingMachineController(service, myView);
//        controller.run();
ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
VendingMachineController controller = ctx.getBean("controller",VendingMachineController.class);
controller.run();
    }
}
