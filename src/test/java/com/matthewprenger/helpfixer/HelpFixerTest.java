package com.matthewprenger.helpfixer;

import static com.matthewprenger.helpfixer.HelpFixer.validCompareTo;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import org.junit.jupiter.api.Test;

public class HelpFixerTest {

    @Test
    public void testValidCompareTo() {
        ICommand cmd1 = new CommandBase() {

            @Override
            public String getCommandName() {
                return "foo";
            }

            @Override
            public String getCommandUsage(ICommandSender sender) {
                return null;
            }

            @Override
            public void processCommand(ICommandSender sender, String[] args) {}

            @Override
            public int compareTo(Object p_compareTo_1_) {
                return 0;
            }
        };

        ICommand cmd2 = new CommandBase() {

            @Override
            public String getCommandName() {
                return "foo";
            }

            @Override
            public String getCommandUsage(ICommandSender sender) {
                return null;
            }

            @Override
            public void processCommand(ICommandSender sender, String[] args) {}

            @Override
            public int compareTo(ICommand p_compareTo_1_) {
                return 0;
            }
        };

        ICommand cmd3 = new CommandBase() {

            @Override
            public String getCommandName() {
                return "z";
            }

            @Override
            public String getCommandUsage(ICommandSender sender) {
                return null;
            }

            @Override
            public void processCommand(ICommandSender sender, String[] args) {}
        };

        assertFalse(validCompareTo(cmd1));
        assertFalse(validCompareTo(cmd2));
        assertTrue(validCompareTo(cmd3));
    }
}
