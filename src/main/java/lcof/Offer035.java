package lcof;


import java.util.HashMap;
import java.util.Map;


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Offer035 {
        public Node copyRandomList(Node head) {
            //head为空怎么处理？？
            if (head == null ){
                return null;
            }
            Node res = new Node(0);
            Node cur = head;
            Map<Node,Node> map = new HashMap<>();
            while (cur!=null){
                Node newNode = new Node(cur.val);
                map.put(cur,newNode);
                cur = cur.next;
            }
            cur = head;
            while (cur!=null){
                map.get(cur).next = map.get(cur.next);
                map.get(cur).random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
}
