package com.xuxue.downloadmap.tools;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by HanHan on 2016/5/19.
 */
public class TestTransform {

    @Test
    public void test(){
        double lat=29.791503;
        double lon=118.364213;
        double lonn=Transform.lonToPixel(lon,18);
        double lonnn=Transform.pixelToLon(lonn,18);

        double latt=Transform.latToPixel(lat,18);
        double lattt=Transform.pixelToLat(latt,18);
        System.out.println("long="+lonn/256);
        System.out.println("latt="+latt/256);

    }

}
