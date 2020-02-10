package runoob.Polymorphism;

/**
 * 多态
 */

public class Polymorphism {
    public class Animal {
        private void eat() {
            System.out.println("Animal eat");
        }
    }

    public class Cat extends Animal{
        private void eat() {
            System.out.println("Cat eat");
        }
        private void run() {
            System.out.println("Cat run");
        }
    }

    public class Dog extends Animal{
        private void eat() {
            System.out.println("Dog eat");
        }
    }

    public static void main(String[] args) {
        Polymorphism pmp = new Polymorphism();
        // 内部非静态类的实例化方法
        Polymorphism.Animal animal_animal = pmp.new Animal();
        Polymorphism.Animal animal_cat = pmp.new Cat();
        Polymorphism.Cat cat_cat = pmp.new Cat();
        animal_animal.eat();
        animal_cat.eat();
        cat_cat.eat();
    }
}
