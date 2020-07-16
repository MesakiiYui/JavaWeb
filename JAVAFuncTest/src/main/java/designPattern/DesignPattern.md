## 工厂模式

----

工厂模式属于创建型模式。意图：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。

最主要的还是ShapeFactory.getShape(),根据入参的不同决定访问哪个shape

## 抽象工厂在工厂模式的基础上更进一步

FactoryProducer根据你要shape还是color来决定返回的对象是shapeFactory还是colorFactory,后续操作一样
