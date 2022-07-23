
/**
 * Write a description of class Map here.
 * 
 * @author Zachary Toews
 * @version 21/04/22
 */
public class Map
{
    // instance variables - replace the example below with your own
    int amountOfRoomsX = 2;//Ammount of rooms X
    int amountOfRoomsY = 3;//Ammount of rooms Y
    int amountOfLevels = 2;
    Player playerInTheMap;
    Room board[][][] = new Room[amountOfRoomsX][amountOfRoomsY][amountOfLevels];//Board for the rooms
    int playerX = 0;// The player's X
    int playerY = 0;// The player's Y
    int playerZ = 0;// The player's Z
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        // initialise instance variables

    }

    public void movePlayerXYZ(int x, int y, int z){
        boolean playerInBounds = x >= 0 && x < amountOfRoomsX && y >= 0 && y < amountOfRoomsY && z >= 0 && z < amountOfLevels;//Checking if the move is valid
        boolean validMove = playerInBounds && getCurrentRoomPlayerIsIn().checkValidRooms(board[x][y][z]);//Checking if the move is valid
        if (validMove){
            playerX = x;//asigning playerX to x
            playerY = y;//asigning playerY to y
            playerZ = z;
        }else{
            System.out.println("Sorry, not a valid move");// Telling the player it isnt a valid move
        }
    }

    public void setRoom(int x, int y, int z, Room value){
        board[x][y][z] = value; 
    }

    public Room getCurrentRoomPlayerIsIn(){
        return board[playerX][playerY][playerZ];
    }

    public void setPlayerInTheMap(Player value){//player in the map function
        playerInTheMap = value;
    }

    public void describingRoomWhereThePlayerIs(){//says where the playrer is after the look command
        getCurrentRoomPlayerIsIn().showValues();
    }

    public void pickingUpItem(){
        if(!getCurrentRoomPlayerIsIn().checkIfEndRoom()){
            if(getCurrentRoomPlayerIsIn().itemInTheRoom == null){
                System.out.println("Sorry, there is no item in this room");       
            }else if(playerInTheMap.itemInThePlayer != null){
                System.out.println("Sorry, you already have a item");
            }else{
                playerInTheMap.setItemInThePlayer(getCurrentRoomPlayerIsIn().itemInTheRoom);
                getCurrentRoomPlayerIsIn().itemInTheRoom = null;
                System.out.println("You picked up a "+playerInTheMap.itemInThePlayer.name);
            }  
        }else{
            System.out.println("Sorry, you can't pickup an item from the end room");
        }
    }

    public void placingItem(){
        if(playerInTheMap.itemInThePlayer == null){
            System.out.println("Sorry, you don't have a item");
        }else if(!getCurrentRoomPlayerIsIn().checkIfEndRoom()){
            if(getCurrentRoomPlayerIsIn().itemInTheRoom != null){
                System.out.println("Sorry, there is already a "+getCurrentRoomPlayerIsIn().itemInTheRoom.name+" in the room");
            }else{
                System.out.println("You placed a "+playerInTheMap.itemInThePlayer.name);         
                getCurrentRoomPlayerIsIn().itemInTheRoom = playerInTheMap.itemInThePlayer;
                playerInTheMap.itemInThePlayer = null;
            }
        }else{
            for (int x=0;x<getCurrentRoomPlayerIsIn().amountOfItemsInTheRoomNeededToWin;x++){
                if (getCurrentRoomPlayerIsIn().itemsInTheRoomNeededToWin[x] == null) {
                    System.out.println("You placed a "+playerInTheMap.itemInThePlayer.name);         
                    getCurrentRoomPlayerIsIn().itemsInTheRoomNeededToWin[x] = playerInTheMap.itemInThePlayer;
                    playerInTheMap.itemInThePlayer = null;
                    return;
                }
            }
        }
    }

    public void showValues(){
        System.out.println("The player is located at: "+playerX+","+playerY+","+playerZ); //printing where the       
        for (int x=0;x<amountOfRoomsX;x++){
            for (int y=0;y<amountOfRoomsY;y++){
                for(int z=0;z<amountOfLevels;z++)
                if (board[x][y][z] != null) {
                    board[x][y][z].showValues();
                    System.out.println("");
                }
            }
        }
    }
}
