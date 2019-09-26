package dp.abstractfactory;


public class EricssonType implements TypeMarker {

    @Override
    public VenorFactory getTypeFactory() {
        return new EricssonGlobalFactory();
    }
}
