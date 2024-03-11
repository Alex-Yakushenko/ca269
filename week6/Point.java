public interface Order {
    public boolean lessThan(Order other);
}

public class Point implements Order {
    private double x, y;

    public Point(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean equals(Point other) {
        if (this.x == other.getX() && this.y == other.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Point other) {
        if (this.equals(other)) {
            return false;
        } else if (this.x < other.getX()) {
            return true;
        } else if (this.y < other.getY()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean lessThan(Order other) {
        if (!(other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) other;
        return (this.lessThan(otherPoint));
    }


    public int compareTo(Object other) {
        if (!(other instanceof Point)) {
            return 0;
        }
        Point otherPoint = (Point) other;
        if (this.equals(otherPoint)) {
            return 0;
        } else if (this.lessThan(otherPoint)) {
            return -1;
        } else if (otherPoint.lessThan(this)) {
            return 1;
        }
        return 0; // can get rid of last else if I just want to use the equals in the compare to
    }

    public static void main(String[] args) {
        Comparator<Point> C = new Comparator<>();

        Point P1 = new Point(0, 0);
        Point P2 = new Point(1, 1);

        System.out.println(C.getLesser(P1, P2)); // (0.0, 0.0)
        System.out.println(C.getLesser(P2, P1)); // (0.0, 0.0)
        System.out.println(C.getLesser(P1, P1)); // null
    
    }
}
class Comparator<T extends Order> {
    public T getLesser(T p1, T p2) {
        if (p1.lessThan(p2)) {
            return p1;
        } else if (p2.lessThan(p1)) {
            return p2;
        }
        return null;
    }
}