#include <WiFi.h>
#include <WiFiAP.h>
#include <WiFiClient.h>
#include <WiFiGeneric.h>
#include <WiFiMulti.h>
#include <WiFiSTA.h>
#include <WiFiScan.h>
#include <WiFiServer.h>
#include <WiFiType.h>
#include <WiFiUdp.h>

#include <HTTPClient.h>


String ssid = "Charlie";
String password = "200122Charlie";
String ip = "ipv4";
String apiUrl = "http://" + ip + ":8080/api/rest/v1/laser-tag";

const int valueToSend = 10;
const int sensor_pin = A0;
const int threshold = 4000;  

void setup() {   
  Serial.begin(9600);  

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    Serial.println("Connecting to WiFi..");
    delay(500);
  }
  Serial.println("Connected to WiFi!");  
}

void loop() {   
  int sensor = analogRead(sensor_pin);   
  if(sensor > threshold) {  
    delay(300);
    if(sensor>threshold) {
      HTTPClient  client;
      client.begin("apiUrl");
      client.addHeader("Content-Type", "application/json");
      client.POST("valueToSend");
      delay(5000);
    }  
  }  
}