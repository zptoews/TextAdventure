/**
 * Write a description of class Room here.
 *
 * @author Zachary
 * @version 20/4/22
 */
public class Room
{
    // instance variables - replace the example below with your own
    String name = "unNamed"; //Variable for name
    Item itemInTheRoom = null;
    int amountOfItemsInTheRoomNeededToWin = 0;
    int amountOfValidRooms = 2; //ammount of valid rooms
    Item itemsInTheRoomNeededToWin[] = null; //items in the rooms       
    Room validRooms[] = new Room[amountOfValidRooms]; // array form rooms
    int roomX = 0;
    int roomY = 0;
    int roomZ = 0;
    
    /**
     * Constructor for objects of class Room
     */
    public Room(String value, int x, int y, int z)
    {
        name = value;
        roomX = x;
        roomY = y;
        roomZ = z;
    }

    public Room(String value, int x, int y, int z, int itemsNeededToWin){
        this(value, x, y, z);
        amountOfItemsInTheRoomNeededToWin = itemsNeededToWin;
        itemsInTheRoomNeededToWin = new Item[amountOfItemsInTheRoomNeededToWin]; //items in the rooms
    }

    public void setName(String value){
        name = value;
    }

    public void setItemInTheRoom(Item value){//item in the room function
        itemInTheRoom = value; 
    }

    public boolean checkIfItemsAreInRoomNeededToWin(){
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

    private String getDirectionOfValidRoom(Room validRoom){
        if(roomX > validRoom.roomX){
            return TextAdventure.directionWest;
        }else if(roomX < validRoom.roomX){
            return TextAdventure.directionEast;
        }else if(roomY > validRoom.roomY){
            return TextAdventure.directionNorth;
        }else if(roomY < validRoom.roomY){
            return TextAdventure.directionSouth;
        }else if(roomZ > validRoom.roomZ){
            return TextAdventure.directionDown;
        }else if(roomZ < validRoom.roomZ){
            return TextAdventure.directionUp;
        }
        return "Direction judging error";
    }
    
    public void showValues(){
        System.out.println("Room name: "+name);

        if(itemInTheRoom != null){
            System.out.println("  The item in the room is: " + itemInTheRoom.name);
        }

        if(checkIfEndRoom()){
            System.out.println("  Items needed to be in the room to win: "+amountOfItemsInTheRoomNeededToWin);//The text for the words "Items"
            for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ //prints item names
                if (itemsInTheRoomNeededToWin[x] != null) {
                    System.out.println("    "+itemsInTheRoomNeededToWin[x].name);//prints the actual items in the room
                }
            }
        } 

        System.out.println("  Valid Directions: ");//The text for the words "Valid rooms"
        for (int x=0;x<amountOfValidRooms;x++){ //prints valid rooms
            if (validRooms[x] != null) {
                System.out.println("    "+getDirectionOfValidRoom(validRooms[x]));//prints the actual valid rooms
            }
        }
    }
}
