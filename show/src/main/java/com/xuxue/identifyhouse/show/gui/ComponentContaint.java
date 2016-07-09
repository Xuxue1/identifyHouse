package com.xuxue.identifyhouse.show.gui;

import java.awt.Component;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这个类
 * Created by HanHan on 2016/5/20.
 */
public class ComponentContaint {

    private ConcurrentHashMap<String,Component> continers;

    public ComponentContaint(){
        this.continers=new ConcurrentHashMap<String,Component>();
    }

    public void add(Component com){
        continers.put(com.getName(),com);
    }

    public Component get(String name){
        return continers.get(name);
    }


}
