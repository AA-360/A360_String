import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.samples.commands.basic.GetAllMatches;
import com.automationanywhere.botcommand.samples.commands.basic.GetFirstMatch;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringEndsWith;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringMatches;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringStartsWith;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Arrays;

public class TEST {

    public void sort(){
        String abcd = "bdca5847";
        char[] chars = abcd.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);

    }
    @Test
    public void regex(){
        GetFirstMatch a = new GetFirstMatch();
        GetAllMatches b = new GetAllMatches();

        System.out.println(a.action("A29a","(\\d)*").toString());
        //ListValue<String> values = b.action("hello world!","\\D{5}");

//        for(Value v: values.get()){
//            System.out.println(v.toString());
//        }
    }

    public void teste(){
        StringMatches a = new StringMatches();
        StringStartsWith b = new StringStartsWith();
        StringEndsWith c = new StringEndsWith();
        //System.out.println(a.validate("23/12/1991","\\d*/\\d*/\\d*"));
        System.out.println(a.validate("WEEKLY AGESLJU - SEM 3","WEEKLY .* - SEM 3"));
        System.out.println(b.validate("olá mundo!","olá"));
        System.out.println(c.validate("olá mundo!","mundo!"));
    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}

