package com.chandlertu.gson.samples;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DateFormatTests {

  private Gson gson = new Gson();

  private DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

  @Test
  public void toJson() throws ParseException {
    DateFieldExample dateField = new DateFieldExample(dataFormat.parse("2018-01-04 12:29:12.123"));

    String json = gson.toJson(dateField);

    assertThat(json).isEqualTo("{\"date\":\"Jan 4, 2018 12:29:12 PM\"}");
  }

  @Test
  public void fromJson() throws ParseException {
    String json = "{\"date\":\"Jan 4, 2018 12:29:12 PM\"}";

    DateFieldExample dateField = gson.fromJson(json, DateFieldExample.class);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateField.getDate());
    assertThat(calendar.get(Calendar.SECOND)).isEqualTo(12);
    assertThat(calendar.get(Calendar.MILLISECOND)).isEqualTo(0);
  }

  @Test(expected = JsonParseException.class)
  public void givenDateValueIsEmptyWhenFromJson() {
    String json = "{date:\"\"}";

    gson.fromJson(json, DateFieldExample.class);
  }

}
