package com.cashsystem.cmd.impl;

import com.cashsystem.cmd.Command;
import com.cashsystem.cmd.annotation.AdminCommand;
import com.cashsystem.cmd.annotation.CommandMeta;
import com.cashsystem.cmd.annotation.CustomerCommand;
import com.cashsystem.cmd.annotation.EntranceCommand;
import com.cashsystem.cmd.impl.account.AccountBrowseCommand;
import com.cashsystem.cmd.impl.account.AccountPasswordResetCommand;
import com.cashsystem.cmd.impl.account.AccountStatusSetCommand;
import com.cashsystem.cmd.impl.common.AboutCommand;
import com.cashsystem.cmd.impl.common.HelpCommand;
import com.cashsystem.cmd.impl.common.QuitCommand;
import com.cashsystem.cmd.impl.entrance.LoginCommand;
import com.cashsystem.cmd.impl.entrance.RegisterCommand;
import com.cashsystem.cmd.impl.goods.GoodsBrowseCommand;
import com.cashsystem.cmd.impl.goods.GoodsPutAwayCommand;
import com.cashsystem.cmd.impl.goods.GoodsSoldOutCommand;
import com.cashsystem.cmd.impl.goods.GoodsUpdateCommand;
import com.cashsystem.cmd.impl.order.OrderBrowseCommand;
import com.cashsystem.cmd.impl.order.OrderPayCommand;

import java.util.*;

public class Commands {
    public static final Map<String,Command> ADMIN_COMMANDS = new HashMap<>();
    public static final Map<String,Command> CUSTOMER_COMMANDS = new HashMap<>();
    public static final Map<String,Command> ENTRANCE_COMMANDS = new HashMap<>();

    private static final Set<Command> COMMANDS = new HashSet<>();
    private static final Command CACHED_HELP_COMMANDS;
    static {
        Collections.addAll(COMMANDS,
                new AccountBrowseCommand(),
                new AccountPasswordResetCommand(),
                new AccountStatusSetCommand(),
                new AboutCommand(),
                //将HelpCommand 进行缓存
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
            CommandMeta commandMeta = cls.getDeclaredAnnotation(CommandMeta.class);

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
