//-----------------------------------------------------
// Title: Person class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: person class which contains constructor and instance variables.
// -----------------------------------------------------
import java.util.ArrayList;

class Person {
	
	public String name;
	public int id;

    public ArrayList<Person> children;




    public Person(String name, int id)
	//--------------------------------------------------------
	// Summary: constructor method of person class
	// Precondition: takes string value as a name and integer value as a unique id.
	// Postcondition: object created.
	// --------------------------------------------------------
	{
    	this.name = name;
    	this.id = id;
		this.children = new ArrayList<>();
    }

}