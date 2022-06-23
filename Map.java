
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
    Player playerInTheMap;
    Room board[][] = new Room[amountOfRoomsX][amountOfRoomsY];//Board for the rooms
    int playerX = 0;// The players's X
    int playerY = 0;// The players's Y
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        // initialise instance variables
        
    }
    
    public void movePlayerXY(int x, int y){
        boolean playerInBounds = x >= 0 && x < amountOfRoomsX && y >= 0 && y < amountOfRoomsY;//Checking if the move is valid
        boolean validMove = playerInBounds && getCurrentRoomPlayerIsIn().checkValidRooms(board[x][y]);//Checking if the move is valid
        if (validMove){
            playerX = x;//asigning playerX to x
            playerY = y;//asigning playerY to y
        }else{
            System.out.println("Sorry, not a valid move");// Telling the player it isnt a valid move
        }
    }
    
    public void setRoom(int x, int y, Room value){
        board[x][y] = value; 
    }
    
    
    public Room getCurrentRoomPlayerIsIn(){
        return board[playerX][playerY];
    }
    
    public void setPlayerInTheMap(Player value){//player in the map function
        playerInTheMap = value;
    }
    
    public void describingRoomWhereThePlayerIs(){//says where the playrer is after the look command
        getCurrentRoomPlayerIsIn().showValues();
    }
     
    public void pickingUpItem(){
        if(getCurrentRoomPlayerIsIn().itemInTheRoom == null){
            System.out.println("Sorry, there is no item in this room");       
        }else if(playerInTheMap.itemInThePlayer != null){
            System.out.println("Sorry, you already have a item");
        }else{
            playerInTheMap.setItemInThePlayer(getCurrentRoomPlayerIsIn().itemInTheRoom);
            getCurrentRoomPlayerIsIn().itemInTheRoom = null;
            System.out.println("You picked up a "+playerInTheMap.itemInThePlayer.name);
        }     
    }

    public void placingItem(){
        if(playerInTheMap.itemInThePlayer == null){
            System.out.println("Sorry, you don't have a item");
        }else if(getCurrentRoomPlayerIsIn().itemInTheRoom != null){
            System.out.println("Sorry, there is already a "+getCurrentRoomPlayerIsIn().itemInTheRoom.name+" in the room");
        }else{
            System.out.println("You placed a "+playerInTheMap.itemInThePlayer.name);         
            getCurrentRoomPlayerIsIn().itemInTheRoom = playerInTheMap.itemInThePlayer;
            playerInTheMap.itemInThePlayer = null;
        }
    }
    public void showValues(){
        System.out.println("The player is located at:"+playerX+" "+playerY); //printing where the       
        for (int x=0;x<amountOfRoomsX;x++){
            for (int y=0;y<amountOfRoomsY;y++){
                if (board[x][y] != null) {
                    board[x][y].showValues();
                    System.out.println("");
                }
            }
        }
    }
}
