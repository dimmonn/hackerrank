package dp.abstractfactory;

public class EricssonApac implements Apac {
    @Override
    public Void buid() {
        System.out.println(EricssonApac.class.getName());
        return null;
    }
}
