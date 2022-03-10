package ShaikhPractice10032022;

public class CircularSingleLinkedList1 {
    class Node{
        int data;
        Node next;
    }
    Node head;
    Node tail;
    int size;

    public Node createCSLL(int nodeData){
        head = new Node();
        Node node = new Node();
        node.data = nodeData;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insert(int nodeData,int location)
    {
        Node node = new Node();
        node.data = nodeData;
        if(head == null){
            createCSLL(nodeData);
            return;
        }else if(location==0){
            node.next = head;
            head = node;
            tail.next = head;
        }else if(location>=size){
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }else{
            Node currnode = head;
            for (int i = 0; i < location-1; i++) {
                currnode=currnode.next;
            }
            node.next = currnode.next;
            currnode.next = node;
        }
        size++;
    }

    public void printLL(){
        Node currNode = head;
        int i=0;
        while(i<size){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
            i++;
        }

    }
    public static void main(String[] args) {
        CircularSingleLinkedList1 list = new CircularSingleLinkedList1();
        list.insert(50,0);
        list.insert(60,1);
        list.insert(30,2);
        list.insert(20,1);
        list.insert(10, list.size);
        list.printLL();
    }
}
