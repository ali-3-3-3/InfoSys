double epsilon = 1E-15;

int findMaxDiscCoverage(ImList<Point> points) {
    int maxDiscCoverage = 0;
    int numOfPoints = points.size();

    for (int i = 0; i < numOfPoints - 1; i++) {
        for (int j = i + 1; j < numOfPoints; j++) {
             
            //Compare distance between two given points.
            Point p = points.get(i);
            Point q = points.get(j);
            double distPQ = p.distanceBetween(q);

            //If the distance is less than 2.0 and more than 0, create Circle
            if (distPQ < 2.0 + epsilon && distPQ > 0) {
                Circle c = createUnitCircle(p, q);
  
                //Check how many points in the circle
                int coverage = 0;
                for (Point point : points) {
                    if (c.contains(point)) {
                        coverage = coverage + 1;
                    }
                }
                
                //If more points are covered in this circle than previous circle..
                if (coverage > maxDiscCoverage) {
                    maxDiscCoverage = coverage;
                }
            }
        }
    }
    return maxDiscCoverage;
}

Circle createUnitCircle(Point p, Point q) {
    Point midPoint = p.midPoint(q);
    double angle = p.angleTo(q);
    double distance = Math.sqrt(1.0 - Math.pow(midPoint.distanceBetween(q), 2));
    return new Circle(midPoint.moveTo(angle + Math.PI / 2.0, distance), 1.0);  
}


