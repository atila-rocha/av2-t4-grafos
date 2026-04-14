/* *****************************************************************************
 * Name: Hasit Nanda
 * Description: Circular Linked List implementation for TSP heuristics
 **************************************************************************** */

public class Tour {
    private class Node {
        private Point p;     // ponto armazenado
        private Node next;   // próximo nó
    }

    private Node start; // início da lista

    // cria um tour vazio
    public Tour() {
        start = new Node();
    }

    // cria um tour com 4 pontos (debug)
    public Tour(Point a, Point b, Point c, Point d) {
        start = new Node();
        Node b1 = new Node();
        Node c1 = new Node();
        Node d1 = new Node();

        start.p = a;
        b1.p = b;
        c1.p = c;
        d1.p = d;

        start.next = b1;
        b1.next = c1;
        c1.next = d1;
        d1.next = start;
    }

    // número de pontos no tour
    public int size() {
        if (start.p == null) return 0;

        int counter = 0;
        Node current = start;

        do {
            counter++;
            current = current.next;
        } while (!current.equals(start));

        return counter;
    }

    // comprimento total do tour
    public double length() {
        if (start.p == null) return 0.0;

        double distance = 0.0;
        Node current = start;

        do {
            distance += current.p.distanceTo(current.next.p);
            current = current.next;
        } while (!current.equals(start));

        return distance;
    }

    // representação em string
    public String toString() {
        if (start.p == null) return "";

        StringBuilder str = new StringBuilder();
        Node current = start;

        do {
            str.append(current.p.toString()).append("\n");
            current = current.next;
        } while (!current.equals(start));

        return str.toString();
    }

    // desenha o tour
    public void draw() {
        if (start.p != null && start.next != null) {
            Node current = start;

            do {
                current.p.drawTo(current.next.p);
                current = current.next;
            } while (!current.equals(start));
        }
    }

    // ------------------------------
    // HEURÍSTICA: NEAREST INSERTION
    // ------------------------------
    public void insertNearest(Point p) {

        // caso vazio
        if (start.p == null) {
            start.p = p;
            start.next = start;
            return;
        }

        Node nearest = start;
        Node current = start;
        double minDist = p.distanceTo(start.p);

        // encontrar o ponto mais próximo
        do {
            double dist = p.distanceTo(current.p);
            if (dist < minDist) {
                minDist = dist;
                nearest = current;
            }
            current = current.next;
        } while (!current.equals(start));

        // inserir após o mais próximo
        Node newNode = new Node();
        newNode.p = p;

        newNode.next = nearest.next;
        nearest.next = newNode;
    }

    // ------------------------------
    // HEURÍSTICA: SMALLEST INSERTION
    // ------------------------------
    public void insertSmallest(Point p) {

        // caso vazio
        if (start.p == null) {
            start.p = p;
            start.next = start;
            return;
        }

        // caso com apenas 1 ponto
        if (start.next.equals(start)) {
            Node newNode = new Node();
            newNode.p = p;

            newNode.next = start;
            start.next = newNode;
            return;
        }

        Node bestNode = start;
        Node current = start;
        double bestIncrease = Double.POSITIVE_INFINITY;

        // encontrar melhor aresta
        do {
            double increase =
                    current.p.distanceTo(p)
                            + p.distanceTo(current.next.p)
                            - current.p.distanceTo(current.next.p);

            if (increase < bestIncrease) {
                bestIncrease = increase;
                bestNode = current;
            }

            current = current.next;
        } while (!current.equals(start));

        // inserir na melhor posição
        Node newNode = new Node();
        newNode.p = p;

        newNode.next = bestNode.next;
        bestNode.next = newNode;
    }

    // teste simples
    public static void main(String[] args) {
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        Tour tourNearest = new Tour(a, b, c, d);
        Tour tourSmallest = new Tour(a, b, c, d);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);

        tourNearest.insertNearest(e);
        tourSmallest.insertSmallest(e);

        StdOut.println("Nearest:");
        StdOut.println(tourNearest);

        StdOut.println("Smallest:");
        StdOut.println(tourSmallest);

        tourNearest.draw();
    }
}