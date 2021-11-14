package ousama.abschlussarbeit.delaunayTriangulierung;



import ousama.abschlussarbeit.model.Edge;
import ousama.abschlussarbeit.model.Node;
import ousama.abschlussarbeit.model.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TriangleSoup {

    private List<Triangle> triangleSoup;

    public TriangleSoup() {
        this.triangleSoup = new ArrayList<>();
    }

    public void add(Triangle triangle) {
        this.triangleSoup.add(triangle);
    }

    public void remove(Triangle triangle) {
        this.triangleSoup.remove(triangle);
    }

    public List<Triangle> getTriangles() {
        return this.triangleSoup;
    }

    public Triangle findContainingTriangle(Node point) {
        for (Triangle triangle : triangleSoup) {
            if (triangle.contains(point)) {
                return triangle;
            }
        }
        return null;
    }

    public Triangle findNeighbour(Triangle triangle, Edge edge) {
        for (Triangle triangleFromSoup : triangleSoup) {
            if (triangleFromSoup.isNeighbour(edge) && triangleFromSoup != triangle) {
                return triangleFromSoup;
            }
        }
        return null;
    }

    public Triangle findOneTriangleSharing(Edge edge) {
        for (Triangle triangle : triangleSoup) {
            if (triangle.isNeighbour(edge)) {
                return triangle;
            }
        }
        return null;
    }

    public Edge findNearestEdge(Node point) {
        List<EdgeDistancePack> edgeList = new ArrayList<>();

        for (Triangle triangle : triangleSoup) {
            edgeList.add(triangle.findNearestEdge(point));
        }

        EdgeDistancePack[] edgeDistancePacks = new EdgeDistancePack[edgeList.size()];
        edgeList.toArray(edgeDistancePacks);

        Arrays.sort(edgeDistancePacks);
        return edgeDistancePacks[0].edge;
    }

    public void removeTrianglesUsing(Node node) {
        List<Triangle> trianglesToBeRemoved = new ArrayList<>();

        for (Triangle triangle : triangleSoup) {
            if (triangle.hasVertex(node)) {
                trianglesToBeRemoved.add(triangle);
            }
        }

        triangleSoup.removeAll(trianglesToBeRemoved);
    }
}