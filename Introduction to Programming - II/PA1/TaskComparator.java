import java.util.Comparator;

class TaskComparator implements Comparator<AbstractTask> {
    public int compare(AbstractTask t1, AbstractTask t2) {
        return t1.compareTo(t2);
    }
}
