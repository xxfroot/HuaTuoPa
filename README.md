# HuaTuoPa
一个轻型多线程爬虫框架

爬取常规html页面实例

 public static void main(String[] args) {

        /**
         * 设置jsoup请求配置
         */
        JsoupConnect.setUserAgent("Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
        JsoupConnect.setIgnoreContentType(true);
        JsoupConnect.setTimeout(3000);
        HuaTuoPaChong huaTuoPaChong=new HuaTuoPaChong(); //建立爬虫实例
        huaTuoPaChong.addObserver(3); //设置线程连接数
        String url="https://www.qidian.com/all?orderId=&style=1&pageSize=20&siteid=1&pubflag=0&hiddenField=0&page=";

        for (int i=0;i<100;i++){
            huaTuoPaChong.recviveTask().receive(url + i, new Runnable() {
                @Override
                public void run() {
                    Connection con = null;
                    String url=UrlQueue.getQueue().getUrl(); //获得url
                    System.out.println(Thread.currentThread().getName()+"正在爬取:"+url);
                    List<String> urlList = new ArrayList<String>();
                    con = Jsoup.connect(url) //建立连接
                            .userAgent(JsoupConnect.getUserAgent())
                            .timeout(JsoupConnect.getTimeout())
                            .ignoreContentType(JsoupConnect.isIgnoreContentType());
                    try {
                        Document document = con.get(); //获取文档
                        Elements images = document.select("img[src~=(?i)]"); //获取所有图片
                        for (Element element : images) { //遍历
                            if (element.attr("src").contains("qdbimg")){
                                urlList.add("https:" + element.attr("src"));
                            }
                        }
                        new DownLoador().dowmLoadCover(urlList);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }



爬取ajax异步数据实例

    private String url;

    public Task (){


    }

    /**
     * 爬取非html页面，即爬取ajax请求结果
     */
    public  void run() {
        Connection con = Jsoup.connect(UrlQueue.getQueue().getUrl())
                .userAgent(JsoupConnect.getUserAgent())
                .timeout(JsoupConnect.getTimeout())
                .ignoreContentType(JsoupConnect.isIgnoreContentType());
        Connection.Response rs = null;//建立链接
        try {
            System.out.println(Thread.currentThread().getName()+"正爬取....."+url);
            rs = con.execute();
            String body=rs.body();
            ObjectMapper objectMapper=new ObjectMapper();
            Map<String,List<Map<String,Object>>> listMap= objectMapper.readValue(body,new HashMap<String,List<Map<String,Object>>>().getClass());
            List<Map<String,Object>> movieMap=listMap.get("subjects");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
