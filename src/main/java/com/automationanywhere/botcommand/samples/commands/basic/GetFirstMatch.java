package com.automationanywhere.botcommand.samples.commands.basic;
import java.util.ArrayList;
import java.util.List;

import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.exception.BotCommandException;
import com.automationanywhere.commandsdk.model.DataType;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.platform.win32.User32;

import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;

import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.automationanywhere.commandsdk.model.AttributeType.SELECT;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.DataType.LIST;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "GetFirstMatch",
        name = "GetFirstMatch",
        description = "[[GetFirstMatch.description]]",
        node_label = "[[GetFirstMatch.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = STRING,
        return_required = true
)


public class GetFirstMatch {

    @Execute
    public StringValue action(
            @Idx(index = "1", type = TEXT)
            @Pkg(label = "[[GetFirstMatch.value.label]]",description = "[[GetFirstMatch.value.description]]")
            @NotEmpty
                    String value,
            @Idx(index = "2", type = TEXT)
            @Pkg(label = "[[GetFirstMatch.pattern.label]]",description = "[[GetFirstMatch.pattern.description]]")
            @NotEmpty
                    String pattern
    ) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(value);
        while(m.find()) {
            return new StringValue(m.group());
        }
        return new StringValue("");
    }


}
