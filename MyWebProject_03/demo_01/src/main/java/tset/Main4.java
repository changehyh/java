package tset;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String ip = scanner.nextLine();
            String p = scanner.nextLine();
            System.out.println(ipToLong(ip));
            TenToIp(p);
        }
    }

    public static void TenToIp(String p) {
        long temp = Long.parseLong(p);
        String ip = Long.toBinaryString(temp);
        StringBuilder sb = new StringBuilder();
        if (ip.length() < 32) {
            for (int i = 0; i < (32 - ip.length()); i++) {
                sb.append(0);
            }
            sb.append(ip);
        } else if (ip.length() == 32) {
            sb.append(ip);
        }
        for (int i = 0; i < sb.length() - 8; i = i + 8) {
            System.out.print(Integer.parseInt(sb.substring(i, i + 8), 2) + ".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length() - 8, sb.length()), 2));
    }

    public static long IpToTen(String ip) {
        String[] str = ip.split("\\.");
        long n = Long.parseLong(str[0]);
        for (int i = 0; i < str.length; i++) {
            n = n << 8;
            n = n + Long.parseLong(str[i]);
        }
        return n;
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(ipToLong(str));
            Long longs = scanner.nextLong();
            System.out.println(longToIp(longs));
        }
//        Long s = new Long(167773121);
//        String s1 = new String("10.0.3.193");
//        System.out.println(longToIp(s));
//        System.out.println(ipToLong(s1));
    }
    public static String longToIp(long ipLong) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipLong >>> 24);
        sb.append(".");
        sb.append(String.valueOf((ipLong & 0x00FFFFFF) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((ipLong & 0x0000FFFF) >>> 8));
        sb.append(".");
        sb.append(String.valueOf(ipLong & 0x000000FF));
        return sb.toString();
    }
    public static long ipToLong(String ipString){
        long result = 0;
        java.util.StringTokenizer token = new java.util.StringTokenizer(ipString,".");
        result += Long.parseLong(token.nextToken())<<24;
        result += Long.parseLong(token.nextToken())<<16;
        result += Long.parseLong(token.nextToken())<<8;
        result += Long.parseLong(token.nextToken());
        return result;
    }
}