package com.hyh.cmd.impl.entrance;
import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.common.AccountStatus;
import com.hyh.vo.Account;


@CommandMete(
        name = "DL",
        desc = "登录",
        group = "入口命令"
)
@EntranceCommand
public class LoginCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if (account != null){
            System.out.println("您已经登录过");
        }
        System.out.println("输入用户名：");
        String username = scanner.nextLine();
        System.out.println("输入密码：");
        String password = scanner.nextLine();
        //解析的account
        account = this.accountService.login(username,password);

        if (account != null && account.getAccountStatus()==AccountStatus.UNLOCK){
            System.out.println(account.getAccountTyp() + "登录成功");
            subject.setAccount(account);
        }else {
            System.out.println("密码或者用户名错误");
        }
    }
}
