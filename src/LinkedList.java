import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by shobhit on 14/05/17.
 */
public class LinkedList {

    private Set<Node> nodes = new LinkedHashSet<>(0);

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Node getLastNode() {
        return nodes.stream().reduce((a, b) -> b).orElse(null);
    }

    public Node getFirstNode() {
        return nodes.iterator().next();
    }

    public LinkedList create() {
        return null;
    }

    public LinkedList add(Node node) {
        nodes.add(node);
        return this;
    }

    public LinkedList add(Object data) {
        Node n = new Node(null, data, null);
        Node l = getLastNode();
        if (l != null) {
            l.setNextNode(n);
            n.setPrevNode(l);
        }
        nodes.add(n);
        return this;
    }

    public void print() {
        nodes.forEach(n -> System.out.println(n.getData()));
    }
}
