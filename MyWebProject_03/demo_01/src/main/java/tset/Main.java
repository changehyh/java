package tset;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            Double d = in.nextDouble();
            System.out.println(getUppercase(d));
        }
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double[] num = new double[n];
            double[] sum = new double[n];
            double sumnum = 0;
            double sumsum = 0;
            for (int i = 0; i < num.length; i++) {
                num[i] = sc.nextInt();
                sumnum += num[i];
            }
            for (int j = 0; j < sum.length; j++) {
                int temp = sc.nextInt();
                if (temp >= 90 && temp <= 100) {
                    sum[j] = num[j] * 4.0;
                }
                if (temp >= 85 && temp <= 89) {
                    sum[j] = num[j] * 3.7;
                }
                if (temp >= 82 && temp <= 84) {
                    sum[j] = num[j] * 3.3;
                }
                if (temp >= 78 && temp <= 81) {
                    sum[j] = num[j] * 3.0;
                }
                if (temp >= 75 && temp <= 77) {
                    sum[j] = num[j] * 2.7;
                }
                if (temp >= 72 && temp <= 74) {
                    sum[j] = num[j] * 2.3;
                }
                if (temp >= 68 && temp <= 71) {
                    sum[j] = num[j] * 2.0;
                }
                if (temp >= 64 && temp <= 67) {
                    sum[j] = num[j] * 1.5;
                }
                if (temp >= 60 && temp <= 63) {
                    sum[j] = num[j] * 1.0;
                }
                if (temp < 60) {
                    sum[j] = num[j] * 0;
                }
                sumsum += sum[j];
            }
            System.out.printf("%.2f", sumsum / sumnum);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[] score = new int[N];
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
            }
            for (int i = 0; sc.hasNext() && i < M; i++) {
                char c = sc.next().toCharArray()[0];
                int A = sc.nextInt();
                int B = sc.nextInt();
                opeartor(score, c, A, B);
            }
        }
    }

    private static void opeartor(int[] score, char c, int a, int b) {
        if (c == 'Q') {
            int begin = (a < b ? a : b) - 1;
            int end = a > b ? a : b;
            int max = score[begin];
            for (int i = begin; i < end; i++) {
                if (score[i] > max) {
                    max = score[i];
                }
            }
            System.out.println(max);
        } else if (c == 'U') {
            score[a - 1] = b;
        }
    }

    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = 0;
        int ability = 0;

        while (scan.hasNext()) {
            num = scan.nextInt();
            ability = scan.nextInt();
            for (int i = 0; i < num; ++i) {
                int monster = scan.nextInt();
                if (monster <= ability)
                    ability += monster;
                else
                    ability += GCD(ability, monster);
            }
            System.out.println(ability);
        }
        scan.close();
    }

    public static int GCD(int a, int b) {
        int temp;
        while (b > 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    private static String getUppercase(Double d) {
        StringBuilder sb = new StringBuilder();
        sb.append("人民币");
        String str = String.valueOf(d);
        String str1 = str.substring(0, str.indexOf('.'));
        if (!str1.equals("0")) {
            int length = str1.length();
            int n = 1;
            String[] strs = new String[length];
            while (length > 0) {
                String string = convertToUpper(str1.substring(length - 1, length));
                switch (n % 4) {
                    case 1:
                        int n1 = n / 4;
                        if (n1 == 0) {
                            strs[n - 1] = string + "元";
                        } else {
                            if (n1 % 2 == 0) {
                                strs[n - 1] = string + "亿";
                            } else {
                                strs[n - 1] = string + "万";
                            }
                        }
                        break;
                    case 2:
                        if (!string.equals("零")) {
                            strs[n - 1] = string + "拾";
                        } else {
                            strs[n - 1] = "零";
                        }
                        break;
                    case 3:
                        if (!string.equals("零")) {
                            strs[n - 1] = string + "佰";
                        } else {
                            strs[n - 1] = "零";
                        }
                        break;
                    case 0:
                        if (!string.equals("零")) {
                            strs[n - 1] = string + "仟";
                        } else {
                            strs[n - 1] = "零";
                        }
                        break;
                    default:
                        break;
                }

                n++;
                length--;
            }
            for (int i = strs.length - 1; i >= 0; i--) {
                sb.append(strs[i]);
            }
        }
        String str2 = str.substring(str.indexOf('.') + 1);
        if (str2.equals("0")) {
            sb.append("整");
        } else {
            sb.append(convertToUpper(str2.substring(0, 1)) + "角");
            sb.append(convertToUpper(str2.substring(1)) + "分");
        }

        String result = sb.toString();
        while (result.contains("零零")) {
            result = result.replace("零零", "零");
        }
        result = result.replace("零亿", "亿");
        result = result.replace("零万", "万");
        result = result.replace("零元", "元");

        return result;
    }
    public static String convertToUpper(String c) {
        String rString = "";
        switch (Integer.valueOf(c)) {
            case 0:
                rString = "零";
                break;
            case 1:
                rString = "壹";
                break;
            case 2:
                rString = "贰";
                break;
            case 3:
                rString = "叁";
                break;
            case 4:
                rString = "肆";
                break;
            case 5:
                rString = "伍";
                break;
            case 6:
                rString = "陆";
                break;
            case 7:
                rString = "柒";
                break;
            case 8:
                rString = "捌";
                break;
            case 9:
                rString = "玖";
                break;
            default:
                rString = "";
                break;
        }
        return rString;
    }
}