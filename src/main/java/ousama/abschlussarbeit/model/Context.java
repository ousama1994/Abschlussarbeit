package ousama.abschlussarbeit.model;

import ousama.abschlussarbeit.delaunayTriangulierung.NotEnoughPointsException;
import ousama.abschlussarbeit.service.abstractGraphRNG.AbstractAlgorithms;
import ousama.abschlussarbeit.service.abstractGraphRNG.Algorithm;

import java.util.ArrayList;

public class Context {

    private ArrayList<AbstractAlgorithms> algorithms;

    public Context(ArrayList<AbstractAlgorithms> algorithms) {
        this.algorithms = algorithms;
    }

    public ArrayList<Algorithm> execute() throws NotEnoughPointsException {
        ArrayList<Algorithm> alg = new ArrayList<>();

        for (AbstractAlgorithms algorithm : algorithms) {
            alg.add(algorithm.executeAlgorithm());
        }
        return alg;
    }
}