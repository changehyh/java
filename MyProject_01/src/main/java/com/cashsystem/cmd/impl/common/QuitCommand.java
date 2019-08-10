package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

@CommandMeta(
        name = "TC",
        desc = "退出系统",
        group = "公共命令"
)
@EntranceCommand
@CustomerCommand
@AdminCommand
public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("退出系统");
        scanner.close();
        System.out.println("欢迎下次使用");
        System.exit(0);

    }
}
