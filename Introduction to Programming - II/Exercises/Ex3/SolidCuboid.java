class SolidCuboid extends Cuboid implements Solid {

    private final double density;

    public SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.density = density;
    }
    
    @Override
    public double mass() {
        return new SolidImpl(this, this.density).mass();
    }

    @Override
    public String toString() {
        return String.format("solid-cuboid [%.2f x %.2f x %.2f] with a mass of %.2f",
                this.getHeight(), this.getWidth(), this.getLength(), this.mass());
    }

}

