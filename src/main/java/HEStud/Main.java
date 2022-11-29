package HEStud;

import HEStud.Comparators.StudComparator;
import HEStud.Comparators.UniverComparator;
import HEStud.Enums.StudEnum;
import HEStud.Enums.UniverEnum;
import HEStud.FileInstrument.FileReader;
import HEStud.FileInstrument.FileWriter;
import HEStud.Models.Statistics;
import HEStud.Models.Student;
import HEStud.Models.University;
import HEStud.Util.JsonUtil;
import HEStud.Util.StatUtil;
import HEStud.Util.Utilitarian;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Не удалось настроить конфигурацию" + e.toString());
        }

        logger.log(INFO, "Приложение запущено, Logger настроен");

        List<University> universities =
                FileReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniverComparator universityComparator =
                Utilitarian.getUniversityComparator(UniverEnum.UNIVER_YEAR_OF_FOUNDATION);
        universities.sort(universityComparator);

        List<Student> students =
                FileReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudComparator studentComparator =
                Utilitarian.getStudentComparator(StudEnum.STUD_AVG_EXAM_SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatUtil.createStatistics(students, universities);
        FileWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        logger.log(INFO, "Приложение остановлено");
    }
}