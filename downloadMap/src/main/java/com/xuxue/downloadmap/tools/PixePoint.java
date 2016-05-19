package com.xuxue.downloadmap.tools;

import java.awt.*;

/**
 * Created by HanHan on 2016/5/19.
 */
public class PixePoint {

    private double x;

    private double y;

    public PixePoint(double x,double y){
        this.x=x;
        this.y=y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Rectangle calceRectangle(PixePoint point){
        int width=Math.abs((int)(this.x-point.getX()));
        int height=Math.abs((int)(this.y-point.getY()));
        return new Rectangle((int)x,(int)y,width,height);
    }

    public Center toCenter(){
        double x=Transform.pixelToLon(this.x,Parameters.ZOOM);
        double y=Transform.pixelToLat(this.y,Parameters.ZOOM);
        return new Center(x,y);
    }

}
