import groovyx.net.http.RESTClient
import org.apache.commons.httpclient.util.URIUtil
import org.apache.commons.lang.StringUtils

import java.security.MessageDigest
import java.text.DateFormatSymbols

import static groovyx.net.http.ContentType.*

/**
 * Created by Development on 7/23/2014.
 */
class Training {
    static HEX_DIGITS = "0123456789abcdef"
    public static void main(String[] args) {
        /* try {
             System.setProperty("http.proxyHost", "tu0991as3");
             System.setProperty("http.proxyPort", "8080");
             URL url = new URL("http://localhost:8080/api/collector/postUGC");
             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setDoOutput(true);
             conn.setRequestMethod("POST");
             conn.setRequestProperty("Content-Type", "application/json");

             String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

             OutputStream os = conn.getOutputStream();
             os.write(input.getBytes());
             os.flush();

             if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                 throw new RuntimeException("Failed : HTTP error code : "
                         + conn.getResponseCode());
             }

             BufferedReader br = new BufferedReader(new InputStreamReader(
                     (conn.getInputStream())));

             String output;
             System.out.println("Output from Server .... \n");
             while ((output = br.readLine()) != null) {
                 System.out.println(output);
             }

             conn.disconnect();

         } catch (MalformedURLException e) {

             e.printStackTrace();

         } catch (IOException e) {

             e.printStackTrace();

         }*/


        /* String inputString="http://media.cheqqer.com/direct/tuinl/ecrm/producttype/zonvakantie.jpg"
           def r;

           def md = MessageDigest.getInstance("SHA1")
           r=md.digest(inputString.toString().getBytes())

           def result2 = new StringBuffer()
           r.each() {
               result2 << HEX_DIGITS[(it & 0xF0) >> 4]
               result2 << HEX_DIGITS[(it & 0x0F)]
           }
           println result2.toString()
   */
        String r="http://content-test.tui.nl/airport/out/output-airport-düsseldorf-dus-9987150.xml"
        println URIUtil.encodeQuery(r,"UTF-8")
        /*  String url="http://video.tui.nl/playlists/2000/2373.html?template=15&amp;height=414px&amp;width=736px"
          String height;
          String width;
          if(url.indexOf("height")>0){
              height=StringUtils.substringBetween(url,"height=","px")
              println(height)
          }
          if(url.indexOf("width")>0){
              width=StringUtils.substringBetween(url,"width=","px")
              println(width)
          }


              // Sample usage.
              // Should be "Apr" in English languages

          String[] months = new DateFormatSymbols().getMonths();
          for (int i = 0; i < months.length; i++) {
              String month = months[i];
              System.out.println("month = " + month);
          }

          String[] shortMonths = new DateFormatSymbols().getShortMonths();
          for (int i = 0; i < shortMonths.length; i++) {
              String shortMonth = shortMonths[i];
              System.out.println("shortMonth = " + shortMonth);
          }

          String[] germanyMonths = new DateFormatSymbols(new Locale('nl')).getMonths();
          for (int i = 0; i < germanyMonths.length; i++) {
              String germanyMonth = germanyMonths[i];
              System.out.println("germanyMonth = " + germanyMonth);
          }

          String[] germanyShortMonths = new DateFormatSymbols(Locale.GERMANY).getMonths();
          for (int i = 0; i < germanyShortMonths.length; i++) {
              String germanyShortMonth = germanyShortMonths[i];
              System.out.println("germanyShortMonth = " + germanyShortMonth);
          }



          String s="2"
          Integer s3=s
          println s3



          def map=["BAGGAGE EXTRA":1,"BAGGAGE ONLINE":2]

          def r=map.find{"BAGGAGE EXTRA (12FLY)".contains(it.key)}

  println r*/
    }
/**
 * @param month Month number
 * @return The short month name
 */
    public static String getMonthNameShort(int month,Locale locale)
    {

    }

}

