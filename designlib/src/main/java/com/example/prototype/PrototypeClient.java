package com.example.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建型
 * 定义:用原型实例指定创建对象的种类,并通过拷贝这些原型创建新的对象
 * 场景:1,类初始化需要消耗非常多的资源(数据,硬件);通过new产生一个对象需要繁琐的数据准备;当一个对象需要提供
 * 给其他对象访问,而且各个对象都可能修改其值时,可以使用保护性拷贝
 * Created by rgk on 16/9/27.
 */
public class PrototypeClient {
    public static void main(String[] args) {
        WordDocument document = new WordDocument();
        // edit doc
        document.setText("this is a document");
        document.addImages("image 1");
        document.addImages("image 2");
        document.addImages("image 3");
        document.showDocument();

        // copy a doc
        try {
            WordDocument document1 = document.clone();
            document1.showDocument();
            // modify this copy
            document1.setText("this is modified doc2");
            document1.showDocument();

            document.showDocument();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

interface Prototype {
    void clone();
}

class WordDocument implements Cloneable {
    private String mText;
    private List<String> mImages = new ArrayList<>();

    public WordDocument() {
        System.out.println("--------WordDocument构造方法---------");
    }

    @Override
    protected WordDocument clone() throws CloneNotSupportedException {
        WordDocument document = (WordDocument) super.clone();
        document.mText = this.mText;
        document.mImages = this.mImages;
        return document;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void addImages(String images) {
        mImages.add(images);
    }

    public void showDocument() {
        System.out.println("----Word Content Start----");
        System.out.println("text : " + mText);
        System.out.println("Images list : ");
        for (String s : mImages)
            System.out.println("image name : " + s);
        System.out.println("----Word Content End----");
    }
}
