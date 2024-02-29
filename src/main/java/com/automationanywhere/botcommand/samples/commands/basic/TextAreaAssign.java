package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Arrays;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXTAREA;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "TextAreaAssign",
        name = "TextAreaAssign",
        description = "",
        node_label = "",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class TextAreaAssign {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXTAREA)
            @Pkg(label = "Text:",description = "")
            @NotEmpty
                    String value
    ) {
        

        return new StringValue(value);
    }


}
