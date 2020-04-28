package cesar_duplicatedEmails;

import java.util.HashSet;

public class RemoveDupEmails {
		//subclass to define the Nodes
	    static class Node  
	    { 
	        String email; 
	        Node next; 
	  
	        public Node(String email)  
	        { 
	            this.email = email; 
	        } 
	    } 
	      
	   //function to remove duplicated e-mails from a thread
	    static void removeDup(Node head)  
	    { 
	        // Hash - stores emails already seen
	        HashSet<String> hs = new HashSet<String>(); 
	        
	        Node current = head;
	        Node prev = null;
	        while (current != null)  
	        { 
	            String currentVal = current.email; 
	              
	            if (hs.contains(currentVal)) { 
	                prev.next = current.next; 
	            } else { 
	                hs.add(currentVal); 
	                prev = current; 
	            } 
	            current = current.next; 
	        } 
	  
	    } 
	      
	    // Print linked list
	    static void printList(Node head)  
	    { 
	        while (head != null)  
	        { 
	            System.out.println(head.email); 
	            head = head.next; 
	        } 
	    } 
	  
	    public static void main(String[] args)  
	    { 
	        // Create list for testing purposes
	        Node listTest = new Node("Hello, this is a test e-mail"); 
	        listTest.next = new Node("Hello, this is a test e-mail"); 
	        listTest.next.next = new Node("Hello, this is a test e-mail"); 
	        listTest.next.next.next = new Node("Hi Cassio, how are you"); 
	        listTest.next.next.next.next = new Node("I'm fine, thanks"); 
	        listTest.next.next.next.next.next = new Node("I'm fine, thanks"); 
	        listTest.next.next.next.next.next.next = new Node("Good"); 
	  
	        System.out.println("E-mail list before removing duplicated ones :"); 
	        printList(listTest); 
	  
	        removeDup(listTest); 
	  
	        System.out.println("\nE-mail list after removing duplicated ones :"); 
	        printList(listTest);
	    }
	  
}
