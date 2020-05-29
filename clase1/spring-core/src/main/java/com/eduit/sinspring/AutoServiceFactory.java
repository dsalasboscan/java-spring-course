package com.eduit.sinspring;

public class AutoServiceFactory {

  private CubiertasFactory cubiertasFactory;

  public AutoServiceFactory() {
    CopasFactory copasFactory = new CopasFactory("");

    cubiertasFactory = new CubiertasFactory("1", "2", "3", "4", "pirelli", copasFactory);
  }

  public void crearAuto() {
  }

  public void crearAuto(String test) {
    CopasFactory copasFactory = new CopasFactory("");
    CubiertasFactory cubiertasFactory
      = new CubiertasFactory("1", "2", "3", "4", "pirelli", copasFactory);
  }
}
