package live.fanxing.codegenerator.core.gen;

import lombok.Data;

/**
 * @auther fanxing
 * 2021/6/6
 * left join on;
 */

@Data
public class Keyon {
    String filed;
    String value;

    public Keyon(String filed, String value) {
        this.filed = filed;
        this.value = value;
    }
}
