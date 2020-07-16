package designPattern.abstractFactoryPattern.factory;

import designPattern.bean.Color;
import designPattern.bean.Shape;
import designPattern.bean.impl.Blue;
import designPattern.bean.impl.Green;
import designPattern.bean.impl.Red;

public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
