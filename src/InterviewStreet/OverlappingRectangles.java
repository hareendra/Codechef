package InterviewStreet;

/**
 * Created by HReddy on 5/7/2014.
 */

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
};

public class OverlappingRectangles {

    // Returns true if two rectangles (l1, r1) and (l2, r2) overlap
    // A Rectangle is represented by two points , top left and lower right
    static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // If one rectangle is on left side of other
        if (l1.x > r2.x || l2.x > r1.x)
            return false;
        // If one rectangle is above other
        if (l1.y < r2.y || l2.y < r1.y)
            return false;
        return true;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        Point l2 = new Point(0, 10), r2 = new Point(10, 0);
        Point l1 = new Point(5, 5), r1 = new Point(15, 0);
        if (doOverlap(l1, r1, l2, r2))
            System.out.printf("Rectangles Overlap");
        else
            System.out.printf("Rectangles Don't Overlap");
        return;
    }
}
