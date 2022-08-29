package com.automationanywhere.botcommand.samples.commands.basic;

import com.automationanywhere.botcommand.data.impl.NumberValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.commandsdk.annotations.*;
import com.automationanywhere.commandsdk.annotations.rules.NotEmpty;

import java.util.Arrays;

import static com.automationanywhere.commandsdk.model.AttributeType.TEXT;
import static com.automationanywhere.commandsdk.model.AttributeType.TEXTAREA;
import static com.automationanywhere.commandsdk.model.DataType.NUMBER;
import static com.automationanywhere.commandsdk.model.DataType.STRING;


@BotCommand
@CommandPkg(
        label = "LockMatch",
        name = "LockMatch",
        description = "[[LockMatch.description]]",
        node_label = "[[LockMatch.node_label]]",
        icon = "pkg.svg",
        return_description = "",
        return_type = NUMBER,
        return_required = true
)


public class LockMatch {

    @Execute
    public NumberValue action(
            @Idx(index = "1", type = TEXTAREA)
            @Pkg(label = "[[LockMatch.value1.label]]",description = "[[LockMatch.value1.description]]")
            @NotEmpty
                    String text1,
            @Idx(index = "2", type = TEXTAREA)
            @Pkg(label = "[[LockMatch.value2.label]]",description = "[[LockMatch.value2.description]]")
            @NotEmpty
                    String text2
    ) {

        return new NumberValue(lock_match(text1,text2));
    }


    public static int lock_match(String s, String t) {



        int totalw = word_count(s);
        int total = 100;
        int perw = total / totalw;
        int gotperw = 0;

        if (!s.equals(t)) {

            for (int i = 1; i <= totalw; i++) {
                if (simple_match(split_string(s, i), t) == 1) {
                    gotperw = ((perw * (total - 10)) / total) + gotperw;
                } else if (front_full_match(split_string(s, i), t) == 1) {
                    gotperw = ((perw * (total - 20)) / total) + gotperw;
                } else if (anywhere_match(split_string(s, i), t) == 1) {
                    gotperw = ((perw * (total - 30)) / total) + gotperw;
                } else {
                    gotperw = ((perw * smart_match(split_string(s, i), t)) / total) + gotperw;
                }
            }
        } else {
            gotperw = 100;
        }
        return gotperw;
    }

    public static int anywhere_match(String s, String t) {
        int x = 0;
        if (t.contains(s)) {
            x = 1;
        }
        return x;
    }

    public static int front_full_match(String s, String t) {
        int x = 0;
        String tempt;
        int len = s.length();

        //----------Work Body----------//
        for (int i = 1; i <= word_count(t); i++) {
            tempt = split_string(t, i);
            if (tempt.length() >= s.length()) {
                tempt = tempt.substring(0, len);
                if (s.contains(tempt)) {
                    x = 1;
                    break;
                }
            }
        }
        //---------END---------------//
        if (len == 0) {
            x = 0;
        }
        return x;
    }

    public static int simple_match(String s, String t) {
        int x = 0;
        String tempt;
        int len = s.length();


        //----------Work Body----------//
        for (int i = 1; i <= word_count(t); i++) {
            tempt = split_string(t, i);
            if (tempt.length() == s.length()) {
                if (s.contains(tempt)) {
                    x = 1;
                    break;
                }
            }
        }
        //---------END---------------//
        if (len == 0) {
            x = 0;
        }
        return x;
    }

    public static int smart_match(String ts, String tt) {

        char[] s = new char[ts.length()];
        s = ts.toCharArray();
        char[] t = new char[tt.length()];
        t = tt.toCharArray();


        int slen = s.length;
        //number of 3 combinations per word//
        int combs = (slen - 3) + 1;
        //percentage per combination of 3 characters//
        int ppc = 0;
        if (slen >= 3) {
            ppc = 100 / combs;
        }
        //initialising an integer to store the total % this class genrate//
        int x = 0;
        //declaring a temporary new source char array
        char[] ns = new char[3];
        //check if source char array has more then 3 characters//
        if (slen < 3) {
        } else {
            for (int i = 0; i < combs; i++) {
                for (int j = 0; j < 3; j++) {
                    ns[j] = s[j + i];
                }
                if (cross_full_match(ns, t) == 1) {
                    x = x + 1;
                }
            }
        }
        x = ppc * x;
        return x;
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static int  cross_full_match(char[] s, char[] t) {
        int z = t.length - s.length;
        int x = 0;
        if (s.length > t.length) {
            return x;
        } else {
            for (int i = 0; i <= z; i++) {
                for (int j = 0; j <= (s.length - 1); j++) {
                    if (s[j] == t[j + i]) {
                        // x=1 if any charecer matches
                        x = 1;
                    } else {
                        // if x=0 mean an character do not matches and loop break out
                        x = 0;
                        break;
                    }
                }
                if (x == 1) {
                    break;
                }
            }
        }
        return x;
    }

    public static String split_string(String s, int n) {

        int index;
        String temp;
        temp = s;
        String temp2 = null;

        int temp3 = 0;

        for (int i = 0; i < n; i++) {
            int strlen = temp.length();
            index = temp.indexOf(" ");
            if (index < 0) {
                index = strlen;
            }
            temp2 = temp.substring(temp3, index);
            temp = temp.substring(index, strlen);
            temp = temp.trim();

        }
        return temp2;
    }

    public static int word_count(String s) {
        int x = 1;
        int c;
        s = s.trim();
        if (s.isEmpty()) {
            x = 0;
        } else {
            if (s.contains(" ")) {
                for (;;) {
                    x++;
                    c = s.indexOf(" ");
                    s = s.substring(c);
                    s = s.trim();
                    if (s.contains(" ")) {
                    } else {
                        break;
                    }
                }
            }
        }
        return x;
    }

}
