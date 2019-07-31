package compare;

import lombok.Data;

import java.util.Set;
import java.util.TreeSet;

@Data
class Person{
    private String name;
    private Integer age;

}
public class CompareTest {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>();
    }
}
