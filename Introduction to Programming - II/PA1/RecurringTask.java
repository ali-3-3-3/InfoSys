class RecurringTask extends Task {
    private final ImList<AbstractTask> tasks;
    private final int freq;
    private final int occurence;

    RecurringTask(Task task, int freq, int occurence) {
        super(task);
        ImList<AbstractTask> tempTaskList = new ImList<AbstractTask>();
        for(int i = 0; i < occurence; i++) {
            tempTaskList = tempTaskList.add(task.repeat(freq * i));
        }
        this.tasks = tempTaskList;
        this.freq = freq;
        this.occurence = occurence;
    }

    private RecurringTask(RecurringTask task, ImList<AbstractTask> tasks) {
        super(task);
        this.freq = task.freq;
        this.occurence = task.occurence;
        this.tasks = tasks;
    }

    @Override
    RecurringTask edit(int newStart, int newEnd) {
        return new RecurringTask(new Task(this, newStart, newEnd), freq, occurence);
    }

    @Override
    CancelledRecurringTask cancel() {
        return new CancelledRecurringTask(this);
    }

    ImList<AbstractTask> getTaskOnDay(int day) {
        ImList<AbstractTask> taskList = new ImList<AbstractTask>();

        for(AbstractTask task : tasks) {
            taskList = taskList.addAll(task.getTaskOnDay(day));
        }

        return taskList;
    }

    RecurringTask edit(int index, int newDay, int newStart, int newEnd) {
        Task updatedTask = new Task(newDay, newStart, newEnd, this.getDesc());
        ImList<AbstractTask> updatedTaskList = tasks.set(index - 1, updatedTask);
        updatedTaskList = updatedTaskList.sort(new TaskComparator());
        return new RecurringTask(this, updatedTaskList);
    }

    RecurringTask cancel(int index) {
        CancelledTask cancelledTask = new CancelledTask(tasks.get(index - 1));
        ImList<AbstractTask> updatedTaskList = tasks.set(index - 1, cancelledTask);
        return new RecurringTask(this, updatedTaskList);
    }

    public String toString() {
        String output = "Recurring " + super.toString();
        for(int i = 0; i < tasks.size(); i++) {
            output += String.format("\n#%d:%s", i + 1, tasks.get(i).toString());
        }

        return output;
    }
}
