package ousama.abschlussarbeit.delaunayTriangulierung;

public class NotEnoughPointsException extends Exception {

    private static final long serialVersionUID = 7061712854155625067L;

    public NotEnoughPointsException(String s) {
        super(s);
    }
}