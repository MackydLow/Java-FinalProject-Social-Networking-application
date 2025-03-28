import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

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
	
	public int getID() {
		
		return this.id;
	}
	
	public void setID(int nID) {
		
		this.id = nID;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public void setName(String nName) {
		
		this.name = nName;
	}
	
	public postNode getPrevious() {

		return this.previousPost;
	}
	
	public void setPrevious(postNode nPrevious) {
		
		this.previousPost = nPrevious;
	}
	
	public postNode getNext() {

		return this.nextPost;
	}
	
	public void setNext(postNode nNext) {
		
		this.nextPost = nNext;
	}
	
	public LocalDate getDate() {
		
		return this.datePosted;
	}
	
	public String getText() {
		
		return this.text;
	}
	
	public void setText(String nText)
	{
		this.text = nText;
	}
	
	public int getLikes(){
		
		return this.likes;
	}
	
	public void setLikes(int nLikes) {
		
		this.likes = nLikes;
	}
	
	public void displayPost()
    {	
		System.out.println(name + "(" + id + ")" + "  " + datePosted);
        System.out.println(text);
        System.out.println("Likes " + likes);
    }
	
}

