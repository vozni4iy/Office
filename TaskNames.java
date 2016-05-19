/**
 * Created by Admin on 19.05.2016.
 */
public enum TaskNames {
    ACCOUNTING ("составляю отчетность"), CLEANING("выполняю уборку в офисе"), DESIGNING ("рисую макет"),
    MANAGING ("продаю услуги"), PROGRAMMING ("пишу код"), TESTING ("тестирую программу");

    private String name;

    TaskNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
