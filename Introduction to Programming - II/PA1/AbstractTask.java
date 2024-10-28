import java.util.Comparator;

abstract class AbstractTask implements Comparable<AbstractTask>{
    private final int day;
    private final int start;
    private final int end;
    private final String desc;

    AbstractTask(int day, int start, int end, String desc) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.desc = desc;
    }

    AbstractTask(AbstractTask task, int newStart, int newEnd) {
        this(task.day, newStart, newEnd, task.desc);
    }

    AbstractTask(AbstractTask task) {
        this(task.day, task.start, task.end, task.desc);
    }

    AbstractTask(AbstractTask task, int addNumOfDays) {
        this(task.day + addNumOfDays, task.start, task.end, task.desc);
    }

    int getDay() {
        return this.day;
    }

    int getStart() {
        return this.start;
    }

    int getEnd() {
        return this.end;
    }

    String getDesc() {
        return this.desc;
    };

    boolean isSameDay(int day) {
        return this.day == day;
    }

    abstract ImList<AbstractTask> getTaskOnDay(int day);

    @Override
    public int compareTo(AbstractTask other) {
        if(this.day != other.day) {
            return this.day - other.day;
        }

        return this.start - other.start;
    }

    @Override
    public String toString() {
        return String.format("Task: %d,%d,%d,%s", day, start, end, desc);
    }
}

