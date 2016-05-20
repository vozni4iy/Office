/**
 * Created by Admin on 20.05.2016.
 */
public enum Salary {
    DIRECTOR (3000), ACCOUNTANT(1000), CLEANER(0), DESIGNER(0), MANAGER(500), PROGRAMMER(0), TESTER(0);

    private int salary;

    Salary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }
}
