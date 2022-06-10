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
    int amountOfValidRooms = 2; //ammount of valid rooms
    String name; //Variable for name
    Item itemInTheRoom; //items in the rooms
    Room validRooms[] = new Room[amountOfValidRooms]; // array form rooms
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
    
    public void setItemInTheRoom(Item value){//item in teh room function
        itemInTheRoom = value;
    }
    
    public void setValidRooms(int room, Room valid){//if the room is valid
        validRooms[room] = valid;
    }
    
    public boolean checkValidRooms(Room playerRoom){//checking the valid rooms
        for (int x=0;x<amountOfValidRooms;x++){ 
            if (validRooms[x].name.equals(playerRoom.name)) {
                return true;
            }
        }
        return false;
    }
    
     public void showValues(){
        System.out.println(name);
        System.out.println("Valid Rooms:");//The text for the words "Valid rooms"
        for (int x=0;x<amountOfValidRooms;x++){ //prints valid rooms
            if (validRooms[x] != null) {
                System.out.println("  "+validRooms[x].name);//prints the actual valid rooms
            }
        }
    }
}
