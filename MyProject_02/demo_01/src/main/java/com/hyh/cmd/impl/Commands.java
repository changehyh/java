package com.hyh.cmd.impl;

import com.hyh.cmd.Command;
import com.hyh.cmd.annotation.AdminCommand;
import com.hyh.cmd.annotation.CommandMete;
import com.hyh.cmd.annotation.CustomerCommand;
import com.hyh.cmd.annotation.EntranceCommand;
import com.hyh.cmd.impl.account.AccountBrowseCommand;
import com.hyh.cmd.impl.account.AccountPasswordResetCommand;
import com.hyh.cmd.impl.account.AccountStatusSetCommand;
import com.hyh.cmd.impl.common.AboutCommand;
import com.hyh.cmd.impl.common.HelpCommand;
import com.hyh.cmd.impl.common.QuitCommand;
import com.hyh.cmd.impl.entrance.LoginCommand;
import com.hyh.cmd.impl.entrance.RegisterCommand;
import com.hyh.cmd.impl.goods.GoodsBrowseCommand;
import com.hyh.cmd.impl.goods.GoodsPutAwayCommand;
import com.hyh.cmd.impl.goods.GoodsSoldOutCommand;
import com.hyh.cmd.impl.goods.GoodsUpdateCommand;
import com.hyh.cmd.impl.order.OrderBrowseCommand;
import com.hyh.cmd.impl.order.OrderPayCommand;

import java.util.*;

public class Commands {
    public static final Map<String, Command> ADMIN_COMMANDS = new HashMap<>();
    public static final Map<String, Command> CUSTOMER_COMMANDS = new HashMap<>();
    public static final Map<String, Command> ENTRANCE_COMMANDS = new HashMap<>();

    private static final Set<Command> COMMANDS = new HashSet<>();

    private static final Command CACHED_HELP_COMMANDS;
    static {
        Collections.addAll(COMMANDS,
                new AccountBrowseCommand(),
                new AccountPasswordResetCommand(),
                new AccountStatusSetCommand(),
                new AboutCommand(),
                CACHED_HELP_COMMANDS = new HelpCommand(),
                new QuitCommand(),
                new LoginCommand(),
                new RegisterCommand(),
                new GoodsBrowseCommand(),
                new GoodsPutAwayCommand(),
                new GoodsSoldOutCommand(),
                new GoodsUpdateCommand(),
                new OrderBrowseCommand(),
                new OrderPayCommand()
        );
        for (Command command:COMMANDS) {

            //利用反射 将命令分类到不同的map
            Class<?> cls = command.getClass();

            AdminCommand adminCommand = cls.getDeclaredAnnotation(AdminCommand.class);
            CustomerCommand customerCommand = cls.getDeclaredAnnotation(CustomerCommand.class);
            EntranceCommand entranceCommand = cls.getDeclaredAnnotation(EntranceCommand.class);
            CommandMete commandMeta = cls.getDeclaredAnnotation(CommandMete.class);

            if (commandMeta == null){
                continue;
            }
            String commandKey = commandMeta.name();
            if (adminCommand != null){
                ADMIN_COMMANDS.put(commandKey,command);
            }
            if (customerCommand != null){
                CUSTOMER_COMMANDS.put(commandKey,command);
            }
            if (entranceCommand != null){
                ENTRANCE_COMMANDS.put(commandKey,command);
            }
        }
    }

    public static Command getCachedHelpCommands(){
        return CACHED_HELP_COMMANDS;
    }
    public static Command getAdminCommand(String commandKey){
        return getCommand(commandKey,ADMIN_COMMANDS);
    }
    public static Command getCustomerCommand(String commandKey){
        return getCommand(commandKey,CUSTOMER_COMMANDS);
    }
    public static Command getEntranceCommand(String commandKey){
        return getCommand(commandKey,ENTRANCE_COMMANDS);
    }
    public static Command getCommand(String commandKey, Map<String, Command> commandMap){
        //遍历相应的Map。根据commandkey,得到对应的value值
        return commandMap.getOrDefault(commandKey,CACHED_HELP_COMMANDS);
    }
}
