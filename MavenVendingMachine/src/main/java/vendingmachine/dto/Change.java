/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

/**
 *
 * @author anna
 */
public class Change {

    int dollars;
    int quarters;
    int dimes;
    int nickels;
    int pennies;

    public int
            getDollars() {

        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int
            getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int
            getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int
            getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

    public int
            getPennies() {
        return pennies;
    }

    public void setPennies(int pennies) {
        this.pennies = pennies;
    }

}
