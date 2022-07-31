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
    public static final String NZ = "nz";
    public static final String Canada = "canada";
    
    public static final String directionEast = "east";//Constant string for decting if the player types east
    public static final String directionWest = "west";//Constant String for decting if the player types west
    public static final String directionNorth = "north";//Constant String for decting if the player types north
    public static final String directionSouth = "south";//Constant String for decting if the player types south
    public static final String directionUp = "up";//Constant String for decting if the player types south
    public static final String directionDown = "down";//Constant String for decting if the player types south

    public static final String look = "look";//Constant String for the look command
    public static final String pickup = "pickup";//Constant To detect if the player types pickup
    public static final String inventory = "inventory";//Constant To detect if the player types inventory
    public static final String place = "place";//Constant ot detect if the player types place
    
    Scanner keyboard;//import for the keyboard
    
    /**
     * Constructor for objects of class textAdventure
     */
    public TextAdventure(){
        printInstructions();//runs the print the start file methood
        Player player = getPlayer();//gets the players name
        Map map = adventureChoice();//prompos the adventure choice
        startAdventure(map, player);//Starts the players function after the map is loaded
    }

    public void printInstructions(){
        File myFile=new File("GameStart.txt");//For printing the inital text
        try { //printing out the file
            Scanner readTheFile = new Scanner(myFile);//Scanner
            while (readTheFile.hasNextLine()){
                System.out.println(readTheFile.nextLine());//Printing out the file
            }
        }
        catch (IOException e) {
            e.printStackTrace();//incase something goes wrong
            System.out.println("Something went wrong 🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿🗿?");//incase something goes wrong
        }//catch statment
    }
    
    public Player getPlayer(){
        Scanner inputStream = new Scanner(System.in);//Scanner for detecting player name
        
        String playerName = inputStream.next();//For entering the player name
        Player player = new Player(playerName);//For entering the player name
        System.out.println("");
        player.showValues();//For printing the players name
        
        return player;
    }
    
    public Map adventureChoice(){
        Scanner inputStream = new Scanner(System.in);//Scanner for detecting adventure choice
        
        System.out.println("Type what adventure you want: NZ or Canada");//System out print for asking for adventure
        
        String adventureChoice = inputStream.next().toLowerCase();//Making the choice and making it lower case
        Map map;//Map variable
        
        switch (adventureChoice) {//Switch statment for which adventure
            case NZ://NZ case
                System.out.println("You have choosen the NZ adventure");
                map = getAdventureNzMap(); //chooses the map
                break;
            default:
                System.out.println("What you typed is invalid so the NZ adventure has been chosen");
                map = getAdventureNzMap();//defualt if somthing invalid is typed
        }
        
        return map;
    }
    
    public Map getAdventureNzMap(){
        Item hat = new Item("L&P");//Creating items
        Item apple = new Item("wool");//Creating items
        Item kiwi = new Item("kiwi");//Creating items
        Item key = new Item("rugby ball");//Creating items

        Room room000 = new Room("Starting room", 0, 0, 0);//Putting the items in the room        
        Room room100 = new Room("Room", 1, 0, 0);//Making new room
        Room room010 = new Room("Room", 0, 1, 0);//Making new room
        Room room110 = new Room("Room", 1, 1, 0);//Making new room
        Room room020 = new Room("Room", 0, 2, 0);//Making new room
        Room room120 = new Room("Ending room ", 1, 2, 0, 3);//Making new end room
        Room room001 = new Room("room", 0, 0, 1);//Putting the items in the room
        Room room101 = new Room("room", 1, 0, 1);//Making new room
        Room room011 = new Room("room", 0, 1, 1);//Making new room
        Room room111 = new Room("room", 1, 1, 1);//Making new room
        Room room021 = new Room("room", 0, 2, 1);//Making new room
        Room room121 = new Room("room", 1, 2, 1);//Making new room
        
        room000.setItemInTheRoom(hat);//Putting the items in the room
        room100.setItemInTheRoom(apple);//Putting the items in the room
        room021.setItemInTheRoom(key);//Putting the items in the room
        room121.setItemInTheRoom(kiwi);//Putting the items in the room
        
        Map map = new Map("NZ",2,3,2);
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

        room120.setValidRooms(0, room020);//Setting the valid rooms for each room
        room120.setValidRooms(1, room110);//Setting the valid rooms for each room

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

        room121.setValidRooms(0, room111);//Setting the valid rooms for each room
        room121.setValidRooms(1, room120);//Setting the valid rooms for each room
        
        return map;//Return sttment becasue the methood isnt void
    }
    
    public void startAdventure(Map map, Player player){
        map.setPlayerInTheMap(player);//Player put in the map
        
        boolean gameRunning = true;// The boolean for if the game is running
        Scanner inputStream = new Scanner(System.in);//Allows imput
        
        while(gameRunning){//while loop
            String command = inputStream.next().toLowerCase();// String to take in words
            if(command.equals(directionEast)){//Moving the player east if the player types east
                map.movePlayerXYZ(map.playerX+1, map.playerY, map.playerZ);
            }    
            else if(command.equals(directionWest)){//Moving the player west if the player types west
                map.movePlayerXYZ(map.playerX-1, map.playerY, map.playerZ);
            }
            else if(command.equals(directionNorth)){//Moving the player north if the player types north
                map.movePlayerXYZ(map.playerX, map.playerY-1, map.playerZ);
            }
            else if(command.equals(directionSouth)){//Moving the player south if the player types south
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
            else if(command.equals(pickup)){// The command for picking up an item
                map.pickingUpItem();
            }
            else if(command.equals(inventory)){// The command for looking at the players inventory
                player.showValues();
            }
            else if(command.equals(place)){// The command for placing a object in a room
                map.placingItem();
            }
            else{//in case the player typed somthing wrong or a invalid command
                System.out.println("Sorry what you typed is invalid");
            }

            if(map.getCurrentRoomPlayerIsIn().checkIfPlayerWon()){//Ends the game if the palyer gets to the end room
                System.out.println("congratulations, you won");//Print the word "End"
                gameRunning = false;//Stops the game
            }
        }
    }
}

