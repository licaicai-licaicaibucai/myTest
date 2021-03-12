package demo01;

public class UlLecturer extends Stuff implements Drawing {
    @Override
    public void drawing() {
        System.out.println("还得花花");
    }

    @Override
    public void work() {
        System.out.println("整天工作");
    }
}
