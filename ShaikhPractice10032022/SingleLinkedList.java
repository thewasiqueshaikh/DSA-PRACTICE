package ShaikhPractice10032022;

public class SingleLinkedList {
    Node head;
    Node tail;
    int size;
    public class Node{
        int value;
        Node next;
    }

    public Node createSingleLL(int nodeValue){
        head = new Node();
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertionInSingleLL(int nodeValue, int location){
        Node node = new Node();
        node.value = nodeValue;
        if(head==null){
            createSingleLL(nodeValue);
            return;
        }else if(location==0){
            node.next = head;
            head = node;
        }else if(location >= size){
            node.next = null;
            tail.next = node;
            tail = node;
        }else{
            Node currNode = head;
            int index = 0;
            while(index < location-1){
                currNode = currNode.next;
                index++;
            }
            Node nextNode = currNode.next;
            currNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    public void deletionInSingleLL(int location){
        if(head == null){
            System.out.println("Linklist is empty");
            return;
        }else if(location==0){
            head = head.next;
            size--;
            if(size==0){
                tail=null;
            }
        }else if(location>=size){
            Node currNode = head;
            int i = 0;
            while(i<size-1){
                currNode = currNode.next;
                i++;
            }
            if(currNode==head){
                head=tail=null;
                size--;
                return;
            }
            currNode.next = null;
            tail = currNode;
            size--;
        }else{
            Node currNode = head;
            int i = 0;
            while(i<location-1){
                currNode = currNode.next;
                i++;
            }
            currNode.next = currNode.next.next;
            size--;
        }
    }


    public void printLL(){
        Node currNode = head;
        int index = 0;
        while(index < size){
            System.out.print(currNode.value+" -> ");
            currNode = currNode.next;
            index++;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertionInSingleLL(5,0);
        list.insertionInSingleLL(6,0); // at beginning
        list.insertionInSingleLL(9, list.size-1); //in middle
        list.insertionInSingleLL(10,list.size); // at the end
        list.printLL();
//        list.deletionInSingleLL(list.size); //last delete
//        list.deletionInSingleLL(0); //first delete
        list.deletionInSingleLL(2); //middle delete

        System.out.println();
        list.printLL();
    }
}
