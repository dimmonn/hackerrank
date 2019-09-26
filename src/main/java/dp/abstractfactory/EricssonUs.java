package dp.abstractfactory;

public class EricssonUs implements US {
    @Override
    public Void buid() {
        System.out.println(EricssonUs.class.getName());
        return null;
    }
}
