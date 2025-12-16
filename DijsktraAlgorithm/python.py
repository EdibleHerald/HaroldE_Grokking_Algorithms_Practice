import math

# Create a hash table to represent the graph
graph = {}

# Create another hash table to represent costs of out-neighbors (for node "Start" in this case)
graph["start"] = {}
graph["start"]["a"] = 6
graph["start"]["b"] = 4

# Node "a" out-neighbors
graph["a"] = {}
graph["a"]["fin"] = 1

# Node "b" out-neighbors
graph["b"] = {}
graph["b"]["a"] = 3
graph["b"]["fin"] = 5

# Node "fin" out-neighbors (none)
graph["fin"] = {}


# NEXT: A hash table to hold CURRENT costs of nodes
infinity = math.inf
costs = {}
costs["a"] = graph["start"]["a"]
costs["b"] = graph["start"]["b"]
costs["fin"] = infinity

# NEXT: A hash table to track parents
parents = {}
parents["a"] = "start"
parents["b"] = "start"
parents["fin"] = None

# Processed: A set to keep track of all nodes already processed
processed = set()


def find_lowest_cost_node(costs):
    lowest_cost = math.inf
    lowest_cost_node = None
    for node in costs:
        cost = costs[node]
        if cost < lowest_cost and node not in processed:
            lowest_cost = cost
            lowest_cost_node = node
    return lowest_cost_node

node = find_lowest_cost_node(costs)
while node is not None:
    cost = costs[node]
    neighbors = graph[node]
    for n in neighbors.keys():
        new_cost  = cost + neighbors[n]
        if costs[n] > new_cost:
            costs[n] = new_cost
            parents[n] = node
    processed.add(node)
    node = find_lowest_cost_node(costs)

print(costs["fin"])

