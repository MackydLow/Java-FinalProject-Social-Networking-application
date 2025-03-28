import java.util.Scanner;
public class post
{
    private postNode head;
    
    public post()
    {
        head = null;
    }

    public void makePost(String name, String text)
    {
    	Scanner S = new Scanner(System.in);
    	
    	//System.out.println("text:");
    	//String text = S.nextLine(); 
    	
        postNode  newNode = new postNode(text, name); 
        newNode.setNext(head);  
        
        if (head != null)
        {
        	int prevID = head.getID();
        	newNode.setID(prevID + 1);
        	
        	head.setPrevious(newNode);
   
        }
        
        
        
        head = newNode;
        
    }
 
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
     
    public void addLike(int id, String name)
    {
        postNode current; 
        Boolean foundNode;

        current = head;
        foundNode = false;

        while ((current != null) && (foundNode == false))
        {
            if (id == current.getID())
            {
                current.setLikes(current.getLikes() + 1);
                foundNode = true;
            }
            else 
            {
                current = current.getNext();
            }
        }

    }
    
    public void deletePost(int id) {
    	
    	postNode current; 
        Boolean foundNode;

        current = head;
        foundNode = false;

        while ((current != null) && (foundNode == false))
        {
            if (id == current.getID())
            {
                postNode previous = current.getPrevious();
                postNode next = current.getNext();
                if (next == null)
                {
                	previous.setNext(current.getNext());
                	
                	} else if (previous == null)
                	{
                		head = current.getNext();
                		
                	} else
                		{
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
    
    public static void main(String[] args) {
    
    	post friendPosts = new post();
    	post yourPosts = new post();
    	
    	friendPosts.makePost("bob", "fein");
    	friendPosts.makePost("bob", "steve");
    	friendPosts.makePost("bob", "cum");
    	friendPosts.makePost("bob", "ji");
    	friendPosts.display();
    	friendPosts.deletePost(3);
    	System.out.println();
    	friendPosts.display();
    	
    	
    }
}

