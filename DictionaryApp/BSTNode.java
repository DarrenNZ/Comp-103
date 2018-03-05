// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 103, Assignment 6
 * Name:
 * Usercode:
 * ID:
 */
import java.io.*;
import ecs100.*;

/**  
 * Implements a binary search tree node.
 *   
 *  @author: Thomas Kuehne (based on previous code)
 */

public class BSTNode <E extends Comparable<E>> {

    private E value;
    private BSTNode<E> left;
    public BSTNode<E> right;

    // constructs a node with a value
    public BSTNode(E value) {
        this.value = value;
    }

    // Getters...

    public E getValue() {
        return value;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    /** 
     * Returns true if the subtree formed by the receiver contains 'item'
     * 
     * CORE
     *
     * ASSUMPTION: 'item' is not 'null'.
     * 
     * HINT: A recursive approach leads to a very short and simple code. 
     * 
     * HINT: use 'compareTo(...)' in order to compare the parameter 
     * with the data in the node. 
     * 
     * HINT: Make sure that you invoke 'compareTo' by always using
     * the same receiver / argument ordering throughout the program, e.g., 
     * always use the item as the receiver of 'compareTo'.
     *
     *@param item - the item to check for
     *@returns true if the subtree contained 'item'
     *
     */
    public boolean contains(E item) {
        /*# YOUR CODE HERE */
        int temp = item.compareTo(value);
        if (temp == 0)//use compareTo
            return true;

        if (left != null)
            if (left.contains(item))
                return true;

        if (right != null)
            if (right.contains(item))
                return true;
        // no matching node was found
        return false;
    }

    /**
     * Adds an item to the subtree formed by the receiver.
     * 
     * CORE
     * 
     * Must not add an item, if it is already in the tree.
     * 
     * HINT: use 'compareTo(...)' in order to compare the parameter 
     * with the data in the node. 
     * 
     * @param item - the value to be added
     * @returns false, if the item was in the subtree already. Returns true otherwise.
     */
    public boolean add(E item) {
        /*# YOUR CODE HERE */
        if (item.compareTo(value) == 0)
            return false;

        if (item.compareTo(value) < 0){
            if (left == null){
                this.left = new BSTNode(item);
                return true;
            }
            else{
                left.add(item);
            }
        }
        else if (item.compareTo(value) > 0) {
            if (right == null){
                this.right = new BSTNode(item);
                return true;
            }
            else{
                right.add(item);
            }
        }
        // not proper code, just needed to enable compilation

        return false;
    }

    /**
     * Returns the height of the receiver node.
     * 
     * CORE 
     * 
     * HINT: The number of children the receiver node may have, implies
     * four cases to deal with (none, left, right, left & right).
     * 
     * @returns the height of the receiver
     */
    public int height() {
        /*# YOUR CODE HERE */
        int i = 1;
        int l = 0;
        int r = 0;
        if (right != null)
            r = right.height();
        if (left != null){
            l = left.height();
        }
        if (r>l)
            return i + r;
        else{
            return i + l;
        }
    }

    /**
     * Returns the length of the shortest branch in the subtree formed by the receiver.
     * 
     * COMPLETION
     * 
     * @returns the minimum of all branch lenghts starting from the receiver. 
     * 
     */
    public int minDepth() {
        /*# YOUR CODE HERE */
        //nt i = 1;
        int l = 0;
        int r = 0;
        if (left == null && right == null)
            return 1;
        if (right != null)
            r = right.minDepth();
        if (left != null){
            l = left.minDepth();
        }
        if (r>l)
            return 1 + l;
        else{
            return 1 + r;
        }

    }

    /** 
     *  Removes an item in the subtree formed by the receiver.
     *  
     *  COMPLETION
     *  
     *  ASSUMPTION: The item to be removed does exist. 
     *  The case that it cannot be found, should be dealt with before this method is called.
     *  
     *  Performs two tasks:
     *  1. locates the node to be removed, and
     *  2. replaces the node with a suitable node from its subtrees.
     *  
     *  HINT: use 'compareTo(...)' in order to compare the parameter 
     *  with the data in the node. 
     * 
     *  HINT: For task 2, you should use call method 'replacementSubtreeFromChildren'
     *  to obtain this node. 
     *  
     *  HINT: When replacing a node, it is sufficient to change the value of the existing node
     *  with the value of the node that conceptually replaces it. There is no need to actually 
     *  replace the node object as such. 
     *  
     *  @param item - the item to be removed
     *  @returns the reference to the subtree with the item removed.
     *  
     *  HINT: Often the returned reference will be the receiver node, but it is possible that
     *  the receiver itself needs to be removed. If you use a recursive approach, the
     *  latter case is the base case. 
     *   
     */
    public BSTNode<E>remove(E item) {
        /*# YOUR CODE HERE */
        
        // there was no need to replace the receiver node
        return this;  
    }

    /**
     *  Returns a replacement subtree for the receiver node (which is to be removed).
     *  
     *  COMPLETION
     *  
     *  The replacement subtree is determined from the children of the node to be removed.
     *  
     *  HINT: There are several cases:
     *  - node has no children    => return null
     *  - node has only one child => return the child
     *  - node has two children   => return the current subtree but with
     *       a) its (local) root replaced by the leftmost node in the right subtree, and
     *       b) the leftmmost node in the right subtree removed.
     *       
     * @param left - the left subtree from which to include items.       
     * @param right - the right subtree from which to include items.       
     * @returns a reference to a subtree which contains all items from 'left' and 'right' combined.      
     *                                          
     */
    private BSTNode<E> replacementSubtreeFromChildren(BSTNode<E> left, BSTNode<E> right) {
        /*# YOUR CODE HERE */

        // not a simple case => return modified node
        return this;
    }

    /**
     *  Returns the leftmost node in the subtree formed by the receiver. 
     *  
     *  COMPLETION
     *  
     *  HINT: The code is very simple. Just keep descending left branches, 
     *  until it is no longer possible. 
     * 
     * @returns a reference to the leftmost node, starting from the receiver.    
     *                                          
     */
    private BSTNode<E> getLeftmostNode() {
        /*# YOUR CODE HERE */
        return null;
    }

    /**
     * Prints all the nodes in a subtree to a stream.
     * 
     * @param stream - the output stream 
     */
    public void printAllToStream(PrintStream stream) {
        if (left!=null) 
            left.printAllToStream(stream);

        stream.println(value);

        if (right!=null) 
            right.printAllToStream(stream);
    }

    /**
     * Prints all the nodes in a subtree on the text pane.
     * 
     * Can be useful for debugging purposes, but 
     * is most useful on small sample trees. 
     * 
     * Usage: node.printAll("").
     */
    public void printAll(String indent){
        if (right!=null)
            right.printAll(indent+"    ");

        UI.println(indent + value);

        if (left!=null) 
            left.printAll(indent+"    ");
    }
}
