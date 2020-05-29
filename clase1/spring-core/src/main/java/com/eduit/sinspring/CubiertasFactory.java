package com.eduit.sinspring;

public class CubiertasFactory {

  private String rueda1;
  private String rueda2;
  private String rueda3;
  private String rueda4;
  private String marca;

  private CopasFactory copasFactory;

  public CubiertasFactory(String rueda1, String rueda2, String rueda3, String rueda4, String marca, CopasFactory copasFactory) {
    this.rueda1 = rueda1;
    this.rueda2 = rueda2;
    this.rueda3 = rueda3;
    this.rueda4 = rueda4;
    this.marca = marca;
    this.copasFactory = copasFactory;
  }
}
