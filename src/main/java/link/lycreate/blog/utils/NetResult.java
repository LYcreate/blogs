package link.lycreate.blog.utils;

/**
 * @ClassName NetResult
 * @Description TODO
 * @Author LYcreate
 * @Date 2019/2/17 10:48
 */
public class NetResult {
    public int status;
    public Object result;

    public NetResult() {
    }

    public NetResult(int status, Object result) {
        this.status = status;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
