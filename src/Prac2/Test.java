package Prac2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static List<Human> createList() {
        List<Human> list = new ArrayList<>();
        list.add(new Human(30,"Ivan","Victorov", LocalDate.of(1993,1,1),80));
        list.add(new Human(30,"Ivan","Sidorov", LocalDate.of(1993,1,1),88));
        list.add(new Human(25,"Ivan","Petrov", LocalDate.of(1998,1,1),60));
        list.add(new Human(33,"Ivan","Ivanov", LocalDate.of(1990,1,1),50));
        list.add(new Human(30,"Ivan","Sergeev", LocalDate.of(1993,1,1),80));
        list.add(new Human(30,"Ivan","Titov", LocalDate.of(1993,1,1),88));
        list.add(new Human(25,"Ivan","Blood", LocalDate.of(1998,1,1),60));
        list.add(new Human(33,"Ivan","Lenin", LocalDate.of(1990,1,1),50));
        return list;
    }

    public static String Test(Stream<Human> stream) {
        String res=stream.peek(a->a.setWeight(a.weight-5))
                .filter(a -> a.getBirthDate().isBefore(LocalDate.of(1999,2,1)))
                .map(a->a.lastName)
                .reduce("",(x,y)->x+" "+y);
        return res;
    }
    public static void main(String[] args) {
        Stream<Human> stream = createList().stream();
        System.out.println(Test(stream));

    }
}