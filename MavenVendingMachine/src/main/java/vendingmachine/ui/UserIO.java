/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.ui;

/**
 *
 * @author anna
 */
public interface UserIO {

    void print(String msg);

    int readInt(String msg);

    int readInt(String msg, int min, int max);

    double readDouble(String msg);

    String readString(String msg);
}
