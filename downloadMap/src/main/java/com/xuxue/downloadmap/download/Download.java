package com.xuxue.downloadmap.download;

import com.xuxue.downloadmap.tools.Center;
import com.xuxue.downloadmap.tools.CenterProviter;
import com.xuxue.downloadmap.tools.Parameters;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by HanHan on 2016/5/19.
 */
public class Download {

    private static final String baseURL="https://maps.googleapis.com/maps/api/staticmap?";

    private CenterProviter p;

    private CloseableHttpClient client;

    public Download(Center c1,Center c2){
        p=new CenterProviter(c1,c2);
        client= HttpClients.createDefault();
    }

    public void download(){
        InputStream in=null;
        CloseableHttpResponse res=null;
        while(true){
            try{
                Center center=p.next();
                File file=new File("..\\map\\"+center.getX()+"_"+center.getY()+".png");
                file.createNewFile();
                HttpGet get=new HttpGet(centerToURL(center));
                System.out.println(get.getURI().toString());
                res=client.execute(get);
                in=res.getEntity().getContent();
                BufferedImage image= ImageIO.read(in);
                WriteImage(image,file);
            } catch (Exception e){
                e.printStackTrace();
                break;
            }finally {
               try{
                   in.close();
                   res.close();
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        }
    }

    public void mergePicture()throws IOException{
        BufferedImage writer=new BufferedImage(256*p.getMaxX(),256*p.getMaxY(),BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<p.getMaxX();i++){

            for(int j=0;j<p.getMaxY();j++){
                BufferedImage reader=ImageIO.read(new File("..\\map\\"+i+"_"+j+".png"));
                for(int ii=0;ii<256;ii++){
                    for(int jj=0;jj<256;jj++){
                        int rgb=reader.getRGB(ii,jj);
                        int x=256*i+ii;
                        int y=256*j+jj;
                       try{
                           writer.setRGB(256*i+ii,256*j+jj,rgb);
                       }catch (Exception e){
                           System.out.println("x="+x+" y="+y);
                           throw new IOException();
                       }
                    }
                }
            }
        }
        File file=new File("..//map//new.png");
        file.createNewFile();
        ImageIO.write(writer,"png",file);
    }

    public static void WriteImage(BufferedImage image,File file)throws IOException{
        int[] rgb = new int[Parameters.WIDTH*Parameters.HEIGHT];
        image.getRGB(0,30,Parameters.WIDTH,Parameters.HEIGHT,rgb,0,Parameters.WIDTH);
        BufferedImage newImage = new BufferedImage(256,256,BufferedImage.TYPE_INT_RGB);
        newImage.setRGB(0,0,Parameters.WIDTH,Parameters.HEIGHT,rgb,0,Parameters.WIDTH);
        ImageIO.write(newImage,"png",file);
    }

    /**
     * 将一个Center转化为URL
     *
     * 为了去除谷歌的水印 在获取图片的时候 请求的每张图片的HEIGHT将比设定的多60个像素
     * @param c
     * @return
     */
    public static String centerToURL(Center c){

        return baseURL+c.toString()+"&zoom="+ Parameters.ZOOM+
                "&maptype=satellite"+"&size="+Parameters.WIDTH+"x"+(Parameters.HEIGHT+60);
    }

}
