package com.xuxue.downloadmap.tools;

/**
 * Created by HanHan on 2016/5/20.
 */
public class TooManyPictureException extends Exception {

    public TooManyPictureException(String message){
        super(message);
    }

    public TooManyPictureException(){
        super();
    }

    public TooManyPictureException(Exception e){
        super(e);
    }

}
