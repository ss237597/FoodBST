/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Sohn
 */
public interface BSTInterface<T> {
    public void add(BSTNode<T> newNode);
    public FoodItem search(BSTNode<T> newNode);
    public int size();
    public boolean isEmpty();
}
