import java.time.LocalDate;
import java.time.Period;

enum State {
    TODO, BEGN, HALT, WAIT, DONE;
}

public class Task {

    private final String title;
    private String description;
    private LocalDate scheduled;
    private LocalDate deadline; 
    private State state;

    // constructor
    Task(String title, State state) {
        this.title = title;
        this.state = state;
    }

    // getters
    public String getTitle() {
        return this.title;
    }
    public State getState() {
        return this.state;
    }
    public LocalDate getScheduled() {
        return this.scheduled;
    }
    public LocalDate getDeadline() {
        return this.deadline;
    }
    public String getDescription() {
        return this.description;
    }
    
    // setters
    public void setState(State state) {
        this.state = state;
    }
    public void setScheduled(LocalDate scheduled) {
        this.scheduled = scheduled;
    }
    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // to string
    public String toString() {
        String message = this.title + " (" + this.state + ")";
        if (scheduled != null) {
            message += " scheduled: " + scheduled;
        }
        if (deadline != null) {
            message += " deadline: " + deadline;
        }
        return message;
    }

    public static void main(String[] args) {
        Task t1 = new Task("T1", State.TODO);
        LocalDate now = LocalDate.now();
        LocalDate.now();
        System.out.println(t1);

        Task s1 = new RepeatedTask("S1", State.TODO);
        System.out.println(s1);
        s1.setState(State.DONE);
        System.out.println(s1);

        Task s2 = new Chore("S2", State.TODO,
            LocalDate.now(),
            LocalDate.now().plus(Period.ofDays(7)));
        System.out.println(s2);
        s2.setState(State.DONE);
        System.out.println(s2);

        Task t2 = new SharedTask("T2", "Alice");
        System.out.println(t2);

        Task t3 = new Dependency("T3", State.TODO, t1);
        System.out.println(t3);
        t3.setState(State.DONE);
        System.out.println(t3);
        t1.setState(State.DONE);
        t3.setState(State.DONE);
        System.out.println(t3);

    }

}

class Chore extends Task {
    LocalDate repeat;

    Chore(String title, State state, LocalDate scheduled, LocalDate repeat) {
        super(title, state);
        setScheduled(scheduled);
        setRepeat(repeat);
    }

    // getters and setters
    public LocalDate getRepeat() {
        return this.repeat;
    }

    public void setRepeat(LocalDate repeat) {
        this.repeat = repeat;
    }

    public void setState(State state) {
        super.setState(state);

        if (state == State.DONE) {
            LocalDate repeat_new = repeat.plus(Period.ofDays(7));
            setScheduled(repeat);
            setRepeat(repeat_new);
            super.setState(State.TODO);
        }
    }
    
}

class RepeatedTask extends Task {

    RepeatedTask(String title, State state) {
        super(title, state);
    }
    
    public void setState(State state) {
        super.setState(state);

        if (state == State.DONE) {
            super.setState(State.TODO);
        }
    }
}

class SharedTask extends Task {

    String partner;

    SharedTask(String title, String partner) {

        super(title, State.WAIT);
        this.setPartner(partner);
    }

    public String getPartner() {
        return this.partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String toString() {
        return super.toString() + " shared with: " + this.partner;
    }
}

class Dependency extends Task {
    Task task;

    Dependency(String title, State state, Task task) {
        super(title, state);
        this.task = task;
    }

    public void setState(State state) {
        if (state == State.DONE && this.task.getState() != State.DONE) {

        } else {
        super.setState(state);
        }
    }

    public Task getTask() {
        return this.task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String toString() {
        return super.toString() + " dependent on: " + this.task.getTitle() + " (" + this.task.getState() + ")";
    }
}