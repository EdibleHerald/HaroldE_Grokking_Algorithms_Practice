package HaroldE_GrokkingAlg_Practice.DijsktraAlgorithm;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;

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
        // Second HashMap is to represent cost of out-neighbors
        HashMap<String,HashMap<String,Integer>> neighborHashMap = createNeighborHashMap();

        // HashMap for tracking costs
        HashMap<String,Integer> costHashMap =  createCostsHashMap(neighborHashMap);

        // HashMap for tracking parents
        HashMap<String,String> parentsHashMap = createParentsHashMap();

        // Track already processed nodes
        ArrayList<String> processed = new ArrayList<>();

        DijsktraAlgorithm(processed, costHashMap, neighborHashMap, parentsHashMap);
        
        System.out.println(costHashMap.get("piano"));
    }

    public static void DijsktraAlgorithm(ArrayList<String> processed,HashMap<String,Integer> costHashMap, HashMap<String, 
        HashMap<String,Integer>> neighborHashMap, HashMap<String,String> parentsHashMap){
        // Now to implement Dijsktra's Algorithm
        // There are 4 steps:
        // 1.) Find the cheapest node.
        // 2.) Check whether there's a cheaper path to out-neighbors of this node. If so, update costs.
        // 3.) Repeat until done for every node in the graph
        // 4.) Calculate the final path
        String node = getLowestCostNode(processed, costHashMap);
        while(node != null){
            int cost = costHashMap.get(node);
            HashMap<String,Integer> neighbors = neighborHashMap.get(node);
            Set<String> neighborSet = neighbors.keySet();
            for(String i : neighborSet){
                int curr_cost = costHashMap.get(i);
                int new_cost = cost + neighborHashMap.get(node).get(i);
                if( curr_cost > new_cost){
                    costHashMap.put(i, new_cost);
                    parentsHashMap.put(i,node);
                }
            }
            processed.add(node);
            node = getLowestCostNode(processed, costHashMap);
        }

    }

    public static String getLowestCostNode(ArrayList<String> processed, HashMap<String,Integer> costs){
        int inf = Integer.MAX_VALUE;
        int lowest_cost = inf;
        String lowest_cost_node = null;

        Set<String> costSet =  costs.keySet();

        for(String i : costSet){
            int currCost = costs.get(i);
            if(currCost < lowest_cost && !processed.contains(i)){
                lowest_cost = currCost;
                lowest_cost_node = i;
            }
        }
        return lowest_cost_node;
    }

    public static HashMap<String,HashMap<String,Integer>> createNeighborHashMap(){
        HashMap<String, HashMap<String,Integer>> neighborHashMap = new HashMap<>();

        // Prices can be manipulated here!
        // Just swap out the value for the out-neighbor of a given node!


        // Out-neighbors of "book"
        HashMap<String,Integer> book = new HashMap<>();
        book.put("rarelp",5); // Value = 5
        book.put("poster",0); // value = 0
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

    public static HashMap<String,Integer> createCostsHashMap(HashMap<String,HashMap<String,Integer>> neighborHashMap){
        HashMap<String,Integer> costs = new HashMap<>();
        int infinity = Integer.MAX_VALUE; // Essentially infinity for my purposes
        costs.put("rarelp", neighborHashMap.get("book").get("rarelp"));
        costs.put("poster",neighborHashMap.get("book").get("poster"));
        costs.put("bassguitar",infinity);
        costs.put("drumset",infinity);
        costs.put("piano",infinity);

        return costs;
    }

    public static HashMap<String,String> createParentsHashMap(){
        HashMap<String,String> parents = new HashMap<>();
        parents.put("rarelp","book");
        parents.put("poster","book");
        parents.put("bassguitar",null);
        parents.put("drumset",null);
        parents.put("piano",null);

        return parents;
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
