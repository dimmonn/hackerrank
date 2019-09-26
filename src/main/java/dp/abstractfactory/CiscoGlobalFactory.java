package dp.abstractfactory;

public class CiscoGlobalFactory implements VenorFactory {
    @Override
    public Apac createApac() {
        return new CiscoApac();
    }

    @Override
    public Emea createEmea() {
        return new CiscoEmea();
    }

    @Override
    public US createUs() {
        return new CiscoUs();
    }
}
