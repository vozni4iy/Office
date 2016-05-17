/**
 * Created by Admin on 14.05.2016.
 */
public class Tester extends Person{

    private int id;
    private boolean [][] schedule;

    public Tester (int id)
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
