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

import static com.automationanywhere.commandsdk.annotations.BotCommand.CommandType.Condition;
import static com.automationanywhere.commandsdk.model.AttributeType.*;


@BotCommand(commandType = Condition)
@CommandPkg(
        label = "StringMatches",
        name = "StringMatches",
        description = "[[StringMatches.description]]",
        node_label = "[[StringMatches.node_label]]"
)
public class StringMatches {

    @ConditionTest
    public Boolean validate(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[StringMatches.value.label]]",description = "[[StringMatches.value.description]]")
            @NotEmpty
                    String value,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "[[StringMatches.pattern.label]]",description = "[[StringMatches.pattern.description]]")
            @NotEmpty
                    String pattern
    ) {

        return value.matches(pattern);
    }

}
