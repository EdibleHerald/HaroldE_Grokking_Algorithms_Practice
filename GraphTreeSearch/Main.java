package HaroldE_GrokkingAlg_Practice.GraphTreeSearch;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayDeque;

// Setup methods for Breadth First search
public class Main {
    public static void main(String[] args){
        Map<String,String[]> dictionary = new HashMap<>();
        String[] you = {"alice","bob","claire","notThom"};
        String[] bob = {"anuj","peggy"};
        String[] alice = {"peggy","thom"};
        String[] claire = {"thom","jonny"};
        String[] anuj = {};
        String[] peggy = {};
        String[] thom = {};
        String[] jonny = {};

        dictionary.put("you",you);
        dictionary.put("bob",bob);
        dictionary.put("alice",alice);
        dictionary.put("claire",claire);
        dictionary.put("anuj",anuj);
        dictionary.put("peggy",peggy);
        dictionary.put("thom",thom);
        dictionary.put("jonny",jonny);

        // Breadth_First_Search(dictionary,"you");
        Depth_First_Search(dictionary, "you");
        
    }
    
    public static boolean person_is_seller(String name){
        // If last letter in name is character lower case m, then return true
        int nameLength = name.length();

        return name.charAt(nameLength-1) == 'm';
    }

    public static boolean Breadth_First_Search(Map<String,String[]> dictionary, String name){
        ArrayDeque<String> newQueue = new ArrayDeque<>();
        
        // Add initial names
        for(String i : dictionary.get(name)){
            newQueue.add(i);
        }
        // Create array to keep track of previously searched names
        
        while(newQueue.isEmpty() != true){
            String person = newQueue.poll();
            // if person not in marked set()
            if(person_is_seller(person)){
                System.out.printf("%s is a mango seller!\n",person);
                return true;
            }else{
                System.out.printf("%s is NOT a mango seller\n",person);
                String[] personArray = dictionary.get(person);
                for(String i: personArray){
                    newQueue.add(i);
                }
            }
        }
        return false;

    }

    public static boolean Depth_First_Search(Map<String,String[]> dictionary, String name){
        ArrayDeque<String> newQueue = new ArrayDeque<>();
        
        // Add initial names
        for(String i : dictionary.get(name)){
            newQueue.add(i);
        }
        // Create array to keep track of previously searched names
        
        while(newQueue.isEmpty() != true){
            String person = newQueue.poll();
            // if person not in marked set()
            if(person_is_seller(person)){
                System.out.printf("%s is a mango seller!\n",person);
                return true;
            }else{
                System.out.printf("%s is NOT a mango seller\n",person);
                if(Depth_First_Search(dictionary, person) == true){
                    return true;
                };

            }
        }
        return false;

    }

}
