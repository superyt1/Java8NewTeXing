package lamda012;

public class Employee {
    public String id;
    public String name;
    public Integer age;
    public Status status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    public Employee(String id, String name, Integer age, Status status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.status = status;
    }


}
