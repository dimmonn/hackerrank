package dp.abstractfactory;


public class CiscoType implements TypeMarker {

    @Override
    public VenorFactory getTypeFactory() {
        return new CiscoGlobalFactory();
    }
}
