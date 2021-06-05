package live.fanxing.codegenerator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import live.fanxing.codegenerator.core.OSinfo;

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






    public static void createFile(String outPath,String modelPath,String modelName,String className,Object obj) throws Exception {
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(modelPath));
            Template template = configuration.getTemplate(modelName);
            File docFile = new File((!OSinfo.isWindows() ?outPath.replace("\\","/") + "/":outPath +"\\") + className + ".java");
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(docFile)));
            Map<String, Object> map = new HashMap<>();
            map.put("tableEntities",obj);
            template.process(map, out);
            System.out.println("文件生成完成:"+ docFile.getName() +",位置：" + docFile.getPath() );
        } catch (Exception e) {
            throw new Exception("检测到为windows系统，将切换目录书写格式");
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
