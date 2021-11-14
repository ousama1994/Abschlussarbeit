package ousama.abschlussarbeit.delaunayTriangulierung;


import ousama.abschlussarbeit.model.Edge;


public class EdgeDistancePack implements Comparable<EdgeDistancePack> {

    public Edge edge;
    public double distance;


    public EdgeDistancePack(Edge edge, double distance) {
        this.edge = edge;
        this.distance = distance;
    }

    @Override
    public int compareTo(EdgeDistancePack o) {
        return Double.compare(this.distance, o.distance);
    }
}