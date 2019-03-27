package maoyan;

/**
 * 爬虫任务封装
 */
public class ObserversTarget {

    private  String url;

    private Runnable runnable;

    public ObserversTarget(String url, Runnable runnable) {
        this.url = url;
        this.runnable = runnable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
