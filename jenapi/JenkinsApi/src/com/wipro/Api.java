package com.wipro;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class Api {

	public static void main(String[] args) {
		try {
		      URL url = new URL("http://23.251.159.27:8080/job/demo/build"); 
		      String user = "anil"; 
		      String pass = "115d72c061245c77642a9a0eb23f5bf2f5"; 
		      String authStr = user + ":" + pass;
		      String encoding = Base64.getEncoder().encodeToString(authStr.getBytes("utf-8"));

		      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		      connection.setRequestMethod("POST");
		      connection.setDoOutput(true);
		      connection.setRequestProperty("Authorization", "Basic " + encoding);
		      InputStream content = connection.getInputStream();
		      BufferedReader in = new BufferedReader(new InputStreamReader(content));
		      String line;
		      while ((line = in.readLine()) != null) {
		        System.out.println(line);
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

	}


