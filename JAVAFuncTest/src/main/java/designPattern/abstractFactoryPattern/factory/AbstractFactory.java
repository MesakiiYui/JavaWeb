package designPattern.abstractFactoryPattern.factory;

import designPattern.bean.Color;
import designPattern.bean.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
