import java.io.Serializable;

/**
 * Stores first name, last name, phone number, email, and address of contact object and constructs its string representation
 * @author Matt Davidson
 *
 */
public class Contact implements Serializable {


	
	/**
	 * Declare data fields of contact class
	 */
	protected String firstName;
	protected String lastName;
	protected String phoneNumber;
	protected String email;
	protected String address;
	
	
	/**
	 * Initializes instance variables of Contact class using received parameters
	 * @param firstName contact's first name
	 * @param lastName contact's last name
	 * @param phoneNumber contact's phone number
	 * @param email contact's email
	 * @param address contact's address
	 */
	public Contact(String firstName, String lastName, String phoneNumber, String email, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		}

	/**
	 * get firstName
	 * @return firstName contact's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * set firstName
	 * @param firstName contact's first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * set lastName
	 * @return lastName contact's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * set lastName
	 * @param lastName contact's last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * get phoneNumber
	 * @return phoneNumber contact's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * set phoneNumber
	 * @param phoneNumber contact's phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * get email
	 * @return email contact's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * set email
	 * @param email contact's email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get address
	 * @return address contact's address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * set address
	 * @param address contact's address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Constructs String representation of contact object
	 * @return String representation of contact object
	 */
	public String toString() {
		return (firstName + " " + lastName + ": " + phoneNumber + ", " + email + ", " + address+"\n");
		
	}
}
