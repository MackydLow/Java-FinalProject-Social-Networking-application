mport java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;
/**
 * This class is used for the method that will allow the user to do thing such as adding
 * friends, removing friends, displaying friends, filtering friends, saving and loading 
 * friends and viewing and adding mutual friends. this class also class many methods from
 * the Friend class
 * 
 */
public class FriendList {

	// creating the head of the linked list
	private Friend head;
	
	/**
	 * Constructor method to initialise the field of this class
	 */
	public FriendList()
	{
		// initialising the head of the linked list
		head = null;
		
	}
	
	/**
	 * A method to return the head of the linked list
	 * 
	 * @return head the head of the linked list used in this program
	 */
	public Friend getHead()
	{
		return head;
	}
	
	/**
	 * A method that will allow the user to add a friend by entering all of the data of the 
	 * friend they wish to add
	 * 
	 * @param addName a variable used to store the name entered by the user
	 * @param addID a variable used to store the ID entered by the user
	 * @param addHometown a variable used to store the home town entered by the user
	 * @param addWorkplace a variable used to store the work place entered by the user
	 */
	public void addFriend(String addName, String addID, String addHometown, String addWorkplace)
	{
		// creating an instance of the Friend Class
		Friend newFriend = new Friend();
		
		// calling all the methods required to set the data of the friend that the user is adding
		newFriend.setName(addName);
		newFriend.setID(addID);
		newFriend.setHometown(addHometown);
		newFriend.setWorkplace(addWorkplace);
		
		// creating an if statement to check if there is a value in the linked list yet
		if (head == null)
		{
			// setting the head of the linked list to the friend entered by the user
			head = newFriend;
		}
		else
		{
			//check if he id enters equals the one stores as the head
			if (head.getID().equals(addID))
			{
				// displaying a message if the friend already exists in the linked list
				System.out.println("Friend with this ID already exists");
				return;
			}
			
			// creating an object of the Friend class and setting it to the head of the linked list
			Friend current = head;
			// creating a while loop to loop for each friend in the linked list class
			while (current.getNext() != null)
			{
				// if statement to check if the ID entered by the user already exists in the linked list
				if (current.getID().equals(addID))
				{
					// displaying a message if the friend already exists in the linked list
					System.out.println("Friend with this ID already exists");
					return;
				}
				// setting the current linked list value to the next value
				current = current.getNext();
			}
			current.setNext(newFriend);
		}
		// displaying a method to the user if the friend was added to the linked list
		System.out.println(newFriend.getName() + " added successfully!");
		
		//create random instance
		Random rand = new Random();
		
		//set random number for amount of posts by friend
		int numbOfPosts = rand.nextInt(5);
		
		//cycle for amount of posts and create friends posts
		for(int p = 0; p < numbOfPosts; p++)
		{
			//create posts for your added friend
			newFriend.createFriendPost(addName);
		}
		
	}
	
	/**
	 * a method to cycle through the linked list and display your friends posts
	 */
	public void DisplayFriendPosts()
	{
		//if head is null you have no friends
		if (head == null)
		{
		
			System.out.println("Sorry, you have no friends.");
			return;
		}
			Friend current = head;
				
			//cycle through linked list and display posts of friends
			while (current != null)
			{
				//display friends posts
				current.getFriendPost();
					
				//get next friend from linked list
				current = current.getNext();
			}
	}
	
	/**
	 * to cycle through the linked list and check if the name and id match a post by your friend to then like it 
	 * 
	 * @param name name of friend
	 * @param id of the post you want to like
	 */
	public void likeFriendPosts(String name, int id)
	{
		//check if user has friends
		if (head == null)
		{
		
			System.out.println("Sorry, you have no friends.");
			return;
		}
			Friend current = head;
				
			//cycle through linked list 
			while (current != null)
			{
				//check friend with friend inputed by user
				if (current.getName().equals(name))
				{
					//if they match send data to friend class which will send to post class and like the post
					current.likeFriendPost(name, id);
					return;
				}
					
				//get next friend if doesn't match
				current = current.getNext();
			}
			
		//if none match wrong input
		System.out.println("Friend does not exist");
	}
	
	/**
	 * A method to add a friend from one of your friends friend list
	 * 
	 * @param friendID the ID of the friend in your Friend list
	 * @param mutualFriendName the name of the friend from your friends friend list
	 * @param mutualFriendID the ID of the friend from your friends friend list
	 * @param mutualFriendHometown the home town of the friend from your friends friend list
	 * @param mutualFriendWorkplace the work place of the friend from your friends friend list
	 */
	public void addMutualFriend(String friendID, String mutualFriendName, String mutualFriendID, String mutualFriendHometown, String mutualFriendWorkplace)
	{
		// creating an object of the Friend class and setting it to the head of the linked list
		Friend current = head;
		
		// creating a while loop to loop for each value in the linked list
		while (current != null)
		{
			// creating an if statement to check if the ID of the friend entered equals one of the ID's in the linked list
			if (current.getID().equals(friendID))
			{
				// calling the methods required to add mutual friends to your friend list
				current.getFriendList().addFriend(mutualFriendName, friendID, mutualFriendHometown, mutualFriendWorkplace);
				
				// displaying a message of the mutual friend that you have just added
				System.out.println("friendName + added to " + current.getName() + "'s friends.");
				return;
			}
			// setting the current linked list value to the next value
			current = current.getNext();
		}
		// displaying a message if the friend was not found
		System.out.println("Friend was not found");
	}
	
	/**
	 * A method that will be used to remove friend from your friend list by receiving 
	 * the id of the friend that the user wishes to delete and find it in the linked 
	 * list and remove the friend
	 * 
	 * @param removeID the ID of the friend that the user wishes to be removed
	 */
	public void removeFriend(String removeID)
	{
		// creating an if statement to check if the user has any friends in the linked list
		if (head == null)
		{
			// displaying a message to the user if there are no friends in the linked list
			System.out.println("No friends to remove");
			return;
		}
		
		// creating an if statement to check if the friend the user wishes to remove at the head of the linked list
		if (head.getID().equals(removeID))
		{
			// removing the head of the linked list and setting it to the next friend
			head = head.getNext();
			//displaying a message telling the user that the friend has been removed
			System.out.println("Friend removed.");
			return;
		}
		
		// creating a object of the Friend class and setting it to the head
		Friend current = head;
		// creating a while loop to loop through every friend in the linked list
		while (current.getNext() != null)
		{
			// creating an if statement to find the ID of the friend that the user wishes to remove
			if (current.getNext().getID().equals(removeID))
			{
				// removing the friend that the user want to be removed from the linked list
				current.setNext(current.getNext().getNext());
				
				// displaying a message telling the user that the friend has been removed
				System.out.println("Friend removed.");
				return;
			}
			// setting the current linked list value to the next value
			current = current.getNext();
		}
		// displaying a message if the friend was not found
		System.out.println("Friend not Found");
	}
	
	/**
	 * A method that will go through the linked list and display each friend with all 
	 * there data to the user
	 */
	public void displayFriends()
	{
		// creating an if statement to check if the user has any friends in the linked list
		if (head == null)
		{
			// displaying a message to the user if there are no friends in the linked list
			System.out.println("Sorry, you have no friends.");
			return;
		}
		// creating a object of the Friend class and setting it to the head
		Friend current = head;
		
		// creating a while loop to loop through every friend in the linked list
		while (current != null)
		{
			// displaying the current friend in the linked list
			System.out.println(current);
			
			// setting the current friend of the linked list to the next friend
			current = current.getNext();
		}
	}
	
	/**
	 * A method that will allow the user to view the friends in the friend list of all 
	 * of their friends
	 * 
	 * @param friendID the ID of the friend that will have their friend list displayed
	 */
	public void displayMutualFriends(String friendID)
	{
		// creating a object of the Friend class and setting it to the head
		Friend current = head;
		
		// creating a while loop to loop through every friend in the linked list
		while (current != null)
		{
			// creating an if statement to find the friend that has been entered by the user
			if (current.getID().equals(friendID))
			{
				// displaying the friends friend list
				System.out.println(current.getName() + "'s friends:");
				current.getFriendList().displayFriends();
				return;
			}
			// setting the current friend of the linked list to the next friend
			current = current.getNext();
		}
		// displaying a message if the friend was not found
		System.out.println("Friend not Found.");
	}
	
	/**
	 * A method that will allow the user to filter there friends by asking the user to 
	 * enter a home town and then only friends with the home town entered will be 
	 * displayed
	 * 
	 * @param filteredHometown the home town that the user has entered and that will be 
	 * used to filter the friend list
	 */
	public void filterByHometown(String filteredHometown)
	{
		// creating an if statement to check if the user has any friends in the linked list
		if (head == null)
		{
			// displaying a message to the user if there are no friends in the linked list
			System.out.println("Sorry, you have no friends.");
			return;
		}
		
		// creating a object of the Friend class and setting it to the head
		Friend current = head;
		
		// creating a while loop to loop through every friend in the linked list
		while (current != null)
		{
			// creating an if statement to find the friend that has the same home town that was entered by the user
			if (filteredHometown.equals(current.getHometown()))
			{
				// displaying the friend to the user
				System.out.println(current);
			}
			// setting the current friend of the linked list to the next friend
			current = current.getNext();
		}
	}
	
	/**
	 * A method that will allow the user to filter there friends by asking the user to 
	 * enter a work place and then only friends with the work place entered will be 
	 * displayed
	 * 
	 * @param filteredWorkplace the work place that the user has entered and that will be 
	 * used to filter the friend list
	 */
	public void filterByWorkplace(String filteredWorkplace)
	{
		// creating an if statement to check if the user has any friends in the linked list
		if (head == null)
		{
			// displaying a message to the user if there are no friends in the linked list
			System.out.println("Sorry, you have no friends.");
			return;
		}
		
		// creating a object of the Friend class and setting it to the head
		Friend current = head;
		// creating a while loop to loop through every friend in the linked list
		while (current != null)
		{
			// creating an if statement to find the friend that has the same work place that was entered by the user
			if (filteredWorkplace.equals(current.getWorkplace()))
			{
				// displaying the friend to the user
				System.out.println(current);
			}
			// setting the current friend of the linked list to the next friend
			current = current.getNext();
		}
	}
	
	/**
	 * A method that will save each of the friends and all of there data from the linked 
	 * list and write them to a text file
	 * 
	 * @param filename 
	 */
	public void saveFriend(String filename)
	{
		// creating an instance of the built in class in java
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename)))
		{
			// creating a object of the Friend class and setting it to the head
			Friend current = head;
			
			// creating a while loop to loop through every friend in the linked list
			while (current != null)
			{
				// writing all of the data of the friends to a file
				writer.write(current.toString());
				writer.newLine();
				
				// setting the current friend of the linked list to the next friend
				current = current.getNext();
			}
			
			// displaying a message to the user saying that the friends have been saved
			System.out.println("Friends Saved!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * A method that will read in each friend from a text file and store them in the 
	 * linked list
	 * 
	 * @param filename
	 */
	public void loadFriends(String filename)
	{
		// setting the head to equal null
		head = null;
		
		// creating an instance of the built in class in java
		try (BufferedReader reader = new BufferedReader(new FileReader(filename)))
		{
			// reading in each of the lines from the text file and storing it into the linked list
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] data = line.split(",");
				if (data.length == 4)
				{
					addFriend(data[0], data[1], data[2], data[3]);
				}
			}
			// displaying a message to the user saying that the friends have been saved
			System.out.println("Friends have been loaded!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
