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
        label = "SortString",
        name = "SortString",
        description = "[[SortString.description]]",
        node_label = "[[SortString.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class SortString {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[SortString.value.label]]",description = "[[SortString.value.description]]")
            @NotEmpty
                    String value
    ) {
        char[] chars = value.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        return new StringValue(sorted);
    }


}
