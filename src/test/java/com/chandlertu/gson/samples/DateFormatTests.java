package com.chandlertu.gson.samples;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateFormatTests {

  private Gson gson = new Gson();

  private DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  @Test
  public void toJson() throws ParseException {
    Date date = dataFormat.parse("2018-01-04 12:29:12.123");

    String json = gson.toJson(date);

    assertThat(json).isEqualTo("\"Jan 4, 2018 12:29:12 PM\"");
  }

  @Test
  public void fromJson() throws ParseException {
    String json = "\"Jan 4, 2018 12:29:12 PM\"";

    Date date = gson.fromJson(json, Date.class);

    assertThat(date).isEqualTo(dataFormat.parse("2018-01-04 12:29:12.000"));
  }

}
