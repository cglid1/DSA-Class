public class node{
    int data;//node class definition
    node next;
    node previous;
    public node(int data){
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

public class doubleLL{
    node head;//variables
    node tail;
    public doubleLL(){
        this.head = null;//setters
        this.tail = null;
    }
    public void insertLast(int data){
        if(this.head == null){
            this.head = this.tail = new node(data);//fills list if empty
        }else{
            this.tail.next = new node(data);//creates a new node at the end of the list where tail is pointing to.
            node curr = tail;//creates a temp node to hold the spot of tail
            tail = tail.next;//sets tail to the new node
            tail.previous = curr;//makes the new tail point to the old tail.
        }
    }
    public void deleteLast(){
        if(this.head == null){
            System.out.println("List is empty");//if the list is empty
        }else {
            if (this.head == this.tail){
                this.head = this.tail = null;//only one node
            }else {
                this.tail = this.tail.previous;//makes the tail the previous node
                this.tail.next = null;//deletes the last node by deleting what the tail is pointing to
            }
        }
    }
    public void insertFirst(int data){
        if(this.head == null){
            this.head = this.tail = new node(data);//fills list if empty
        }else{
            this.head.previous = new node(data);//makeing the previous which is null point to the new data node. creates a node in the spot before the head
            node curr = head; //creates a temp node to hold the spot of the current head
            head = head.previous; //makes head point to the new node
            head.next = curr;// makes the new head point to the old head
        }
    }
    public void deleteFirst(){
        if(this.head == null){
            System.out.println("List is empty");//if the list is empty
        }else{
            if(this.head == this.tail){
                this.head = this.tail = null;//only one node
            }
            else{
                this.head = this.head.next;//make head point to the next node in line
                this.head.previous = null;//makes the previous head now equal to null affectively deleting the node
            }
        }
    }
}
