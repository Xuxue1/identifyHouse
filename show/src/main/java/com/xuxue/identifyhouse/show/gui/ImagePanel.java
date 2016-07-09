package com.xuxue.identifyhouse.show.gui;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by HanHan on 2016/5/20.
 */
public class ImagePanel extends JPanel{

    private ImageComponent imageComponent;

    public ImagePanel(File file)throws IOException{
        imageComponent=new ImageComponent(file);
        imageComponent.setfather(this);
        this.setLayout(new BorderLayout());
        this.add(imageComponent);
        this.setVisible(true);
        validate();
    }

    public ImageComponent getImageComponent() {
        return imageComponent;
    }

    public void setImageComponent(ImageComponent imageComponent) {
        this.imageComponent = imageComponent;
    }

    public static JScrollPane getScorlledImagePanel(File file)throws IOException{
        JScrollPane panel=new JScrollPane();
        ImagePanel imagePanel=new ImagePanel(file);
        imagePanel.getImageComponent().setPreferredSize();
        imagePanel.setPreferredSize(new Dimension(imagePanel.getWidth(), imagePanel.getHeight()));
        panel.setViewportView(imagePanel.getImageComponent());
        panel.add(imagePanel);
        return panel;
    }

}
