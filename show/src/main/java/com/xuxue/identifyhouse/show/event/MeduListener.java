package com.xuxue.identifyhouse.show.event;

import com.xuxue.downloadmap.download.Download;
import com.xuxue.downloadmap.tools.Center;
import com.xuxue.downloadmap.tools.TooManyPictureException;
import com.xuxue.identifyhouse.show.gui.ComponentContaint;
import com.xuxue.identifyhouse.show.gui.ImagePanel;
import com.xuxue.identifyhouse.show.gui.MyMenue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.File;

/**
 * Created by HanHan on 2016/5/20.
 */
public class MeduListener implements ActionListener{

    ComponentContaint containt;



    public MeduListener(ComponentContaint containt){
        this.containt=containt;
    }


    public void actionPerformed(ActionEvent e) {
        MyMenue menue=(MyMenue) containt.get("MyMenue_1");



        if(e.getSource()==menue.getAnalyze()){
            System.out.println("分析");
        }else if(e.getSource()==menue.getDownload()){
            String[] point1=menue.getLat().getText().split(",");
            String[] point2=menue.getLon().getText().split(",");
            File file=null;
            try{
                Center c1= Center.createByStrings(point1);
                Center c2=Center.createByStrings(point2);
                Download download=new Download(c1,c2);
                download.download();
                file=download.mergePicture();
                JScrollPane imagePanel= ImagePanel.getScorlledImagePanel(file);
                JFrame frame=(JFrame) containt.get("MainFrame");
                frame.add(imagePanel, BorderLayout.CENTER);
            }catch (NumberFormatException ee){
                JOptionPane.showMessageDialog(menue,"输入的经纬度格式不正确","title",1);

            }catch (TooManyPictureException ee){
                JOptionPane.showMessageDialog(menue,"你要下载的图片太多了","title",1);
            }catch (IOException ee){
                ee.printStackTrace();
                JOptionPane.showMessageDialog(menue,"合并图片出现错误","title",1);
            }catch (ClassNotFoundException ee){
                ee.printStackTrace();
                JOptionPane.showMessageDialog(menue,"类无法找到","title",1);
            }


        }else if(e.getSource()==menue.getMerge()){
            System.out.println("merget");
            try{
                Download d=new Download(new Center(118.362380,29.752344),new Center(118.366093,29.742512));
                File file=d.mergePicture();
                JScrollPane imagePanel= ImagePanel.getScorlledImagePanel(file);
                JFrame frame=(JFrame) containt.get("MainFrame");
                frame.add(imagePanel, BorderLayout.CENTER);
                System.out.println("add");
                frame.repaint();
            }catch (Exception ee){
                ee.printStackTrace();
            }
        }
    }
}
