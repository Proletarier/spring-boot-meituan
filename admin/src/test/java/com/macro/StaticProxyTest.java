package com.macro;


interface  ClothFactory{
    void  produceCloth();
}

class ProxyClothFactory implements  ClothFactory{

    private  ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("执行");
        factory.produceCloth();
        System.out.println("结束");
    }
}
class  NikeClothFactory implements  ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("生产");
    }
}

public class StaticProxyTest {
    public static void  main(String ...args){
        NikeClothFactory nikeClothFactory=new NikeClothFactory();
        ProxyClothFactory factory=new ProxyClothFactory(nikeClothFactory);
        factory.produceCloth();
    }
}
