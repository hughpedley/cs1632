import java.util.Scanner;

public class coffeeMaker
{
	public static void main(String[] args)
	{
		//make the room objects
		room smallRoom = new room(true, false, false, true, false, "You see a small room.\nIt has a quaint sofa.", "A magenta door leads north.", null, null, null);
		room funnyRoom = new room(false, false, false, true, true, "You see a funny room.\nIt has a sad record player.", "A beige door leads north.", "A massive door leads south.", null, smallRoom);
		room refinancedRoom = new room(false, true, false, true, true, "You see a refinanced room.\nIt has a tight pizza.", "A dead door leads north.", "A smart door leads south.", null, funnyRoom);
		room dumbRoom = new room(false, false, false, true, true, "You see a dumb room.\nIt has a flat energy drink.", "A vivacious door leads north.", "A slim door lead south.", null, refinancedRoom);
		room bloodthirstyRoom = new room(false, false, false, true, true, "You see a bloodthirsty room.\nIt has a beautiful bag of money.", "A purple door leads north.", "A sandy door leads south.", null, dumbRoom);
		room roughRoom = new room(false, false, true, false, true, "You see a rough room.\nIt has a perfect air hockey table.", null, "A minimalist door leads south.", null, bloodthirstyRoom);
		//Assign northRoom now that all rooms are made
		smallRoom.setNorthRoom(funnyRoom);
		funnyRoom.setNorthRoom(refinancedRoom);
		refinancedRoom.setNorthRoom(dumbRoom);
		dumbRoom.setNorthRoom(bloodthirstyRoom);
		bloodthirstyRoom.setNorthRoom(roughRoom);
		
		//set up all other variables needed for game
		room currentRoom = smallRoom;
		Scanner keyboard = new Scanner(System.in);
		String input;
		boolean playerCream = false;
		boolean playerCoffee = false;
		boolean playerSugar = false;
		
		//loop through the game, only exits program when player attempts to drink coffee
		while(true){
			currentRoom.describeRoom();
			System.out.print("\n Instructions (N,S,L,I,D,H)");
			input = keyboard.nextLine();
			System.out.println();
			if(input.toLowerCase().equals("n")){
				if(currentRoom.northDoor){
					currentRoom = currentRoom.northRoom;
				}
				else{
					System.out.println("There is no room to the north.\n");
				}
			}
			else if(input.toLowerCase().equals("s")){
				if(currentRoom.southDoor){
					currentRoom = currentRoom.southRoom;
				}
				else{
					System.out.println("There is no room to the south.\n");
				}
			}
			else if(input.toLowerCase().equals("l")){
				System.out.println("You look around the room.");
				if(currentRoom.hasCoffee){
					System.out.println("You found coffee!\n");
					playerCoffee = true;
					currentRoom.hasCoffee = false;
				}
				else if(currentRoom.hasCream){
					System.out.println("You found cream!\n");
					playerCream = true;
					currentRoom.hasCream = false;
				}
				else if(currentRoom.hasSugar){
					System.out.println("You found sugar!\n");
					playerSugar = true;
					currentRoom.hasSugar = false;
				}
				else{
					System.out.println("You found nothing out of the ordinary.\n");
				}
			}
			else if(input.toLowerCase().equals("i")){
				printInventory(playerCoffee, playerCream, playerSugar);
			}
			else if(input.toLowerCase().equals("d")){
				if(playerCoffee && playerCream && playerSugar){
					System.out.println("You drink the coffee. Delicious!");
					System.out.println("You win!");
					keyboard.close();
					System.exit(0);
				}
				else{
					System.out.println("You don't have the three ingredients! This...drink, if you can call it that, is horrible.");
					System.out.println("You lose.");
					keyboard.close();
					System.exit(0);
				}
			}
			else if(input.toLowerCase().equals("h")){
				room.printHelp();
			}
			else{
				System.out.println("What?\n");
			}
		}
	}
	
	//prints out contents of inventory
	public static void printInventory(boolean playerCoffee, boolean playerCream, boolean playerSugar)
	{
		if(playerCoffee){
			System.out.println("You have coffee!\n");
		}
		else{
			System.out.println("You do not have coffee.\n");
		}
		if(playerCream){
			System.out.println("You have cream!\n");
		}
		else{
			System.out.println("You do not have cream.\n");
		}
		if(playerSugar){
			System.out.println("You have sugar!\n");
		}
		else{
			System.out.println("You have no sugar.\n");
		}
	}
}