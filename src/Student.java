public class Student implements Comparable<Student> {
    private String name;
    private double gpa;
    private int age;

    public Student(String name, double gpa, int age) {
        this.name = name;
        this.gpa = gpa;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    public void setGpa(double newGpa) {
        this.gpa = newGpa;
    }

    // TODO: Task 1 (Sorting) — Реализуй Comparable по GPA (по возрастанию)
    @Override
    public int compareTo(Student other) {
        // заглушка — верни правильное значение сравнения
        return Double.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return "Name: "+name+" gpa: "+gpa+" age "+age;
    }
}