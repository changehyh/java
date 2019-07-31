package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("hello");
        list.add("java");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("bit")){
                list.remove("bit");
            }
            System.out.println(str);
        }
    }
}
