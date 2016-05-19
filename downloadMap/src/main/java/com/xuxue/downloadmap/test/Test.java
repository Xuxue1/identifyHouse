package com.xuxue.downloadmap.test;

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

    public  static void main(String[] args)throws IOException{
        CloseableHttpClient client= HttpClients.createDefault();
        HttpGet get=new HttpGet(createURL("29.754243854706672","118.35639953613281","18","3000x1000"));
        System.out.println(get.getURI().toString());

        CloseableHttpResponse res=client.execute(get);
        System.out.println(res.getStatusLine().getStatusCode());
        BufferedImage image= ImageIO.read(res.getEntity().getContent());
        ImageIO.write(image,"png",new File("map\\1.png"));
    }

    public static String createURL(String x,String y,String ZOOM,String size){
        return url+"?center="+x+","+y+"&zoom="+ZOOM+"&size="+size+"&maptype=satellite";
    }

}
