package module2.lecture8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class University {
    private final List<Group> groups = new ArrayList<>();

    public static void main(String[] args) {
        final University university = new University();
        for (int i = 0; i < 5; i++) {
            university.addGroup();
        }
        university.applyStudents(50);

        System.out.println(university);
        university.groups.stream()
                .flatMap(u -> u.students.stream())
                .filter(s -> s.age > 40)
                .forEach(System.out::println);

        final List<String> list = university.groups.stream()
                .sorted(Comparator.comparingInt(Group::getGroupNumber).reversed())
                .map(g -> "Group name: " + g.name)
                .toList();
        System.out.println(list);

        university.groups.stream()
                .flatMap(g -> g.students.stream())
                .collect(Collectors.toMap(
                        student -> student.age,
                        student -> 1,
                        Integer::sum
                )).entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .forEach(System.out::println);
    }

    private void applyStudents(final int studentsCount) {
        final int maxStudentCountPerGroup = studentsCount / groups.size();

        for (int i = 0; i < studentsCount; i++) {
            Collections.shuffle(groups);
            groups.stream()
                    .filter(group -> group.students.size() < maxStudentCountPerGroup)
                    .findFirst()
                    .ifPresent(Group::addStudent);
        }
    }

    private void addGroup() {
        final Group group = new Group();
        groups.add(group);
    }

    @Override
    public String toString() {
        return "University{" +
                "groups=" + groups +
                '}';
    }

    static class Group {
        private static int count = 0;

        private final String name;

        private final List<Student> students = new ArrayList<>();

        public Group() {
            name = "Group " + count++;
        }

        private void addStudent() {
            final Student student = new Student();
            students.add(student);
        }

        int getGroupNumber() {
            final int start = name.length() - 1;
            return Integer.parseInt(name.substring(start));
        }

        @Override
        public String toString() {
            return "Group{" +
                    "groups=" + students +
                    ", name='" + name + '\'' +
                    "}\n";
        }
    }

    static class Student {
        private static final Random RANDOM = new Random();

        private static int count = 0;

        private final String name;

        private final int age;

        public Student() {
            this.name = "Student " + count++;
            this.age = RANDOM.nextInt(18, 50);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
