package prac5;

public class Moon {
    private String name;
    private static Moon instance;

    private Moon(){
        name="Moon";
    }

    public static Moon getInstance(){
        if(instance==null){
            instance = new Moon();
        }
        return instance;
    }

    @Override
    public String toString() {
        return "Moon{" +
                "name='" + name + '\'' +
                '}';
    }
}
