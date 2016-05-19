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
    private static List <CompleteTask> completeList = new ArrayList<>();
    private List <CompleteTask> complist;

    public WorkDay (int number)
    {
        this.number = number;
    }

    public void work()
    {

        getData();
        System.out.println("Сегодня " + name + ", " + number + " марта, " + dayoff);
        System.out.println("Работа пошла! ");
        complist = new ArrayList<>();
        int maxtasks = staff.size()/dirlist.size();
        if (maxtasks < 2)
        {
            maxtasks = 2;
        }
        int w = (number % 7) - 1;
        if (w == -1) w=7;

        //часовые циклы
        for (int h = 0; h < 12; h++) {
            System.out.println();
            int time = h + 8;
            System.out.println("Сейчас " + time + ":00.");
            System.out.println();
            System.out.println("Директора дают задания: ");
            for (Director director : dirlist) {
                if (director.getSchedule()[w][h]) {
                    int n = (int) (Math.random() * maxtasks) + 1;
                    for (int i = 0; i < n; i++) {
                        tasklist.add(director.giveTask());
                    }
                }
            }
            System.out.println("Всего заданий на данный момент: " + tasklist.size());
            System.out.println();
            for (Task task : tasklist) {
                System.out.println(task);
            }
            System.out.println();

            for (Person person : staff) {
                if ((person.getSchedule()[w][h]) && (!person.is_busy())) {
                    Task task = chooseTask(tasklist, person);
                    if (task != null) {
                        person.work(task);
                        person.setIs_busy(true);
                        tasklist.remove(task);
                    }
                }
            }

            System.out.println();
            System.out.println("Нераспределенные задачи: ");
            for (Task task : tasklist) {
                System.out.println(task);
            }
            System.out.println();

            for (Person person : staff) {

                if ((person.getCurTask() == null) && (person.getSchedule()[w][h]) && (!person.is_director()))
                {
                    System.out.println("Сотрудник № " + person.getId() + " сидит без дела");
                }

                if ((person.getCurTask() == null) && (person.getSchedule()[w][h]) && (person.is_director()))
                {
                    System.out.println("Сотрудник № " + person.getId() + " руководит работой офиса");
                }

                if ((person.getCurTask() != null) && (person.getSchedule()[w][h])) {
                    if (person.getStatus() == 0) {
                        person.endWork(person.getCurTask(), complist, is_dayoff);
                    } else {
                        person.continueWorking(person.getCurTask());
                    }
                }

                if (!person.getSchedule()[w][h])
                {
                    System.out.println("Сотрудник № " + person.getId() + " отдыхает");
                }

            }
            System.out.println();
            System.out.println("Всего выполнено заданий: " + complist.size());
            for (CompleteTask ctask : complist) {
                System.out.println(ctask);
            }
            completeList.addAll(complist);
            System.out.println();
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

    private Task chooseTask (List <Task> tasklist, Person person)
    {
        Task task = null;
        int priority = 0;
        int value = 0;
        for (Task t : tasklist)
        {
            if (eqtype(t.getType(), person)) {
                if (t.getPriority() > priority) {
                    task = t;
                    priority = t.getPriority();
                    value = t.getValue();
                } else if (t.getPriority() == priority) {
                    if (t.getValue() > value) {
                        task = t;
                        priority = t.getPriority();
                        value = t.getValue();
                    }
                }
            }

        }
        return task;
    }

    private boolean eqtype (int type, Person person)
    {
        boolean res = false;
        if (person.is_accountant() && (type == 1)) res = true;
        if (person.is_cleaner() && (type == 2)) res = true;
        if (person.is_designer() && (type == 3)) res = true;
        if (person.is_manager() && (type == 4)) res = true;
        if (person.is_programmer() && (type == 5)) res = true;
        if (person.is_tester() && (type == 6)) res = true;
        return res;
    }
}
