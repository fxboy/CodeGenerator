package live.fanxing.codegenerator.util;

import java.util.Locale;

/**
 * @auther Fanxing
 * 这是一个简介
 */

public class ToolsUtils {
    public static String[] jx(String value){
        String[] res = new String[3];
        res[0] = value;
        value = value.toLowerCase(Locale.ROOT); // 先全转小写
        String[] vas = value.split("_"); // 查找下划线

        if(vas.length == 1){
            res[1] = toUper(vas[0]);
            res[2] = vas[0];
            return res;
        }
        StringBuffer s = new StringBuffer(vas[0]);
        for (int i = 1 ; i < vas.length ; i ++){
            s.append(toUper(vas[i]));
        }
        res[1] = toUper(s.toString());
        res[2] = s.toString();

        return res;
    }


    public static  String toUper(String name){
        char[] cs=name.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

    public static String getSzm(String name){
        //return name.substring(0,1).toLowerCase(Locale.ROOT);
        return name.toLowerCase(Locale.ROOT);
    }

}
