import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/**
 * to create each node in the linked list and initialise all the variables it needs
 */
public class postNode {
	
	int id;
	String name;
	postNode previousPost;
	postNode nextPost;
	LocalDate datePosted;
	String text;
	int likes;
	
	public postNode(){
		
		this.id = 0;
		this.name = "";
		this.previousPost = null;
		this.nextPost = null;
		this.datePosted = LocalDate.now();
		this.text= "";
		this.likes = 0;			 
		
	}
	
	public postNode(String cText, String cName){
		
		this.id = 0;
		this.name = cName;
		this.previousPost = null;
		this.nextPost = null;
		this.datePosted = LocalDate.now();
		this.text = cText;
		this.likes = 0;

	}
	
	/**
	 * get the ID of the post
	 * 
	 * @return id of the post
	 */
	public int getID() {
		
		return this.id;
	}
	
	/**
	 * to replace the current ID
	 * 
	 * @param nID the new ID to replace the current id
	 */
	public void setID(int nID) {
		
		this.id = nID;
	}
	
	/**
	 * get name of the person who posted
	 * 
	 * @return name of the poster
	 */
	public String getName() {
		
		return this.name;
	}
	
	/**
	 * set a new name for the post maker
	 * 
	 * @param nName new name
	 */
	public void setName(String nName) {
		
		this.name = nName;
	}
	
	/**
	 * get the previous node from the linked list
	 * 
	 * @return previous ndoe
	 */
	public postNode getPrevious() {

		return this.previousPost;
	}
	
	/**
	 * input a new previous node in the linked list
	 * 
	 * @param nPrevious new previous post
	 */
	public void setPrevious(postNode nPrevious) {
		
		this.previousPost = nPrevious;
	}
	
	/**
	 * return the next node from the linked list
	 * 
	 * @return the next node
	 */
	public postNode getNext() {

		return this.nextPost;
	}
	
	/**
	 * set up the next node for the post linked list
	 * 
	 * @param nNext new next post
	 */
	public void setNext(postNode nNext) {
		
		this.nextPost = nNext;
	}
	
	/**
	 * return the date of the post created
	 * 
	 * @return
	 */
	public LocalDate getDate() {
		
		return this.datePosted;
	}
	
	/**
	 * get the text of the post
	 * 
	 * @return the text posted
	 */
	public String getText() {
		
		return this.text;
	}
	
	/**
	 * set the text of the post
	 * 
	 * @param nText new text for the post
	 */
	public void setText(String nText)
	{
		this.text = nText;
	}
	
	/**
	 * get the likes of the post
	 * 
	 * @return the likes
	 */
	public int getLikes(){
		
		return this.likes;
	}
	
	/**
	 * set the likes for post
	 * 
	 * @param nLikes new likes for the post
	 */
	public void setLikes(int nLikes) {
		
		this.likes = nLikes;
	}
	
	/**
	 * display the details of the post and its content
	 */
	public void displayPost()
    {	
	System.out.println(name + "(" + id + ")" + "  " + datePosted);
        System.out.println(text);
        System.out.println("Likes " + likes);
    }
	
}
