package module3.lecture15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        final List<Map<String, Object>> dataFromDB = getDataFromDB();
        for (Map<String, Object> stringObjectMap : dataFromDB) {

        }
    }

    private static List<Map<String, Object>> getDataFromDB() {
        final Map<String, Object> stringObjectHashMap1 = new HashMap<>();
        final Map<String, Object> stringObjectHashMap2 = new HashMap<>();
        final Map<String, Object> stringObjectHashMap3 = new HashMap<>();
        return List.of(stringObjectHashMap1, stringObjectHashMap2, stringObjectHashMap3);
    }

    static class Student {
        private StudentTicket ticket;
        private List<Book> books;
        private List<Course> courses;
    }

    static class StudentTicket{
        private Student student;
    }

    static class Book {
        private Student student;
    }

    static class Course {
        private List<Student> students;
    }
}
