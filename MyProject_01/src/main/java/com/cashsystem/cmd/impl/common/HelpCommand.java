package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;
import com.cashsystem.cmd.impl.Commands;
import com.cashsystem.entity.Account;

import java.util.*;

import static sun.misc.Version.print;

@CommandMeta(
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
//        System.out.println("helpCommand");
        Account account = subject.getAccount();
        if (account == null){
            entranceHelp();
        }else {
            switch (account.getAccountType()){
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
    public void entranceHelp(){
        print("欢迎",Commands.ENTRANCE_COMMANDS.values());
    }

    public void customerHelp(){
        print("客户端",Commands.CUSTOMER_COMMANDS.values());
    }

    public void adminHelp(){
        print("管理端",Commands.ADMIN_COMMANDS.values());
    }


    public void print(String title, Collection<Command> collection){

        System.out.println("*************"+title+"*************");

        Map<String,List<String>> helpInfo = new HashMap<>();

        for (Command command:collection) {
            CommandMeta commandMeta = command.getClass().getDeclaredAnnotation(CommandMeta.class);
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
