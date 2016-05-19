import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class Director extends Person{

    private int id;
    private boolean[][] schedule;
    private static final int ACCVALUE = 500;
    private static final int CLEVALUE = 100;
    private static final int DESVALUE = 600;
    private static final int MANVALUE = 400;
    private static final int PROGVALUE = 800;
    private static final int TESTVALUE = 300;

    public Director (int id)
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

    public Task giveTask ()
    {
        //System.out.println("Даю задание");
        int type = (int) (Math.random()*6) + 1;
        int hours = (int) (Math.random()*2) + 1;
        int priority = (int) (Math.random()*10) + 1;
        int value = getValue(type);
        Task task = new Task (type, hours, priority, value);
        return task;
        }

    private int getValue(int type)
    {
        int res = 0;
        switch (type)
        {
            case 1:
                res = ACCVALUE/2 + (int) (Math.random()*ACCVALUE/2);
                break;
            case 2:
                res = CLEVALUE/2 + (int) (Math.random()*CLEVALUE/2);
                break;
            case 3:
                res = DESVALUE/2 + (int) (Math.random()*DESVALUE/2);
                break;
            case 4:
                res = MANVALUE/2 + (int) (Math.random()*MANVALUE/2);
                break;
            case 5:
                res = PROGVALUE/2 + (int) (Math.random()*PROGVALUE/2);
                break;
            case 6:
                res = TESTVALUE/2 + (int) (Math.random()*TESTVALUE/2);
                break;
        }
        return res;
    }
}
