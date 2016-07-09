package com.xuxue.identifyhouse.show.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Created by HanHan on 2016/5/20.
 */
public class ImageComponent extends JPanel{

    private BufferedImage image;

    private int weidth;

    private int heigth;

    private Component component;

    public ImageComponent(File imageFile,int weidth,int height)throws IOException{
        image= ImageIO.read(imageFile);
        this.weidth=weidth;
        this.heigth=height;
    }

    public ImageComponent(BufferedImage image){
        this.image=image;
        this.weidth=image.getWidth();
        this.heigth=image.getHeight();
    }

    public ImageComponent(File imageFile)throws IOException{
        image= ImageIO.read(imageFile);
        this.weidth=image.getWidth();
        this.heigth=image.getHeight();
    }

    public void setfather(Component component){
        this.component=component;
    }

    public void setPreferredSize(){
        this.setPreferredSize(new Dimension(this.weidth,this.heigth));
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(image,0,0,weidth,heigth,null);
        component.repaint();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWeidth() {
        return weidth;
    }

    public void setWeidth(int weidth) {
        this.weidth = weidth;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
}
