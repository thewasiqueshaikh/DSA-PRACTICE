package ShaikhPractice10032022;

public class SingleLinklist1 {

    class Node{
        int data;
        Node next;
    }
    Node head;
    Node tail;
    int size;

    public Node createSingleLL(int nodeData){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.data = nodeData;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLL(int nodeData,int location){
        Node node = new Node();
        node.data = nodeData;
        if(head == null){
            createSingleLL(nodeData);
            return;
        }else if(location==0){
            node.next = head;
            head = node;
        }else if(location>=size){
            node.next=null;
            tail.next=node;
            tail=node;
        }else{
            Node currNode = head;
            int i = 0;
            while(i<location-1){
                currNode = currNode.next;
                i++;
            }
            Node nextNode = currNode.next;
            currNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void delete(int location){
        if(head == null){
            System.out.println("empty list");
            return;
        }else if(location==0){
            head = head.next;
            size--;
        }else if(location>=size){
            Node currNode = head;
            for (int i = 0; i < size-1; i++) {
                currNode = currNode.next;
            }
            currNode.next = null;
            tail = currNode;
            size--;
        }else{
            Node currNode = head;
            for (int i = 0; i < location-1; i++) {
                currNode = currNode.next;
            }
            currNode.next = currNode.next.next;
            size--;
        }
    }

    public void printLL(){
        Node currNode = head;
        int i=0;
        while(i<size){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
            i++;
        }
        System.out.print("null");
        System.out.println();
    }

    public void deleteWholeLL(){
        head = null;
        tail = null;
        System.out.println("Linklist is deleted");
    }

    public static void main(String[] args) {
        SingleLinklist1 list = new SingleLinklist1();
        list.insertLL(10,0);
        list.insertLL(20,1);
        list.insertLL(30,0); // in beginning
        list.insertLL(40,list.size); //at last
        list.insertLL(60,2); //in middle
        list.printLL();
//        list.delete(0); //first delete
//        list.delete(list.size); //last delete
        list.delete(2); //middle delete
        list.printLL();
//        list.deleteWholeLL();
    }
}
