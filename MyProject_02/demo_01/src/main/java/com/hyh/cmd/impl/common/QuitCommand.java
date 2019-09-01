package com.hyh.cmd.impl.common;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.AbstractCommand;

@CommandMete(
        name = "TCXT",
        desc = "退出系统",
        group = "公共命令"
)
@CustomerCommand
@AdminCommand
@EntranceCommand

public class QuitCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("系统已退出");
        this.scanner.close();
        System.exit(0);//正常退出
    }
}
