/*
 * Copyright (c) 2020 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */

/**
 *
 */
package com.automationanywhere.botcommand.samples.commands.variable;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.VariableExecute;
import com.automationanywhere.commandsdk.model.DataType;


@BotCommand(commandType = BotCommand.CommandType.Variable)
@CommandPkg(description = "Returns Tab Char as a String", name = "TabChar", label = "TabChar", variable_return_type = DataType.STRING)
public class TabChar {

    @VariableExecute
    public StringValue get() {
        String computedValue = "\t";
        return new StringValue(computedValue);
    }

}
