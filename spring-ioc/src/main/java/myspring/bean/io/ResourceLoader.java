package myspring.bean.io;

import java.net.URL;

/**
 * @author liangkuai
 * @date 2018/11/20
 */
public class ResourceLoader {

    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
