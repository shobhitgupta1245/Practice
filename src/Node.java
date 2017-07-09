/**
 * Created by shobhit on 14/05/17.
 */
public class Node {

    private Node prevNode;

    private Object data;

    private Node nextNode;

    public Node() {
    }

    public Node(Node prevNode, Object data, Node nextNode) {
        this.prevNode = prevNode;
        this.data = data;
        this.nextNode = nextNode;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Node node = (Node) o;

        if (prevNode != null ? !prevNode.equals(node.prevNode) : node.prevNode != null)
            return false;
        if (!data.equals(node.data))
            return false;
        return nextNode != null ? nextNode.equals(node.nextNode) : node.nextNode == null;
    }

    @Override
    public int hashCode() {
        int result = prevNode != null ? prevNode.hashCode() : 0;
        result = 31 * result + data.hashCode();
        result = 31 * result + (nextNode != null ? nextNode.hashCode() : 0);
        return result;
    }
}
