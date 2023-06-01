package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args){
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
        hash_map.put(1, "Violet");
        hash_map.put(2, "Indigo");
        hash_map.put(3, "Blue");
        hash_map.put(4, "Green");
        hash_map.put(5, "Yellow");
        System.out.println("Colors in hashmap are: " + hash_map);
        //System.out.println("Removing color Violet from the map: " + hash_map.remove(1));
        hash_map.remove(4);
        System.out.println("After removing White: " + hash_map);
        //System.out.println("Map after removal of color: " +hash_map);
        if(hash_map.containsValue("Green")){
            System.out.println("Green is Present in the map");
        }else{
            System.out.println("Green is not available in the Hash map");
        }
        System.out.println("Size of the Hash_Map is: " + hash_map.size());

    }
}
