package com.hyh.cmd.impl.account;

import com.hyh.cmd.Subject;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.impl.AbstractCommand;


@CommandMete(
        name = "QTZH",
        desc = "启停账号",
        group = "账号信息"
)

@AdminCommand
public class AccountStatusSetCommand extends AbstractCommand {
    @Override
    public void execute(Subject subject) {
        System.out.println();
    }
}
