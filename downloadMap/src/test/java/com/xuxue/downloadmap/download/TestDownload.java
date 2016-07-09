package com.xuxue.downloadmap.download;

import com.xuxue.downloadmap.tools.Center;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HanHan on 2016/5/19.
 */
public class TestDownload {

    @Before
    public void befor(){

    }

    public void testCenterToURL(){
        Center center=new Center(7,8);
        System.out.println(Download.centerToURL(center));
    }

    @Test
    public void testdowload()throws Exception{
        Download d=new Download(new Center(118.362380,29.752344),new Center(118.366093,29.742512));
        d.download();
    }

    public void testMerge()throws Exception{
        Download d=new Download(new Center(118.362380,29.752344),new Center(118.366093,29.742512));
        d.mergePicture();
    }


    public void testPictureCreate(){
        try{
            File fi=new File(".");
            System.out.println(fi.getAbsolutePath());
            File file=new File("..\\map\\"+1+"_"+2+".png");
            file.createNewFile();
            Center center=new Center(7,8);
            HttpGet get=new HttpGet(Download.centerToURL(center));
            CloseableHttpClient client= HttpClients.createDefault();
            CloseableHttpResponse res=client.execute(get);
            InputStream in=res.getEntity().getContent();
            BufferedImage image= ImageIO.read(in);
            Download.WriteImage(image,file);
            in.close();
            res.close();
            client.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("failture");
        }
        System.out.println("OK");

    }

}
