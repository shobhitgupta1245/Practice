import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by shobhit on 25/06/17.
 */

public class Graph {

    private boolean directed = false;

    private int numOfVertices;

    private List<Vertex> vertices;

    public Graph() {
        numOfVertices = 0;
    }

    public Graph(boolean isDirected) {
        this.directed = isDirected;
        this.numOfVertices = 0;
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public void setNumOfVertices(int numOfVertices) {
        this.numOfVertices = numOfVertices;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    /*
     * Default is bi-directional graph Else, U ---W---> V
     */
    public void addEdge(String u, String v, Integer w) {
        if (v == null || u == null) {
            throw new RuntimeException("v and u cannot be null");
        }
        if (w == null) {
            w = 0;
        }
        if (numOfVertices == 0) {
            vertices = new LinkedList<>();
        }
        Vertex v1 = new Vertex(u);
        Vertex v2 = new Vertex(v);
        if (!vertices.contains(v1)) {
            vertices.add(v1);
            numOfVertices++;
        }
        if (!vertices.contains(v2)) {
            vertices.add(v2);
            numOfVertices++;
        }
        v1 = vertices.stream().filter(vv -> vv.data.contains(u)).findFirst().orElse(null);
        v1.getVertexToEdgeWeight().put(v2, w);
        if (!directed) {
            v2 = vertices.stream().filter(vv -> vv.data.contains(v)).findFirst().orElse(null);
            v2.getVertexToEdgeWeight().put(v1, w);
        }
    }

    public Set<String> getEdges(String v) {
        if (v == null || v.isEmpty()) {
            throw new RuntimeException(v + " is empty");
        }
        if (numOfVertices == 0) {
            throw new RuntimeException("Graph is empty");
        }
        if (!this.vertices.stream().filter(vx -> vx.data.equals(v)).collect(Collectors.toSet()).contains(v)) {
            throw new RuntimeException("Vertex{" + v + "} doesn't exist in this Graph");
        }
        return this.vertices.stream().filter(vx -> vx.data.equals(v))
                .map(f -> f.vertexToEdgeWeight.keySet().stream().map(ve -> ve.data).collect(Collectors.toSet()))
                .findAny().orElse(null);
    }

    public void printAdjacencyListFormatData() {
        for (Vertex v : this.vertices) {
            StringBuilder s = new StringBuilder();
            s.append(v + " => ");
            for (Vertex iv : v.getVertexToEdgeWeight().keySet()) {
                s.append(iv + " -> ");
            }
            System.out.println(s);
        }
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public static class Vertex {

        String data;

        Map<Vertex, Integer> vertexToEdgeWeight = new LinkedHashMap<>();

        public Vertex(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Map<Vertex, Integer> getVertexToEdgeWeight() {
            return vertexToEdgeWeight;
        }

        public void setVertexToEdgeWeight(Map<Vertex, Integer> vertexToEdgeWeight) {
            this.vertexToEdgeWeight = vertexToEdgeWeight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Vertex vertex = (Vertex) o;

            return data.equals(vertex.data);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }

        @Override
        public String toString() {
            return "V[" + data + "]";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Graph graph = (Graph) o;

        if (directed != graph.directed)
            return false;
        return numOfVertices == graph.numOfVertices;
    }

    @Override
    public int hashCode() {
        int result = (directed ? 1 : 0);
        result = 31 * result + numOfVertices;
        return result;
    }
}
