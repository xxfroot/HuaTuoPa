package maoyan;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.*;

/**
 * 执行方法
 */
public  class HuaTuoPaChong implements PaChongConfig{


    private ReceiveTask receiveTask=null;

    public HuaTuoPaChong(){

    }

    @Override
    public JsoupConnect jsoupConfig(JsoupConnect jsoupConnect) {
        JsoupConnect.setUserAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        JsoupConnect.setIgnoreContentType(true);
        JsoupConnect.setTimeout(3000);
        return jsoupConnect;
    }

    /**
     * 添加观察者
     * @param receiveTask
     * @param runClient
     */
    public final void addObserver(ReceiveTask receiveTask,RunClient runClient){
        receiveTask.deleteObservers();
        receiveTask.addObserver(runClient);
    }

    /**
     * 重载上面方法
     * @param receiveTask
     */
    public final void addObserver(ReceiveTask receiveTask,int threadMax){
        receiveTask.deleteObservers();
        receiveTask.addObserver(new RunClient(threadMax));
    }

    /**
     *
     * @param threadMax
     * @return
     */
    public final void  addObserver(int threadMax){
        this.receiveTask=new ReceiveTask();
        receiveTask.addObserver(new RunClient(threadMax));
    }

    public ReceiveTask recviveTask(){
        return this.receiveTask;
    }

}
