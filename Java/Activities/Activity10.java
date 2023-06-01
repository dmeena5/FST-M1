package activities;

import java.util.HashSet;
/*Use the contains() method to check if an item is in the Set or not.
Print the updated set.*/
public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<String>();
        hs.add("Obj1");
        hs.add("Obj2");
        hs.add("Obj3");
        hs.add("Obj4");
        hs.add("Obj5");
        hs.add("Obj6");
        System.out.println("Original hashset is: " + hs);
        System.out.println("Size of the Hashset is: " + hs.size());
        System.out.println("Removing element from Hashset: " + hs.remove("Obj4"));
        if (hs.remove("Obj7")) {
            System.out.println("Obj7 is removed from the hashset");
        } else {
            System.out.println("Obj7 is not available in the hashset");
        }
        System.out.println("Check if object is present in hashset:" + hs.contains("Obj2"));
        System.out.println("The updated element list is:" + hs);
    }
}
