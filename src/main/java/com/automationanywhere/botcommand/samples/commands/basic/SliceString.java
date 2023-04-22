package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.STRING;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@BotCommand
@CommandPkg(
        label = "SliceString",
        name = "SliceString",
        description = "[[SliceString.description]]",
        node_label = "[[SliceString.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)

public class SliceString {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[SliceString.value.label]]", description = "[[SliceString.value.description]]")
            @NotEmpty
                    String value,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "[[SliceString.index.label]]", description = "[[SliceString.index.description]]")
            @NotEmpty
                    String index
    ) {

        Boolean pattern1= index.matches("^(-?([0-9]){1,}):(-?([0-9]){1,})$");
        Boolean pattern2= index.matches("^(-?([0-9]){1,})$");
        if(!(pattern1 || pattern2)){
            throw new BotCommandException("has not a valid format try to use as 1 or 2 or -1 or -2 or -2:-1");
        }
        if(pattern1){
            Integer idx1 = Integer.parseInt(index.split(":")[0]);
            Integer idx2 = Integer.parseInt(index.split(":")[1]);
            idx1 = IdxToIdx(idx1,value);
            idx2 = IdxToIdx(idx2,value);
            if(idx1 > idx2){
                throw new BotCommandException("start can not be higher than end!");
            }

            String out = "";
            for(Integer i=idx1;i<=idx2;i++){
                out += value.charAt(i);
            }

            return new StringValue(out);

        }else{
            Integer idx = IdxToIdx(Integer.parseInt(index),value);
            return new StringValue(value.charAt(idx) + "");
        }
    }


    private int IdxToIdx(Integer index,String value){
        Integer idx = 0;
        if (index.intValue() < 0){
            idx = value.length() - Math.abs(index.intValue());
        }else{
            idx = index.intValue();
        }

        return idx;
    }



}