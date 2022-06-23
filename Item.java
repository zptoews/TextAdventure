
/**
 * Write a description of class Items here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Item
{
    // instance variables - replace the example below with your own
    String name;//item name
    /**
     * Constructor for objects of class Items
     */
    public Item()
    {
        // initialise instance variables
        name = "";//item name
    }
    public Item(String value){
        name = value;//names value
    }
    public void setName(String value){
        name = value;//names value
    }
    
    public void showValues(){
        System.out.println(name);
    }
}