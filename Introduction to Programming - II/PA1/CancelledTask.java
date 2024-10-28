class CancelledTask extends AbstractTask {

    CancelledTask(AbstractTask task) {
        super(task);
    }

    @Override
    ImList<AbstractTask> getTaskOnDay(int day) {
        return new ImList<AbstractTask>();
    }

    public String toString() {
        return super.toString() + "[cancelled]";
    }
}
