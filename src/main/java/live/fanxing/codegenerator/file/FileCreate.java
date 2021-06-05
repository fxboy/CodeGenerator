package live.fanxing.codegenerator.file;

import live.fanxing.codegenerator.core.OSinfo;
import live.fanxing.codegenerator.core.pojo.TableEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * */

@Component
public interface FileCreate {
    @Value("${cr.package.entity}")
    String packageName = null;
    @Value("${cr.model.entity}")
    String modelName = null;
    boolean isUnix = OSinfo.isWindows();
    void outFiles(String outPath, String modelPath, TableEntity tableEntity);
}
