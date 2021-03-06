package ousama.abschlussarbeit.service.algorithms;

import java.util.ArrayList;

import ousama.abschlussarbeit.delaunayTriangulierung.NotEnoughPointsException;
import ousama.abschlussarbeit.model.Edge;
import ousama.abschlussarbeit.model.Graph;
import ousama.abschlussarbeit.model.Node;
import ousama.abschlussarbeit.service.abstractGraphRNG.AbstractAlgorithms;
import ousama.abschlussarbeit.service.abstractGraphRNG.Algorithm;
import org.apache.commons.math3.util.Pair;


public class RNG1 extends AbstractAlgorithms {

	public RNG1(Graph gr) {
		super(gr);
	}

	@Override
	public Algorithm executeAlgorithm() throws NotEnoughPointsException {
		// Laufzeit
		double start = System.currentTimeMillis();
		double end = 0;

//		Long x = System.currentTimeMillis();

		// Step 1: Compute the distance between all pairs of points d(pi,pj) i,j=
		// 1,...,n, i!=j
		ArrayList<Node> node = graph.getV();
		ArrayList<Edge> edge = new ArrayList<Edge>();

		ArrayList<ArrayList<Double>> distance = new ArrayList<ArrayList<Double>>();

		for (int i = 0; i < node.size(); i++) {
			ArrayList<Double> tmp = new ArrayList<Double>();
			for (int j = 0; j < node.size(); j++) {
				if (i != j) {
					tmp.add(getDistance(node.get(i), node.get(j)));
				} else {
					tmp.add(null);
				}
			}
			distance.add(tmp);
		}

		
		// Step 2: For each pair of points (pi,pj) compute dkMax = max{
		// d(pk,pi),d(pk,pj)} for k =1,...,n k!=i, k!=j.
		// ( ( (p,q), k) , value)
		ArrayList<Pair<Pair<Pair<Integer, Integer>, Integer>, Double>> dkMax = new ArrayList<Pair<Pair<Pair<Integer, Integer>, Integer>, Double>>();


		
		for (int i = 0; i < distance.size(); i++) {
			for (int j = i + 1; j < distance.size(); j++) {
				//System.out.println("j: "+ j);
				for (int k = 0; k < node.size(); k++) {
					if (k != i && k != j) {
						dkMax.add(new Pair<>(new Pair<>(new Pair<>(i, j), k), Math
								.max(getDistance(node.get(i), node.get(k)), getDistance(node.get(j), node.get(k)))));
					}
				}
				
			}
		}


		// Step 3: For each pair of points search for a value of dkMax that is smaller
		// than d(pi,pj). If such a points is not found, am edge is formed between pi
		// and pj.

		boolean found;
		for (int i = 0; i < distance.size(); i++) {
			for (int j = i + 1; j < distance.size(); j++) {
				found = false;
				for (int l = 0; l < node.size() - 2; l++) {
					if (dkMax.get(0).getValue() < distance.get(i).get(j)) {
						found = true;
					}
					dkMax.remove(0);
				}
				if (found == false) {
					edge.add(new Edge(node.get(i), node.get(j)));
				}
			}
		}

		end = (System.currentTimeMillis() - start) / 1000;
		return new Algorithm("RNG1", edge.size(), new Graph(node, edge), end);
	}

	public double getDistance(Node start, Node end) { // start= (Xs,Ys) ende = (Xe,Ye)
		double x = Math.pow(Math.abs(end.getX() - start.getX()), 2);
		double y = Math.pow(Math.abs(end.getY() - start.getY()), 2);
		return Math.sqrt(x + y);
	}


}
