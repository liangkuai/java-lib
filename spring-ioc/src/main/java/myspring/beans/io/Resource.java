package myspring.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Spring 内部定位资源的接口
 *
 * @author liangkuai
 * @date 2018/11/20
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
