package com.xuxue.identifyhouse.show.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by HanHan on 2016/5/20.
 */
public class TestImagePanel {

    public static void main(String[] args)throws IOException{

        JFrame frame=new JFrame("Hello");
        JScrollPane s=new JScrollPane();
        System.out.println((new File("")).getAbsolutePath());

        ImagePane panel=new ImagePane(new File("map\\new.png"));

        s.add(panel);
        frame.setContentPane(s);
        frame.setLocation(100,100);
        frame.setBounds(100,200,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static class ImagePane extends JPanel{

        public ImagePane(File file)throws IOException{
            BufferedImage image=ImageIO.read(file);
            this.setLayout(new BorderLayout());
            ImageComponent imageComponent=new ImageComponent(image,500,500);
            this.add(imageComponent);
            setVisible(true);
            validate();
        }
    }

    public static class ImageComponent extends JPanel{

        private BufferedImage image;

        private int width;

        private int height;


        public ImageComponent(BufferedImage image,int width,int height){
            this.image=image;
            this.width=width;
            this.height=height;
            setPreferredSize(new Dimension(width,height));
            setLayout(new BorderLayout());
            setVisible(true);
            validate();
            this.repaint();
        }


        @Override
        public void paintComponent(Graphics g){
            g.drawImage(image, 0, 0,width, height, null);
        }


    }

}
