package pointOffer;



import tools.Node;

import java.util.HashMap;
import java.util.Map;

public class copyRandomList35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> cachedNode = new HashMap<Node, Node>();
        Node res = new Node(head.val);
        cachedNode.put(head, res);
        while (head != null) {
        }
        return res;
    }

}
