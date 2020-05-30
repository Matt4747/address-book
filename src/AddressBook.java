import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.Serializable;
/**
 * Displays menu in console giving user the option to add, remove, show, and search for Contact objects, and load/save Contact objects to and from a file
 * @author Matt Davidson
 *
 */
public class AddressBook extends Contact implements Serializable{

	/**
	 * Declare data fields of AddressBook class
	 */
	 static ArrayList<Contact> contacts = new ArrayList<Contact>();
	 static String selection;
	 static Scanner kb = new Scanner(System.in);
	 
	 /**
	  * Initializes instance variables of AddressBook class using received parameters
	  * @param firstName contact's first name
	  * @param lastName contact's last name
	  * @param phoneNumber contact's phone number
	  * @param email contact's email
	  * @param address contact's address
	  */
	public AddressBook(String firstName, String lastName, String phoneNumber, String email, String address) {
		super(firstName, lastName, phoneNumber, email, address);
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	
	/**
	 * Prints menu of options
	 */
	public static void printMenu() {
		System.out.println("Address Book Operations:\n" + 
				"1) Add\n" + 
				"2) Remove\n" + 
				"3) Save\n" + 
				"4) Load\n" + 
				"5) Show All\n" + 
				"6) Search\n" + 
				"7) Exit\n" + 
				"Select a number:");
	}
	
	/**
	 * Saves contacts arrayList to file "addressbook.dat"
	 */
	public static void saveFile() {
		try {
		    FileOutputStream fos = new FileOutputStream("addressbook.dat");
		    ObjectOutputStream oos = new ObjectOutputStream(fos);       
		    oos.writeObject(contacts);	    
		    oos.close(); 
		    fos.close();
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	/**
	 * Loads objects from addressbook.dat and adds them to arrayList contacts
	 */
	public static void loadFile() {
		try{
			FileInputStream is = new FileInputStream("addressbook.dat");
			ObjectInputStream ois = new ObjectInputStream(is);
			contacts = (ArrayList<Contact>) (ois.readObject());
			is.close();
			ois.close();
			}
		catch(IOException | ClassNotFoundException ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * Performs a different action based on user's selection and takes user input when performing actions
	 */
	public static void main(String[] args) {
		
		
		loadFile();
		
		
		System.out.println("Address Book Operations:\n" + 
				"1) Add\n" + 
				"2) Remove\n" + 
				"3) Save\n" + 
				"4) Load\n" + 
				"5) Show All\n" + 
				"6) Search\n" + 
				"7) Exit\n" + 
				"Select a number:");
		
		
	
		boolean exit = false;
		
		while (exit == false) {
		selection = kb.next();
		switch(selection) {
        
		
		/**
		 * Prompts user to enter contact info and adds contact object to arrayList contacts
		 */
		case "1" :
			Contact contact = new Contact(null, null, null, null, null);
			System.out.println("Enter contact information\n" + "Enter first name:");
			contact.setFirstName(kb.next());
			System.out.println("Enter last name:");
			contact.setLastName(kb.next());
			System.out.println("Enter phone number:");
			contact.setPhoneNumber(kb.next());
			System.out.println("Enter email:");
			contact.setEmail(kb.next());
			System.out.println("Enter address(NO SPACES):");
			contact.setAddress(kb.next());
			contacts.add(contact);
			System.out.println("Contact added");
           printMenu();
           break;
        
		
		/**
		 * prompts user to enter a phone number and removes contact with matching phone number from arrayList contacts
		 */
		case "2" :
        		System.out.println("Enter phone number of contact to be removed:");
        		String remove = kb.next();
        		int numRemoved = 0;
        		
        		for (int i=0; i<contacts.size(); i++) {
        		    if (contacts.get(i).phoneNumber.equals(remove)) {
        		        contacts.remove(i);
        		        numRemoved++;
        		    }
        		}
    		    if (numRemoved == 0) {
		    		System.out.println("Contact not found");
    		    	}
    		    else {
		    		System.out.println(numRemoved + " Contacts removed");
		    	}
        		printMenu();
        		break;
        
		
		/**
		 * Saves contacts arrayList to file "addressbook.dat"
		 */
		case "3" :
			saveFile();
			System.out.println("Contacts Saved");
			printMenu();
			break;
        
		
		/**
		 * Loads objects from addressbook.dat and adds them to arrayList contacts
		 */
		case "4" :
		   loadFile();
           System.out.println("Contacts Loaded");  
           printMenu();
           break;
        
		
		/**
		 * Displays all contacts
		 */
		case "5" :
			for(Contact cont: contacts)
			System.out.println(cont.toString());
			printMenu();
           break;
        
		
		/**
		 * Prompts user to enter a search string and displays any contact objects from arrayList contacts that contain the string
		 */
		case "6" :
			System.out.println("Search:");
			String search = kb.next();
			String res = "";
			
	        for(int i=0;i<contacts.size();i++){
	            if(contacts.get(i).toString().contains(search)){
	                res += contacts.get(i).toString();
	            }
	        }
	        if (res == ""){
	        		System.out.println("No results found");
	        }
	        else {
	        		System.out.println(res);
	        }
            printMenu();
            break;
        
		
		/**
		 * Exits the switch menu loop and saves arrayList contacts to addressbook.dat
		 */
		case "7" :
			saveFile();
			System.out.println("Contacts saved");
            System.out.println("Exited");
            exit = true;
            break;
					
		
		/**
		 * Displays "Invalid Selection" if number other than 1 through 7 is entered
		 */
		default :
            System.out.println("Invalid Selection");
            printMenu();
		}
      }
	} 
		
	}



