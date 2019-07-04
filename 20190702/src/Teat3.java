
import java.util.Scanner;

public class Teat3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  a =in.next();
        String b = in.next();
        if (a == null || b ==null){
            return;
        }
        String[] str1 = a.split(",");
        String[] str2 = b.split(",");
        for (int i = 0; i <str2.length ; i++) {
            for (int j = 0; j <str1.length ; j++) {
                if (str1[j].equals(str2[i])){
                    str1[j] = "";
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <str1.length ; i++) {
            if (!"".equals(str1[i])){
                stringBuffer.append(str1[i] + ",");
            }
        }
        System.out.println(stringBuffer.toString().substring(0,stringBuffer.toString().length()-1));
    }
}
