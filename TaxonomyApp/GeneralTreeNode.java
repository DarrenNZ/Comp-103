// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 103, Assignment 7
 * Name:
 * Usercode:
 * ID:
 */
import java.awt.Color;
import ecs100.*;
import java.util.*;

/** 
 *  GeneralTreeNode represents a simple node in a tree. The node stores references 
 * to children and a parent (the latter is null in the case of the root node).
 * 
 * For the purposes of one technique for drawing on the screen, there is a location field as well.
 * This is purely for drawing purposes, and is not directly related to the concept of the tree structure.
 * NOTE: There are other techniques for drawing the tree that don't require the location field, so you 
 * may decide not to use the location field/methods at all.
 * 
 * @author Thomas Kuehne
 * 
 * Based on code written by Stuart Marshall and Monique Damitio
 */

public class GeneralTreeNode {
    // The name that is stored at the node.
    private String name;

    // A reference to the parent node of this node.  
    private GeneralTreeNode parent;

    // Since this is a general tree, we don't have a limit on the number of children a node may have, so we use a set.
    private Set<GeneralTreeNode> children = new HashSet<GeneralTreeNode>();

    // This field is only needed for one particular technique for drawing the tree on the screen.
    private Location location;  //location of the center of the node on the screen

    /**
     * Creates a new node
     * 
     * @param newName the name of the new node
     */
    public GeneralTreeNode(String newName) {
        name = newName;
    }

    // getter and setter methods

    public String getName() {
        return name;
    }

    public GeneralTreeNode getParent() {
        return parent;
    }

    private void setParent(GeneralTreeNode newParent) {
        parent = newParent;
    }

    public Set<GeneralTreeNode> getChildren() {
        return children;
    }

    public void setLocation(Location newLocation) {
        location = newLocation;
    }

    public Location getLocation() {
        return location;
    }

    /**
     * Adds a child to the receiver node
     * 
     * @param newChild the node/subtree to be added as a new child
     * 
     */
    public void addChild(GeneralTreeNode newChild) {
        // add to set of children
        children.add(newChild);

        // set new parent reference
        newChild.setParent(this);  
    }

    /**
     * Finds the node whose name is equal to the target string
     * 
     * CORE.
     * 
     * If the target string appears multiple times, then just return the first one encountered. 
     * The 'addNode' method from class GeneralTree should guarantee that duplicate strings aren't added anyway.
     * 
     * HINT: The most natural implementation of this method is recursive.
     * 
     * @param  targetName the name of the node we are looking for
     * @return the node that contains the target name, or null if no such node exists.
     */
    public GeneralTreeNode findNode(String targetName) {
        /*# YOUR CODE HERE */
        GeneralTreeNode correctNode = null;

        if (targetName.equals(this.getName())){
            UI.println("found");
            correctNode = this;
        } 
        else{
            //goes through the children comparing names if false, calls its children recursivly
            Set <GeneralTreeNode> childz = this.getChildren();
            for(GeneralTreeNode G: childz){
                UI.println("** findnode for results " + G.getName());
                correctNode = G.findNode(targetName);
                if (correctNode != null){
                    break;
                }
            }

        }
        return correctNode;
    }

    /**
     * Removes the receiver node from the list of children of its parent
     * 
     * CORE.
     * 
     */
    public void remove() {
        /*# YOUR CODE HERE */ 
        Set <GeneralTreeNode> children = this.getParent().getChildren();
        Set <GeneralTreeNode> grandChildren = this.getChildren();
        GeneralTreeNode grandParent = getParent();

        //add grandChildren to grandparent //WORKING WELL
        for (GeneralTreeNode G : grandChildren){
            grandParent.addChild(G);
            G.setParent(grandParent);
        }

        //remove node from grandparent //NOT WORKING
        for (GeneralTreeNode G : children){
            if(G.getName().equals(this.getName()))
                G.setParent(null);
            // G.setLocation(null);
        } 

    }

    /**
     * Adds children from another donor node to this node
     * 
     * CORE.
     * 
     * This method is used to implement method 'moveSubtree' in class General Tree.
     * 
     * @param donorNode the node that has the children to be added
     */
    public void addChildrenFromNode(GeneralTreeNode donorNode) {
        /*# YOUR CODE HERE */ 
        Set <GeneralTreeNode> temp = donorNode.getChildren(); 
        
        for (GeneralTreeNode G: temp){
            this.addChild(G);
            G.setParent(this);
        }

    }

    /** 
     *  Prints the strings of all the nodes under the given target node 
     *  (including the target node itself)
     *  
     *  CORE.
     * 
     *  HINT: The most natural version of this method is recursive.
     */
    public void printSubtree() {
        /*# YOUR CODE HERE */ 

        for (GeneralTreeNode G : getChildren()){
            G.printSubtree();
            UI.println(G.getName());
        }

    }

    /** 
     *  Returns true if the subtree whose root starts with the receiver contains the node of the parameter
     *   
     *  COMPLETION.
     * 
     *   This method is used by moveSubtree(...), to ensure that we aren't trying to move a node 
     *  (and hence the subtree rooted at that node) in a way that makes it become a child of one
     *  of it's existing descendants. 
     *  
     *  HINT: The most natural version of this method is recursive.
     *  
     *  @param node the node to check for
     *  @return true if the node is in the subtree, and false otherwise
     *  
     */
    public boolean contains(GeneralTreeNode node) {
        /*# YOUR CODE HERE */ 

        // this subtreee does not contain 'node'
        return false;
    }

    /** 
     *  Prints the names of all the nodes in the path from the target node to the root of the entire tree 
     *  
     *  COMPLETION.
     * 
     */

    public void printPathToRoot() {
        /*# YOUR CODE HERE */ 

    }

    /** 
     *  Prints all the names of all the nodes at the given depth 
     *  
     *  COMPLETION.
     *  
     *  Prints nothing if there are no nodes at the specified depth.
     * 
     *  HINT: The most natural version of this method is recursive.
     *  
     *  @param depth the depth of the tree whoses nodes are to be listed. The root is at depth 0.
     */

    public void printAllAtDepth(int targetDepth, int currentDepth) {
        /*# YOUR CODE HERE */ 

    }

    /**
     * Draws all the nodes in the subtree that has the receiver as the root on the Graphics pane
     * 
     *  CORE.
     * 
     *  The provided code just draws the tree node; you need to make it draw all the nodes.
     *  Make sure that parents and their children are connected by lines .
     *  
     *  HINT: The most natural version of this method is recursive.
     *  
     *  HINT: Use UI.drawLine(...) to draw the connecting lines and pay 
     *  attention in what order you 'paint' on the canvas in order to get a good looking result. 
     *  
     */
    public void redrawSubtree() {
        /*# YOUR CODE HERE */ 
        if (this.getParent() == null)
            this.redrawNode();

        if (this.getParent() != null){

            double parentX = this.getParent().getLocation().getX();
            double parentY = this.getParent().getLocation().getY();

            double x = this.getLocation().getX();
            double y = this.getLocation().getY();
            UI.drawLine(parentX, parentY, x, y);

            this.redrawNode();
        }

        for (GeneralTreeNode G: getChildren()){
            G.redrawSubtree();
        }

    }

    /**
     * Draws a node at the location stored in that node. Drawing the node consists of drawing an oval, and writing the name string
     * out "in" that oval. Note that no consideration is given to the length of the string, so this could look ugly.
     * 
     * @param node  the node to be draw on the canvas. This node should already have had it's location set earlier on.
     */
    private void redrawNode() {
        double x = this.getLocation().getX();
        double y = this.getLocation().getY();

        UI.setColor(Color.white);
        UI.fillOval(x-2*GeneralTree.nodeRad, y-GeneralTree.nodeRad, GeneralTree.nodeRad*4-1, GeneralTree.nodeRad*2-1);

        UI.setColor(Color.black);
        UI.drawOval(x-2*GeneralTree.nodeRad, y-GeneralTree.nodeRad, GeneralTree.nodeRad*4-1, GeneralTree.nodeRad*2-1);

        UI.drawString(name, x-GeneralTree.nodeRad-4, y+5);
    }
}
