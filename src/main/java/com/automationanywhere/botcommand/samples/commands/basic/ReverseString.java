package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "ReverseString",
        name = "ReverseString",
        description = "[[ReverseString.description]]",
        node_label = "[[SortString.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)

public class ReverseString {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[ReverseString.value.label]]",description = "[[ReverseString.value.description]]")
            @NotEmpty
                    String value
    ) {

        StringBuilder sb=new StringBuilder(value);
        sb.reverse();

        return new StringValue(sb.toString());
    }


}
