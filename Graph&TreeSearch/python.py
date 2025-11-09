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
# O(V + E) , V = vertices, E = Edges

from collections import deque
graph = {
    "you" : ["alice","bob","claire"],
    "bob" : ["anuj","peggy"],
    "alice" : ["peggy"],
    "claire" : ["thom","jonny"],
    "anuj" : [],
    "peggy": [],
    "thom" : [],
    "jonny": []
}


def Breadth_First_Search(name):
    search_queue = deque()
    search_queue += graph[name]
    searched = set()
    while search_queue:
        person = search_queue.popleft()
        if not person in searched: 
            if person_is_seller(person):
                print(person + " is a mango seller!")
                return True
            else:
                print(person + " is not a mango seller!")
                search_queue+= graph[person]
                searched.add(person)
    return False

def person_is_seller(name):
    return name[-1] == 'm'

def Depth_First_Search(name,searched = set()):
    search_queue = deque()
    search_queue += graph[name]
    while search_queue:
        person = search_queue.popleft()
        if person not in searched:
            if person_is_seller(person):
                print(person + " is a mango seller!")
                return True
            else:
                print(person + " is not a mango seller!")
                searched.add(person)
                Depth_First_Search(person,searched)

#Breadth_First_Search("you")
#Depth_First_Search("you")