
/**
 * Write a description of class Map here.
 * 
 * @author Zachary Toews
 * @version 21/04/22
 */
public class Map
{
    // instance variables
    String name = "unNamed";
    int amountOfRoomsX = 0;//Ammount of rooms X
    int amountOfRoomsY = 0;//Ammount of rooms Y
    int amountOfLevels = 0;//Ammount of levels Z
    Player playerInTheMap;//instance variable
    Room board[][][] = null; //Board for the rooms
    int playerX = 0;// The player's X
    int playerY = 0;// The player's Y
    int playerZ = 0;// The player's Z
    /**
     * Constructor for objects of class Map
     */
    public Map(String value, int roomsX, int roomsY, int levels)
    {
        name = value;//changing the instance variable to be ajustable
        amountOfRoomsX = roomsX;//changing the instance variable to be ajustable
        amountOfRoomsY = roomsY;//changing the instance variable to be ajustable
        amountOfLevels = levels;//changing the instance variable to be ajustable
        board = new Room[amountOfRoomsX][amountOfRoomsY][amountOfLevels];//Board that makes up the map
    }

    public void movePlayerXYZ(int x, int y, int z){
        boolean playerInBounds = x >= 0 && x < amountOfRoomsX && y >= 0 && y < amountOfRoomsY && z >= 0 && z < amountOfLevels;//Checking if the move is valid
        boolean validMove = playerInBounds && getCurrentRoomPlayerIsIn().checkValidRooms(board[x][y][z]);//Checking if the move is valid
        if (validMove){
            playerX = x;//asigning playerX to x
            playerY = y;//asigning playerY to y
            playerZ = z;//asigning playerZ to z
        }else{
            System.out.println("Sorry, not a valid move");// Telling the player it isnt a valid move
        }
    }

    public void setRoom(int x, int y, int z, Room value){
        board[x][y][z] = value;//changeable board values
    }

    public Room getCurrentRoomPlayerIsIn(){
        return board[playerX][playerY][playerZ];//returns where the player is on the map
    }

    public void setPlayerInTheMap(Player value){//player in the map function
        playerInTheMap = value;
    }

    public void describingRoomWhereThePlayerIs(){//says where the playrer is after the look command
        getCurrentRoomPlayerIsIn().showValues();
    }

    public void pickingUpItem(){//If the player types pickup this executes
        if(!getCurrentRoomPlayerIsIn().checkIfEndRoom()){//happens only if the player isnt in the end room
            if(getCurrentRoomPlayerIsIn().itemInTheRoom == null){//if there is no item in the room
                System.out.println("Sorry, there is no item in this room");       
            }else if(playerInTheMap.itemInThePlayer != null){//if the player all ready has a item
                System.out.println("Sorry, you already have a item");
            }else{//The player actually picking up and storing the item in their inventory
                playerInTheMap.setItemInThePlayer(getCurrentRoomPlayerIsIn().itemInTheRoom);
                getCurrentRoomPlayerIsIn().itemInTheRoom = null;
                System.out.println("You picked up a "+playerInTheMap.itemInThePlayer.name);
            }  
        }else{
            System.out.println("Sorry, you can't pickup an item from the end room");
        }
    }

    public void placingItem(){//If the player types place the executes
        if(playerInTheMap.itemInThePlayer == null){//Happens if the player dosent have a item
            System.out.println("Sorry, you don't have a item");
        }else if(!getCurrentRoomPlayerIsIn().checkIfEndRoom()){//happens only if the player isnt in the end room
            if(getCurrentRoomPlayerIsIn().itemInTheRoom != null){
                System.out.println("Sorry, there is already a "+getCurrentRoomPlayerIsIn().itemInTheRoom.name+" in the room");
            }else{
                System.out.println("You placed a "+playerInTheMap.itemInThePlayer.name);         
                getCurrentRoomPlayerIsIn().itemInTheRoom = playerInTheMap.itemInThePlayer;
                playerInTheMap.itemInThePlayer = null;
            }
        }else{//if the player is in the end room
            for (int x=0;x<getCurrentRoomPlayerIsIn().amountOfItemsInTheRoomNeededToWin;x++){
                if (getCurrentRoomPlayerIsIn().itemsInTheRoomNeededToWin[x] == null) {//if the player is in the end room and the max number of items isin in the end room the plaeyr place an item
                    System.out.println("You placed a "+playerInTheMap.itemInThePlayer.name);//println teliing the player what item they placed      
                    getCurrentRoomPlayerIsIn().itemsInTheRoomNeededToWin[x] = playerInTheMap.itemInThePlayer;//putting th item in the room
                    playerInTheMap.itemInThePlayer = null;//takes the item out of the player
                    return;
                }
            }
        }
    }

    public void showValues(){
        System.out.println("The player is located at: "+playerX+","+playerY+","+playerZ); //printing where the player is       
        for (int x=0;x<amountOfRoomsX;x++){
            for (int y=0;y<amountOfRoomsY;y++){
                for(int z=0;z<amountOfLevels;z++)
                if (board[x][y][z] != null) {
                    board[x][y][z].showValues();//shows the room the player is in
                    System.out.println("");
                }
            }
        }
    }
}
