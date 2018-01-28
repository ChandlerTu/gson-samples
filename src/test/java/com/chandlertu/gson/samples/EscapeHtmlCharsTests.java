package com.chandlertu.gson.samples;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;

import org.junit.Test;

public class EscapeHtmlCharsTests {

  private Gson gson = new Gson();

  @Test
  public void escapeHtmlCharsToJson() {
    String string = "<>&=";

    String json = gson.toJson(string, String.class);

    assertThat(json).isEqualTo("\"\\u003c\\u003e\\u0026\\u003d\"");
  }

  @Test
  public void escapeHtmlCharsFromJson() {
    String json = "\"\\u003c\\u003e\\u0026\\u003d\"";

    String string = gson.fromJson(json, String.class);

    assertThat(string).isEqualTo("<>&=");
  }

  @Test
  public void fromJson() {
    String json = "\"<>&=\"";

    String string = gson.fromJson(json, String.class);

    assertThat(string).isEqualTo("<>&=");
  }

}
