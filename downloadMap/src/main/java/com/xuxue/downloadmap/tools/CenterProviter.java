package com.xuxue.downloadmap.tools;

import java.awt.*;

/**
 * 这个类根据
 * Created by HanHan on 2016/5/18.
 */
public class CenterProviter {

    private Center center1;

    private Center center2;

    private int maxX;

    private int maxY;

    private int x;

    private int y;

    private double pixelx;

    private double pixely;

	public CenterProviter(Center center1,Center center2){
	    this.center1=center1;
        this.center2=center2;
        pixelx=Transform.lonToPixel(center1.getLon(),Parameters.ZOOM);
        pixely=Transform.latToPixel(center1.getLat(),Parameters.ZOOM);
        init();
	}

    public int getMaxX(){
        return this.maxX;
    }

    public int getMaxY(){
        return this.maxY;
    }

    private void init(){
        PixePoint p1=center1.toPixePoint();
        PixePoint p2=center2.toPixePoint();
        Rectangle r=p1.calceRectangle(p2);
        this.maxX=(int)Math.ceil(r.getWidth()/Parameters.WIDTH);
        this.maxY=(int)Math.ceil(r.getHeight()/Parameters.HEIGHT);
        System.out.println("maxX="+maxX+" maxY="+maxY);
       // System.exit(0);
    }

    public Center next()throws EndCenterException{
        if(x>=maxX){
            x=0;
            y+=1;
        }
        if(y>=maxY){
            throw new EndCenterException();
        }
        double rpixelx=pixelx+x*Parameters.WIDTH;
        double rpixely=pixely+y*Parameters.HEIGHT;
        Center c=Center.createByPixel(rpixelx,rpixely);
        c.setX(this.x);
        c.setY(this.y);
        this.x+=1;
        return c;
    }
	
}
