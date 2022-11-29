package HEStud.FileInstrument;

import HEStud.Models.MaxInfo;
import HEStud.Util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteJson {

    private static final Logger logger = Logger.getLogger(WriteJson.class.getName());

    private WriteJson() {
    }

    public static void writeJsonReq(MaxInfo MaxInfo) {

        logger.log(Level.INFO, "JSON запись началась");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Каталог успешно создан");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Каталог уже существует", ioEx);
        }

        writeStudents(MaxInfo);
        writeUniversities(MaxInfo);
        writeStatisticsList(MaxInfo);

        logger.log(Level.INFO, "JSON запись успешно завершена");
    }

    private static void writeStudents(MaxInfo MaxInfo) {
        String studentsJson = JsonUtil.writeJson(MaxInfo.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/students" + MaxInfo.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON запись не удалась", e);
        }
    }

    private static void writeUniversities(MaxInfo MaxInfo) {
        String universitiesJson = JsonUtil.writeJson(MaxInfo.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + MaxInfo.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON запись не удалась", e);
        }
    }

    private static void writeStatisticsList(MaxInfo MaxInfo) {
        String studentsJson = JsonUtil.writeJson(MaxInfo.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + MaxInfo.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON запись не удалась", e);
        }
    }
}
