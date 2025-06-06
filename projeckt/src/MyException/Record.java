package MyException;

public class Record {
    private final int id;
    private final String name;
    private final int age;
    private final String email;

    public Record(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Gettery:
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return id + ";" + name + ";" + age + ";" + email;
    }
}