package com.hyh.cmd.impl.common;

import com.hyh.cmd.Command;
import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.cmd.impl.Commands;
import com.hyh.vo.Account;

import java.util.*;

import static com.hyh.common.AccountTyp.ADMIN;
import static com.hyh.common.AccountTyp.CUSTOMER;

@CommandMete(
        name = "BZXX",
        desc = "帮助信息",
        group = "公共命令"
)
@EntranceCommand
@CustomerCommand
@AdminCommand
public class HelpCommand extends AbstractCommand {

    @Override
    public void execute(Subject subject) {
        Account account = subject.getAccount();
        if (account == null){
            entranceHelp();
        }else {
            //这里需要注意 当登录成功之后  用户看不到对应的命令信息  输入的如果是回车
            //那么在 Command getCommand  函数内 并不能返回对应信息 只会返回 CACHED_HELP_COMMAND 导致执行到这个地方
            //所以 这里需要处理。
            switch (account.getAccountTyp()) {
                case CUSTOMER:
                    customerHelp();
                    break;
                case ADMIN:
                    adminHelp();
                    break;
                default:
            }
        }
    }

    private void adminHelp() {
        print("管理员",Commands.ADMIN_COMMANDS.values());
    }

    private void customerHelp() {
        print("普通用户",Commands.CUSTOMER_COMMANDS.values());
    }

    public void entranceHelp() {
        print("欢迎",Commands.ENTRANCE_COMMANDS.values());
    }

    public void print(String title, Collection<Command> collection){

        System.out.println("*************"+title+"*************");

        Map<String,List<String>> helpInfo = new HashMap<>();

        for (Command command:collection) {
            CommandMete commandMeta = command.getClass().getDeclaredAnnotation(CommandMete.class);
            String group = commandMeta.group();//Key

            List<String> func = helpInfo.get(group);
            if (func == null){
                func=new ArrayList<>();
                helpInfo.put(group,func);
            }
            func.add(commandMeta.desc()+"("+commandMeta.name()+")");
        }
        int i = 0;
        //entrySet取出键-值对的集合  getKey  getValue
        for (Map.Entry<String,List<String>> entry: helpInfo.entrySet()) {
            i++;
            System.out.println(i + "." + entry.getKey());
            int j = 0;
            for (String item: entry.getValue()) {
                j++;
                System.out.println("\t" + (i) + "." + (j) + " " +item);
            }
        }
    }
}
