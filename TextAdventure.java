
/**
 * Write a description of class textAdventure here.
 *
 * @author Zachary
 * @version 14/4/22
 */
import java.io.File;//all the imports
import java.io.FileWriter;//all the imports
import java.io.IOException;//all the imports
import java.util.Scanner;//all the imports
public class TextAdventure
{
    // instance variables - replace the example below with your own
    Scanner keyboard;//import for the keyboard
    /**
     * Constructor for objects of class textAdventure
     */
    public TextAdventure()
    {
        // initialise instance variables
        File myFile=new File("GameStart.txt");
        //System.out.println("Welcome to my text adventure game");//inroduction for the game
        //System.out.println("");//inroduction for the game
        //System.out.println("Insturctions: You can type up,down,north,south,east, and west to go diffrent places");//inroduction for the game
        //System.out.println("You can also type pickup_item_name to pickup a item and put it into your invintory");//inroduction for the game
        //System.out.println("");//inroduction for the game
        //System.out.println("Your goal is escape the island");//inroduction for the game
        try {
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                //String reading=readTheFile.nextLine();
                System.out.println(readTheFile.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong 🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿?");
        }//catch statment

        testing();
    }

    void testing(){
        Item item = new Item();
        item.setName("item_name");
        System.out.println("");
        item.showValues();

        Room room00 = new Room();
        room00.setName("room00");
        room00.setItemInTheRoom(item);
        //System.out.println("");
        //room.showValues();
        Room room10 = new Room();
        room10.setName("room10");
        room10.setItemInTheRoom(item);

        Room room01 = new Room();
        room01.setName("room01");
        room01.setItemInTheRoom(item);

        Room room11 = new Room();
        room11.setName("room11");
        room11.setItemInTheRoom(item);

        Room room02 = new Room();
        room02.setName("room02");
        room02.setItemInTheRoom(item);

        Room room12 = new Room();
        room12.setName("room12");
        room12.setItemInTheRoom(item);

        Map map = new Map();
        map.setRoom(0, 0, room00);//setting the rooms that exist
        map.setRoom(1, 0, room10);//setting the rooms that exist
        map.setRoom(0, 1, room01);//setting the rooms that exist
        map.setRoom(1, 1, room11);//setting the rooms that exist
        map.setRoom(0, 2, room02);//setting the rooms that exist
        map.setRoom(1, 2, room12);//setting the rooms that exist
        
        room00.setValidRooms(0, room01);
        room00.setValidRooms(1, room10);
        
        room10.setValidRooms(0, room00);
        room10.setValidRooms(1, room11);
        
        room01.setValidRooms(0, room00);
        room01.setValidRooms(1, room02);
        
        room02.setValidRooms(0, room01);
        room02.setValidRooms(1, room12);
        
        room11.setValidRooms(0, room10);
        room11.setValidRooms(1, room12);
        
        map.showValues();
        
        Scanner inputStream = new Scanner(System.in);
        String directionRight = "right";
        String directionLeft = "left";
        String directionUp = "up";
        String directionDown = "down";
        
        String look = "look";
        
        int endX = 1;
        int endY = 2;
        boolean gameRunning = true;
        
        while(gameRunning){
            String command = inputStream.next();
            if(command.equals(directionRight)){
                map.movePlayerXY(map.playerX+1, map.playerY);
            }    
            else if(command.equals(directionLeft)){
                map.movePlayerXY(map.playerX-1, map.playerY);
            }
            else if(command.equals(directionUp)){
                map.movePlayerXY(map.playerX, map.playerY-1);
            }
            else if(command.equals(directionDown)){
                map.movePlayerXY(map.playerX, map.playerY+1);
            }
            else if(command.equals(look)){
                System.out.println("looks");
                map.describingRoomWhereThePlayerIs();
            }
            
            if(map.playerX == endX && map.playerY == endY){
                System.out.println("End");
                gameRunning = false;
            }
            //map.showValues();
        }
    }
}

