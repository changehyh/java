/**
 * 1. enum Color 类
 * 2. 枚举类  继承Enum
 */

public enum Color implements IColor {
    RED("红色", "#ff0000"),
    GREEN("绿色", "#0ff00"),
    BLACK("黑色", "#00000"),
    BLUE("蓝色", "#0000ff"); //枚举常量

    private String title;
    private final String rgb;
    private  static String Message = "Hello";

    Color(String title, String rgb) {
        this.title = title;
        this.rgb = rgb;
    }


    public static void main(String[] args) {
//     Color color = Color.RED;
//     Color color1= Color.GREEN;
//     Color color2= Color.BLUE;
//     System.out.println(color.name());
//        System.out.println(color2.ordinal());
        //输出所有枚举常量
//        Color[] colors = Color.values();
//        for (Color color:colors) {
//            System.out.println(color);
//        }
        //2、通过枚举常量的名字（String) 获取枚举常量对象
//        Color color = Color.valueOf("RED");
//        System.out.println(color);
        // System.out.println(Color.valueOf("red"));
//        Color color = Enum.valueOf(Color.class, "BLUE");
//        System.out.println(color);
//        for (Color color : Color.values()) {
//            System.out.println(color);//toString()
//        }
//
//        Color color = Color.BLUE;
//        switch (color) {
//            case RED:
//                System.out.println("中国色");
//                break;
//            case BLUE:
//                System.out.println("澳大利亚");
//                break;
//            case BLACK:
//                System.out.println(" ");
//                break;
//            case GREEN:
//                System.out.println();
//            default:
//        }

        //JDK7之前不支持switch JDK7支持switch
        //不可变，unicode
        //"一"代表 "\u4e00"
        String message = "一";
        switch (message) {
            case "一": {
                System.out.println("ok");
                break;
            }
            default: {
                System.out.println("default");
            }
        }
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
            return this.name()
                    + " " + this.title +
                    " rgb(" + this.rgb() + ")";
    }

    //成员方法
    public void print() {
        System.out.println(this);
    }

    @Override
    public String rgb() {
        return null;
    }

}

interface IColor {
    String rgb();
}