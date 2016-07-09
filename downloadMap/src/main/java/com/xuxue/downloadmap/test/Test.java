package com.xuxue.downloadmap.test;

import com.xuxue.downloadmap.download.Download;
import com.xuxue.downloadmap.tools.Center;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

/**
 * Created by HanHan on 2016/5/18.
 */
public class Test {

    private static String url="https://maps.googleapis.com/maps/api/staticmap";

    public  static void main(String[] args)throws Exception{
        Download d=new Download(new Center(118.362380,29.752344),new Center(118.366093,29.742512));
    }

    public static String createURL(String x,String y,String ZOOM,String size){
        return url+"?center="+x+","+y+"&zoom="+ZOOM+"&size="+size+"&maptype=satellite";
    }

}
