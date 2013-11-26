/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Sohn
 */
public class BSTNode <T> implements BSTInterface {
    T info;
    BSTNode left;
    BSTNode right;
    BSTNode parent;
    public BSTNode()    {   }
    public BSTNode (T info, BSTNode left, BSTNode right, BSTNode parent)    {
        this.info = info;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
    public void setInfo(T info)   { this.info = info;   }
    public void setParent(BSTNode newNode)  {   this.parent = newNode;  }
    public void setLeft(BSTNode newNode)    {   this.left = newNode;    }
    public void setRight(BSTNode newNode)    {  this.right = newNode;   }
    public void initialize()    {
        setInfo(null);
        setParent(null);
        setLeft(null);
        setRight(null);
    }
    public T getInfo()   {  return this.info;   }
    public BSTNode getLeft()    {   return this.left;   }
    public BSTNode getRight()   {   return this.right;  }
    public BSTNode getParent()  {   return this.parent; }
    public BSTNode getRoot()    {
        BSTNode curr = this;
        if (curr != null)   {
            while (curr.getParent() != null)
                curr = curr.getParent();
            return curr;
        }
        return null;
    }
    public BSTNode getRightmost()   {
        BSTNode curr = this;
        while(curr.getRight() != null)
            curr = curr.getRight();
        return curr;
    }
    public boolean isLeft() {
        if (this.getParent() == null)
            return false;
        return this==this.getParent().getLeft();
    }
    public boolean isRight() {
        if (this.getParent() == null)
            return false;
        return this==this.getParent().getRight();
    }
    public void replace(BSTNode newNode)   {
        newNode.setLeft(this.getLeft());
        newNode.setRight(this.getRight());
        newNode.setParent(this.getParent());
        if (this.getLeft() != null)
            this.getLeft().setParent(newNode);
        if (this.getRight() != null)
        this.getRight().setParent(newNode);
        if (this.getParent() != null)   {
            if (this.isLeft())
                this.getParent().setLeft(newNode);
            else
                this.getParent().setRight(newNode);
        }
    }
    @Override
    public void add(BSTNode newNode) {
        if (isEmpty())
            this.replace(newNode);
        else    {
            BSTNode<FoodItem> curr = this.getRoot();
            try {
                if (curr.getInfo() instanceof FoodItem) {
                    FoodItem fnew = (FoodItem) newNode.getInfo();
                    while (newNode.getParent() == null) {
                        if (curr.getInfo().getName().compareTo(fnew.getName()) > 0)  {
                            if (curr.getLeft() == null) {
                                curr.setLeft(newNode);
                                newNode.setParent(curr);
                            }
                            else
                                curr = curr.getLeft();
                        }
                        else if (curr.getInfo().getName().compareTo(fnew.getName()) < 0) {
                            if (curr.getRight() == null)    {
                                curr.setRight(newNode);
                                newNode.setParent(curr);
                            }
                            else
                                curr = curr.getRight();
                        }
                        else
                            throw new ItemAlreadyExistsException();
                    }
                }
            System.out.println(this.getRoot());
            }
            catch (ItemAlreadyExistsException ex)   {
                System.out.println("The item already exists!");
            }
        }
    }
    @Override
    public FoodItem search(BSTNode newNode) {
        if (isEmpty())  {
            System.out.println("Item not found - tree is empty.");
            return null;
        }
        else    {
            BSTNode<FoodItem> curr = this.getRoot();
            boolean found = false;
            while (curr != null && !found)  {
                FoodItem fnew = (FoodItem) newNode.getInfo();
                if (fnew.getName().compareTo(curr.getInfo().getName()) == 0)
                    found = true;
                else if (fnew.getName().compareTo(curr.getInfo().getName()) < 0)
                    curr = curr.getLeft();
                else
                    curr = curr.getRight();
            }
            if (curr != null)   {
                System.out.println("Item found!");
                System.out.println(curr);
                return (FoodItem) curr.getInfo();
            }
            else    {
                System.out.println("Item not found.");
                return null;
            }
        }
    }
    @Override
    public int size() {
        if (this.getInfo() == null)
            return 0;
        return 1+(left.size())+(right.size());
    }
    @Override
    public boolean isEmpty() {
    	if (this.getRoot() != null)
    		return false;
    	else	{
    		try {
				throw new EmptyBSTException();
			} catch (EmptyBSTException e) {
				return true;
			}
    	}
    }
    @Override
    public String toString()    {
        String result = "";
        if (this.getInfo() instanceof FoodItem)   {
            String l = "";
            String r = "";
            if (this.getLeft() != null)
                l = this.getLeft().toString();
            FoodItem fi = (FoodItem) getInfo();
            result = fi.printItem();
            if (this.getRight() != null)
                r = this.getRight().toString();
            return l + result + r;
        }
        return result;
    }
    public void reset() {
        this.info = null;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
    public void remove(BSTNode<FoodItem> thisNode)    {
        if (search(thisNode) != null)   {
            BSTNode<FoodItem> curr = getRoot();
            int c = curr.getInfo().getName().compareTo(thisNode.getInfo().getName());
            while (c != 0)  {
                if (c < 0)
                    curr = curr.getRight();
                else
                    curr = curr.getLeft();
                c = curr.getInfo().getName().compareTo(thisNode.getInfo().getName());
            }
            if (curr.getLeft() == null && curr.getRight() == null)  {
                if (curr.getParent() != null)   {
                    if (curr.isLeft())
                        curr.getParent().setLeft(null);
                    if (curr.isRight())
                        curr.getParent().setRight(null);
                }
                curr.reset();
            }
            else if (curr.getLeft() != null && curr.getRight() == null)  {
                if (curr.getParent() != null)   {
                    BSTNode p = curr.getParent();
                    BSTNode l = curr.getLeft();
                    if (curr.isLeft())
                        p.setLeft(l);
                    if (curr.isRight())
                        p.setRight(l);
                    l.setParent(p);
                    curr.reset();
                }
                else    {
                    curr.getLeft().setParent(null);
                    curr.setInfo((FoodItem) curr.getLeft().getInfo());
                    curr.setRight(curr.getLeft().getRight());
                    curr.setLeft(curr.getLeft().getLeft());
                }
            }
            else if (curr.getLeft() == null && curr.getRight() != null)  {
                if (curr.getParent() != null)   {
                    BSTNode p = curr.getParent();
                    BSTNode r = curr.getRight();
                    if (curr.isLeft())
                        p.setLeft(r);
                    if (curr.isRight())
                        p.setRight(r);
                    r.setParent(p);
                    curr.reset();
                }
                else    {
                    curr.getRight().setParent(null);
                    curr.setInfo((FoodItem) curr.getRight().getInfo());
                    curr.setLeft(curr.getRight().getLeft());
                    curr.setRight(curr.getRight().getRight());
                }
            }
            else  {
                BSTNode<FoodItem> rm = curr.getLeft().getRightmost();
                if (rm.getLeft() != null)   {
                    rm.getParent().setRight(rm.getLeft());
                    rm.getLeft().setParent(rm.getParent());
                }
                rm.setParent(curr.getParent());
                rm.setLeft(curr.getLeft());
                rm.setRight(curr.getRight());
                curr.getLeft().setParent(rm);
                curr.getRight().setParent(rm);
                if (curr.getParent() != null)   {
                    if (curr.isRight())
                        curr.getParent().setRight(rm);
                    else
                        curr.getParent().setLeft(rm);
                }
            }
            System.out.println(this.getRoot());
        }
    }
    private static class EmptyBSTException extends Exception {
        public EmptyBSTException() {
        }
    }
    private static class ItemAlreadyExistsException extends Exception {
        public ItemAlreadyExistsException() {
        }
    }
}
