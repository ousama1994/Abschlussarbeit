package ousama.abschlussarbeit.factory;


import ousama.abschlussarbeit.model.Graph;
import ousama.abschlussarbeit.service.abstractGraphRNG.AbstractAlgorithms;
import ousama.abschlussarbeit.service.algorithms.RNG1;
import ousama.abschlussarbeit.service.algorithms.RNG2;
import ousama.abschlussarbeit.service.algorithms.RNG3;

import java.util.ArrayList;

public class FactoryAlgorithms {

    FactoryAlgorithms() {
    }

    public static ArrayList<AbstractAlgorithms> getAlgorithms(ArrayList<String> algorithms, Graph gr) {

        ArrayList<AbstractAlgorithms> algorithm = new ArrayList<>();

        for (String algorithm1 : algorithms) {
            if (algorithm1.contains("RNG1")) {
                algorithm.add(new RNG1(gr));
            }
            if (algorithm1.contains("RNG2")) {
                algorithm.add(new RNG2(gr));
            }
            if (algorithm1.equals("RNG3")) {
                algorithm.add(new RNG3(gr));
            }
        }
        return algorithm;
    }
}
