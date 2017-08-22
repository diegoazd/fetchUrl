package com.diegoazd.api;

import org.junit.*;
import java.io.IOException;

public class FetchTest {
  
  @Test
  public void shouldReturnSomeResult() throws IOException {
    Fetch fetch = new Fetch();
    String[] results = fetch.get("spiderman");
    Assert.assertTrue(results.length == 13);
    Assert.assertTrue(results[12] != null && results[12] != "");
    Assert.assertEquals(results[0], "Amazing Spiderman Syndrome");
    Assert.assertEquals(results[12], "They Call Me Spiderman");

  }
}
