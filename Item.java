
/**
 * Write a description of class Items here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Item
{
    // instance variables - replace the example below with your own
    String name;
    /**
     * Constructor for objects of class Items
     */
    public Item()
    {
        // initialise instance variables
        name = "";
    }
    
    public void setName(String value){
        name = value;
    }
    
    public void showValues(){
        System.out.println(name);
    }
    }

