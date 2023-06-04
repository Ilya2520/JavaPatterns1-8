package prac5;

public class Sun {
    private String Name;
    private static final Sun instance = new Sun();

    private Sun(){
        Name="Sun";
    }

    public static Sun getInstance() {
        return instance;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "Name='" + Name + '\'' +
                '}';
    }
}
