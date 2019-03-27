package maoyan;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class DownLoador {

    private static int count=0;

    public synchronized void dowmLoadCover(List<String> urls){
        System.out.println("开始下载");
        for (String m:urls){
            try {
                URL url=new URL(m);
                DataInputStream dataInputStream=new DataInputStream(url.openStream());
                String title=UUID.randomUUID().toString()+".jpg";
                File file=new File("D:/huatuoJAVA/images/"+title);
                if (!file.exists()){
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream=new FileOutputStream(file);
                IOUtils.copy(dataInputStream,fileOutputStream);
                System.out.println( ++count+"张图片已经下载完成"+"当前完成:"+title);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }




}
