package com.xuxue.downloadmap.download;

import com.xuxue.downloadmap.tools.Center;
import com.xuxue.downloadmap.tools.CenterProviter;
import com.xuxue.downloadmap.tools.Parameters;
import com.xuxue.downloadmap.tools.TooManyPictureException;
import com.xuxue.downloadmap.util.MapInfo;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Properties;

/**
 * Created by HanHan on 2016/5/19.
 */
public class Download {

    private static final String baseURL="https://maps.googleapis.com/maps/api/staticmap?";

    private CenterProviter p;

    private CloseableHttpClient client;

    private static String path;

    private MapInfo mapInfo;

    static{
       try{
           Properties p=new Properties();
           System.out.println(Download.class.getResource(".").getPath());
           InputStream in=Download.class.getResourceAsStream("output.properties");
           p.load(in);
           path=p.getProperty("path");
           in.close();
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public Download(Center c1,Center c2)throws TooManyPictureException,IOException{
        p=new CenterProviter(c1,c2);

        this.mapInfo=new MapInfo(c1,c2);
        System.out.println("Hello");
        System.out.println(c2.getLat()+" "+c2.getLon());
        System.out.println(mapInfo);
        int pictureNumber=p.getMaxX()*p.getMaxY();
        if(pictureNumber>150){
            throw new TooManyPictureException("要下载"+pictureNumber+"个图片 这图片太多了");
        }
        client= HttpClients.createDefault();

    }

    public void download(){
        InputStream in=null;
        CloseableHttpResponse res=null;
        while(true){
            try{
                Center center=p.next();
                File file=new File(path+"\\"+center.getX()+"_"+center.getY()+".png");
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
           try{
               savePictureInfo();
           }catch (Exception e){
               e.printStackTrace();
           }
        }
    }

    public void savePictureInfo()throws IOException{
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(new File(path+"\\info.data")));
        out.writeObject(mapInfo);
        out.close();
    }

    public static MapInfo  readPictureInfo()throws IOException,ClassNotFoundException{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(new File(path+"\\info.data")));
        MapInfo mapInfo=(MapInfo)in.readObject();
        return mapInfo;
    }

    public static File mergePicture()throws IOException,ClassNotFoundException{
        MapInfo mapInfo=Download.readPictureInfo();
        System.out.println(mapInfo==null);
        CenterProviter p=new CenterProviter(mapInfo.getC1(),mapInfo.getC2());
        BufferedImage writer=new BufferedImage(256*p.getMaxX(),256*p.getMaxY(),BufferedImage.TYPE_INT_RGB);
        for(int i=0;i<p.getMaxX();i++){

            for(int j=0;j<p.getMaxY();j++){
                BufferedImage reader=ImageIO.read(new File(path+"\\"+i+"_"+j+".png"));
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
        File file=new File(path+"\\new.png");
        file.createNewFile();
        ImageIO.write(writer,"png",file);
        return file;
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
