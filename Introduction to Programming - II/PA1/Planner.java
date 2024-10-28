class Planner {
    private final ImList<AbstractTask> tasks;

    Planner() {
        this(new ImList<AbstractTask>());
    }

    Planner(ImList<AbstractTask> tasks) {
        this.tasks = tasks;
    }

    Planner add(AbstractTask task) {
        return new Planner(tasks.add(task));
    }

    void view(View viewer) {
        viewer.view(tasks);
    }

    @Override
    public String toString() {
        String output = "";
        for(AbstractTask task : tasks) {
            output += "\n" + task;
        }

        return output;
        
    }
}
