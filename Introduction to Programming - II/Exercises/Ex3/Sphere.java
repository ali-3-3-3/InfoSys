class Sphere implements Shape3D {
    private final double radius;
    private static final double CONSTANT_1 = 4.0;
    private static final double CONSTANT_2 = 3.0;

    public Sphere(double radius) {
        this.radius = radius;
    }

    double getRadius() {
        return this.radius;
    }

    @Override
    public double volume() {
        return Math.PI * this.radius * this.radius * this.radius * CONSTANT_1 / CONSTANT_2;
    }

    @Override
    public String toString() {
        return String.format("sphere [%.2f]", this.radius);
    }
}
