package Demo03;

public class Test {
    public static void main(String[] args) {
        Animial animial=new Cat();
        animial.eat();
        Cat cat=(Cat)animial;
        cat.work();
    }
}
