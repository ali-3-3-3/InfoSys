class SolidSphere extends Sphere implements Solid {
    private final double density;

    public SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
    }

    @Override
    public double mass() {
        return new SolidImpl(this, this.density).mass();
    }

    @Override
    public String toString() {
        return String.format("solid-sphere [%.2f] with a mass of %.2f", 
                this.getRadius(), this.mass());
    }
}
