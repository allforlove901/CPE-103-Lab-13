import java.util.Scanner;
import java.util.Iterator;

public class MyHashTest {

	public static void main(String[] args) {
		
		boolean quit = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter table size");
		int size = Integer.parseInt(sc.nextLine());
		
		MyHashTable<Integer> myHash = new MyHashTable<Integer>(size);
		
		System.out.println("Menu of operations:");
		System.out.println("   - add/insert..(enter the letter a)");
		System.out.println("   - find........(enter the letter f)");
		System.out.println("   - delete......(enter the letter d)");
		System.out.println("   - empty.......(enter the letter e)");
		System.out.println("   - print.......(enter the letter p)");
    	System.out.println("   - quit........(enter the letter q)");
    	
    	while(!quit){
    		System.out.println("Choose an option");
    		String input =  sc.nextLine();
    		
    		switch(input){
    		
    		case"a":
    			System.out.println("please enter a numerical value to add");
    			int store = Integer.parseInt(sc.nextLine());
    			myHash.insert(store);
    			System.out.println(store + " inserted");
    			break;
    			
    		case"f":
    			System.out.println("please enter a numerical value to find");
    			int store2 = Integer.parseInt(sc.nextLine());
    			if(myHash.find(store2))
        			System.out.println("found");
    			else
        			System.out.println("not found");
    			break;
    			
    		case"d":
    			System.out.println("please enter a numerical value to delete");
    			int store3 = Integer.parseInt(sc.nextLine());
    			myHash.delete(store3);
    			break;
    			
    		case"p":
    			myHash.print();
    			break;
    			
    		case"e":
    			if(myHash.isEmpty())
    				System.out.println("Yes");
    			else
    				System.out.println("No");
    			break;
    			
    		case"k":
    			myHash.makeEmpty();
    			System.out.println("Table emptied");
    			break;
    			
    		case"s":
    			System.out.println(myHash.size());
    			break;
    			
    		case"o":
    			Iterator<Integer> i = myHash.iterator();
    			while(i.hasNext()){
    				System.out.print(i.next() + " ");
    			}
    			System.out.print("\r");
    			break;
    			
    		case"q":
    			System.out.println("quitting");
    			quit = true;
    			break;
    			
			default:
    			System.out.println("invalid choice");
    			break;
    		}
    	}
	}
}
