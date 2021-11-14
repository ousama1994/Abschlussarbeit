package ousama.abschlussarbeit.service.abstractGraphRNG;


import ousama.abschlussarbeit.delaunayTriangulierung.NotEnoughPointsException;
import ousama.abschlussarbeit.model.Graph;

public abstract class AbstractAlgorithms {
    public Graph graph;

    protected AbstractAlgorithms(Graph gr) {
        this.graph = gr;
    }

    /*
     * The first extended Algorithms must be executed.
     * The seconds method describes the implemented Algorithm.
     * The third method prints the test of the Algorithms.
     */
    public abstract Algorithm executeAlgorithm() throws NotEnoughPointsException;

}
