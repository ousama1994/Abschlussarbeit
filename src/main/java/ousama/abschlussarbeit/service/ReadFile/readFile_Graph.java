package ousama.abschlussarbeit.service.ReadFile;


import ousama.abschlussarbeit.model.Edge;
import ousama.abschlussarbeit.model.Graph;
import ousama.abschlussarbeit.model.Node;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class readFile_Graph {

    public int edges;

    public readFile_Graph() {

    }

    public static void deleteFiles(String filename) {
        File myfile = new File(filename);

        if (myfile.isDirectory()) {
            if (Objects.requireNonNull(myfile.list()).length > 0) {
                Arrays.stream(Objects.requireNonNull(new File(filename).listFiles())).forEach(File::delete);
            }
        }
    }

    /*
     * This method read a File and produce a Graph.
     */
    public Graph readGraphFromFile(String path) throws Exception {

        File file = new File(path);

        ArrayList<Node> v = new ArrayList<Node>();
        ArrayList<Edge> e = new ArrayList<Edge>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            String[] parts = st.split("\t");
            if (isNum(parts[0]) && isNum(parts[1])) {
                double x = Double.parseDouble(parts[0]);
                double y = Double.parseDouble(parts[1]);
                v.add(new Node(x, y));
            } else return null;
        }
        br.close();
        return new Graph(v, e);
    }

    public boolean isNum(String x) {
        try {
            double dou = Double.parseDouble(x);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
