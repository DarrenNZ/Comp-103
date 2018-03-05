// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 Assignment 2
 * Name:
 * Usercode:
 * ID:
 */

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import ecs100.UI;

/** 
 * This class is provided as a bad example.
 * Don't do this at home!
 */
public class Order {
    
    /** the items that are wanted for the order */
    private boolean wantsFish;
    private boolean wantsChips;
    private boolean wantsBurger;
    
    
    /**Insert Code**/
    //list bag of strings to take customerOrder
    //list bag of string to take whats been added
    
    
    /** the items that have been added and are ready in the order */
    private boolean hasFish;
    private boolean hasChips;
    private boolean hasBurger;

    public Order() {
        wantsFish = Math.random() > 0.5;
        wantsChips = Math.random() > 0.5;
        wantsBurger = Math.random() > 0.5;
        wantsFish = Math.random() > 0.5;
        wantsChips = Math.random() > 0.5;
        wantsBurger = Math.random() > 0.5;
        
        
        /**Insert Code**/
        //add string to bag
        
        

        if (!wantsFish && !wantsChips && !wantsBurger) {
            int choice = (int)(Math.random() * 3);
            if (choice==0) wantsFish = true;
            else if (choice==1) wantsChips = true;
            else if (choice==2) wantsBurger = true;
        }
    }

    /** 
     *  The order is ready as long as every item that is
     *  wanted is also ready.
     */
    public boolean isReady() {
        if (wantsFish && !hasFish) return false;
        if (wantsChips && !hasChips) return false;
        if (wantsBurger && !hasBurger) return false;
        return true;
        
        /**Insert Code**/
        //compare total string of value in orderlist and what beed added to order
        
    }

    /** 
     *  If the item is wanted but not already in the order,
     *  then put it in the order and return true, to say it was successful.
     *  If the item not wanted, or is already in the order,
     *  then return false to say it failed.
     */
    public boolean addItemToOrder(String item){
        /**Insert Code**/
        //insert item to itemaddedList
        
        if (item.equals("Fish")) {
            if (wantsFish && !hasFish) {
                hasFish = true;
                return true;
            }
        }
        else if (item.equals("Chips")){
            if (wantsChips && !hasChips) {
                hasChips = true;
                return true;
            }
        }
        else if (item.equals("Burger")){
            if (wantsBurger && !hasBurger) {
                hasBurger = true;
                return true;
            }
        }
        return false;
    }

    /** 
     *  Computes and returns the price of an order.
     *  [CORE]: Uses constants: 2.50 for fish, 1.50 for chips, 5.00 for burger
     *  to add up the prices of each item
     *  [COMPLETION]: Uses a map of prices to look up prices
     */
    public double getPrice() {
        double price = 0;
        if (wantsFish) price += 2.50;
        if (wantsChips) price += 1.50;
        if (wantsBurger) price += 5.00;
        return price;
    }

    public void draw(int y) {
        
        /**Insert Code**/
        //while loop through customerlist adding image for each item in the list
        
        if (wantsFish) UI.drawImage("Fish-grey.png", 10, y);
        if (wantsChips) UI.drawImage("Chips-grey.png", 50, y);
        if (wantsBurger) UI.drawImage("Burger-grey.png", 90, y);

        if (hasFish) UI.drawImage("Fish.png", 10, y);
        if (hasChips) UI.drawImage("Chips.png", 50, y);
        if (hasBurger) UI.drawImage("Burger.png", 90, y);
    }
}
