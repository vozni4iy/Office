import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 13.05.2016.
 */
public class office {

    private static List<Person> staff = new ArrayList<Person>();
    private static List<Director> dirlist = new ArrayList<>();
    private static List<Accountant> acclist = new ArrayList<>();
    private static List<Cleaner> clelist = new ArrayList<>();
    private static List<Designer> deslist = new ArrayList<>();
    private static List<Manager> manlist = new ArrayList<>();
    private static List<Programmer> proglist = new ArrayList<>();
    private static List<Tester> testlist = new ArrayList<>();

    private static final int FIXED_COSTS = 50000;

      public static void main (String [] args)
    {
        System.out.println("Office");
        int quan;
        //quan = (int) (Math.random() * 91) + 10;
        quan = (int) (Math.random() * 11) + 10;
        System.out.println("Количество сотрудников: " + quan);
        basicInit();
        staff = createRndStaff(staff, quan, 5);
        printStaff(staff);
        createProfLists();
        System.out.println();
        //dirlist.get(0).printSchedule();
        System.out.println();
        for (int i = 1; i <= 31; i++) {
            WorkDay day = new WorkDay(i);
            day.work();
        }

        List <CompleteTask> clist = WorkDay.getCompleteList();

        System.out.println("Всего выполнено заданий за месяц: " + clist.size());
        Report report = new Report(clist);
        report.make();
    }

    public static void basicInit()
    {
        Person person;
        person = new Person(1,true,false,false,false,false,false,false);
        staff.add(person);
        //person.printSchedule();
        person = new Person(2,false,true,false,false,false,false,false);
        staff.add(person);
        person = new Person(3,false,false,false,false,true,false,false);
        staff.add(person);
        person = new Person(4,false,false,true,false,false,false,false);
        staff.add(person);
    }

    public static void createProfLists()
    {
        dirlist = createDirList(staff);
        acclist = createAccList(staff);
        clelist = createCleList(staff);
        deslist = createDesList(staff);
        manlist = createManList(staff);
        proglist = createProgList(staff);
        testlist = createTestList(staff);
    }

    public static void printStaff (List<Person> staff)
    {
        int dirnum = 0, accnum = 0, clenum = 0, desnum = 0, mannum = 0, prognum = 0, testnum = 0;
        for (Person person : staff)
        {
            System.out.print(person.getId() + " ");
            if (person.is_director()) {
                System.out.print("Директор ");
                dirnum++;
            }
            if (person.is_accountant()) {
                System.out.print("Бухгалтер ");
                accnum++;
            }
            if (person.is_cleaner()) {
                System.out.print("Уборщик ");
                clenum++;
            }
            if (person.is_designer()) {
                System.out.print("Дизайнер ");
                desnum++;
            }
            if (person.is_manager()) {
                System.out.print("Менеджер ");
                mannum++;
            }
            if (person.is_programmer()) {
                System.out.print("Программист ");
                prognum++;
            }
            if (person.is_tester()) {
                System.out.print("Тестировщик");
                testnum++;
            }
            System.out.println();

        }


        System.out.println();
        System.out.println("Всего сотрудников: " + staff.size());
        System.out.println("Директоров: " + dirnum);
        System.out.println("Бухгалтеров: " + accnum);
        System.out.println("Уборщиков: " + clenum);
        System.out.println("Дизайнеров: " + desnum);
        System.out.println("Менеджеров: " + mannum);
        System.out.println("Программистов: " + prognum);
        System.out.println("Тестировщиков: " + testnum);
        System.out.println();
    }

    public static List<Person> createRndStaff (List <Person> staff, int quan, int start)
    {
        Person person;
        for (int i = start; i <= quan; i++)
        {
            int rnd = (int) (Math.random()*20);
            Profs profs = Profs.values()[rnd];
            person = new Person(i);
            person.setIs_director(profs.is_director());
            person.setIs_accountant(profs.is_accountant());
            person.setIs_cleaner(profs.is_cleaner());
            person.setIs_designer(profs.is_designer());
            person.setIs_manager(profs.is_manager());
            person.setIs_programmer(profs.is_programmer());
            person.setIs_tester(profs.is_tester());
            staff.add(person);
        }
        return staff;
    }

    private static List<Director> createDirList(List <Person> staff)
    {
        List <Director> dirlist = new ArrayList<>();
        Director director;
        System.out.print("Директора: ");
        for (Person person : staff)
        {
            if (person.is_director())
            {
                director = new Director(person.getId());
                dirlist.add(director);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return dirlist;
    }

    private static List<Accountant> createAccList(List <Person> staff)
    {
        List <Accountant> acclist = new ArrayList<>();
        Accountant accountant;
        System.out.print("Бухгалтера: ");
        for (Person person : staff)
        {
            if (person.is_accountant())
            {
                accountant = new Accountant(person.getId());
                acclist.add(accountant);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return acclist;
    }

    private static List<Cleaner> createCleList(List <Person> staff)
    {
        List <Cleaner> clelist = new ArrayList<>();
        Cleaner cleaner;
        System.out.print("Уборщики: ");
        for (Person person : staff)
        {
            if (person.is_cleaner())
            {
                cleaner = new Cleaner(person.getId());
                clelist.add(cleaner);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return clelist;
    }

    private static List<Designer> createDesList(List <Person> staff)
    {
        List <Designer> deslist = new ArrayList<>();
        Designer designer;
        System.out.print("Дизайнеры: ");
        for (Person person : staff)
        {
            if (person.is_designer())
            {
                designer = new Designer(person.getId());
                deslist.add(designer);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return deslist;
    }

    private static List<Manager> createManList(List <Person> staff)
    {
        List <Manager> manlist = new ArrayList<>();
        Manager manager;
        System.out.print("Менеджеры: ");
        for (Person person : staff)
        {
            if (person.is_manager())
            {
                manager = new Manager(person.getId());
                manlist.add(manager);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return manlist;
    }

    private static List<Programmer> createProgList(List <Person> staff)
    {
        List <Programmer> proglist = new ArrayList<>();
        Programmer programmer;
        System.out.print("Программисты: ");
        for (Person person : staff)
        {
            if (person.is_programmer())
            {
                programmer = new Programmer(person.getId());
                proglist.add(programmer);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return proglist;
    }

    private static List<Tester> createTestList(List <Person> staff)
    {
        List <Tester> testlist = new ArrayList<>();
        Tester tester;
        System.out.print("Тестировщики: ");
        for (Person person : staff)
        {
            if (person.is_tester())
            {
                tester = new Tester(person.getId());
                testlist.add(tester);
                System.out.print(person.getId() + " ");
            }
        }
        System.out.println();
        return testlist;
    }

    public static List<Director> getDirlist() {
        return dirlist;
    }

    public static List<Accountant> getAcclist() {
        return acclist;
    }

    public static List<Cleaner> getClelist() {
        return clelist;
    }

    public static List<Designer> getDeslist() {
        return deslist;
    }

    public static List<Manager> getManlist() {
        return manlist;
    }

    public static List<Programmer> getProglist() {
        return proglist;
    }

    public static List<Tester> getTestlist() {
        return testlist;
    }

    public static List<Person> getStaff() {
        return staff;
    }

    public static int getFixedCosts() {
        return FIXED_COSTS;
    }
}
