package HEStud.FileInstrument;

import HEStud.Enums.StudyProfile;
import HEStud.Models.Student;
import HEStud.Models.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

private static final Logger log = Logger.getLogger(FileReader.class.getName());

    private FileReader() {
    }

    public static List<University> readXlsUniversities(String filePath) {

        List<University> universities = new ArrayList<>();

        try {

            log.log(Level.INFO, "Чтение файла началось");

            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Университеты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(currentRow.getCell(0).getStringCellValue());
                university.setFullName(currentRow.getCell(1).getStringCellValue());
                university.setShortName(currentRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(
                        StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            }

        } catch (IOException e) {
            log.log(Level.SEVERE, "Чтение файла не удалось", e);
            return universities;
        }

        log.log(Level.INFO, "Чтение файла завершено");
        return universities;
    }

    public static List<Student> readXlsStudents(String filePath) {

        List<Student> students = new ArrayList<>();

        try {

            log.log(Level.INFO, "Чтение файла началось");

            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Студенты");

            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                student.setFullName(currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            }

        } catch (IOException e) {
            log.log(Level.SEVERE, "Чтение файла не удалось", e);
            return students;
        }

        log.log(Level.INFO, "Чтение файла завершено");
        return students;
    }
}