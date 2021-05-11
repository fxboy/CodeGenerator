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
    private Element root;
    public AbstractDocunmentReader(){

    }
    public AbstractDocunmentReader(String file) throws DocumentException {
        SAXReader reader = new SAXReader();
        this.document = reader.read(new File(file));
        this.root = this.document.getRootElement();
    }

    public void addNode(){

    }

    public void setNodeValue(){

    }

    /**
     *  获取单个在root下指定节点的内容
     * @param key 节点名称
     * @exception Exception
     * @return 节点下的内容
     * */
    public String getNodeValue(String key) throws Exception {
        if(this.root.element(key).elements().size() > 0){
            throw new Exception("当前节点没有String类型的值");
        }
        return this.root.element(key).getText();
    }

    /**
     *  获取单个在root下指定节点的子节点
     * @param key 节点名称
     * @exception Exception
     * @return 节点下的子节点
     * */
    public List<Element> getNodeElements(String key) throws Exception {
        if(this.root.element(key).elements().size() == 0){
            throw new Exception("Element Number is 0");
        }
        return this.root.elements(key);
    }

    public Document getDocument(){
        return this.document;
    }


    public void toFile(String path){

    }

    public static void main(String[] args) throws Exception {
       XmlDocumentReader xmlDocumentReader = new XmlDocumentReader("G:\\classTest\\TestFile\\pom.xml");
       Document document = xmlDocumentReader.getDocument();
        System.out.println(xmlDocumentReader.getNodeValue("groupId"));
    }
}


class XmlDocumentReader extends AbstractDocunmentReader{
    public XmlDocumentReader(String file) throws DocumentException {
        super(file);
    }
}