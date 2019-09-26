package dp.abstractfactory;

public class CiscoUs implements US {
    @Override
    public Void buid() {
        System.out.println(CiscoUs.class.getName());
        return null;
    }
}
