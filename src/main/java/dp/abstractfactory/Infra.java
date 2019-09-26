package dp.abstractfactory;

public class Infra {

  private Apac apac;
  private Emea emea;
  private US us;

  Void createInfra(VenorFactory infraFactory) {
    setApac(infraFactory.createApac());
    setEmea(infraFactory.createEmea());
    setUs(infraFactory.createUs());
    return null;
  }

  public void setApac(Apac apac) {
    this.apac = apac;
  }

  public void setEmea(Emea emea) {
    this.emea = emea;
  }

  public void setUs(US us) {
    this.us = us;
  }

  static class InfraFactory {

    static VenorFactory createInfraFactory(TypeMarker infraType) {
      return infraType.getTypeFactory();
    }
  }

  /**
   * main.
   */
  public static void main(String[] args) {
    Infra infra = new Infra();
    Void infra1 = infra.createInfra(InfraFactory.createInfraFactory(new CiscoType()));
    Void infra2 = infra.createInfra(InfraFactory.createInfraFactory(new EricssonType()));
  }
}