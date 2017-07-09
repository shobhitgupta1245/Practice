/**
 * Created by shobhit on 14/05/17.
 */
public class Main {

    public static void main(String[] args) {
//        LinkedList ll = new LinkedList();
//        for (int i = 0; i < 15; i++) {
//            ll.add(i);
//        }
//        ll.print();

//        Trie t = new Trie();
//        t.insert("shobhit");
//        t.insert("shobha");
//        t.insert("shobit");
//        t.search("shobhi");
//        Trie.traverse(t);
        Graph g = new Graph();
        g.addEdge("1", "2", null);
        g.addEdge("2", "3", null);
        g.addEdge("1", "4", null);
        g.addEdge("3", "4", null);
        g.addEdge("2", "5", null);
        g.addEdge("2", "1", null);

        g.printAdjacencyListFormatData();

    }

}
