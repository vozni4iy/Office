/**
 * Created by Admin on 16.05.2016.
 */
public class Cleaner extends Person{

    private int id;
    private boolean[][] schedule;

    public Cleaner (int id)
    {
        this.id = id;
        this.schedule = office.getStaff().get(id - 1).getSchedule();
    }

    public int getId ()
    {
        return id;
    }

    public boolean[][] getSchedule() {
        return schedule;
    }

    public void printSchedule()
    {
        super.printSchedule(schedule);
    }
}
