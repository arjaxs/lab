/**
 * Created by Development on 8/29/2014.
 */


import org.apache.commons.httpclient.util.URIUtil
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
class FileUpload {


    static{
        System.getProperties().put("http.proxyHost", "proxy");
        System.getProperties().put("http.proxyPort", "8080");
        System.getProperties().put("http.proxyUser", "extaj3");
        System.getProperties().put("http.proxyPassword", "arif\$7augs7");
    }

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier(){
                    public boolean verify(String hostname,
                                          javax.net.ssl.SSLSession sslSession) {
                        if (hostname.equals("localhost")) {
                            return true;
                        }
                        return false;
                    }
                });
    }
    public static void  main(String[] args) {
//        try {
//            System.setProperty("http.proxyHost", "tu0991as3");
//            System.setProperty("http.proxyPort", "8080");
//            URL url = new URL("http://dev-api.cheqqer.com/api/community/postUgcV3");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setDoOutput(true);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json");
//
//            String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
//
//            OutputStream os = conn.getOutputStream();
//            os.write(input.getBytes());
//            os.flush();
//
//
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//
//            conn.disconnect();
//
//        } catch (MalformedURLException e) {
//
//            e.printStackTrace();
//
//        } catch (IOException e) {
//
//            e.printStackTrace();
//
//        }

        Authenticator.setDefault(new ProxyAuthenticator("extaj3", "arif\$7augs7"));
        System.setProperty("http.proxyHost", "tu0991as3");
        System.setProperty("http.proxyPort", "8080");
        HttpClient client = new DefaultHttpClient() ;
        HttpPost postRequest = new HttpPost ("http://dev-api.cheqqer.com/api/community/postUgcV3") ;
        try
        {
/**
 *
 * <endpoint>http://tui.padma.razuna.org/index.cfm</endpoint>
 <!-- API KEY -->
 <key>B27862C83A004322AEC6B39E5E88579B</key>
 <!-- parent labels -->
 <parent>
 <label>Concepts</label>
 </parent>
 *
 */

            HttpClient httpclient = new DefaultHttpClient();
         println new URL("http://tui.padma.razuna.org/index.cfm/").getText()

            InputStream inputStream = new URL("http://media.cheqqer.com/direct/ugcc/6/e/4/community_1403025785588_189b68d0.jpeg").openStream();

            ByteArrayInputStream imageByteInputStream = new ByteArrayInputStream(inputStream.getBytes())
            ByteArrayOutputStream imageByteOutputStream = new ByteArrayOutputStream(imageByteInputStream.read())

            MultipartEntity multiPartContent = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE)
            multiPartContent.addPart("fa",new StringBody("c.apiupload"))
            multiPartContent.addPart("api_key",new StringBody("B27862C83A004322AEC6B39E5E88579B"))
            multiPartContent.addPart("destfolderid",new StringBody("1627ECABCE594870B36772B36FD6C62B"))
            multiPartContent.addPart("filedata", new InputStreamBody(imageByteInputStream, 'jpg'  , 'test' ))
            URI uri = new URI("http://tui.padma.razuna.org/index.cfm/");

            HttpPost post = new HttpPost(uri)
            post.setHeader("Content-Type", "multipart/form-data")
            post.setEntity(multiPartContent)
           // System.out.println("executing request to " + endpoint + " via " + proxy)

//      create the client, make the request Get the response
            HttpResponse response = httpclient.execute(post)
           // log.debug("sending image:" + imageUrl.text + "Image post response :" + response.statusLine + "Razuna Asset ID " + response.getHeaders('assetid'))

            println response
        }
        catch (Exception ex)
        {
            ex.printStackTrace() ;
        }


    }


}
