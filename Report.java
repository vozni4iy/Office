import java.io.*;
import java.util.List;

/**
 * Created by Admin on 14.05.2016.
 */
public class Report {

    private List<CompleteTask> completeTaskList;

    public Report(List<CompleteTask> completeTaskList) {
        this.completeTaskList = completeTaskList;
    }

    public void make()
    {
        List <Person> staff = Office.getStaff();
        List <Freelancer> freelist = WorkDay.getFreelist();
        File file = new File("report.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            String header = "Отчет за март 2020 года ООО Ноунейм";
            bw.write(header);
            bw.newLine();
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Общий доход за месяц: " + totalIncome());
            bw.newLine();
            bw.write("Почасовая оплата сотрудникам: " + hourPayments());
            bw.newLine();
            bw.write("Фиксированная оплата сотрудникам: " + salary(staff));
            bw.newLine();
            bw.write("Оплата фрилансерам: " + freelancerPayment(freelist));
            bw.newLine();
            bw.write("Постоянные издержки: " + Office.getFixedCosts());
            bw.newLine();
            bw.write("Общий баланс: " + totalBalance(staff, freelist));
            bw.newLine();
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Общий список сотрудников: ");
            bw.newLine();
            bw.write("\r\n");
            for (Person person : staff)
            {
                bw.write(person.toString());
                bw.newLine();
            }
            bw.newLine();
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Подробный отчет о каждом сотруднике ");
            bw.newLine();
            bw.write("\r\n");
            for (Person person : staff)
            {
                bw.write(person.toString());
                bw.newLine();
                bw.write("Общая стоимость выполенных заданий: " + personValue(person.getId()));
                bw.newLine();
                bw.write("Почасовая оплата за месяц: " + personHour(person.getId()));
                bw.newLine();
                bw.write("Фиксированная оплата за месяц: " + fixPerson(person));
                bw.newLine();
                bw.write("Баланс: " + personBalance(person));
                bw.newLine();
                bw.write("Задачи, выполенные сотрудником №" + person.getId() + " за месяц: ");
                bw.newLine();
                bw.write("\r\n");
                for (CompleteTask ctask : completeTaskList)
                {
                    if (ctask.getId() == person.getId()) {
                        bw.write(ctask.toString());
                        bw.newLine();
                    }
                }
                bw.write("\r\n");
            }
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Общий список фрилансеров: ");
            bw.newLine();
            bw.write("\r\n");
            for (Freelancer lancer : freelist)
            {
                bw.write(lancer.toString());
                bw.newLine();
            }
            bw.newLine();
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Подробный отчет о каждом фрилансере ");
            bw.newLine();
            bw.write("\r\n");
            for (Freelancer lancer : freelist)
            {
                bw.write(lancer.toString());
                bw.newLine();
                bw.write("Общая стоимость выполенных заданий: " + personValue(lancer.getId()));
                bw.newLine();
                bw.write("Оплата за месяц: " + personHour(lancer.getId()));
                bw.newLine();
                int bal = personValue(lancer.getId()) - personHour(lancer.getId());
                bw.write("Баланс: " + bal);
                bw.newLine();
                bw.write("Задачи, выполенные сотрудником №" + lancer.getId() + " за месяц: ");
                bw.newLine();
                bw.write("\r\n");
                for (CompleteTask ctask : completeTaskList)
                {
                    if (ctask.getId() == lancer.getId()) {
                        bw.write(ctask.toString());
                        bw.newLine();
                    }
                }
                bw.write("\r\n");
            }
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("\r\n");
            bw.write("Общий список выполенных заданий за месяц: ");
            bw.newLine();
            bw.write("\r\n");
            for (CompleteTask ctask : completeTaskList)
            {
                bw.write(ctask.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int totalIncome()
    {
        int total = 0;
        for (CompleteTask ctask : completeTaskList)
        {
            total += ctask.getValue();
        }
        return total;
    }

    private int hourPayments()
    {
        int total = 0;
        for (CompleteTask ctask : completeTaskList)
        {
            if (ctask.getId() <= 200)
                total += ctask.getPayment();
        }
        return total;
    }

    private int salary(List <Person> staff)
    {
        int total = 0;
        for (Person person : staff)
        {
            if (person.is_director()) total += Salary.DIRECTOR.getSalary();
            if (person.is_accountant()) total += Salary.ACCOUNTANT.getSalary();
            if (person.is_manager()) total += Salary.MANAGER.getSalary();
            // можно добавить еще строки, если у других профессий появится фиксированная ставка
        }
        return total;
    }

    private int freelancerPayment (List <Freelancer> freelist)
    {
        int total = 0;
        for (CompleteTask ctask : completeTaskList)
        {
            if (ctask.getId() > 200)
                total += ctask.getPayment();
        }
        return total;
    }

    private int totalBalance (List <Person> staff, List <Freelancer> freelist)
    {
        int total = totalIncome() - hourPayments() - salary(staff)
                - freelancerPayment(freelist) - Office.getFixedCosts();
        return total;
    }

    private int personValue (int id)
    {
        int total = 0;
        for (CompleteTask ctask : completeTaskList)
        {
            if (ctask.getId() == id)
                total += ctask.getValue();
        }
        return total;
    }

    private int personHour (int id)
    {
        int total = 0;
        for (CompleteTask ctask : completeTaskList)
        {
            if (ctask.getId() == id)
                total += ctask.getPayment();
        }
        return total;
    }

    private int fixPerson (Person person)
    {
        int total = 0;

            if (person.is_director()) total += Salary.DIRECTOR.getSalary();
            if (person.is_accountant()) total += Salary.ACCOUNTANT.getSalary();
            if (person.is_manager()) total += Salary.MANAGER.getSalary();
            // можно добавить еще строки, если у других профессий появится фиксированная ставка

        return total;
    }

    private int personBalance(Person person)
    {
        int total = personValue(person.getId()) - personHour(person.getId()) - fixPerson(person);
        return total;
    }


}
