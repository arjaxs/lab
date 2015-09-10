import groovyx.net.http.RESTClient

/**
 * Created by Development on 8/12/2014.
 */
try {
    System.setProperty("http.proxyHost", "tu0991as3");
    System.setProperty("http.proxyPort", "8080");
    def client = new RESTClient( 'http://www.acme.com/' )
    def resp = client.post( path : '/user/details',
            body : [ firstName:'John', lastName:'Doe' ] )




} catch (MalformedURLException e) {

    e.printStackTrace();

} catch (IOException e) {

    e.printStackTrace();

}