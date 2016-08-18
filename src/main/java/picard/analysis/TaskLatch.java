package picard.analysis;

/**
 * Created by Nusrat on 7/25/2016.
 */
public class TaskLatch {
    private int counter;
    private boolean isDone;
    private boolean isReleased;
    private int maxTasks;

    public TaskLatch(int maxTasks) {
        counter = 0;
        resetDone();
        setReleased();
        this.maxTasks = maxTasks;
    }

    public synchronized void acquire() {
        --counter;
    }

    public synchronized void release() {
        ++counter;
        if (isReleased && isEmpty()) {
            setDone();
        }
    }

    public synchronized void enter() {
        resetReleased();
    }

    public synchronized void leave() {
        setReleased();
    }

    public boolean hasFreeSpace(int currTasks) {
        return currTasks < maxTasks;
    }

    public synchronized void waitUntilDone() {
        while (!isDone) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void notifyChanged() {
        notifyAll();
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    private void setDone() {
        isDone = true;
    }

    private void resetDone() {
        isDone = false;
    }

    private void setReleased() {
        isReleased = true;
    }

    private void resetReleased() {
        isReleased = false;
    }
}