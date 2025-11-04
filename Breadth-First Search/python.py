# Breadth First-Search
# Runs on graphs, finds shortest distance between two things
# Searches surface and slowly delves deeper into the graph until a solution is found (typically endpoint is reached)
#
# In-neighbor: edge points towards another node (Alex --> Rama ,  Alex is an In-neighbor of Rama, while Rama is an out-neighbor of Alex)
# Out-neighbor: edge comes from another node (Alex <-- Rama, Alex is an out-neightbor of Rama, while Rama is an in-neighbor of Alex)
#
# Directed Graph: Node relationships are one way, represented with arrows
# Undirected Graph: Node relationships don't use arrows at all. Just lines
#
# Breadth First-Search can answer one of two questions:
# 1.) Is there a connection between point A and B?
# 2.) What is the shortest distance between point A and B?
#
#