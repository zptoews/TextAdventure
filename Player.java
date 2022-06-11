
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
    
    public void setName(String value){//setting player name
        name = value;
    }
    
    public void setPlayerInTheRoom(Room value){//player in room
        playerInTheRoom = value;
    }
    
    public void setItemInThePlayer(Item value){//giving player item
        itemInThePlayer = value;
    }
    
    public void showValues(){
        System.out.println("Player name: "+name);
        if(itemInThePlayer !=  null){
            System.out.println("  Item name: "+itemInThePlayer.name);
        }
    }
}
