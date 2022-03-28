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
package com.automationanywhere.botcommand.samples.commands.conditionals;

import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationanywhere.commandsdk.annotations.BotCommand.CommandType.Condition;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;


@BotCommand(commandType = Condition)
@CommandPkg(
        label = "StringHasOnlyNumbers",
        name = "StringHasOnlyNumbers",
        description = "[[StringHasOnlyNumbers.description]]",
        node_label = "[[StringHasOnlyNumbers.node_label]]"
)
public class StringHasOnlyNumbers {

    @ConditionTest
    public Boolean validate(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[StringHasOnlyNumbers.value.label]]",description = "[[StringHasOnlyNumbers.value.description]]")
            @NotEmpty
                    String value
    ) {


        Pattern p = Pattern.compile("[0-9]+");

        if (value == null) {
            return false;
        }

        Matcher m = p.matcher(value);

        return m.matches();
    }

}
