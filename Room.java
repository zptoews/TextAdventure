import java.util.ArrayList;

/**
 * Write a description of class Room here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Room
{
    // instance variables - replace the example below with your own
    int amountOfValidRooms = 2;
    String name;
    Item itemInTheRoom;
    Room validRooms[] = new Room[amountOfValidRooms];
    //ArrayList validRooms = new ArrayList();
    /**
     * Constructor for objects of class Room
     */
    public Room()
    {
        // initialise instance variables
        name = "";
    }
     
    public void setName(String value){
        name = value;
    }
    
    public void setItemInTheRoom(Item value){
        itemInTheRoom = value;
    }
    
    public void setValidRooms(int room, Room valid){
        validRooms[room] = valid;
    }
    
    public boolean checkValidRooms(Room playerRoom){
        for (int x=0;x<amountOfValidRooms;x++){ 
            if (validRooms[x].name.equals(playerRoom.name)) {
                return true;
            }
        }
        return false;
    }
    
     public void showValues(){
        System.out.println(name);
        System.out.println("Valid Rooms:");
        for (int x=0;x<amountOfValidRooms;x++){ 
            if (validRooms[x] != null) {
                System.out.println("  "+validRooms[x].name);
            }
        }
    }
}
