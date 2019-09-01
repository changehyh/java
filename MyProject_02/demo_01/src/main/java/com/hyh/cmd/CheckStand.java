package com.hyh.cmd;

import com.hyh.cmd.impl.AbstractCommand;
import com.hyh.cmd.impl.Commands;
import com.hyh.vo.Account;

public class CheckStand extends AbstractCommand {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new CheckStand().execute(subject);
    }

    @Override
    public void execute(Subject subject) {
        Commands.getCachedHelpCommands().execute(subject);
        while (true){
            System.out.println(">>>");
            String line = scanner.nextLine();
            String commandCode = line.trim().toUpperCase();
            Account account = subject.getAccount();
            if (account == null){
                Commands.getEntranceCommand(commandCode).execute(subject);
            }else {
                switch (account.getAccountTyp()){
                    case ADMIN:
                        Commands.getAdminCommand(commandCode).execute(subject);
                        break;
                    case CUSTOMER:
                        Commands.getCustomerCommand(commandCode).execute(subject);
                        break;
                    default:
                }
            }
        }
    }
}
