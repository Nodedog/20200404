
class Animal{
    public String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(){
        System.out.println("Animal" + this.name + "正在吃");
    }
    //如果与cat 构成重写  那么这里不能是 private
   /* private void eat(){
        System.out.println(this.name + "正在吃");
    }*/

}

class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
    public void run(){
        System.out.println( "dog" + this.name + "正在跑");
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    //构成重写 那么子类的访问修饰限定符 要大约等于 父类的访问修饰限定符 public proteceted
    @Override
    public void eat(){
        System.out.println("cat" + this.name + "正在吃猫粮");
    }
}

public class TestDome {
    public static void main(String[] args) {
        Animal animal = new Cat("小猫咪");
        //此时animal并不是Dog的一个实例
        if (animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.run();
        }
    }


    public static void main5(String[] args) {
        Animal animal = new Dog("小狗");
        //发生运行时绑定（动态绑定）
        animal.eat();

        //向下转型
        Dog dog = (Dog) animal;
        dog.run();
    }





    //第三种 返回值的形式 进行向上转型
    public static Animal func2(){
        Cat cat1 = new Cat("小猫");
        return cat1;
        //或者直接return new cat("小猫");
    }
    public static void main4(String[] args) {
        Animal animal =  func2();
        System.out.println(animal.name);
    }


    //第二种 传参的形式 进行向上转型
    public static void func1(Animal animal){
        animal.eat();
    }
    public static void main3(String[] args) {
        Cat cat = new Cat("小鸟");
        func1(cat);
    }


    //第一种  直接赋值 进行向上转型
    public static void main2(String[] args) {
        //父类引用 引用子类对象  叫 向上转型
        Animal animal =  new Cat("咪咪");
    }




    public static void main1(String[] args) {
        Animal animal = new Animal("动物");
        Dog dog = new Dog("狗狗");
        Cat cat = new Cat("猫咪");

    }
}



