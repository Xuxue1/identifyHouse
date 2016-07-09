package com.xuxue.identifyhouse.show.gui;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by HanHan on 2016/5/20.
 */
public class TestImagePanel {

    public void befor(){

    }


    public void test()throws IOException{
        JFrame frame=new JFrame();
        frame.setContentPane(ImagePanel.getScorlledImagePanel(new File("H:\\1图像识别软件--gengtao\\村落识别\\Picture\\wanan.jpg")));
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args)throws IOException{
        new TestImagePanel().test();
    }

}
