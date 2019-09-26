package dp.abstractfactory;

public interface VenorFactory {
    Apac createApac();

    Emea createEmea();

    US createUs();
}
