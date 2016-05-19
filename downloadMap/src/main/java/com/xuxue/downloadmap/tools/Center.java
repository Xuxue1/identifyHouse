package com.xuxue.downloadmap.tools;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by HanHan on 2016/5/18.
 */
public class Center {

    private final double lng;

    private final double lat;

    private int x;

    private int y;

    public Center(double lng,double lat){
        this.lng=lng;
        this.lat=lat;
    }

    public static Center createByPixel(double x,double y){
        double lng=Transform.pixelToLon(x,Parameters.ZOOM);
        double lat=Transform.pixelToLat(y,Parameters.ZOOM);
        return new Center(lng,lat);
    }

    public double getLng(){
        return this.lng;
    }

    public double getLat(){
        return this.lat;
    }

    public String toString(){
        DecimalFormat format=new DecimalFormat("0.00000000");
        return "center="+format.format(lng)+","+format.format(lat);
    }

    /**
     * 将经纬度转换为像素点
     * @return
     */
    public PixePoint toPixePoint(){
        double y=Transform.latToPixel(lat,Parameters.ZOOM);
        double x=Transform.lonToPixel(lng,Parameters.ZOOM);
        return new PixePoint(x,y);
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x=x;
    }

    public int getY(){
        return this.y;
    }

    public void setY(int y){
        this.y=y;
    }

}
