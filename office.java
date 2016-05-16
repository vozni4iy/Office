import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 13.05.2016.
 */
public class office {

    static List<Person> staff = new ArrayList<Person>();
    static List<Director> dirlist = new ArrayList<>();
    static List<Accountant> acclist = new ArrayList<>();
    static List<Cleaner> clelist = new ArrayList<>();
    static List<Designer> deslist = new ArrayList<>();
    static List<Manager> manlist = new ArrayList<>();
    static List<Programmer> proglist = new ArrayList<>();
    static List<Tester> testlist = new ArrayList<>();

    public static void main (String [] args)
    {
        System.out.println("Office");
        int quan;
        Person person;


        quan = (int) (Math.random() * 91) + 10;
        System.out.println("Количество сотрудников: " + quan);
        person = new Person(1,true,false,false,false,false,false,false);
        staff.add(person);
        person.printSchedule();
        person = new Person(2,false,true,false,false,false,false,false);
        staff.add(person);
        person = new Person(3,false,false,false,false,true,false,false);
        staff.add(person);
        person = new Person(4,false,false,true,false,false,false,false);
        staff.add(person);
        staff = createRndStaff(staff, quan, 5);
        printStaff(staff);
        createDirList(staff);
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
}
