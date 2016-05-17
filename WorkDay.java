/**
 * Created by Admin on 17.05.2016.
 */
public class WorkDay {

    private int number;
    private String name, dayoff;
    private boolean is_dayoff;

    public WorkDay (int number)
    {
        this.number = number;
    }

    public void work()
    {
        getData();
        System.out.println("Сегодня " + name + ", " + number + " марта, " + dayoff);
        System.out.println("Работа пошла! ");
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
