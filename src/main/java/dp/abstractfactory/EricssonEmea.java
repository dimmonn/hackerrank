package dp.abstractfactory;

public class EricssonEmea implements Emea {
    @Override
    public Void buid() {
        System.out.println(EricssonEmea.class.getName());
        return null;
    }
}
