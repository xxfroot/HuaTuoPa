package maoyan;


import java.util.Observable;
import java.util.Observer;

public class ReceiveTask extends Observable {

   private ObserversTarget observersTarget;
    /**
     * 唤醒观察者
     */
    private  void run(){
        this.setChanged();
        this.notifyObservers(observersTarget);
    }

    /**
     * 接收url字符串，人物逻辑
     * @param url
     */
    public void receive(String url,Runnable runnable){
      this.observersTarget=new ObserversTarget(url,runnable);
      run();
    }


}
