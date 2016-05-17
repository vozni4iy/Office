import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.05.2016.
 */
public class WorkDay {

    private int number;
    private String name, dayoff;
    private boolean is_dayoff;

    private static List<Person> staff = office.getStaff();
    private static List<Director> dirlist = office.getDirlist();
    private static List<Accountant> acclist = office.getAcclist();
    private static List<Cleaner> clelist = office.getClelist();
    private static List<Designer> deslist = office.getDeslist();
    private static List<Manager> manlist = office.getManlist();
    private static List<Programmer> proglist = office.getProglist();
    private static List<Tester> testlist = office.getTestlist();
    private static List <Task> tasklist = new ArrayList<>();

    public WorkDay (int number)
    {
        this.number = number;
    }

    public void work()
    {
        getData();
        System.out.println("Сегодня " + name + ", " + number + " марта, " + dayoff);
        System.out.println("Работа пошла! ");
        int maxtasks = staff.size()/dirlist.size();
        if (maxtasks < 2)
        {
            maxtasks = 2;
        }
        for (Director director : dirlist)
        {
            if (director.getSchedule()[0][0])
            {
                int n = (int) (Math.random()*maxtasks) + 1;
                for (int i = 0; i < n; i++)
                {
                    tasklist.add(director.giveTask());
                }
            }
        }

        System.out.println();
        for (Task task : tasklist)
        {
            System.out.println(task);
        }
    }

    private void getData()
    {
        int i = number % 7;
        WeekDays day = WeekDays.values()[i];
        name = day.getName();
        is_dayoff = day.is_dayoff();
        if (is_dayoff)
        {
            dayoff = " выходной день.";
        } else {
            dayoff = " будний день.";
        }
    }
}
