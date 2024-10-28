import java.util.*;

class ResearcherComparator implements Comparator<Researcher> {
    @Override
    public int compare(Researcher r1, Researcher r2) {
        
        //If arrival times are equal, compare stay times instead
        if(r1.getArrivalTime() == r2.getArrivalTime()) {
            return r1.getStayTime() - r2.getStayTime();
        } else {
            return r1.getArrivalTime() - r2.getArrivalTime();
        }
    }
}
