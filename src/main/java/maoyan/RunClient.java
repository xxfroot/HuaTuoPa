package maoyan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunClient implements Observer{

    private ExecutorService executorService= null; //线程池可自定义

    private int TreadMax=0; //线程池最大容量

    private ObserversTarget observersTarget;

        public RunClient() {

         }

    public void setObserversTarget(ObserversTarget observersTarget) {
        this.observersTarget = observersTarget;
    }

    public RunClient(ExecutorService executorService, int treadMax) {
        this.executorService = executorService;
        TreadMax = treadMax;
    }

    public RunClient(int threadMax) {
        TreadMax = threadMax;
        this.executorService=Executors.newFixedThreadPool(threadMax);
    }



    /**
     * 观察者uopdate,
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        this.observersTarget=(ObserversTarget)arg;
        UrlQueue.getQueue().setUrl(observersTarget.getUrl());
        go();
    }

    /**
     * 提交任务
     */
    private void go(){
        executorService.submit(observersTarget.getRunnable());
    }


    public ExecutorService getExecutorService() {
        return executorService;
    }

    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public int getTreadMax() {
        return TreadMax;
    }

    public void setTreadMax(int treadMax) {
        TreadMax = treadMax;
    }
}
