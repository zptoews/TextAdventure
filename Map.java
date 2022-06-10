
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
        boolean playerInMap = x >= 0 && x < amountOfRoomsX && y >= 0 && y < amountOfRoomsY;//Checking if the move is valid
        boolean validMove = playerInMap && board[playerX][playerY].checkValidRooms(board[x][y]);//Checking if the move is valid
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
    
    public void describingRoomWhereThePlayerIs(){//says where the playrer is after the look command
        board[playerX][playerY].showValues();
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
