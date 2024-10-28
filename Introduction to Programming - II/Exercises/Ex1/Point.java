class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }
    
    Point midPoint(Point other) {
        return new Point((this.x + other.x) / 2, (this.y + other.y) / 2);
    }                   
         
    double angleTo(Point other) {
        return Math.atan2(other.y - this.y, other.x - this.x);
    }

    Point moveTo(double angle, double distance) {
        return new Point(this.x + distance * Math.cos(angle),
                    this.y + distance * Math.sin(angle));
    }

    double distanceBetween(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    @Override
    public String toString() {
        return String.format("point (%.3f, %.3f)", this.x, this.y);
    }
}
