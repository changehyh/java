package com.bit.src;


import javax.jws.soap.SOAPBinding;

public class Client {
    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();
        DaiLISubject daiLISubject=new DaiLISubject(realSubject);
        daiLISubject.buyComputer();

    }



}
//    public static void buyComputer(Computer computer){
//        computer.printComputer();
//    }
//    public static void Use(OperatingSystem operatingSystem){
//        operatingSystem.printSystem();
//    }

//    public static void main3(String[] args) {
//        ComputerFactory computerFactory=new MsFactory();
//        ComputerFactory computerFactory2=new AppleFactory();
//        Computer computer=computerFactory.createComputer();
//        Computer computer2=computerFactory2.createComputer();
//        OperatingSystem operatingSystem=computerFactory.createSystem();
//        OperatingSystem operatingSystem2=computerFactory2.createSystem();
//        buyComputer(computer);
//        Use(operatingSystem);
//        buyComputer(computer2);
//        Use(operatingSystem2);
//
//    }



//    public static void main2(String[] args) {
//     ComputerFactory ComputerFactory=new AppleFactory();
//     Computer computer=ComputerFactory.createComputer();
//     buyComputer(computer);
//     buyComputer(iComputerFactory.createComputer());







//    public static void main1(String[] args) {
//        System.out.println("请输入你要的电脑型号");
//        Scanner scanner=new Scanner(System.in);
//        String type=scanner.nextLine();
//        buyComputer(ComeputerFactory.getInstance(type));

//        Client client=new Client();
//        client.buyComputer(new MacBookComputer());
//        client.buyComputer(new SurfaceBookComputer());


