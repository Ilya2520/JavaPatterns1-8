package prac1;

public class Student {
    int age;
    String name;
    int sum;

    public Student(int age, String name, int sum) {
        this.age = age;
        this.name = name;
        this.sum = sum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
