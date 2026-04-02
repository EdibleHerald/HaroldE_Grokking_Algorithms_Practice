#include "main.h"
#include <stdexcept>


class Node
{
    public:
        int data;
        Node* next;

        Node(){
            // Defaults data value to 0 (like arrays do)
            this -> data = 0;
            this -> next = nullptr;
        }

        Node(int data){
            this -> data = data;
            this -> next = nullptr;
        }

        Node(int data, Node* ptr){
            this->data=data;
            this->next=ptr;
        }

        // Copy constructor
        Node(Node& copy)
            :data(copy.data),
             next(copy.next)
        {

        }

        // Copy assignment
        Node& operator=(Node& copy){
            this->data=copy.data;
            this->next=copy.next;
            return *this;
        }

        // Move constructor
        Node(Node&& move)
            :data{move.data},
            next{move.next}
        {
            move.data=0;
            move.next=nullptr;
        }

        // Move assignment
        Node& operator=(Node&& move){
            this->data=move.data;
            this->next=move.next;

            // Remove old Node's data/ptr
            move.data=0;
            move.next=nullptr;

            return *this;
        }
    private:
};

class SinglyLinkedList
{
    public:
        int size = 0;
        Node* Tail;

        // Default Constructor
        SinglyLinkedList()
            :size(0)
        { 
            // No node is created. Empty list.
            this->Head = new Node();
            this->Tail = nullptr;
        }
        
        // Constructor: Data provided
        SinglyLinkedList(int d)
            :size(1)
        {
            // Create and append default node
            this->Head = new Node(0,new Node(d));
            this->Tail = Head->next;
        }

        // copy constructor
        SinglyLinkedList(SinglyLinkedList& list)
            :Head(new Node()),
             Tail(),
             size(0)
        {
            // Make an entirely new copy of the given list (Unique nodes and all)
            int size = list.size;

            std::cout << "Copy constructor running!" << std::endl;

            Node* currNode = this->Head;
            for(int i = 0;i<size; ++i){
                currNode->next = new Node(list.get(i));
                this->size +=1;

                if(i == (size-1))
                {
                    this->Tail = currNode->next;
                }

                currNode = currNode->next;
            }

        }

        // copy assignment
        SinglyLinkedList& operator=(SinglyLinkedList& list){
            std::cout << "Copy assignment running!" << std::endl;

            this->Head = new Node();
            
            int size = list.size;
            Node* currNode = this->Head;

            for(int i = 0; i < size ; ++i)
            {
                currNode->next = new Node(list.get(i));
                this->size+=1;

                if(i == (size-1))
                {
                    this->Tail = currNode->next;
                }

                currNode = currNode->next;
            }

            return *this;
        }

        // move constructor
        SinglyLinkedList(SinglyLinkedList&& list)
            :Head(list.Head),
             Tail(list.Tail),
             size(list.size)
        {
            std::cout << "Move constructor ran!" << std::endl;
            list.Head = new Node();
            list.Tail = nullptr;
            list.size = 0;
        }

        // move assignment
        SinglyLinkedList& operator=(SinglyLinkedList&& list){
            std::cout << "Move assignment ran!" << std::endl;
            this->Head = list.Head;
            this->Tail = list.Tail;
            this->size = list.size;

            // Reset old object
            list.Head = new Node(); // New blank node (seperate from the one the new list has)
            list.Tail = nullptr;
            list.size = 0;

            return *this;
        }

        // Destructor
        ~SinglyLinkedList(){
            // Delete all nodes that have allocated data (includes Head)

            Node* prevNode = nullptr;
            Node* currNode = this->Head;

            for(int i = 0; i <= (this->size); ++i)
            {
                if(currNode->next != nullptr)
                {
                    // Move up one
                    prevNode = currNode;
                    currNode = currNode->next;
                    // Delete prevNode
                    delete prevNode;

                    prevNode = nullptr;
                }else{
                    delete currNode;
                }
            }
        }

        // Return "data" data member at a given node at positive index given
        int get(int index)
        {
            // std::cout << "Size: " << this->size << " index: " << index << std::endl;
            // Ensure that index is valid
            if(index < 0 || index >= this->size)
            {
                throw std::out_of_range("SinglyLinkedList::get()");
            }

            Node currNode = *this->Head->next;
            for(int i=0;i<(this->size);++i)
            {
                if(i == index){
                    return currNode.data;
                }else{
                    currNode = *currNode.next;
                }
            }
            
            throw std::out_of_range("SinglyLinkedList::get() : Data not found at provided index");
        }

        // Inserts data node into list at given index. Throws std::out_of_range.
        void insert(int data, int index){

            if(index < 0 || index > (this->size)){
                throw std::out_of_range("SinglyLinkedList::insert()");
            }

            // Check for cases where push_back() or push_front() work.
            if(index == 0)
            {
                push_front(data);
            }
            else if(index == (this->size))
            {   
                push_back(data);
            }
            else
            {
                
                // Grab node before index to add node to
                Node* currNode = this->Head;
                for(int i=0;i<index;++i){
                    // std::cout << "I ran this many times!" << std::endl;
                    currNode=currNode->next;
                }

                Node* prevNodePtr = currNode->next;
                currNode->next = new Node(data);
                currNode->next->next = prevNodePtr;
                this->size+=1;
            }
        }

        // Pushs element to back of list. Returns index of new node.
        int push_back(int d){

            // If Tail is null
            if(this->Head->next == nullptr)
            {
                this->Head->next = new Node(d);
                this->Tail = this->Head->next; 
            }else
            {
                // Create new node to be appended
                this->Tail->next = new Node(d);
                // Make new node the Tail
                this->Tail = this->Tail->next;
            }
            // Adjust size
            this->size+=1;
            return size - 1;
        }

        // Push data to front of list, returns index.
        int push_front(int d){
            
            Node* nextPtr = this->Head->next;
            
            this->Head->next = new Node(d);
            this->Head->next->next = nextPtr;
            if(this->Tail == nullptr)
            {
                this->Tail = this->Head->next;
            }

            this->size+=1;
            return 0;
        }

        // Pops element at a given index. Returns removed data. Throws std::out_of_range.
        int pop(int d){
            
            // Check that index provided is in range
            if(d < 0 || d >= this->size){
                throw std::out_of_range("SinglyLinkedList::remove()");                
            }

            // Check if removed element is Tail or Head
            if(d == (this->size - 1)){
                return pop_back();
            }else if(d == 0){ 
                return pop_front();
            }else{
                // Head has no check since we're using a redundant Head element
                std::cout << "Regular node is being removed!" << std::endl;

                Node* currNode = this->Head;
                for(int i = 0; i <= d ; ++i){
                    if(currNode == nullptr){
                        // Error
                        throw std::out_of_range("SinglyLinkedList::remove()");
                    }else if(i == d){
                        // currNode is node BEFORE removed node
                        int removed_Data = currNode->next->data;
                        Node* node_to_be_removed = currNode->next;
                        currNode->next = currNode->next->next;

                        delete node_to_be_removed;
                        this->size -= 1;
                        return removed_Data;
                    }

                    currNode = currNode->next;
                }
            }

            throw std::out_of_range("SinglyLinkedList::remove() : Failed response");
        }

        // Pops Tail node. Returns popped data. Throws std::out_of_range.
        int pop_back(){
            std::cout << "Tail is being removed!" << std::endl;
                // Find element before Tail
                Node* currNode = this->Head;
                for(int i = 0; i <= (size-1); ++i){
                    if(currNode->next == this->Tail){
                        int tail_Data= currNode->data;
                        this->Tail = currNode;

                        // Delete element
                        Node* tailNode = currNode->next;
                        delete tailNode;

                        // remove reference
                        currNode->next = nullptr;
                        this->size-=1;
                        return tail_Data;
                    }else if(currNode->next == nullptr){
                        // Assume that size is incorrect
                        this->size = i + 1;

                        // Ensure that Tail is set correctly
                        this->Tail = currNode;

                        throw std::out_of_range("SinglyLinkedList::pop_back() : Out of range, corrected size.");
                    }
                    currNode = currNode->next;
                }
            throw std::out_of_range("SinglyLinkedList::pop_back() : Failed operation");
        }

        // Pops Head node. Returns popped data. Throws std::out_of_range.
        int pop_front(){

            if((this->size) == 0){
                throw std::out_of_range("SinglyLinkedList::pop_front()");
            }

            Node* node_to_be_deleted = this->Head->next;
            this->Head->next = node_to_be_deleted->next;
            int data = node_to_be_deleted->data;
            this->size -=1;

            delete node_to_be_deleted;

            return data;
        }


    private:
        // Empty "Head" list
        Node* Head;
        // Node* Tail;
};

