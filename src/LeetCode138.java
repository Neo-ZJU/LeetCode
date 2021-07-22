import java.util.HashMap;

public class LeetCode138 {
}
class Solution138 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node temp = head;
        int i = 0;
        HashMap<Node, Integer> map = new HashMap<>();
        HashMap<Integer, Node> mapNum = new HashMap<>();
        HashMap<Node, Integer> newMap = new HashMap<>();
        HashMap<Integer, Node> newMapNum = new HashMap<>();
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, i);
            mapNum.put(i, temp);
            newMapNum.put(i, newNode);
            newMap.put(newNode, i);
            i++;
            temp = temp.next;
        }
        for(int k = 0; k < map.size(); k++){
            Node cur = mapNum.get(k);
            Node newTemp = newMapNum.get(k);
            newTemp.next = newMapNum.get(k + 1);
            newTemp.random = newMapNum.get(map.get(cur.random));
        }
        return newMapNum.get(0);
    }
}
class Node{
    Node next;
    Node random;
    int val;
    public Node(int thisVal){
        this.val = thisVal;
    }
}