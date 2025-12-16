package HaroldE_GrokkingAlg_Practice.DijsktraAlgorithm;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // We're going to assume:
        //  - Weighted Graph
        //  - Directed (with no loops)
        // I'm using the "Trading for a piano" example in chapter 9

        // We need 3 hash maps:
        // - Neighbor nodes (two hashmaps)
        // - Track Cost
        // - Track Parents
        
        // First Hashmap is for the graph
        // Second Hashmap is to represent cost of out-neighbors
        
        HashMap<String,HashMap<String,Integer>> neighborHashMap = createNeighborHashMap();

        // Hashmap for tracking costs
    }

    public static void DijsktraAlgorithm(HashMap<String,Node> dictionary, String startPoint){
        // Now to implement Dijsktra's Algorithm
        // There are 4 steps:
        // 1.) Find the cheapest node.
        // 2.) Check whether there's a cheaper path to out-neighbors of this node. If so, update costs.
        // 3.) Repeat until done for every node in the graph
        // 4.) Calculate the final path

    }

    public static HashMap<String,HashMap<String,Integer>> createNeighborHashMap(){
        HashMap<String, HashMap<String,Integer>> neighborHashMap = new HashMap<>();

        // Out-neighbors of "book"
        HashMap<String,Integer> book = new HashMap<>();
        book.put("rarelp",5);
        book.put("poster",0);
        neighborHashMap.put("book",book); // We get a hashmap when we enter "book"

        // Out-neighbors of "rarelp"
        HashMap<String,Integer> rarelp = new HashMap<>();
        rarelp.put("bassguitar",15);
        rarelp.put("drumset",20);
        neighborHashMap.put("rarelp",rarelp);

        // Out-neighbors of "poster"
        HashMap<String,Integer> poster =  new HashMap<>();
        poster.put("bassguitar",30);
        poster.put("drumset",35);
        neighborHashMap.put("poster",poster);

        // Out-neighbors of "bassguitar"
        HashMap<String,Integer> bassguitar =  new HashMap<>();
        bassguitar.put("piano",20);
        neighborHashMap.put("bassguitar",bassguitar);

        // Out-neighbors of "drumset"
        HashMap<String,Integer> drumset =  new HashMap<>();
        drumset.put("piano",10);
        neighborHashMap.put("drumset",drumset);

        // Out-neighbors of "piano" (none)
        HashMap<String,Integer> piano = new HashMap<>();
        neighborHashMap.put("piano",piano);

        return neighborHashMap;
    }
}

class Node {
    // Node holds prices depending on WHERE the previous node is at. 
    // For example:
    // Node: Bass Guitar
    //   - If coming from "Rare LP" --> Price is 15 ("Rare LP":15)
    //   - If coming from "Poster" --> Price is 30 ("Poster":30)

    private HashMap<String,Integer> prices;
    public String itemName;

    public Node(String itemName){
        // Constructor
        // Holds item name
        this.itemName = itemName;
        this.prices = new HashMap<>();
    }

    // Uses HashMap.put(); is simply a wrapper
    public void addPrice(String name, int price){
        prices.put(name,price);
    }

    public int getPrice(String name){
        return prices.get(name);
    }
}
