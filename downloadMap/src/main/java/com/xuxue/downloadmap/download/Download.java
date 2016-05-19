package com.xuxue.downloadmap.download;

import com.xuxue.downloadmap.tools.Center;
import com.xuxue.downloadmap.tools.CenterProviter;
import com.xuxue.downloadmap.tools.Parameters;

/**
 * Created by HanHan on 2016/5/19.
 */
public class Download {

    private static final String baseURL="https://maps.googleapis.com/maps/api/staticmap?";

    private CenterProviter p;

    public void Download(Center c1,Center c2){
        p=new CenterProviter(c1,c2);
    }

    public void download(){
        while(true){
            try{
                Center center=p.next();

            } catch (Exception e){

            }
        }
    }

    public static String centerToURL(Center c){
        return baseURL+"center="+c.toString()+"&zoom="+ Parameters.ZOOM+"&size="+Parameters.WIDTH+"x"+Parameters.HEIGHT+"&maptype=satellite";
    }

}
