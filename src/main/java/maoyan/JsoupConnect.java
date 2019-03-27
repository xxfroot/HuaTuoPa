package maoyan;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 * jsoup配置类
 */
public class JsoupConnect {

    private Connection con;
    private String url;
    private  static  String userAgent;
    private  static  int  timeout;
    private  static  boolean  ignoreContentType;

    public Connection getConnection(String url){
        con = Jsoup.connect(url)
                .userAgent(JsoupConnect.getUserAgent())
                .timeout(JsoupConnect.getTimeout())
                .ignoreContentType(JsoupConnect.isIgnoreContentType());
        return con;
    }


    public static String getUserAgent() {
        return userAgent;
    }

    public static void setUserAgent(String userAgent) {
        JsoupConnect.userAgent = userAgent;
    }

    public static int getTimeout() {
        return timeout;
    }

    public static void setTimeout(int timeout) {
        JsoupConnect.timeout = timeout;
    }

    public static boolean isIgnoreContentType() {
        return ignoreContentType;
    }

    public static void setIgnoreContentType(boolean ignoreContentType) {
        JsoupConnect.ignoreContentType = ignoreContentType;
    }
}
