 

 

import java.util.ArrayList;
import edu.duke.FileResource;



public class Shape {
    private ArrayList<Point> points;

    public Shape () {
        points = new ArrayList<Point>();
    }

    public Shape (FileResource file) {
        this();
        for (String line : file.lines()) {
            int commaloc = line.indexOf(",");
            int x = Integer.parseInt(line.substring(0, commaloc).trim());
            int y = Integer.parseInt(line.substring(commaloc + 1).trim());
            addPoint(new Point(x, y));
        }
    }
    
   
    public void addPoint (Point p) {
        points.add(p);
    }

    public Point getLastPoint () {
        return points.get(points.size() - 1);
    }

    public Iterable<Point> getPoints () {
        return points;
    }
}
