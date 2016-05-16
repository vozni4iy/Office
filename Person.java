/**
 * Created by Admin on 14.05.2016.
 */
public class Person {

    private int id;
    private boolean is_director;
    private boolean is_accountant;
    private boolean is_manager;
    private boolean is_tester;
    private boolean is_programmer;
    private boolean is_designer;
    private boolean is_cleaner;
    private boolean [][] schedule;

    public Person (int id)
    {
        this.id = id;
        this.is_director = false;
        this.is_accountant = false;
        this.is_cleaner = false;
        this.is_designer = false;
        this.is_manager = false;
        this.is_programmer = false;
        this.is_tester = false;
        this.schedule = createSchedule();
    }

    public Person (int id, boolean is_director, boolean is_accountant, boolean is_cleaner, boolean is_designer,
                   boolean is_manager, boolean is_programmer, boolean is_tester)
    {
        this.id = id;
        this.is_director = is_director;
        this.is_accountant = is_accountant;
        this.is_cleaner = is_cleaner;
        this.is_designer = is_designer;
        this.is_manager = is_manager;
        this.is_programmer = is_programmer;
        this.is_tester = is_tester;
        this.schedule = createSchedule();
    }

    public void setIs_director(boolean is_director) {
        this.is_director = is_director;
    }

    public void setIs_accountant(boolean is_accountant) {
        this.is_accountant = is_accountant;
    }

    public void setIs_manager(boolean is_manager) {
        this.is_manager = is_manager;
    }

    public void setIs_tester(boolean is_tester) {
        this.is_tester = is_tester;
    }

    public void setIs_programmer(boolean is_programmer) {
        this.is_programmer = is_programmer;
    }

    public void setIs_designer(boolean is_designer) {
        this.is_designer = is_designer;
    }

    public void setIs_cleaner(boolean is_cleaner) {
        this.is_cleaner = is_cleaner;
    }





    public int getId ()
    {
        return id;
    }

    public boolean is_director() {
        return is_director;
    }

    public boolean is_accountant() {
        return is_accountant;
    }

    public boolean is_manager() {
        return is_manager;
    }

    public boolean is_tester() {
        return is_tester;
    }

    public boolean is_programmer() {
        return is_programmer;
    }

    public boolean is_designer() {
        return is_designer;
    }

    public boolean is_cleaner() {
        return is_cleaner;
    }

    private boolean[][] createSchedule()
    {
        boolean flag = true;
        boolean[][] schedule = new boolean[7][12];
        int daylimit = 8;
        int limit = 40;
        int dhours = 0, whours = 0;
        int rnd;
        while (flag) {
            schedule = new boolean[7][12];
            for (int i = 0; i < 7; i++)
            {
                dhours = 0;
                for (int j = 0; j < 12; j++)
                {
                   rnd = (int) (Math.random()*2);
                   if (rnd > 0)
                   {
                       schedule[i][j] = true;
                       dhours++;
                       whours++;
                   }
                    if (dhours==daylimit) break;
                    if (whours == limit) break;
                }

                if (whours == limit) break;

            }
            //System.out.println(whours);
            if (whours == limit) {
                flag = false;

            } else
            {
                whours = 0;
            }

        }
        return schedule;
    }

    public void printSchedule()
    {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(schedule[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean[][] getSchedule() {
        return schedule;
    }
}
