import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 13.05.2016.
 */
public class office {
    public static void main (String [] args)
    {
        System.out.println("Office");
        int quan;
        Person person;
        List<Person> staff = new ArrayList<Person>();
        quan = (int) (Math.random() * 91) + 10;
        System.out.println(quan);
        person = new Person(1,true,false,false,false,false,false,false);
        staff.add(person);
        person = new Person(2,false,true,false,false,false,false,false);
        staff.add(person);
        person = new Person(3,false,false,false,false,true,false,false);
        staff.add(person);
        person = new Person(4,false,false,true,false,false,false,false);
        staff.add(person);
        printStaff(staff);
    }

    public static void printStaff (List<Person> staff)
    {
        for (Person person : staff)
        {
            System.out.print(person.getId() + " ");
            if (person.is_director())
                System.out.print("Директор ");
            if (person.is_accountant())
                System.out.print("Бухгалтер ");
            if (person.is_cleaner())
                System.out.print("Уборщик ");
            if (person.is_designer())
                System.out.print("Дизайнер ");
            if (person.is_manager())
                System.out.print("Менеджер ");
            if (person.is_programmer())
                System.out.print("Программист ");
            if (person.is_tester())
                System.out.print("Тестировщик");
            System.out.println();
        }
    }
}
