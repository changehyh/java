package com.cashsystem.cmd.impl.entrance;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.common.AccountStatus;
import com.cashsystem.common.AccountType;
import com.cashsystem.entity.Account;

@CommandMeta(
        name = "ZC",
        desc = "注册",
        group = "入口命令"
)
@EntranceCommand
public class RegisterCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {

        System.out.println("输入用户名：");
        String username = scanner.nextLine();
        System.out.println("输入密码：");
        String password1 = scanner.nextLine();
        System.out.println("请再次输入密码：");
        String password2 = scanner.nextLine();
        if (!password1.equals(password2)){
            System.out.println("您两次输入密码不一致，请重新输入");
            return;
        }
        System.out.println("请输入姓名：");
        String name = scanner.nextLine();
        System.out.println("请输入账户类型：1、管理员 2、用户");
        int accountType = scanner.nextInt();
        AccountType accountType1 = AccountType.valueOf(accountType);
        System.out.println("请输入瀛湖的状态：1、启用 2、启停");
        int accountStatus1 = scanner.nextInt();
        AccountStatus accountStatus = AccountStatus.valueOf(accountStatus1);

        final Account account = new Account();
        account.setUsername(username);
        account.setPassword(password1);
        account.setName(name);
        account.setAccountType(accountType1);
        account.setAccountStatus(accountStatus);
        boolean effect = this.accountService.register(account);
        if (effect){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }

//        Account account = subject.getAccount();
//        if (account != null){
//            System.out.println("您已经注册过");
//        }
//        System.out.println("输入用户名：");
//        String username = scanner.nextLine();
//        System.out.println("输入密码：");
//        String password1 = scanner.nextLine();
//        System.out.println("请再次输入密码：");
//        String password2 = scanner.nextLine();
//        if (!password1.equals(password1)){
//            System.out.println("您两次输入密码不一致，请重新输入");
//            return;
//        }else {
//            System.out.println("请输入用户类型，1：管理员；2：客户");
//            int item = scanner.nextInt();
//            account = this.accountService.register(username,password2,item);
//            if (account!= null && account.getAccountStatus()==AccountStatus.UNLOCK){
//                System.out.println("注册成功");
//                subject.setAccount(account);
//            }else {
//                System.out.println("注册失败");
//            }
//        }
    }
}
