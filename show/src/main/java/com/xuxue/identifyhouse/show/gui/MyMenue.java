package com.xuxue.identifyhouse.show.gui;

import com.xuxue.identifyhouse.show.event.MeduListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HanHan on 2016/5/20.
 */
public class MyMenue extends JPanel{

    private JButton download;

    private JButton merge;

    private JButton analyze;

    private TextField lon;

    private TextField lat;

    private JLabel slon;

    private JLabel slat;


    public MyMenue(){
        download=new JButton("下载");
        analyze=new JButton("识别");
        merge=new JButton("合并");
        lon=new TextField(20);
        lat=new TextField(20);
        slon=new JLabel("起始经纬度:");
        slat=new JLabel("末尾经纬度:");

        this.setLayout(new FlowLayout());
        this.add(download);
        this.add(merge);
        this.add(analyze);
        this.add(slon);
        this.add(lon);
        this.add(slat);
        this.add(lat);
    }

    public void addMenueListener(MeduListener listener){
        this.download.addActionListener(listener);
        this.analyze.addActionListener(listener);
        this.merge.addActionListener(listener);
    }

    public JButton getMerge() {
        return merge;
    }

    public void setMerge(JButton merge) {
        this.merge = merge;
    }

    public JButton getDownload() {
        return download;
    }

    public void setDownload(JButton download) {
        this.download = download;
    }

    public JButton getAnalyze() {
        return analyze;
    }

    public void setAnalyze(JButton analyze) {
        this.analyze = analyze;
    }

    public TextField getLon() {
        return lon;
    }

    public void setLon(TextField lon) {
        this.lon = lon;
    }

    public TextField getLat() {
        return lat;
    }

    public void setLat(TextField lat) {
        this.lat = lat;
    }

    public JLabel getSlon() {
        return slon;
    }

    public void setSlon(JLabel slon) {
        this.slon = slon;
    }

    public JLabel getSlat() {
        return slat;
    }

    public void setSlat(JLabel slat) {
        this.slat = slat;
    }
}
