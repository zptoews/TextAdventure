/**
 * Write a description of class Room here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Room
{
    // instance variables - replace the example below with your own
    Item itemInTheRoom = null;
    int amountOfItemsInTheRoomNeededToWin = 0;
    int amountOfValidRooms = 2; //ammount of valid rooms
    String name = "unNamed"; //Variable for name
    Item itemsInTheRoomNeededToWin[] = null; //items in the rooms       
    Room validRooms[] = new Room[amountOfValidRooms]; // array form rooms

    /**
     * Constructor for objects of class Room
     */
    public Room()
    {

    }

    public Room(int value){
        amountOfItemsInTheRoomNeededToWin = value;
        itemsInTheRoomNeededToWin = new Item[amountOfItemsInTheRoomNeededToWin]; //items in the rooms
    }

    public void setName(String value){
        name = value;
    }

    public void setItemInTheRoom(Item value){//item in the room function
        itemInTheRoom = value; 
    }

    public boolean checkIfItemsAreInRoom(){
        for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ 
            if (itemsInTheRoomNeededToWin[x] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfPlayerWon(){
        if (checkIfEndRoom()){
            for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ 
                if (itemsInTheRoomNeededToWin[x] == null) {
                    return false;
                }
            }
            return true;   
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

    public boolean checkIfEndRoom(){
        if(itemsInTheRoomNeededToWin != null){
            return true;
        }
        return false;
    }
    
    public void showValues(){
        System.out.println("Room name: "+name);

        if(checkIfEndRoom()){
            System.out.println("  Items needed to win: "+amountOfItemsInTheRoomNeededToWin);//The text for the words "Items"
            for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ //prints item names
                if (itemsInTheRoomNeededToWin[x] != null) {
                    System.out.println("    "+itemsInTheRoomNeededToWin[x].name);//prints the actual items in the room
                }
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
