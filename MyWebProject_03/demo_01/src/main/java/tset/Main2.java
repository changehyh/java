package tset;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int num = in.nextInt();
            LinkedHashMap<String,Integer> map = new LinkedHashMap<String, Integer>();
            in.nextLine();
            String str = in.nextLine();
            String[] array = str.split(" ");
            for (int i = 0; i < array.length; i++) {
                map.put(array[i],0);
            }
            map.put("Invalid",0);

            int m = in.nextInt();
            in.nextLine();
            String str1 = in.nextLine();
            String[] array1 = str1.split(" ");
            for (String s : array1) {
                if (map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Set<String> set = map.keySet();
            for(String s : set){
                System.out.println(s+ ":"+map.get(s));
            }
        }
    }
}
