/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author anna
 */
public class Item {
    private String itemId;
    private String name;
    private int quantity;
    BigDecimal price;


    public String getId() {
        return itemId;
    }
   public void setId(String itemId) {
        this.itemId=itemId;
    }
    public Item(String id) {
        this.itemId = id;

        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    
    }   
    
    @Override
    public String toString(){
        return "ID:"+itemId+" | Name: "+name+" | Price: "+price+" | Quantity: "+quantity;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 97 * hash + Objects.hashCode(this.itemId);
//        hash = 97 * hash + Objects.hashCode(this.name);
//        hash = 97 * hash + this.quantity;
//        hash = 97 * hash + Objects.hashCode(this.price);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Item other = (Item) obj;
//        if (this.quantity != other.quantity) {
//            return false;
//        }
//        if (!Objects.equals(this.itemId, other.itemId)) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.price, other.price)) {
//            return false;
//        }
//        return true;
//    }
    
}
