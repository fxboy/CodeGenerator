package live.fanxing.codegenerator;

import live.fanxing.codegenerator.core.CreateCode;
import live.fanxing.codegenerator.core.pojo.DataBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther Fanxing
 * 这是一个简介
 */
@Component
public class CreateApplication {
    @Autowired
    private CreateCode createCode;

    private String packName;
    private String outPath;
    private String modelPath;
    private DataBaseInfo dataBaseInfo;

    public CreateApplication create(String... obj) throws Exception {
        this.dataBaseInfo = new DataBaseInfo();
        if(obj.length != 3){
            throw new Exception("obj[0]: 项目包名 obj[1]: 代码文件输出的路径（到src/main文件夹即可） obj[2]: 存放模板的文件夹，如果不填，即为默认");
        }
        this.packName = obj[0];
        this.outPath = obj[1];
        this.modelPath = obj[2];
        return this;
    }

    public void run() throws Exception {
        this.createCode.init(this.packName,this.outPath,this.modelPath,this.dataBaseInfo).build();
    }

    public DataBaseInfo getDataBaseInfo(){
        return this.dataBaseInfo;
    }
}
