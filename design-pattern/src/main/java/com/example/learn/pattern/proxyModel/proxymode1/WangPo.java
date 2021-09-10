package com.example.learn.pattern.proxyModel.proxymode1;

/**
 * I'm glad to share my knowledge with you all.
 * 王婆这个人老聪明了，她太老了，是个男人都看不上，
 * 但是她有智慧有经验呀，她作为一类女人的代理！
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    /**
     * 空构造王婆的时候返回潘金莲
     */
    public WangPo() { //默认的话，是潘金莲的代理
        this.kindWomen = new PanJinLian();
    }

    //她可以是KindWomen的任何一个女人的代理，只要你是这一类型

    /**
     * 构造器 传递目标对象,静态代理
     * 可以是贾氏,可以是潘金莲,只要是哪一类女人即可.
     * @param kindWomen
     */
    public WangPo(KindWomen kindWomen) {
        this.kindWomen = kindWomen;
    }

    public void happyWithMan() {
        this.kindWomen.happyWithMan(); //自己老了，干不了，可以让年轻的代替
    }

    public void makeEyesWithMan() {
        this.kindWomen.makeEyesWithMan(); //王婆这么大年龄了，谁看她抛媚眼？！
    }
}
