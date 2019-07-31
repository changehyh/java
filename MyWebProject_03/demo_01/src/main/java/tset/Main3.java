package tset;

/**找x
输入一个数n，然后输入n个数值各不相同，再输入一个值x，
 输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。
*/
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] num = scanner.nextLine().split(" ");
        String x = scanner.nextLine();
        System.out.println(Arrays.asList(num).indexOf(x));
    }
}
