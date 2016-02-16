//Room object, connects to adjacent rooms and contains all necessary fields
class room
{
	//all necessary fields for room object
	boolean hasCream, hasCoffee, hasSugar;
	boolean northDoor, southDoor;
	String roomDescription;
	String northDoorDescription;
	String southDoorDescription;
	room northRoom;
	room southRoom;
	
	//full constructor for room object
	public room(boolean cream, boolean coffee, boolean sugar, boolean north, boolean south, String describeRoom, String describeNorth, String describeSouth, room roomNorth, room roomSouth)
	{
		hasCream = cream;
		hasCoffee = coffee;
		hasSugar = sugar;
		northDoor = north;
		southDoor = south;
		roomDescription = describeRoom;
		northDoorDescription = describeNorth;
		southDoorDescription = describeSouth;
		northRoom = roomNorth;
		southRoom = roomSouth;
	}
	
	//Mutator method for northRoom
	public void setNorthRoom(room north)
	{
		northRoom = north;
	}
	
	//Mutator method for southRoom
	public void setSouthRoom(room south)
	{
		southRoom = south;
	}
	
	//prints out description of room and any doors
	public void describeRoom()
	{
		System.out.println(roomDescription);
		if(northDoor){
			System.out.println(northDoorDescription);
		}
		if(southDoor){
			System.out.println(southDoorDescription);
		}
	}

	//prints out 'help' dialogue
	public static void printHelp()
	{
		System.out.println("You can enter one of 6 commands - N, S, L, I, D, or H. Case does not matter.");
		System.out.println("N stands for 'north.' You will move through the north door, if available.");
		System.out.println("S stands for 'south.' You will move through the south door, if available.");
		System.out.println("L stands for 'look.' You will look around you to see if the room has cream, sugar, or coffee, and pick it up if available.");
		System.out.println("I stands for 'inventory.' You will check your inventory to see what coffee ingredients you have on you.");
		System.out.println("D stands for 'drink.' You will attempt to drink the coffee. If you have all ingredients, you win! If not, you lose.");
		System.out.println("H stands for 'help.' You will see this dialogue printed out again if you enter 'h.'\n");
	}
}