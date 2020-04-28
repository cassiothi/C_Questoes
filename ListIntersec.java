package cesar_listIntersection;

import java.util.*; 
public class ListIntersec {

	
	static class Node { 
	    String data; 
	    Node next; 
	    Node(String d) 
	    { 
	        data = d; 
	        next = null; 
	    } 
	} 
	   
    // find the intersection node between the lists 
    public static Node intersecNode(Node n1, Node n2) 
    { 
        // hashset 
        HashSet<Node> hs = new HashSet<Node>(); 
        while (n1 != null) { 
            hs.add(n1); 
            n1 = n1.next; 
        } 
        while (n2 != null) { 
            if (hs.contains(n2)) { 
                return n2; 
            }
            else {
            	n2 = n2.next;
            }
        } 
        return null; 
    }
    

    // print the list 
    public static void PrintList(Node n) 
    { 
        Node current = n; 
        while (current != null) { 
            System.out.println(current.data); 
            current = current.next; 
        } 
        System.out.println(); 
    } 
    
    public static void main(String[] args) 
    { 
        // E-mail list 1 
        Node n1 = new Node("Email test 1"); 
        n1.next = new Node("Email test 2"); 
        n1.next.next = new Node("Email test 3"); 
        n1.next.next.next = new Node("Email test 4"); 
        n1.next.next.next.next = new Node("Email test 5"); // THIS IS THE INTERSECTION NODE
        n1.next.next.next.next.next = new Node("Email test 6"); 
        n1.next.next.next.next.next.next = new Node("Email test 7"); 
        
        // E-mail list 1
        Node n2 = new Node("Email test A"); 
        n2.next = new Node("Email test B"); 
        n2.next.next = n1.next.next.next.next; 
        
        System.out.println("Data elements in List 1:");
        PrintList(n1);
        System.out.println("Data elements in List 2:");
        PrintList(n2);
        
        //Function should print the data in in intersection node
        System.out.println("Intersect node between the lists:");
        System.out.println(intersecNode(n1, n2).data);
    } 
	
	
}
