/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sam Sohn
 */
public class FoodItem {
    String name;
    String[] ingredients;
    public FoodItem()   {
    }
    public FoodItem(String name, String[] ingredients)   {
        this.name = name;
        this.ingredients = ingredients;
    }
    public String getName() {
        return name.toLowerCase();
    }
    public String[] getIngredients()    {
        return ingredients;
    }
    public void setName(String name)    {
        this.name = name;
    }
    public void setIngredients(String[] ingredients)    {
        this.ingredients = ingredients;
    }
    public String printItem()   {
        String result = "";
        if (this.getName() != null)  {
            result += "Name: " + this.getName() + "\n";
            for (int i = 0; i < ingredients.length; i++)
                result += "Ingredient #" + (i+1) + ": " + getIngredients()[i] + "\n";
        }
        return result;
    }
}
