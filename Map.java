
/**
 * Write a description of class Map here.
 *
 * @author Zachary Toews
 * @version 21/04/22
 */
public class Map
{
    // instance variables - replace the example below with your own
    int amountOfRoomsX = 2;
    int amountOfRoomsY = 3;
    Room board[][] = new Room[amountOfRoomsX][amountOfRoomsY];
    int playerX = 0;
    int playerY = 0;
    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        // initialise instance variables
        
    }
    
    public void movePlayerXY(int x, int y){
        boolean playerInMap = x >= 0 && x < amountOfRoomsX && y >= 0 && y < amountOfRoomsY;
        boolean validMove = playerInMap && board[playerX][playerY].checkValidRooms(board[x][y]);
        if (validMove){
            playerX = x;
            playerY = y;
        }else{
            System.out.println("Sorry, not a valid move");   
        }
    }
    
    public void setRoom(int x, int y, Room value){
        board[x][y] = value; 
    }
    
    public void showValues(){
        System.out.println("The player is located at:"+playerX+" "+playerY);        
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
