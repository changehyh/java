package com.cashsystem.cmd;
import java.util.*;
public interface Command {
    Scanner scanner = new Scanner(System.in);

    void execute(Subject subject);
}
