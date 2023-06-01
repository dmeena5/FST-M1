package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){

        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Meena");
        myList.add("venky");
        myList.add("Guru");
        myList.add("Mourya");
        myList.add("Hari");
        System.out.println ("print all object names");
        for (String name:myList) {
            System.out.println(name);
        }
        System.out.println("3rd name in the list is:" +myList.get(2));
        System.out.println("Check if Guru exists in the list:" +myList.contains("Guru"));
        System.out.println("Number of names in the array list is: " +myList.size());
        myList.remove("Meena");
        System.out.println("Number of names finally in the list after removing one name is: "+myList.size());

    }

}
