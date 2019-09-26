package dp.abstractfactory;

public class CiscoEmea implements Emea {
    @Override
    public Void buid() {
        System.out.println(CiscoEmea.class.getName());
        return null;
    }
}
