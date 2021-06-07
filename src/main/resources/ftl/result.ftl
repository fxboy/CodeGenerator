package ${entity.packageName};

/**
* @auther
* result 返回内容
*/

public class ${entity.className}<T> {
    Integer code;
    String msg;
    T data;

    public ${entity.className}() {

    }

    public ${entity.className}(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ${entity.className}(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}