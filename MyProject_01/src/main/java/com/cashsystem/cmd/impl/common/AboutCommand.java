package com.cashsystem.cmd.impl.common;

import com.cashsystem.cmd.Subject;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.AbstractCommand;

@CommandMeta(
        name = "GYXT",
        desc = "关于系统",
        group = "公共命令"
)
@EntranceCommand
@CustomerCommand
@AdminCommand
public class AboutCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println("*************基于字符界面的**************");
        System.out.println("*************作者：忽宇航**************");
        System.out.println("*************时间：2019/08/04**************");
    }
}
