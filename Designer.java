/**
 * Created by Admin on 14.05.2016.
 */
public class Designer extends Person{

    private int id;
    private boolean[][] schedule;

    public Designer (int id)
    {
        this.id = id;
        this.schedule = Office.getStaff().get(id - 1).getSchedule();
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

    public void drawLayout (Task task)
    {
        System.out.println("Рисую макет, задача номер " + task.getNum());
    }
}
