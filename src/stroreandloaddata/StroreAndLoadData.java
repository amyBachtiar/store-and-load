package stroreandloaddata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author amy
 */
public class StroreAndLoadData {

    public static void main(String args[]) {
        String text = "key1=value1;key2=value2;key3=value2\nkeyA=valueA;keyB=valueB\n";
        List a = load(text);
        store(a);
    }

    public static void store(List a) {
        int i;
        for (Object s : a) {
            i = 1;
            HashMap<String, String> maps = (HashMap<String, String>) s;
            for (Map.Entry<String, String> entry : maps.entrySet()) {
                if (i != 1) {
                    System.out.print(";");
                }
                System.out.print(entry.getKey() + "=" + entry.getValue());
                i++;
            }
            System.out.print("\\n");
        }
    }

    public static List load(String text) {
        Map<String, String> data;
        List<Map<String, String>> finaldata = new ArrayList<>();
        String[] stringdata = text.split("\n");
        int i = 1;
        for (String var : stringdata) {
            data = new HashMap();
            if (var.contains(";")) {
                String[] stringdata2 = var.split(";");
                for (String var2 : stringdata2) {
                    String[] keyvals = var2.split("=");
                    data.put(keyvals[0], keyvals[1]);
                }

            } else {
                String[] stringdata3 = var.split("=");
                data.put(stringdata3[0], stringdata3[1]);
            }
            finaldata.add(data);
            i++;
        }
        return finaldata;
    }

}
