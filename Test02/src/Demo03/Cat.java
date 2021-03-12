package Demo03;

public class Cat extends Animial {
    public void  work()
    {
        System.out.println("抓老鼠");
    }

    @Override
    public void eat() {
        System.out.println("吃打饭");
    }
}
