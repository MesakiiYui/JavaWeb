package designPattern.abstractFactoryPattern;

import designPattern.abstractFactoryPattern.factory.AbstractFactory;
import designPattern.abstractFactoryPattern.factory.ColorFactory;
import designPattern.abstractFactoryPattern.factory.ShapeFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
