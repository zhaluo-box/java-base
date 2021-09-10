package com.example.learn.pattern.strategy.demo3;

import java.util.HashMap;
import java.util.Map;

// 省略NormalDiscountStrategy、GrouponDiscountStrategy、PromotionDiscountStrategy类代码...
// 策略的创建
public class DiscountStrategyFactory {

    /**
     * 池化 缓存起来.
     */
    private static final Map<OrderType, DiscountStrategy> strategies = new HashMap<>();

    static {
        strategies.put( OrderType.NORMAL, new NormalDiscountStrategy() );
        strategies.put( OrderType.GROUPON, new GrouponDiscountStrategy() );
        strategies.put( OrderType.PROMOTION, new PromotionDiscountStrategy() );
    }

    /**
     * 获取策略.
     *
     * @param type 订单类型
     * @return 策略.
     */
    public static DiscountStrategy getDiscountStrategy(OrderType type) {
        return strategies.get( type );
    }


    /**
     * 如果业务场景需要每次都创建不同的策略对象，我们就要用另外一种工厂类的实现方式了
     *
     * @param type 订单类型
     * @return 策略.
     */
    public static DiscountStrategy getDiscountStrategy2(OrderType type) {

        if (type == null) {
            throw new IllegalArgumentException( "Type should not be null." );
        }

        if (type.equals( OrderType.NORMAL )) {
            return new NormalDiscountStrategy();
        } else if (type.equals( OrderType.GROUPON )) {
            return new GrouponDiscountStrategy();
        } else if (type.equals( OrderType.PROMOTION )) {
            return new PromotionDiscountStrategy();
        }
        return null;
    }
}
