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
    int roomX = 0;//instance variable for roomX
    int roomY = 0;//instance variable for roomY
    int roomZ = 0;//instance variable for roomZ
    
    /**
     * Constructor for objects of class Room
     */
    public Room(String value, int x, int y, int z)//making the instance variable changeable so the game is more engine like
    {
        name = value;
        roomX = x;
        roomY = y;
        roomZ = z;
    }

    public Room(String value, int x, int y, int z, int itemsNeededToWin){//Allows the room location and items needed to win to be declared in the textadventure class
        this(value, x, y, z);
        amountOfItemsInTheRoomNeededToWin = itemsNeededToWin;
        itemsInTheRoomNeededToWin = new Item[amountOfItemsInTheRoomNeededToWin]; //items in the rooms
    }

    public void setName(String value){
        name = value;//set name for the rooms
    }

    public void setItemInTheRoom(Item value){//item in the room function
        itemInTheRoom = value; 
    }

    public boolean checkIfItemsAreInRoomNeededToWin(){//methood to check if items in the room needed to win
        for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ 
            if (itemsInTheRoomNeededToWin[x] != null) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfPlayerWon(){//methood to check if the player won
        if (checkIfEndRoom()){//if the end room the the player can win if all the items are in the end room
            for (int x=0;x<amountOfItemsInTheRoomNeededToWin;x++){ 
                if (itemsInTheRoomNeededToWin[x] == null) {
                    return false;
                }
            }
            return true;   
        }
        return false;
    }

    public void setValidRooms(int x, Room valid){//if the room is valid//setting valid rooms which are set in text adventure
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

    public boolean checkIfEndRoom(){//methood for checking if the room is the end room by seeing if there are item need to win set to that room
        if(itemsInTheRoomNeededToWin != null){
            return true;
        }
        return false;
    }

    private String getDirectionOfValidRoom(Room validRoom){//shows the player the valid directions for the room they are in if the type look
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
    
    public void showValues(){//methhod used for the look command
        System.out.println("Room name: "+name);

        if(itemInTheRoom != null){//if there is a item in the room this is printed
            System.out.println("  The item in the room is: " + itemInTheRoom.name);
        }

        if(checkIfEndRoom()){//if the room is the end room this is printed
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
