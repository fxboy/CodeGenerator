package live.fanxing.codegenerator.core.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther fanxing
 * 2021/6/6
 */

public class CodeInfo {
    List<Entity> entities = new ArrayList<>();

    public void addEntity(Entity entity){
        this.entities.add(entity);
    }
}
