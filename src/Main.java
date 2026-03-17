
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Student> students = new HashMap<>();

        // ====================== TASK 1 ======================
        System.out.println("\n=== Task 1 ===");
        Student s1 = new Student("Mira",4.0, 18);
        Student s2 = new Student("Bina",4.0, 18);
        Student s3 = new Student("Cico",4.0, 18);
        Student s4 = new Student("Sara",4.0, 18);
        Student s5 = new Student("Charli",4.0, 18);

        students.put("12345",s1);
        students.put("12346",s2);
        students.put("12347",s3);
        students.put("12348",s4);
        students.put("12349",s5);

        // TODO: Напечатай всех студентов (ID + объект)
        for (Map.Entry<String, Student> s : students.entrySet()){
            System.out.println("ID: "+s.getKey()+" "+s.getValue().toString());
        }

        // TODO: Найди студента по ID и выведи его
        String id = "12345";
        for (Map.Entry<String, Student> s: students.entrySet()){
            if(s.getKey().equals(id)){
                System.out.println(s.getValue().toString());
            }
        }

        // TODO: Удали одного студента по ID
        System.out.println("Remove: "+ students.remove(id));

        // TODO: Обнови GPA у одного студента
        Student s = students.get("12348");
        if (s != null){
            s.setGpa(3.8);
        }

        // TODO: Создай ArrayList из всех студентов (students.values())
        ArrayList<Student> newStudents = new ArrayList<>();
        for (Map.Entry<String, Student> st : students.entrySet()){
            newStudents.add(st.getValue());
        }

        Main main = new Main();
        // TODO 6a: Отсортируй по GPA (natural ordering) и выведи

        main.sortAndPrintMap(students);

        // TODO 6b: Отсортируй по имени (Comparator) и выведи

        main.sortStudentName(students);

        System.out.println("\n=== Task 2: Top 3 by GPA ===");
        // TODO: Создай новый список, отсортируй по GPA по убыванию, выведи первые 3

        main.topThreeGpa(students);

        System.out.println("\n=== Task 3: Students with same GPA ===");
        // TODO: Сгруппируй студентов по GPA и выведи только те, где больше 1 студента

        main.taskGroupManual(students);

        System.out.println("\n=== Task 4: Courses ===");
        HashMap<Course, List<Student>> courseMap = new HashMap<>();
        // TODO: Создай 2–3 курса, добавь студентов, выведи всё
        Course c1 = new Course("CS");
        Course c2 = new Course("Pl");
        Course c3 = new Course("DM");

        courseMap.put(c1, new ArrayList<>(List.of(s1, s2, s3)));
        courseMap.put(c2, new ArrayList<>(List.of(s2, s4)));
        courseMap.put(c3, new ArrayList<>(List.of(s1, s5)));

        for (Map.Entry<Course, List<Student>> entry : courseMap.entrySet()) {

            Course course = entry.getKey();
            List<Student> studen = entry.getValue();

            System.out.println(course + ":");

            for (Student ss : studen) {
                System.out.println("  - " + ss.getName() + " (GPA: " + ss.getGpa() + ")");
            }
        }

        System.out.println("\n=== Task 5: GPA desc + Name ===");
        // TODO: Создай Comparator (GPA убывание → если равно, то имя возрастание) и отсортируй
        main.task5(students);
    }

    public void sortAndPrintMap(HashMap<String, Student> map) {
        List<Map.Entry<String, Student>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue());

        list.forEach(entry -> System.out.println(entry.getValue()));
    }
    public void sortStudentName(HashMap<String, Student> map){
        List<Map.Entry<String, Student>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.comparing(Student::getName)));

        list.forEach(entry -> System.out.println(entry.getValue()));
    }
    public void topThreeGpa(HashMap<String, Student> map){
        List<Map.Entry<String, Student>> list = new ArrayList<>(map.entrySet());

        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (int i =0;i<3;i++) {
            System.out.println(list.get(i).getValue());
        }
    }
    public void taskGroupManual(HashMap<String, Student> map){
        HashMap<Double, List<Student>> groups = new HashMap<>();

        for (Student s: map.values()){
            double gpa = s.getGpa();

            groups.putIfAbsent(gpa, new ArrayList<>());

            groups.get(gpa).add(s);
        }

        for (Map.Entry<Double, List<Student>> entry:groups.entrySet()){
            if (entry.getValue().size() > 1){
                System.out.println("GPA: " + entry.getKey() + " -> " + entry.getValue());
            }
        }
    }
    public void task5(HashMap<String, Student> map){
        List<Map.Entry<String, Student>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b)->{
            Student s1 = a.getValue();
            Student s2 = b.getValue();

            int res = Double.compare(s2.getGpa(), s1.getGpa());
            if(res == 0){
                return s1.getName().compareTo(s2.getName());
            }
            return res;
        });
        for(Map.Entry<String, Student> e : list) {
            System.out.println(e.getValue());
        }
    }
}
