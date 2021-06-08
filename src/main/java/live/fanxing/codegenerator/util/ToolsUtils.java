package live.fanxing.codegenerator.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import live.fanxing.codegenerator.core.OSinfo;
import live.fanxing.codegenerator.core.code.Entity;

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


    public static <T> void nCreateFile(String outPath, String modelPath, String modelName, T obj) throws Exception {
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            configuration.setDirectoryForTemplateLoading(new File(modelPath));
            Template template = configuration.getTemplate(modelName);
            String filePaht = "";
            int lastIndexOf = outPath.lastIndexOf(File.separator);
            filePaht = outPath.substring(0,lastIndexOf);
            File docFile = new File(filePaht);
            if(!docFile.exists()){
                docFile.mkdirs(); //创建目录
            }
            File classFile = new File(outPath);
            if (!classFile.exists()) {
                classFile.createNewFile();//有路径才能创建文件
            }
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(classFile)));
            Map<String,T> map = new HashMap<>();
            map.put("entity",obj);
            map.put("service",obj);
            template.process(map, out);
            System.out.println(outPath);
            System.out.println("文件生成完成:"+ classFile.getName() +",位置：" + classFile.getPath() );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("检测到输出路径：" + outPath);
            System.out.println("检测模板路径：" + modelPath + modelName);
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

    public static boolean existFile(String outPath) throws Exception {
        if(outPath==null){
            throw new Exception("文件路径未填写，请确保参数完整！");
        }
        File file = new File(outPath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return true;
            }catch (Exception e){
                throw new Exception("文件创建失败！");

            }
        }
        return true;
    }

}
