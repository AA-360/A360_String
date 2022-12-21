import com.automationanywhere.botcommand.data.Value;
import com.automationanywhere.botcommand.data.impl.ListValue;
import com.automationanywhere.botcommand.data.impl.StringValue;
import com.automationanywhere.botcommand.samples.commands.basic.GetAllMatches;
import com.automationanywhere.botcommand.samples.commands.basic.GetFirstMatch;
import com.automationanywhere.botcommand.samples.commands.basic.LockMatch;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringEndsWith;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringHasOnlyNumbers;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringMatches;
import com.automationanywhere.botcommand.samples.commands.conditionals.StringStartsWith;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class TEST {

    public void sort(){
        String abcd = "bdca5847";
        char[] chars = abcd.toCharArray();

        Arrays.sort(chars);
        String sorted = new String(chars);
        System.out.println(sorted);

    }

    public void onlynumb(){
        StringHasOnlyNumbers a = new StringHasOnlyNumbers();

        System.out.println(a.validate("10001247501").toString());

    }
    @Test
    public void regex()throws Exception{
        GetFirstMatch a = new GetFirstMatch();
        GetAllMatches b = new GetAllMatches();
        String text = textBlocks();

        //System.out.println(b.action("asdasd_asdasds_111.txt",".*?(?=_)").toString());
        //ListValue<String> values = b.action(text,"(?<=InstallLocation\\s*:\\s).*(approve.*)",true);
        StringValue value = a.action(text,"(?<=InstallLocation\\s*:\\s).*(approve.*)",true);
        System.out.println("-" + value.toString());

        //for(Value v: values.get()){
         //   System.out.println("-" + v.toString());
        //}
    }

    public String textBlocks() throws Exception {
        // File path is passed as parameter
        File file = new File(
                "C:\\Users\\melque\\Documents\\reg.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
                = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        String text = "";
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null)

            // Print the string
            text += st +"\n";
        return text;

    }


    public void lockMatch(){
        LockMatch a = new LockMatch();
    }
    public void teste(){
        StringMatches a = new StringMatches();
        StringStartsWith b = new StringStartsWith();
        StringEndsWith c = new StringEndsWith();
        //System.out.println(a.validate("23/12/1991","\\d*/\\d*/\\d*"));
        System.out.println(a.validate("Analysis Report COD-en-us.xlsx",".*?-en-us.*"));
        //System.out.println(a.validate("12315",".*\\D.*"));
        //System.out.println(b.validate("olá mundo!","olá"));
        //System.out.println(c.validate("olá mundo!","mundo!"));
    }
    private void alert(String text){
        JOptionPane.showMessageDialog(null, text, "InfoBox: Title", JOptionPane.INFORMATION_MESSAGE);
    }
}