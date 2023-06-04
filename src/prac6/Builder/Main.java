package prac6.Builder;

interface Builder{
    Builder hasCar(boolean car);
    Builder hasHouse(boolean house);
    Human build();
}



class HumanBuilder implements Builder{
    String name;
    int age;
    boolean hasCar;
    boolean hasHouse;

    public HumanBuilder(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public HumanBuilder hasCar(boolean car) {
        this.hasCar=car;
        return this;
    }

    @Override
    public HumanBuilder hasHouse(boolean house) {
        this.hasHouse=house;
        return this;
    }

    public Human build(){
        return new Human(this);
    }

}

class Human{
    int age;
    String name;
    Boolean hasCar;
    Boolean hasHouse;

    public Human(HumanBuilder humanBuilder) {
        this.age = humanBuilder.age;
        this.name = humanBuilder.name;
        this.hasCar = humanBuilder.hasCar;
        this.hasHouse = humanBuilder.hasHouse;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hasCar=" + hasCar +
                ", hasHouse=" + hasHouse +
                '}';
    }
}

class Director{
    public void create(Builder builder,boolean hasCar,boolean hasHouse){
        builder.hasCar(hasCar).hasHouse(hasHouse);
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        HumanBuilder builder = new HumanBuilder("Andrey",18);
        director.create(builder,false,true);
        System.out.println(builder.build().toString());
    }
}
