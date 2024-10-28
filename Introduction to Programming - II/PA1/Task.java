class Task extends AbstractTask {
    
    Task(int day, int start, int end, String desc) {
        super(day, start, end, desc);
    }

    Task(Task task, int newStart, int newEnd) {
        super(task, newStart, newEnd);
    }

    Task(Task task, int addNumOfDays) {
        super(task, addNumOfDays);
    }

    Task(Task task) {
        super(task);
    }

    ImList<AbstractTask> getTaskOnDay(int day) {
        ImList<AbstractTask> taskList = new ImList<AbstractTask>();
        if(isSameDay(day)) {
            taskList = taskList.add(this);
        }
        return taskList;
    }

    Task edit(int newStart, int newEnd) {
        return new Task(this, newStart, newEnd);
    }

    Task repeat(int numOfDays) {
        return new Task(this, numOfDays);
    }

    CancelledTask cancel() {
        return new CancelledTask(this);
    }
}
