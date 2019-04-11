import java.util.Scanner;

abstract class OnlineShopping {

    public final void browseGoods() {
        System.out.println("1、浏览商品");
    }

    public final void selectGoods() {
        System.out.println("2、选择商品");
    }

    public abstract void callService();

    public final void computerPrice() {
        System.out.println("4、结算");
    }

    public abstract void orderPay();

    public abstract void sendService();

    public final void showOrder() {
        System.out.println("7、查看订单");
    }

    final void process() {
        browseGoods();
        selectGoods();
       if (isCallService()) {
           callService();
      }
        computerPrice();
        orderPay();
        sendService();
        showOrder();
    }
    public boolean isCallService() {
        return  true;
    }

}
class Jd extends OnlineShopping {


        @Override
        public void callService() {
            System.out.println("3、您好，京东客服为您服务");
        }
        public String getAnswer(){
        System.out.println("请问您需要客服服务吗？要：y 不要：n");
            Scanner scanner=new Scanner(System.in);
            String str=scanner.nextLine();
            return str;
        }
        public boolean isCallService() {
            String str = getAnswer();
            if (str.equals("y")) {
                return true;
            } else
                return false;

        }
        @Override
        public void orderPay() {
            System.out.println("5、微信支付");
        }

        @Override
        public void sendService() {
            System.out.println("6、京东配送");
        }


    }
//       class TianMao extends onlineShopping {
//           @Override
//           public void callService() {
//
//           }
//
//           @Override
//           public void orderPay() {
//
//           }
//
//           @Override
//           public void sendService() {
//
//           }
//       }
public class TestDemo1{
    public static void main(String[] args) {
        OnlineShopping onlineShopping=new Jd();
         onlineShopping.process();
//        Jd jd=new Jd();
//        jd.process();
    }
}
