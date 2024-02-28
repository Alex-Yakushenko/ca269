class Point implements GridQuadrant, CompareQuadrant {
    private double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }

    public Quadrant getQuadrant() {
        if (x > 0 && y > 0) {
            return Quadrant.Q1;
        } else if (x < 0 && y > 0) {
            return Quadrant.Q2;
        } else if (x < 0 && y < 0) {
            return Quadrant.Q3;
        } else if (x > 0 && y < 0) {
            return Quadrant.Q4;
        } else {
            return null;
        }
    }

    public boolean isInSameQuadrant(Point other) {
        if (this.getQuadrant() == other.getQuadrant()) {
            return true;
        } else {
            return false;
        }
    }
}

enum Quadrant {
    Q1, // x +ve, y +ve
    Q2, // x -ve, y +ve
    Q3, // x -ve, y -ve
    Q4; // x +ve, y -ve
}

interface GridQuadrant {
    Quadrant getQuadrant(); // return which quadrant the point is in
        // if point is at (0,0) return null
}

interface CompareQuadrant {
    boolean isInSameQuadrant(Point other); // true if given point is
                                     // in the same quadrant as this point
}

interface PointMaker {
    Point makePoint(double x, double y); // returns point with given x,y
    int countPointsCreated(); // returns count of points created via factory
}
// TODO: create class PointFactory which implements the interface PointMaker

public class PointFactory implements PointMaker {
    private static int counter;
    public Point makePoint(double x, double y) {
        counter += 1;
        return new Point(x, y);
    }

    public int countPointsCreated() {
        return counter;
    }
    
    public static void main(String[] args) {
        
    }
}