package com.xuxue.downloadmap.tools;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by HanHan on 2016/5/18.
 */
public class Center implements Serializable{

    private double lon;

    private double lat;

    private int x;

    private int y;

    public Center(double lon,double lat){
        this.lon=lon;
        this.lat=lat;
    }

    public static Center createByPixel(double x,double y){
        double lon=Transform.pixelToLon(x,Parameters.ZOOM);
        double lat=Transform.pixelToLat(y,Parameters.ZOOM);
        return new Center(lon,lat);
    }

    public static Center createByStrings(String[] point)throws NumberFormatException{
        double lon=Double.parseDouble(point[0]);
        double lat=Double.parseDouble(point[1]);
        return new Center(lon,lat);
    }

    public double getLon(){
        return this.lon;
    }

    public double getLat(){
        return this.lat;
    }

    public String toString(){
        DecimalFormat format=new DecimalFormat("0.00000000");
        return "center="+format.format(lat)+","+format.format(lon);
    }

    /**
     * 将经纬度转换为像素点
     * @return
     */
    public PixePoint toPixePoint(){
        double y=Transform.latToPixel(lat,Parameters.ZOOM);
        double x=Transform.lonToPixel(lon,Parameters.ZOOM);
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

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
