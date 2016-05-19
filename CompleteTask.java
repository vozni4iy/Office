/**
 * Created by Admin on 19.05.2016.
 */
public class CompleteTask extends Task {

    private int type;
    private int hours;
    private int priority;
    private int value;
    private int id;
    private int payment;


    public CompleteTask (Task task, Person person, boolean is_dayoff)
    {
        super(person.getId(), task.getHours(), task.getPriority(), task.getValue());
        Task.number--;
        this.type = task.getType();
        this.hours = task.getHours();
        this.priority = task.getPriority();
        this.value = task.getValue();
        this.id = person.getId();
        int mult = 1;
        if (is_dayoff) mult = 2;
        this.payment = mult*hours*TaskNames.values()[task.getType()-1].getPayment();
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getHours() {
        return hours;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public int getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    public int getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "CompleteTask{" +
                "type=" + type +
                ", hours=" + hours +
                ", priority=" + priority +
                ", value=" + value +
                ", id=" + id +
                ", payment=" + payment +
                '}';
    }
}
