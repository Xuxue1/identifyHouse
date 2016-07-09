package com.xuxue.downloadmap.util;

import com.xuxue.downloadmap.tools.Center;

import java.io.Serializable;

/**
 * Created by HanHan on 2016/5/21.
 */
public class MapInfo implements Serializable{

    private Center c1;

    private Center c2;

    public MapInfo(){

    }

    public String toString(){
        StringBuilder builder=new StringBuilder();

        builder.append("c1.x"+c1.getLat()+" c1.y"+c1.getLon());
        builder.append("c2.x"+c2.getLat()+" c2.y"+c2.getLon());

        return builder.toString();
    }

    public MapInfo(Center c1,Center t2){
        this.c1=c1;
        this.c2=t2;
    }

    public Center getC2() {
        return c2;
    }

    public void setC2(Center c2) {
        this.c2 = c2;
    }

    public Center getC1() {
        return c1;
    }

    public void setC1(Center c1) {
        this.c1 = c1;
    }
}
