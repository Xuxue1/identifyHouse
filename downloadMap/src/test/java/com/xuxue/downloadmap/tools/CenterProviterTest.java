package com.xuxue.downloadmap.tools;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by HanHan on 2016/5/19.
 */
public class CenterProviterTest {

    CenterProviter p=new CenterProviter(new Center(1,1),new Center(1.01,1.01));

    @Before
    public void befor(){

    }

    @Test
    public void test(){
        try{
            while(true){
                Center c=p.next();
                System.out.println(c+" "+c.getX()+" "+c.getY());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
