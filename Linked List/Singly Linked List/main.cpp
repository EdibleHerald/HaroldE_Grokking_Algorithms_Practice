#include "main.h"
#include "singlylinkedlist.cpp"

// using namespace std::chrono_literals;
using namespace list;

SinglyLinkedList funnyFunction();

int main(){
    SinglyLinkedList list = SinglyLinkedList();
    // std::cout << list.get_head_data() << std::endl;
    int main = 1;
    int main2;
    std::string user;
    // ISSUE: RUNNING THIS RETURNS "20" INSTEAD OF "5"
    // I SUSPECT ITS AN ISSUE WITH THE "find()"/"get()" FUNCTION LOGIC
    try{
        list.push_back(5); // 5
        list.push_back(10); // 4
        list.push_back(15); // 3
        list.push_back(20); // 2
        list.push_back(25); // 1
        list.push_back(30); // 0
        
        // for(int i=0; i < list.size;++i){
        //     std::cout << "Index: "<< i << " Number:" << list.get(i) << std::endl;
        // }

        // test move assignment
        // SinglyLinkedList listMoveAssign;
        SinglyLinkedList listMoveAssign;
        listMoveAssign = std::move(funnyFunction());
        // std::this_thread::sleep_for(std::chrono::milliseconds(2000));

        // listMoveAssign.pop_front();
        // listMoveAssign.pop_front();
        // listMoveAssign.pop_front();
        // listMoveAssign.pop_front();
        // listMoveAssign.pop_front();
        // listMoveAssign.pop_front();
    
        for(int i=0; i < list.size;++i){
            std::cout << "Index: "<< i << " Number:" << list.get(i) << std::endl;
        }
        // std::cout << listMoveAssign.Tail->data << std::endl;
    }catch(std::out_of_range what){
        std::cout << what.what() << std::endl;
    }
    
    return 0;
}

// Used for testing move constructor / assignment
SinglyLinkedList funnyFunction(){
    SinglyLinkedList list = SinglyLinkedList();
    list.push_back(5);
    list.push_back(10);
    list.push_back(15);
    list.push_back(20);
    list.push_back(25);
    list.push_back(30);

    return list;
}
