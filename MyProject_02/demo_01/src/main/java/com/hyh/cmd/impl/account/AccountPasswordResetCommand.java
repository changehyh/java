package com.hyh.cmd.impl.account;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.impl.AbstractCommand;

@CommandMete(
        name = "MMCZ",
        desc = "重置密码",
        group = "账号信息"
)
@AdminCommand
public class AccountPasswordResetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println();
    }
}
