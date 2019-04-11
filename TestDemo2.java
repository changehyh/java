abstract class BankTemplate{
    public final void takeNumber(){
        System.out.println("1、取号");
    }
    public abstract void transact();
    public final void evaluate(){
        System.out.println("3、业务评价");
    }
    final void process(){
        takeNumber();
        transact();
        if(isEvaluate()){
            evaluate();
        }
    }
    public boolean isEvaluate(){
        return true;
    }
}
class User1 extends BankTemplate{

    @Override
    public void transact() {
        System.out.println("2、我要取一个亿");
    }

    @Override
    public boolean isEvaluate() {
        return false;
    }
}
class User2 extends BankTemplate{

    @Override
    public void transact() {
        System.out.println("2、我要存十个亿");
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        BankTemplate bankTemplate=new User1();
        bankTemplate.process();
        BankTemplate bankTemplate2=new User2();
        bankTemplate2.process();

    }


}
