/**
 * Write a description of class Room here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Room
{
    // instance variables - replace the example below with your own
    int amountOfItemsInTheRoom = 3;
    int amountOfValidRooms = 2; //ammount of valid rooms
    String name; //Variable for name
    Item itemsInTheRoom[] = new Item[amountOfItemsInTheRoom]; //items in the rooms
    Room validRooms[] = new Room[amountOfValidRooms]; // array form rooms

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

    public void setItemsInTheRoom(int x, Item value){//item in the room function
        itemsInTheRoom[x] = value; 
    }

    public boolean checkIfItemsAreInRoom(){
        for (int x=0;x<amountOfItemsInTheRoom;x++){ 
            if (itemsInTheRoom[x] != null) {
                return true;
            }
        }
        return false;
    }
    
    public void setValidRooms(int x, Room valid){//if the room is valid
        validRooms[x] = valid;
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
        System.out.println("Room name: "+name);
        
        System.out.println("  Items: ");//The text for the words "Items"
        for (int x=0;x<amountOfItemsInTheRoom;x++){ //prints item names
            if (itemsInTheRoom[x] != null) {
                System.out.println("    "+itemsInTheRoom[x].name);//prints the actual items in the room
            }
        }
        
        System.out.println("  Valid Rooms: ");//The text for the words "Valid rooms"
        for (int x=0;x<amountOfValidRooms;x++){ //prints valid rooms
            if (validRooms[x] != null) {
                System.out.println("    "+validRooms[x].name);//prints the actual valid rooms
            }
        }
    }
}
