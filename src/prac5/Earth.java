package prac5;

public class Earth {

    private String name;

    private Earth(){
        this.name="Earth";
    }
    private static class EarthHelper {
        private static final Earth INSTANCE = new Earth();
    }

    public static Earth getInstance() {
        return EarthHelper.INSTANCE;
    }

    @Override
    public String toString() {
        return "Earth{" +
                "name='" + name + '\'' +
                '}';
    }
}
