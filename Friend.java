/**
 * This class is to create all of the fields of data for the friends you will 
 * be adding and creating get set methods to give each fields a value
 * 
 */
public class Friend {

	// Creating all the fields and objects in this class which will be used to store the data of the friends that you will add
	private String name;
	private String ID;
	private String hometown;
	private String workplace;
	private Friend next;
	private FriendList friendList;
	private post friendPost;
	
	/** 
	 * Constructor method to initialise all of the fields and objects to a value
	 */
	public Friend()
	{
		// Initialising all of the fields from this class
		name = "";
		ID = "";
		hometown = "";
		workplace = "";
		next = null;
		friendList = null;
		friendPost = new post();
	}
	
	/**
	 * A method to receive the name from the user and then set that value to a field
	 * 
	 * @param newName a variable that stores the name entered by the user
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * A method that will return the field that will store the name back to the user
	 * 
	 * @return name field that will store the name entered by the user
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * A method that will receive the ID entered by the user and set it to a field
	 * 
	 * @param newID a variable that stores the ID entered by the user
	 */
	public void setID(String newID)
	{
		ID = newID;
	}
	
	/**
	 * A method that will return the field that will store the ID back to the user
	 * 
	 * @return ID field that will store the ID entered by the user
	 */
	public String getID()
	{
		return ID;
	}
	
	/**
	 * A method that will receive the home town entered by the user and set it to a field
	 * 
	 * @param newHometown a variable that stores the home town entered by the user
	 */
	public void setHometown(String newHometown)
	{
		hometown = newHometown;
	}
	
	/**
	 * A method that will return the field that will store the home town back to the user
	 * 
	 * @return hometown field that will store the home town entered by the user
	 */
	public String getHometown()
	{
		return hometown;
	}
	
	/**
	 * A method that will receive the work place entered by the user and set it to a field
	 * 
	 * @param newWorkplace a variable that stores the work place entered by the user
	 */
	public void setWorkplace(String newWorkplace)
	{
		workplace = newWorkplace;
	}
	
	/**
	 * A method that will return the field that will store the work place back to the user
	 * 
	 * @return workplace field that will store the work place entered by the user
	 */
	public String getWorkplace()
	{
		return workplace;
	}
	
	/**
	 * A method that will set an object of this class
	 * 
	 * @param next and object of the Friend class
	 */
	public void setNext(Friend next)
	{
		this.next = next;
	}
	
	/**
	 * A method that will return the object of this class
	 * 
	 * @return next object of the friend class
	 */
	public Friend getNext()
	{
		return next;
	}
	
	/**
	 * A method to return an object of the FriendList class
	 * 
	 * @return friendList object of the FriendList class
	 */
	public FriendList getFriendList()
	{
		return friendList;
	}
	
	/**
	 * A method to provide a string representation of the object of this class
	 */
	@Override
	public String toString()
	{
		return name + "," + ID + "," + hometown + "," + workplace;
	}
	
	
	/**
	 * a method to send data to the post class and create a post for the added friend
	 * 
	 * @param name name of the friend
	 */
	public void createFriendPost(String name)
	{
		
		friendPost.makePost(name, friendPost.friendMakePost());
	}
	
	/**
	 * to display the posts of your friends
	 */
	public void getFriendPost()
	{
		friendPost.display();
	}
	
	/**
	 * to sent data to the post class to like a post made by one of your friends
	 * 
	 * @param name name of the friend
	 * @param id of the post you are liking
	 */
	public void likeFriendPost(String name, int id)
	{
		friendPost.addLike(id, name);
	}
	
}
