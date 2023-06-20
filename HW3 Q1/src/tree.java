//-----------------------------------------------------
// Title: tree class
// Author: Abdullah Doğanay
// ID: 10549887192
// Section: 2
// Assignment: 3
// Description: tree class which contains methods of tree data structure.
// -----------------------------------------------------

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class tree {
    public ArrayList<Person> personList;
    ArrayList<String> listForOperationOne = new ArrayList<>();

    public tree(String fileName) throws IOException
    //--------------------------------------------------------
    // Summary: this method is a constructor of tree class
    // Precondition: class takes the fileName as a parameter.
    // Postcondition: tree object created according to file that we provide.
    // --------------------------------------------------------
    {
        this.personList = new ArrayList<>();
        Path personPath = Paths.get(fileName);
        List<String> personStringLines = Files.readAllLines(personPath, StandardCharsets.UTF_8);
        Person p = new Person(personStringLines.get(0).split(",")[0].split(" ")[0], Integer.parseInt(personStringLines.get(0).split(",")[0].split(" ")[1]));
        personList.add(p);

        for (int i = 0; i<personStringLines.size(); i++){
            if (!isThere(personList, Integer.parseInt(personStringLines.get(i).split(",")[1].split(" ")[1]))){
                Person a = new Person(personStringLines.get(i).split(",")[1].split(" ")[0], Integer.parseInt(personStringLines.get(i).split(",")[1].split(" ")[1]));
                personList.add(a);
                for(int j =0; j<personList.size(); j++){
                    if(personList.get(j).id == Integer.parseInt(personStringLines.get(i).split(",")[0].split(" ")[1])){
                        personList.get(j).children.add(a);
                        break;
                    }
                }
            }

        }



    }

    public void AllDescendants(int a)
    //--------------------------------------------------------
    // Summary: this method takes the all descendants and put them into an Arraylist to print later.
    // Precondition: method takes integer value which is unique id of person.
    // Postcondition: people stored in the arrayList.
    // --------------------------------------------------------
    {
        if(!personList.get(a).children.isEmpty()){
            for (int i = 0; i<personList.get(a).children.size(); i++){
                listForOperationOne.add(personList.get(a).children.get(i).name);
                AllDescendants(personList.get(a).children.get(i).id);
            }
        }
    }

    public void printAllDescendants(int a)
    //--------------------------------------------------------
    // Summary: printer method of print all descendants operation
    // Precondition: takes the unique id.
    // Postcondition: printed all the person that they descendants of person whose id is "a".
    // --------------------------------------------------------
    {
        AllDescendants(a);
        System.out.print(listForOperationOne.get(0));
        for(int i = 1; i<listForOperationOne.size(); i++){
            System.out.print(", "+ listForOperationOne.get(i));
        }
    }

    public boolean checkAncestor(int a, int b)
    //--------------------------------------------------------
    // Summary: this method is checking if the b is ancestor of "a".
    // Precondition: takes two integers as a unique id
    // Postcondition: returned boolean true if "b" is ancestor of "a", otherwise it returns false.
    // --------------------------------------------------------
    {
        return personList.get(a).children.contains(personList.get(b));
    }

    public boolean checkDescendant(int a, int b)
    //--------------------------------------------------------
    // Summary: this method is checking if the b is descendant of "a".
    // Precondition: takes two integers as a unique id
    // Postcondition: returned boolean true if "b" is descendant of "a", otherwise it returns false.
    // --------------------------------------------------------
    {
        return personList.get(b).children.contains(personList.get(a));
    }

    public Person getParent(int z)
    //--------------------------------------------------------
    // Summary: parent getter method
    // Precondition: takes one integer as a unique id
    // Postcondition: returned person who is a parent of provided id.
    // --------------------------------------------------------
    {
        for (Person person : personList) {
            if (person.children.contains(personList.get(z))) {
                return person;
            }
        }
        return null;
    }

    public boolean checkSiblings(int a, int b)
    //--------------------------------------------------------
    // Summary: this method is checking if the a and b are siblings or not
    // Precondition: takes two integers as a unique id
    // Postcondition: returned boolean true if b and a are siblings, otherwise it returns false.
    // --------------------------------------------------------
    {
        return getParent(a) == getParent(b);
    }

    public String findFirstOldestCommon(int a, int b)
    //--------------------------------------------------------
    // Summary: this method finds the nearest common person of two people.
    // Precondition: takes two integers as a unique id
    // Postcondition: returned name of the nearest common person.
    // --------------------------------------------------------
    {
        Person temp1 = personList.get(a);
        Person temp2 = personList.get(b);
        while (temp1 != temp2){
            if(getParent(temp1.id) != null){
                temp1 = getParent(temp1.id);
            }
            if (temp1 != temp2){
                temp2 = getParent(temp2.id);
            }
        }
        return temp1.name;
    }

    public boolean isThere(ArrayList<Person> personList, int id)
    //--------------------------------------------------------
    // Summary: this method is checks if there is a person whose id is known.
    // Precondition: takes the arrayList to look for person whose id is known.
    // Postcondition: returned boolean true if there is a person which id is entered. otherwise returns false.
    // --------------------------------------------------------
    {
        for (Person person : personList) {
            if(id == person.id)
                return true;
            break;
        }
        return false;
    }





}
