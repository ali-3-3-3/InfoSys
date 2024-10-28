class Runner implements Comparable<Runner>{
    String name;
    double firstLeg;
    double otherLeg;

    public Runner(String name, double firstLeg, double otherLeg){
        this.name = name;
        this.firstLeg = firstLeg;
        this.otherLeg = otherLeg;
    }

    @Override
    public int compareTo(Runner other){
        return Double.compare(this.otherLeg, other.otherLeg);
    }
}