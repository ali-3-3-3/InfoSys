 class DayView implements View {
    private final int day;

    DayView(int day) {
        this.day = day;
    }

    public void view(ImList<AbstractTask> tasks) {
        ImList<AbstractTask> filteredTasks = new ImList<AbstractTask>();
        for(AbstractTask task : tasks) {
            filteredTasks = filteredTasks.addAll(task.getTaskOnDay(day));
        }

        filteredTasks = filteredTasks.sort(new TaskComparator());

        for(AbstractTask task : filteredTasks) {
            System.out.println(task);
        }
    }
}
