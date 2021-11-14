package ousama.abschlussarbeit.model;

import ousama.abschlussarbeit.service.abstractGraphRNG.Algorithm;

import java.util.ArrayList;

public class JsonOutput {

    private ArrayList<Algorithm> algorithms;

    public JsonOutput(ArrayList<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }

}
