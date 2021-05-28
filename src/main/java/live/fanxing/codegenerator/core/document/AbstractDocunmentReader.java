package live.fanxing.codegenerator.core.document;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @auther Fanxing
 * 这是一个简介
 */

public abstract class AbstractDocunmentReader {
    private Document document;
    private File file;
    public AbstractDocunmentReader(String file) throws DocumentException {
        SAXReader reader = new SAXReader();
        this.file = new File(file);
        this.document = reader.read(this.file);
    }

    /**
     *  添加text类型的节点，默认在root下添加
     * @param key 节点名称
     * @param value 节点内容
     * @exception Exception
     * */
    public void addNodeString(String key,String value){
        this.document.getRootElement().addAttribute(key, value);
    }

    /**
     *  添加text类型的节点，默认在root下添加
     * @param key 节点名称
     * @param value 节点内容
     * @param element 添加到的节点
     * @exception Exception
     * */
    public void addNodeString(String key,String value,Element element){
        element.addAttribute(key,value);
    }

    /**
     *  添加节点，默认在root下添加
     * @param value 添加的节点
     * @exception Exception
     * */
    public void addNodeElement(Element value){
        // 添加节点
        this.document.getRootElement().add(value);
    }

    /**
     *  添加节点，默认在root下添加
     * @param value 添加的节点
     * @param element 添加到的节点
     * @exception Exception
     * */
    public Element addNodeElement(Element value,Element element){
        element.add(value);
        return element;
    }

    public void setNodeValue(String key,String value){
        this.document.getRootElement().element(key).setText(value);
    }

    /**
     *  获取单个在root下指定节点的内容，默认在root节点下查找
     * @param key 节点名称
     * @exception Exception
     * @return 节点下的内容
     * */
    public String getNodeValue(String key) throws Exception {
        if(this.document.getRootElement().element(key).isTextOnly()){
          //  throw new Exception("当前节点没有String类型的值");
        }
        return this.document.getRootElement().element(key).getText();
    }

    /**
     *  获取单个在root下指定节点的内容
     * @param key 节点名称
     * @param element 指定要查找的节点
     * @exception Exception
     * @return 节点下的内容
     * */
    public String getNodeValue(String key,Element element) throws Exception {
        if(element.element(key).isTextOnly()){
            throw new Exception("当前节点没有String类型的值");
        }
        return element.element(key).getText();
    }

    /**
     *  获取单个在root下指定节点的子节点,默认在root节点下查找
     * @param key 节点名称
     * @exception Exception
     * @return 节点下的子节点
     * */
    public List<Element> getNodeElements(String key) throws Exception {
        if(this.document.getRootElement().element(key).elements().size() == 0){
            throw new Exception("Element Number is 0");
        }
        return this.document.getRootElement().elements(key);
    }


    /**
     *  获取单个在root下指定节点的子节点
     * @param key 节点名称
     * @exception Exception
     * @return 节点下的子节点
     * */
    public List<Element> getNodeElements(String key,Element element) throws Exception {
        if(element.element(key).elements().size() == 0){
            throw new Exception("Element Number is 0");
        }
        return element.elements(key);
    }

    public Document getDocument(){
        return this.document;
    }

    public Element getRoot(){
        return this.document.getRootElement();
    }


    public void toFile(String path){

    }

    public void close(){

    }

    @Override
    public String toString(){
        for (Object child: this.document.getRootElement().elements()
             ) {
            Element element = (Element) child;
            System.out.println(element.getName() + ":" + element.getText());
        }

        return null;
    }

    public static void main(String[] args) throws Exception {
       PomDocumentReader xmlDocumentReader = new PomDocumentReader("G:\\classTest\\TestFile\\pom.xml");
       Document document = xmlDocumentReader.getDocument();
       System.out.println("修改前："+xmlDocumentReader.getNodeValue("groupId"));
      xmlDocumentReader.setGroupId("ddddd");
        System.out.println("修改后："+xmlDocumentReader.getNodeValue("groupId"));
    }
}


class PomDocumentReader extends AbstractDocunmentReader{
    public PomDocumentReader(String file) throws DocumentException {
        super(file);
    }
    public void setGroupId(String groupid){
        if(this.getDocument().getRootElement().elements("groupId").size() > 0){
            // 修改
            this.setNodeValue("groupId",groupid);
        }
        this.addNodeString("groupId",groupid);
    }

    public void setArtifactId(String artifactId){
        if(this.getDocument().getRootElement().elements("artifactId").size() > 0){
            // 修改
            this.setNodeValue("artifactId",artifactId);
        }
        this.addNodeString("artifactId",artifactId);
    }

    public void setVersion(String version){
        if(this.getDocument().getRootElement().elements("version").size() > 0){
            // 修改
            this.setNodeValue("version",version);
        }
        this.addNodeString("version",version);
    }

    public void setName(String name){
        if(this.getDocument().getRootElement().elements("name").size() > 0){
            // 修改
            this.setNodeValue("name",name);
        }
        this.addNodeString("name",name);
    }

    public void addDependency(){

    }






    @Override
    public String toString(){
        return super.toString();
    }
}