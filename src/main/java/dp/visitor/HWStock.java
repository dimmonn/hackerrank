package dp.visitor;

public class HWStock implements Visitable {
    private HDD hdd;
    private Keyboard keyboard;
    private Monitor monitor;

    public HWStock(HDD hdd, Keyboard keyboard, Monitor monitor) {
        this.hdd = hdd;
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    @Override
    public void accept(Visitor visitor) {
        hdd.accept(visitor);
        keyboard.accept(visitor);
        monitor.accept(visitor);
    }
}