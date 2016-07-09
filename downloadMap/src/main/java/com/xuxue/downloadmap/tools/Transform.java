package com.xuxue.downloadmap.tools;

/**
 * Created by HanHan on 2016/5/18.
 */
public class Transform {


    /**
     *经度到像素x值的转换
     */
    public static double lonToPixel(double lon, int zoom){

        return (lon + 180) * (Parameters.WIDTH << zoom) / 360;
    }

    /**
     *纬度到像素y的转换
     */
    public static double latToPixel(double lat, int zoom){
        double siny = Math.sin(lat * Math.PI / 180);
        double y = Math.log((1 + siny) / (1 - siny));

        return (128 << zoom) * (1 - y / (2 * Math.PI));
    }



    /**
     *像素x到经度的转换
     */
    public static double pixelToLon(double pixelX, int zoom){
        return pixelX * 360 / (Parameters.WIDTH << zoom) - 180;
    }


    /**
     *像素Y到纬度的转换
     */
    public static double pixelToLat(double pixelY, int zoom){
        double y = 2 * Math.PI * (1 - pixelY / (128 << zoom));
        double z = Math.pow(Math.E, y);
        double siny = (z - 1) / (z + 1);

        return Math.asin(siny) * 180 / Math.PI;
    }


    /**
     * 得到第zoom级地图第一张图片的经度像素
     */
    public static double getFirstLonPixel(int zoom, int row){
        return lonToPixel(0.0, zoom) - Parameters.WIDTH * (row - 1) / 2;
    }

    /**
     * 得到第zoom级地图第一张图片的纬度像素
     */
    public static double getFirstLatPixel(int zoom, int col){
        return latToPixel(0.0, zoom) - Parameters.HEIGHT * (col - 1) / 2;
    }

    /**
     *得到第zoom级地图第一张图片的经度
     */
    public static double getFirstLon(int zoom, int row){
        return pixelToLon(getFirstLonPixel(zoom, row), zoom);
    }

    /**
     *得到第zoom级地图第一张图片的纬度
     */
    public static double getFirstLat(int zoom, int col){
        return pixelToLat(getFirstLatPixel(zoom, col), zoom);
    }

	public static void main(String[] args){
        double x1=19;
        double y1=118;
        double bPixel=lonToPixel(x1,18);
        double bp2=bPixel+Parameters.HEIGHT;
        System.out.println(pixelToLon(bp2,18));
    }
}