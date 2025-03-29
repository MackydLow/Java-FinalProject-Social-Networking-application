import java.util.Scanner;
/**
 * A class that is used to create a menu page and receive an input of one of the options 
 * from the user and displaying the correct methods depending on what option the user has
 * entered
 */
public class Main {
	
	/**
	 * A method to display the menu to the user and receive the input from the user and 
	 * then go through the switch statement and call the methods depending on the users 
	 * choice
	 */
	public void menu()
	{
		// creating an instance of the FriendList class
		FriendList friendList = new FriendList();
		
		// creating an instance of the Scanner class
		Scanner s = new Scanner(System.in);
		
		// creating a while loop to continue looping until the correct input is entered
		while (true)
		{
			// displaying the choices to the user
			System.out.println("");
			System.out.println("Social Media Menu");
			System.out.println("1. Add Friend");
			System.out.println("2. Remove Friend");
			System.out.println("3. Display Friends");
			System.out.println("4. Filter Friends");
			System.out.println("5. Save Friends");
			System.out.println("6. Load Friends");
			System.out.println("7. View Mutual Friends");
			System.out.println("8. Add Mutual Friend");
			System.out.println("9. Display Friends Posts");
			System.out.println("10. Like Friends Posts");
			System.out.println("11. Exit Page");
			System.out.println("Choose an option:");
			// receiving the users choice
			int menuChoice = s.nextInt();
			s.nextLine();
			

			// creating a switch statement to call the correct classes depending on the users choice
			switch (menuChoice)
			{
			case 1:
				// asking the user to enter in the name of the friend they would like to add
				System.out.println("Please Enter Friends Name:");
				String addName = s.nextLine();
				
				// asking the user to enter in the ID of the friend they would like to add
				System.out.println("Please Enter Friends ID:");
				String addID = s.nextLine();
				
				// asking the user to enter in the home town of the friend they would like to add
				System.out.println("Please Enter Friends Hometown:");
				String addHometown = s.nextLine();
				
				// asking the user to enter in the work place of the friend they would like to add
				System.out.println("Please Enter Friends Workplace:");
				String addWorkplace = s.nextLine();
				
				// calling the method to add a friend 
				friendList.addFriend(addName, addID, addHometown, addWorkplace);
				break;
			case 2:
				// asking the user to enter in the ID of the friend they would like to remove
				System.out.println("Please Enter the ID Friend of you Would Like to Remove:");
				String removeID = s.nextLine();
				
				// calling the method to remove a friend 
				friendList.removeFriend(removeID);
				break;
			case 3:
				// calling the method to display all of the users friends
				friendList.displayFriends();
				break;
			case 4:
				// asking the user to enter how they would like there friends to be filtered
				System.out.println("Please enter how you would like to filter your Friends:");
				System.out.println("1. Hometown");
				System.out.println("2. Workplace");
				// receiving the users choice
				int filterChoice = s.nextInt();
				s.nextLine();
				
				// creating an if statement to filter the friends in the way that the user wants
				if (filterChoice == 1)
				{
					// asking the user to enter the home town they would like to be displayed
					System.out.println("Please enter the hometown you would like to be displayed:");
					String filteredHometown = s.nextLine();
					
					// calling the method to display the users with the home town entered by the user
					friendList.filterByHometown(filteredHometown);
				}
				else if (filterChoice == 2)
				{
					// asking the user to enter the work place they would like to be displayed
					System.out.println("Please enter the workplace you would like to be displayed:");
					String filteredWorkplace = s.nextLine();
					// calling the method to display the users with the work place entered by the user
					friendList.filterByWorkplace(filteredWorkplace);
				}
				break;
			case 5:
				// calling the method to save the friend list 
				friendList.saveFriend("Friend List.txt");
				break;
			case 6:
				// calling the method to load the friend list
				friendList.loadFriends("Friend List.txt");
				break;
			case 7:
				// asking the user the ID of the friend with the friend list that the user would like to view
				System.out.println("Please Enter the ID of the Friend whose friends you want to view");
				String displayFriendID = s.nextLine();
				// calling the method to view the friends friend list
				friendList.displayMutualFriends(displayFriendID);
				break;
			case 8:
				// asking the user for the ID of there friend
				System.out.println("Please enter the ID of the Friend to add a Friend to:");
				String friendID = s.nextLine();
				
				// asking the user for the name of there mutual friend
				System.out.println("Please Enter the name of the Mutual Friend you would like to add:");
				String mutualFriendName = s.nextLine();
				
				// asking the user for the ID of there mutual friend
				System.out.println("Please Enter the ID of the Mutual Friend you would like to add:");
				String mutualFriendID = s.nextLine();
				
				// asking the user for the home town of there mutual friend
				System.out.println("Please Enter the Hometown of the Mutual Friend you would like to add:");
				String mutualFriendHometown = s.nextLine();
				
				// asking the user for the work place of there mutual friend
				System.out.println("Please Enter the Workplace of the Mutual Friend you would like to add");
				String mutualFriendWorkplace = s.nextLine();
				
				// calling the method to add a mutual friend
				friendList.addMutualFriend(friendID, mutualFriendName, mutualFriendID, mutualFriendHometown, mutualFriendWorkplace);
				break;
			case 9:
				//call method to display friend post
				friendList.DisplayFriendPosts();
				break;
			case 10:
				//get friend who's post you want to like
				System.out.println("Enter friends who's post you want to like ");
				String friendForLike = s.nextLine();
				//get ID of post you want to like
				System.out.println("Enter id of post for that friend");
				int postID = s.nextInt();
				//call method to like post
				friendList.likeFriendPosts(friendForLike, postID);
				break;
			case 11:
				// displaying a message
				System.out.println("Exiting Page...");
				return;
			default:
				// displaying an error message
				System.out.println("Invalid option. Please try again");
			}
		}
	}
	
	/**
	 * A method that will be used to call the menu for this program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// creating an instance of the main class
		Main main = new Main();
		
		// calling the menu method
		main.menu();
		
	}

}
