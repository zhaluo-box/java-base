package com.example.learn.pattern.strategy.demo1;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略工厂.
 */
public class StrategyFactory {

    /**
     * 池化,将策略缓存起来.
     */
    private static final Map<String, Strategy> strategies = new HashMap<>();

    /**
     * 静态代码块 . 伴随着类的加载而执行
     */
    static {
        strategies.put( "A", new ConcreteStrategyA() );
        strategies.put( "B", new ConcreteStrategyB() );
    }


    /**
     * <p>
     * 一般来讲，如果策略类是无状态的，不包含成员变量，只是纯粹的算法实现， <br/>
     * 这样的策略对象是可以被共享使用的，不需要在每次调用 getStrategy() 的时候， <br/>
     * 都创建一个新的策略对象。针对这种情况，我们可以使用上面这种工厂类的实现方式， <br/>
     * 事先创建好每个策略对象，缓存到工厂类中，用的时候直接返回
     * </p>
     *
     * @param type
     * @return
     */
    public static Strategy getStrategy(String type) {

        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException( "type should not be empty." );
        }

        return strategies.get( type );

    }


    /**
     * <p>
     * 如果策略类是有状态的，根据业务场景的需要，我们希望每次从工厂方法中，<br/>获得的都是新创建的策略对象，
     * 而不是缓存好可共享的策略对象，那我们就需要按照如下方式来实现策略工厂类
     * </P>
     *
     * @param type 策略类型
     * @return 策略.
     */
    public static Strategy getStrategy2(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException( "type should not be empty." );
        }
        if (type.equals( "A" )) {
            return new ConcreteStrategyA();
        } else if (type.equals( "B" )) {
            return new ConcreteStrategyB();
        }
        return null;
    }


}
