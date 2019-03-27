package maoyan;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * url队列单例实现
 */
public class UrlQueue {

    private static volatile BlockingQueue<String>
                            blockingQueue=new LinkedBlockingDeque<String>();

    /**
     * 私有构造函数，不可初始化
     */
    private UrlQueue(){

    }

    /**
     * 获得队列，对外开放方法
     * @return
     */
    public static UrlQueue getQueue(){
        return  getIntanceClass.urlQueue;
    }

    /**
     * 获得urlQueue静态类
     */
    private  static class getIntanceClass{
        private static  final UrlQueue urlQueue=new UrlQueue();
    }

    /**
     * 存放url
     * @param url
     */
   public void setUrl(String url){
       System.out.println("setUrl"+url);
        blockingQueue.add(url);
   }

    /**
     * 获取url
     * @param
     * @return
     */
    public   String getUrl(){
        return  blockingQueue.poll();
    }
}
