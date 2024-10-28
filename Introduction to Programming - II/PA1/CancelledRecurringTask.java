class CancelledRecurringTask extends CancelledTask {
    CancelledRecurringTask(AbstractTask task) {
        super(task);
    }

    public String toString() {
        return "Recurring " + super.toString();
    }
}
