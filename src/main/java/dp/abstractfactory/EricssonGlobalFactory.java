package dp.abstractfactory;

public class EricssonGlobalFactory implements VenorFactory {
    @Override
    public Apac createApac() {
        return new EricssonApac();
    }

    @Override
    public Emea createEmea() {
        return new EricssonEmea();
    }

    @Override
    public US createUs() {
        return new EricssonUs();
    }
}
