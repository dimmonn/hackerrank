package dp.abstractfactory;

public class CiscoApac implements Apac {
    @Override
    public Void buid() {
        System.out.println(Apac.class.getName());
        return null;
    }
}
