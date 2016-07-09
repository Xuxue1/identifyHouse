package com.xuxue.identifyhouse.show.gui;

import com.xuxue.identifyhouse.show.event.MeduListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by HanHan on 2016/5/20.
 */
public class TestMyMenue {
//118.362049,29.752707   118.366904 ,29.743116
    public static void main(String[] args){
        ComponentContaint c=new ComponentContaint();
        MyMenue menue=new MyMenue();
        menue.setName("MyMenue_1");
        c.add(menue);

        MeduListener lis=new MeduListener(c);
        menue.addMenueListener(lis);

        JFrame frame=new JFrame();
        frame.setName("MainFrame");
        c.add(frame);
        frame.setLayout(new BorderLayout());
        frame.add(menue, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100,100,1000,500);
        frame.setVisible(true);
    }

}
