import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Sohn
 */
public class Driver {
    static BSTNode<FoodItem> root = new BSTNode();
    public static void main(String[] args)  {
        initialize(root);
        System.out.println(root.toString());
        BSTFrame f = new BSTFrame();
        f.run();
    }
    public static void initialize(BSTNode<FoodItem> root)  {
        BufferedReader br = null;
        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader("C:/Users/Sam Sohn/My Documents/NetBeansProjects/FoodBST/src/foodlist.txt"));
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int m = Integer.parseInt(br.readLine());
                String[] ingredients = new String[m];
                String name = br.readLine();
                for (int j = 0; j < m; j++)
                    ingredients[j] = br.readLine();
                if (i == 0)
                    root.setInfo(new FoodItem(name, ingredients));
                else    {
                    BSTNode<FoodItem> newNode = new BSTNode();
                    FoodItem fi = new FoodItem(name, ingredients);
                    newNode.setInfo(fi);
                    root.add(newNode);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
