import java.util.List;

/**
 * Created by Admin on 19.05.2016.
 */
public class Freelancer extends Person {

    private int id;
    private int prof;
    private boolean is_busy = false;

    private static int freeid = 201;

    public Freelancer (int id, int prof)
    {
        this.id = id;
        this.prof = prof;
        freeid++;
        System.out.println("Знакомьтесь! Новый фрилансер, сотрудник под № " + id + ", " + strProf());
    }

    public void work (Task task, List<CompleteTask> clist, boolean is_dayoff)
    {
        System.out.println("Фрилансер № " + id + " выполнил задачу № " + task.getNum() + " ," +
                TaskNames.values()[task.getType()-1].getName());
        clist.add(new CompleteTask(task, this, is_dayoff));
        this.is_busy = true;
    }

    private String strProf()
    {
        String res = "";
        switch (prof)
        {
            case 1:
                res = "бухгалтер";
                break;
            case 3:
                res = "дизайнер";
                break;
            case 4:
                res = "менеджер";
                break;
            case 5:
                res = "программист";
                break;
            case 6:
                res = "тестировщик";
                break;

        }
        return res;
    }

    @Override
    public int getId() {
        return id;
    }

    public int getProf() {
        return prof;
    }

    @Override
    public boolean is_busy() {
        return is_busy;
    }



    public static int getFreeid() {
        return freeid;
    }


}
