package live.fanxing.codegenerator.file;

import live.fanxing.codegenerator.core.pojo.TableEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * */

@Component
public interface FileCreate {
    void outFiles(String outPath, String modelPath, TableEntity tableEntity);
}
