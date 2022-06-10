
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
        File myFile=new File("GameStart.txt");//For printing the inital text
        //System.out.println("Welcome to my text adventure game");//inroduction for the game
        //System.out.println("");//inroduction for the game
        //System.out.println("Insturctions: You can type up,down,north,south,east, and west to go diffrent places");//inroduction for the game
        //System.out.println("You can also type pickup_item_name to pickup a item and put it into your invintory");//inroduction for the game
        //System.out.println("");//inroduction for the game
        //System.out.println("Your goal is escape the island");//inroduction for the game
        try { //printing out the file
            Scanner readTheFile = new Scanner(myFile);
            while (readTheFile.hasNextLine()){
                //String reading=readTheFile.nextLine();
                System.out.println(readTheFile.nextLine());
            }
        }
        catch (IOException e) {
            e.printStackTrace();//incase something goes wrong
            System.out.println("Something went wrong 🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿?");//incase something goes wrong
        }//catch statment

        testing();
    }

    void testing(){
        Item item = new Item();//Creating items
        item.setName("item_name");//Creating items
        System.out.println("");//Creating items
        item.showValues();//Creating items

        Room room00 = new Room();//Putting the items in the room
        room00.setName("room00");//Putting the items in the room
        room00.setItemInTheRoom(item);//Putting the items in the room
        //System.out.println("");
        //room.showValues();
        Room room10 = new Room();//Making new room
        room10.setName("room10");//Naming the room
        room10.setItemInTheRoom(item);//Putting the items in the room

        Room room01 = new Room();//Making new room
        room01.setName("room01");//Naming the room
        room01.setItemInTheRoom(item);//Putting the items in the room

        Room room11 = new Room();//Making new room
        room11.setName("room11");//Naming the room
        room11.setItemInTheRoom(item);//Putting the items in the room

        Room room02 = new Room();//Making new room
        room02.setName("room02");//Naming the room
        room02.setItemInTheRoom(item);//Putting the items in the room

        Room room12 = new Room();//Making new room
        room12.setName("room12");//Naming the room
        room12.setItemInTheRoom(item);//Putting the items in the room

        Map map = new Map();
        map.setRoom(0, 0, room00);//setting the rooms that exist
        map.setRoom(1, 0, room10);//setting the rooms that exist
        map.setRoom(0, 1, room01);//setting the rooms that exist
        map.setRoom(1, 1, room11);//setting the rooms that exist
        map.setRoom(0, 2, room02);//setting the rooms that exist
        map.setRoom(1, 2, room12);//setting the rooms that exist
        
        room00.setValidRooms(0, room01);//Setting the valid rooms for each room
        room00.setValidRooms(1, room10);//Setting the valid rooms for each room
        
        room10.setValidRooms(0, room00);//Setting the valid rooms for each room
        room10.setValidRooms(1, room11);//Setting the valid rooms for each room
        
        room01.setValidRooms(0, room00);//Setting the valid rooms for each room
        room01.setValidRooms(1, room02);//Setting the valid rooms for each room
        
        room02.setValidRooms(0, room01);//Setting the valid rooms for each room
        room02.setValidRooms(1, room12);//Setting the valid rooms for each room
        
        room11.setValidRooms(0, room10);//Setting the valid rooms for each room
        room11.setValidRooms(1, room12);//Setting the valid rooms for each room
        
        map.showValues();//Showing values for just the first room once
        
        Scanner inputStream = new Scanner(System.in);//Scanner for movement, look command, pickup, place, and invintory
        String directionRight = "right";
        String directionLeft = "left";
        String directionUp = "up";
        String directionDown = "down";
        
        String look = "look";
        
        int endX = 1;
        int endY = 2;
        boolean gameRunning = true;// The boolean for if the game is running
        
        while(gameRunning){//while loop
            String command = inputStream.next();// String to take in words
            if(command.equals(directionRight)){//Moving the player right if the player types right
                map.movePlayerXY(map.playerX+1, map.playerY);
            }    
            else if(command.equals(directionLeft)){//Moving the player left if the player types left
                map.movePlayerXY(map.playerX-1, map.playerY);
            }
            else if(command.equals(directionUp)){//Moving the player up if the player types up
                map.movePlayerXY(map.playerX, map.playerY-1);
            }
            else if(command.equals(directionDown)){//Moving the player down if the player types down
                map.movePlayerXY(map.playerX, map.playerY+1);
            }
            else if(command.equals(look)){// The command for looking what room you are in
                System.out.println("looks");
                map.describingRoomWhereThePlayerIs();
            }
            
            if(map.playerX == endX && map.playerY == endY){//Ends the game if the palyer gets to the end room
                System.out.println("End");
                gameRunning = false;
            }
            //map.showValues();
        }
    }
}

