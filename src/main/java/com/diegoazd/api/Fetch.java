package com.diegoazd.api;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import java.util.*;

public class Fetch {
  int index = 0;
  int total = 0;
  int pages = 1;
  int page = 1;
  
  String[] results;

  public String[] get(String title) throws IOException {
      setInitialValues(fetchUrl(title, 1));
      fetchUrlByPage(title);
      Arrays.sort(results);

      return results;
  }

  private void setInitialValues(JsonObject element) {
      pages = element.get("total_pages").getAsInt();
      total = element.get("total").getAsInt();
      results = new String[total];
  }

  private JsonObject fetchUrl(String title, int page) throws IOException{
      URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title="+title+"&page="+page);
      InputStreamReader isr = new InputStreamReader(url.openStream());
      return new JsonParser().parse(isr).getAsJsonObject();
  }

  private void fetchUrlByPage(String title) throws IOException {
      for(int i=page; i <= pages; i++) 
        setTitle(fetchUrl(title, i).get("data").getAsJsonArray(), results);
  }

  private void setTitle(JsonArray jsonArray, String[] results) {
      for(JsonElement c: jsonArray)
        results[index++] = c.getAsJsonObject().get("Title").getAsString();
  }

}
