package com.wxj.codebaselearn.annotation.userdefined;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/7/29 0029 9:58
 */
public class Banana {

    @FruitName("Banana")
    private String bananaName;

    @FriutColor(fruitColor = FriutColor.Color.YELLOW)
    private String bananaColor;

    @FruitProvider(id = 1,name = "北京旺旺",address = "酒仙桥")
    private String bananaProvider;

    public String getBananaProvider() {
        return bananaProvider;
    }

    public void setBananaProvider(String bananaProvider) {
        this.bananaProvider = bananaProvider;
    }

    public String getBananaName() {
        return bananaName;
    }

    public void setBananaName(String bananaName) {
        this.bananaName = bananaName;
    }

    public String getBananaColor() {
        return bananaColor;
    }

    public void setBananaColor(String bananaColor) {
        this.bananaColor = bananaColor;
    }


    public void displayName(){
        System.out.println("水果的名字是： 香蕉");
    }
}