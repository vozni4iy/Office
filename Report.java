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
        File file = new File("report.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            String header = "Отчет за март 2020 года ООО Ноунейм";
            bw.write(header);
            bw.newLine();
            bw.newLine();
            for (CompleteTask ctask : completeTaskList)
            {
                bw.write(ctask.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
