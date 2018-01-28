package com.chandlertu.gson.samples;

import com.google.gson.Gson;

import org.junit.Test;

public class StringAndIntegerConversionTests {

  private Gson gson = new Gson();

  @Test
  public void toJson() {
    StringFieldExample o = new StringFieldExample();
    o.setField("1");
    String j = gson.toJson(o);
    System.out.println(j);
  }

  @Test
  public void fromJson() {
    IntegerFieldExample o = gson.fromJson("{\"field\":\"1\"}", IntegerFieldExample.class);
    Integer i = o.getField();
    System.out.println(i);
  }

}
