/*
 * package com.mkyong.common;
 * 
 * import java.io.IOException; import java.net.URI; import java.net.URL; import
 * java.security.SecureRandom;
 * 
 * import org.apache.commons.httpclient.HttpClient; import
 * org.apache.commons.httpclient.HttpStatus; import
 * org.apache.commons.httpclient.methods.GetMethod;
 * 
 * 
 * public class SendingSMS {
 * 
 * public String generateOTP(){ SecureRandom random = new SecureRandom();
 * Integer i = 100000 + random.nextInt(900000); //Integer i =
 * random.nextInt((999999 - 100000) + 1); String otp = i.toString();
 * System.out.println("otp is "+otp+" for registration confirmation"); return
 * otp; } public void sendSMS(String mobileNumber, String otp){ try { // String
 * userId = "pelitc"; // String pwd = "pelitic@$U30";
 * 
 * String msg = "Welcome to Tradingapp. OTP is: "
 * +otp+" Use this OTP for account verification."; String urlStr=
 * "http://smslogin.pcexpert.in/api/mt/SendSMS?user=CBDONL&password=850582&senderid=CBDONL&channel=Trans&DCS=0&flashsms=0&number="
 * +mobileNumber+"&text="+msg+"&route=2"; // URI uri= new
 * URI(urlStr.replace(" ", "%20")); URL url=uri.toURL();
 * System.out.println(url.toString()); HttpClient client = new HttpClient();
 * 
 * GetMethod method = new GetMethod(url.toString());
 * 
 * try { int statusCode = client.executeMethod(method);
 * 
 * if (statusCode != HttpStatus.SC_OK) { System.err.println("Method failed: " +
 * method.getStatusLine()); } } catch (IOException e) {
 * System.err.println("Fatal transport error: " + e.getMessage());
 * e.printStackTrace(); } finally { method.releaseConnection(); } }
 * catch(Exception ex) { ex.printStackTrace(); System.out.println("exception "+
 * ex.getMessage()); } } }
 */