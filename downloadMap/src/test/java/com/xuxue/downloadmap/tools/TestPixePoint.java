package com.xuxue.downloadmap.tools;

import org.junit.Test;

/**
 * Created by HanHan on 2016/5/19.
 */
public class TestPixePoint {

    @Test
    public void test(){
        PixePoint p=new PixePoint(1.2,2.1);
        PixePoint p2=new PixePoint(1.5,3);
        System.out.println(p.calceRectangle(p2));
    }

}
