package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationanywhere.commandsdk.model.AttributeType.CHECKBOX;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.*;


@BotCommand
@CommandPkg(
        label = "GetAllMatches",
        name = "GetAllMatches",
        description = "[[GetAllMatches.description]]",
        node_label = "[[GetAllMatches.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = LIST,
        return_required = true,
        return_sub_type = STRING
)


public class GetAllMatches {

    @Execute
    public ListValue<String> action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[GetAllMatches.value.label]]",description = "[[GetAllMatches.value.description]]")
            @NotEmpty
                    String value,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "[[GetAllMatches.pattern.label]]",description = "[[GetAllMatches.pattern.description]]")
            @NotEmpty
                    String pattern,
            @Idx(index = "3", type = CHECKBOX)
            @Pkg(label = "[[GetAllMatches.caseInsensitive.label]]",description = "[[GetAllMatches.caseInsensitive.description]]",default_value = "false",default_value_type = BOOLEAN)
            @NotEmpty
                    Boolean caseInsensitive,
            @Idx(index = "4", type = CHECKBOX)
            @Pkg(label = "[[GetFirstMatch.multline.label]]",description = "[[GetFirstMatch.multline.description]]",default_value = "false",default_value_type = BOOLEAN)
            @NotEmpty
            Boolean multline
    ) {
        ListValue<String> OUTPUT = new ListValue<String>();
        List<Value> ListValues = new ArrayList<>();

        int conf = caseInsensitive?Pattern.CASE_INSENSITIVE:0;
        conf += multline?Pattern.MULTILINE:0;

        Pattern p = Pattern.compile(pattern,conf);

        Matcher m = p.matcher(value);
        while(m.find()) {
            ListValues.add(new StringValue(m.group()));
        }
        OUTPUT.set(ListValues);
        return OUTPUT;
    }


}
