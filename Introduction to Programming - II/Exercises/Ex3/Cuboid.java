class Cuboid implements Shape3D {
    private final double height;
    private final double width;
    private final double length;

    public Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }
    
    double getHeight() {
        return this.height;
    }

    double getWidth() {
        return this.width;
    }

    double getLength() {
        return this.length;
    }

    @Override
    public double volume() {
        return this.height * this.width * this.length;
    }

    @Override
    public String toString() {
        return String.format("cuboid [%.2f x %.2f x %.2f]", this.height, this.width,
                this.length);
    }

}

