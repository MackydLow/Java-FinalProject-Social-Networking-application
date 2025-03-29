/**
 * a class to allow users to create a post or make posts for friends and allow the main user to view them and interact with them 
 * as well as their own posts
 * 
 */
import java.util.Scanner;
import java.util.Random;
import java.util.Random;

public class post
{
	//Initialise head of linked list
    private postNode head;
    
    public post()
    {
    	//set head as null
        head = null;
    }
    
    /**
     * when user make a post to get the information that they want to post
     */
    public void getPostInfo()
    {
    	Scanner S = new Scanner(System.in);
    	
    	//get text for post
    	System.out.println("text: ");
    	String text = S.nextLine(); 
    	
    	String name = "bob";
    	
    	//call method to make post
    	makePost(name, text);
    }
    
    /**
     * when information for post is acquired input it into the linked list
     * 
     * @param name name of person making the post
     * @param text text for the post
     */
    public void makePost(String name, String text)
    {
    	//create a new node
        postNode  newNode = new postNode(text, name); 
        newNode.setNext(head);  
        
        //check if head is null
        if (head != null)
        {
        	//get id of previous post and set new id as + 1
        	int prevID = head.getID();
        	newNode.setID(prevID + 1);
        	
        	//new node previous as current head
        	head.setPrevious(newNode);
   
        }
        
        head = newNode;
        
    }
    
    /**
     * create a random line of text that the main user friends have posted
     * 
     * @return text the random line of text posted by the users friend
     */
    public String friendMakePost() {
    	
    	//create random variable
    	Random rand = new Random();
    		
    		//set up arrays for random sentence creation
    		String Nouns[] = {"I","You","He","She","They","Steve","John","It"};
    		String Verbs[] = {" Walk"," Sprint"," swim"," dance"," sing", " jump"};
    		String Adj[] = {" fast.", " slow.", " funny.", " happily", " funnily", " badly.", " Stupidly."};
    		
    		//randomly assign a noun, verb and adjective
    		int n1 = rand.nextInt(Nouns.length);
    		int v1 = rand.nextInt(Verbs.length);
    		int a1 = rand.nextInt(Adj.length);
    		
    		//create random sentence
    		String text = (Nouns[n1] + Verbs[v1] + Adj[a1]);
    		
    		return text;
    		
    	}
 
    /**
     * display posts that have been posted
     */
     public void display()
     {
        postNode current;

            // start at the head
            current = head;

            // while still a node to display
            while (current != null) 
	        {
                // display node information
                current.displayPost(); 

                System.out.println();
                // move to next node along
                current = current.getNext(); 
	        }
        
    }
     
     /**
      * get data and loop through and like the post designated by the user
      * 
      * @param id id of post
      * @param name name of friend who's post you want to like
      */
    public void addLike(int id, String name)
    {
    	//set up variables
        postNode current; 
        Boolean foundNode;

        //set head and found is be false
        current = head;
        foundNode = false;

        //while current is not empty and node has not been found
        while ((current != null) && (foundNode == false))
        {
        	//check if ID's match
            if (id == current.getID())
            {
            	//call method to add 1 to the like counter
                current.setLikes(current.getLikes() + 1);
                foundNode = true;
            }
            else 
            {
            	//go to next node if ID's don't match
                current = current.getNext();
            }
        }

    }
    
    /**
     * delete a post created by the user
     * 
     * @param id id of post
     */
    public void deletePost(int id) {
    	
    	//set up variables
    	postNode current; 
        Boolean foundNode;
        
        //set up loop
        current = head;
        foundNode = false;

        while ((current != null) && (foundNode == false))
        {
        	//check if ID's match
            if (id == current.getID())
            {
            	//set up previous and next of the node to delete
                postNode previous = current.getPrevious();
                postNode next = current.getNext();
                if (next == null)
                {
                	//if next node is empty only have to change the previous node
                	previous.setNext(current.getNext());
                	
                	} else if (previous == null)
                	{
                		//if the node to delete if the head change the head
                		head = current.getNext();
                		
                	} else
                		{
                			//if node is in the middle change both side to skip node to delete
                			next.setPrevious(current.getPrevious());
                			previous.setNext(current.getNext());
                		}
                foundNode = true;
            }
            else 
            {
                current = current.getNext();
            }
        }
    }
    
}



