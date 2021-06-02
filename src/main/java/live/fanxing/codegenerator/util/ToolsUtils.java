package live.fanxing.codegenerator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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


    public static String sqlTypeToJavaType(String type){
        switch (type.toLowerCase(Locale.ROOT)){
            case "tinyint":
                return "byte";
            case "smallint":
                return "short";
            case "int":
                return "Integer";
            case "bigint":
                return "long";
            case "float":
                return "float";
            case "double":
                return "double";
            default:
                return "String";
        }

    }






    public static void createFile(String outPath,String modelPath,String modelName,String className,Object obj){
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(modelPath));
            // step3 创建数据模型
            // step4 加载模版文件
            Template template = configuration.getTemplate(modelName);
            // step5 生成数据
            File docFile = new File(outPath + "\\"+ className + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            // step6 输出文件
            Map<String, Object> map = new HashMap<>();
            map.put("tableEntities",obj);
            template.process(map, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
