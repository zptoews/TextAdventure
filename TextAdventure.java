
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
        Scanner inputStream = new Scanner(System.in);//Scanner for movement, look command, pickup, place, and invintory
        String playerName = inputStream.next();
        Player player = new Player(playerName);
        System.out.println("");
        player.showValues();
        
        Item hat = new Item("hat");//Creating items
        hat.showValues();//Creating items
        
        Item apple = new Item("apple");//Creating items
        apple.showValues();//Creating items
        
        Item kiwi = new Item("kiwi");//Creating items
        kiwi.showValues();//Creating items
        
        Item key = new Item("key");
        key.showValues();
        
        Room room000 = new Room("room 0,0,0");//Putting the items in the room
        room000.setItemInTheRoom(hat);//Putting the items in the room
        
        Room room100 = new Room("room 1,0,0");//Making new room
        room100.setItemInTheRoom(apple);//Putting the items in the room

        Room room010 = new Room("room 0,1,0");//Making new room

        Room room110 = new Room("room 1,1,0");//Making new room
        
        Room room020 = new Room("room 0,2,0");//Making new room
       
        Room room120 = new Room("end room 1,2,0", 3);//Making new end room
        
        Room room001 = new Room("room 0,0,1");//Putting the items in the room
    
        Room room101 = new Room("room 1,0,1");//Making new room

        Room room011 = new Room("room 0,1,1");//Making new room
    
        Room room111 = new Room("room 1,1,1");//Making new room
        
        Room room021 = new Room("room 0,2,1");//Making new room
        room021.setItemInTheRoom(key);
        
        Room room121 = new Room("room 1,2,1");//Making new room
        room121.setItemInTheRoom(kiwi);//Putting the items in the room
        
        Map map = new Map();
        map.setRoom(0, 0, 0, room000);//setting the rooms that exist
        map.setRoom(1, 0, 0, room100);//setting the rooms that exist
        map.setRoom(0, 1, 0, room010);//setting the rooms that exist
        map.setRoom(1, 1, 0, room110);//setting the rooms that exist
        map.setRoom(0, 2, 0, room020);//setting the rooms that exist
        map.setRoom(1, 2, 0, room120);//setting the rooms that exist
        
        map.setRoom(0, 0, 1, room001);//setting the rooms that exist
        map.setRoom(1, 0, 1, room101);//setting the rooms that exist
        map.setRoom(0, 1, 1, room011);//setting the rooms that exist
        map.setRoom(1, 1, 1, room111);//setting the rooms that exist
        map.setRoom(0, 2, 1, room021);//setting the rooms that exist
        map.setRoom(1, 2, 1, room121);//setting the rooms that exist
        
        map.setPlayerInTheMap(player);
        
        room000.setValidRooms(0, room001);//Setting the valid rooms for each room
        room000.setValidRooms(1, room100);//Setting the valid rooms for each room
        
        room100.setValidRooms(0, room000);//Setting the valid rooms for each room
        room100.setValidRooms(1, room110);//Setting the valid rooms for each room
        
        room010.setValidRooms(0, room110);//Setting the valid rooms for each room
        room010.setValidRooms(1, room020);//Setting the valid rooms for each room
        
        room020.setValidRooms(0, room010);//Setting the valid rooms for each room
        room020.setValidRooms(1, room120);//Setting the valid rooms for each room
        
        room110.setValidRooms(0, room100);//Setting the valid rooms for each room
        room110.setValidRooms(1, room010);//Setting the valid rooms for each room
        
        room120.setValidRooms(0, room020);
        room120.setValidRooms(1, room110);
        
        
        room001.setValidRooms(0, room011);//Setting the valid rooms for each room
        room001.setValidRooms(1, room101);//Setting the valid rooms for each room
        
        room101.setValidRooms(0, room001);//Setting the valid rooms for each room
        room101.setValidRooms(1, room111);//Setting the valid rooms for each room
    
        room011.setValidRooms(0, room001);//Setting the valid rooms for each room
        room011.setValidRooms(1, room021);//Setting the valid rooms for each room
        
        room021.setValidRooms(0, room011);//Setting the valid rooms for each room
        room021.setValidRooms(1, room121);//Setting the valid rooms for each room
        
        room111.setValidRooms(0, room101);//Setting the valid rooms for each room
        room111.setValidRooms(1, room121);//Setting the valid rooms for each room
    
        room121.setValidRooms(0, room111);
        room121.setValidRooms(1, room120);
        
        map.showValues();//Showing values for just the first room once
        
        String directionEast = "east";//String for decting if the player types right
        String directionWest = "west";//String for decting if the player types left
        String directionNorth = "north";//String for decting if the player types up
        String directionSouth = "south";//String for decting if the player types down
        String directionUp = "up";
        String directionDown = "down";
        
        String look = "look";//String for the look command
        
        String pickup = "pickup";//To detect if the player types pickup
        String inventory = "inventory";//To detect if the player types inventory
        String place = "place";// detects if the player types place
        String placeItem1 = "hat";//Item 1 is a hat
        String placeItem2 = "apple";// Item 2 is a apple
        String placeItem3 = "kiwi";//Item 3 is a kiwi
        
        boolean gameRunning = true;// The boolean for if the game is running
        while(gameRunning){//while loop
            String command = inputStream.next().toLowerCase();// String to take in words
            if(command.equals(directionEast)){//Moving the player right if the player types east
                map.movePlayerXYZ(map.playerX+1, map.playerY, map.playerZ);
            }    
            else if(command.equals(directionWest)){//Moving the player left if the player types west
                map.movePlayerXYZ(map.playerX-1, map.playerY, map.playerZ);
            }
            else if(command.equals(directionNorth)){//Moving the player up if the player types north
                map.movePlayerXYZ(map.playerX, map.playerY-1, map.playerZ);
            }
            else if(command.equals(directionSouth)){//Moving the player down if the player types south
                map.movePlayerXYZ(map.playerX, map.playerY+1, map.playerZ);
            }
            else if(command.equals(directionUp)){//Moving the player up if the player types up
                map.movePlayerXYZ(map.playerX, map.playerY, map.playerZ+1);
            }
            else if(command.equals(directionDown)){//Moving the player down if the player types down
                map.movePlayerXYZ(map.playerX, map.playerY, map.playerZ-1);
            }
            else if(command.equals(look)){// The command for looking what room you are in
                map.describingRoomWhereThePlayerIs();
            }
            else if(command.equals(pickup)){// The command for looking what room you are in
                map.pickingUpItem();
            }
            else if(command.equals(inventory)){// The command for looking what room you are in
                player.showValues();
            }
            else if(command.equals(place)){// The command for looking what room you are in
                map.placingItem();
            }
            else{
                System.out.println("Sorry what you typed is invalid");
            }
            
            if(map.getCurrentRoomPlayerIsIn().checkIfPlayerWon()){//Ends the game if the palyer gets to the end room
                System.out.println("The End");//Print the word "End"
                gameRunning = false;//Stops the game
            }
            //map.showValues();
        }
    }
}

