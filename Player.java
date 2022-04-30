
/**
 * Write a description of class Player here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Player
{
    // instance variables - replace the example below with your own
    String name;
    Item itemInThePlayer;
    Room playerInTheRoom;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
        name = "";
    }
    
    public void setName(String value){
        name = value;
    }
    
    public void setPlayerInTheRoom(Room value){
        playerInTheRoom = value;
    }
    
    public void setItemInThePlayer(Item value){
        itemInThePlayer = value;
    }
    
    public void showValues(){
        System.out.println(name);
    }
}
