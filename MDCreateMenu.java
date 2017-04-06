import java.util.*;
import java.io.*;

public class MDCreateMenu{
    public static void main(String[] args){
        try{
            PrintStream out = new PrintStream(System.out, true, "UTF-8");
            FileInputStream fs = new FileInputStream(args[0]);
            InputStreamReader isr = new InputStreamReader(fs, "UTF8");
            BufferedReader br = new BufferedReader(isr);
            String str;
            boolean codeflag = false;
            while ((str = br.readLine())!=null){
                if (str.length()==0) continue;
                if (codeflag){
                    if (str.length()>2 && str.substring(0,3).equals("```")) codeflag = false;
                    continue;
                }
                if (str.length()>2 && str.substring(0,3).equals("```")){
                    codeflag = true;
                    continue;
                }
                int i;
                for(i=0;str.charAt(i)=='#';i++);
                if(i>0 && str.charAt(i)==' '){
                    String title = str.substring(i+1,str.length());
                    String ans = "";
                    for (int j=0;j<i-1;j++) ans += "    ";
                    switch (i%3){
                        case 1:
                            ans += "*";
                            break;
                        case 2:
                            ans += "+";
                            break;
                        case 0:
                            ans += "-";
                            break;
                    }
                    ans += " [";
                    ans += title;
                    ans += "](#";
                    
                    title = title.toLowerCase();
                    
                    String[] ps = {"（","）","・","#","～","\\(","\\)","!","\\?","\\,","\\.","\\[","\\]","\\{","\\}","\\^","\\*"};

                    for (String p : ps) title = title.replaceAll(p,"");
                    title = title.replaceAll(" ","-");

                    ans += title;
                    ans += ")";
                    out.println(ans);
                }
            }
            br.close();
        } catch(Exception e){
            System.err.println(e);
        }
    }
}