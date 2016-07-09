package com.xuxue.downloadmap.tools;

import java.lang.annotation.Target;

/**
 * Created by HanHan on 2016/5/19.
 */
public class Test {

    public static void main(String[] args){
        double slon=29.752609;
        double slat=118.363270;
        double elon=29.743094;
        double elat=118.366331;

        double ilon=Transform.getFirstLonPixel(Parameters.ZOOM,(int)Math.pow(2,Parameters.ZOOM));
        double ilat= Transform.getFirstLatPixel(Parameters.ZOOM,(int)Math.pow(2,Parameters.ZOOM));

        double slonP=Transform.lonToPixel(slon,Parameters.ZOOM);
        double slatP=Transform.latToPixel(slat,Parameters.ZOOM);
        double elonP=Transform.lonToPixel(elon,Parameters.ZOOM);
        double elatP=Transform.latToPixel(elat,Parameters.ZOOM);

        System.out.println("slonP="+slonP);
        System.out.println("slatP="+slatP);

        int rs=(int)((slatP-ilat)/Parameters.HEIGHT);
        int cs=(int)((slonP-ilon)/Parameters.WIDTH);
        int re=(int)((elatP-ilat)/Parameters.HEIGHT);
        int ce=(int)((elonP-ilon)/Parameters.WIDTH);
        System.out.println("rs="+rs);
        System.out.println("cs="+cs);
        System.out.println("re="+re);
        System.out.println("ce="+ce);
    }

}
