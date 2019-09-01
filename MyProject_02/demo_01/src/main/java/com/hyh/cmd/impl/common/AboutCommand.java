package com.hyh.cmd.impl.common;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.vo.Account;

@CommandMete(
        name = "GYXT",
        desc = "关于系统",
        group = "公共命令"
)
@AdminCommand
@CustomerCommand
@EntranceCommand
public class AboutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("关于系统");
        System.out.println("作者：忽宇航");
        System.out.println("时间：20190808");

    }
}
