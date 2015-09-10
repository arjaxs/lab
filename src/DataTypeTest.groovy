import groovy.xml.MarkupBuilder
import groovy.xml.StreamingMarkupBuilder
import groovy.xml.XmlUtil
import jxl.Cell
import jxl.Sheet
import jxl.Workbook
import jxl.WorkbookSettings
import org.apache.commons.codec.digest.DigestUtils
import org.apache.commons.lang.StringEscapeUtils
import org.apache.commons.lang.StringUtils

import org.springframework.web.util.HtmlUtils
import org.w3c.tidy.Tidy

import java.nio.charset.Charset
import java.text.BreakIterator
import java.text.DecimalFormat
import java.text.Normalizer
import java.text.SimpleDateFormat
import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * Created by Development on 5/6/2014.
 */
class DataTypeTest {
def static test

    static main(String[] args) {
//
//        println StringEscapeUtils.escapeXml11("Leau cœur d'une oasis verdoyante œ Riu Helios est un quatre étoiles où qualité, service accueillant, chambres spacieuses et une table d'exception se conjuguent pour vous. Il s'ouvre sur la mer Noire, directement le long d'une plage avec dunes s'étendant sur 8 km. Idéal pour des vacances amusantes en famille, entre amis ou à deux! De même, le centre trépidant et convivial de la Sunny Beach touristique est à proximité. Vous trouverez des tas de petits restaurants, magasins, bars avec musique live et danse, ainsi que des discos")
//        println StringEscapeUtils.escapeHtml4(
//                "De kamers bevinden zich in het hoofdgebouw of in één van de bi Le œ ﬃ Riu Helios est un quatre étoiles où qualité, service accueillant, chambres spacieuses et une table d'exception se conjuguent pour vous. Il s'ouvre sur la mer Noire, directement le long d'une plage avec dunes s'étendant sur 8 km. Idéal pour des vacances amusantes en famille, entre amis ou à deux! De même, le centre trépidant et convivial de la Sunny Beach touristique est à proximité. Vous trouverez des tas de petits restaurants, magasins, bars avec musique live et danse, ainsi que des discos")
//println "œ sds".contains("œ")
//        println StringUtils.replace(org.apache.commons.lang.StringEscapeUtils.escapeXml("" +
//                "  Torshavn is één van de kleinste hoofdsteden ter wereld. In deze stad kom je een mix van oude en nieuwe stijl tegen. Vooral een wandeling door het oude gedeelte van de wijk 'a Reyni' is de moeite waard. Neem ook een kijkje in Tinganes en Skansin fort. De gezellige stad kent tal van mooie winkels en sfeervolle restaurants en bars. Torshavn is centraal gelegen en de infrastructuur is prima, waardoor u gemakkelijk uitstapjes kunt maken naar de eilanden Vágar, Nólsoy, Sandoy of Myskines. Het motto v"
//
//        ),"&amp;#","&#")
//        println org.apache.commons.lang.StringEscapeUtils.unescapeXml(org.apache.commons.lang.StringEscapeUtils.escapeXml("Le œ  Riu Helios est un quatre étoiles où qualité, service accueillant, chambres spacieuses et une table d'exception se conjuguent pour vous. Il s'ouvre sur la mer Noire, directement le long d'une plage avec dunes s'étendant sur 8 km. Idéal pour des vacances amusantes en famille, entre amis ou à deux! De même, le centre trépidant et convivial de la Sunny Beach touristique est à proximité. Vous trouverez des tas de petits restaurants, magasins, bars avec musique live et danse, ainsi que des discos "))
//
//        BufferedReader reader = new BufferedReader(
//
//                new FileReader("C:/Cheqqer/empty.txt"));
//
//        System.out.println(reader.getLine());
//        String returnString;
//
//      Object  obj = new Integer(42);
//       println obj = new Double(42.0);
//        def x=null;
//        def y=null;
//       println x.equals(y);
//
//
//        String inputString="Hotel Gran Bahía Príncipe Akumal"
//
//        println returnString
//        returnString=StringUtils.replace(org.apache.commons.lang.StringEscapeUtils.escapeXml(inputString), "&amp;amp", "&amp;")
//        returnString=StringUtils.replace(returnString,"&amp;quot", "&quot")
//        returnString=StringUtils.replace(returnString,"&amp;apos", "&apos")
//        returnString=StringUtils.replace(returnString,"&amp;#", "&#")
//        println returnString
//        def writer = new StringWriter()
//        def xml = new MarkupBuilder(writer)
//       // test=mkp
//
//    xml.records {
//        test=mkp
//    car(name:'HSV Maloo', make:'Holden', year:2006) {
//        country('Australia')
//        record(type:'speed', mkp.yieldUnescaped('Production Pickup Truck wasdasdasd&&& &amp;ith speed of 271kph'))
//    car(name:'P50', make:'Peel', year:1962) {
//        country('Isle of Man')
//        record(type:'size', 'Smallest Street-Legal Car at 99cm wide and 59 kg in weight')
//
//
/*
String test="arifulla@sonata-software.com"
        byte[] bytes = test.getBytes("US-ASCII")
//        println bytes.sum();


        def comment = "<![CDATA[<!-- address is new to this release -->]]>"
        def builder = new groovy.xml.StreamingMarkupBuilder()
        builder.encoding = "UTF-8"
        def person = {
            mkp.xmlDeclaration()

            person(id:100){
               firstname{mkp.yieldUnescaped("Jan&&e")}
               // mkp.yieldUnescaped firstname("Jan&&e")

            }
        }
        def writer = new FileWriter("personss2.xml")
        writer << builder.bind(person)
*/
/*String inputString="à"
        println  HtmlUtils.htmlEscapeDecimal(inputString);
   *//*println  HtmlUtilsinputString);
        println  HtmlUtils.htmlEscapeHex("&#39;");
     *//*   //tidy.parse(inputStream, System.out); // run tidy, providing an input and output stream
File spreadSheet= new File("C:\\Users\\Development\\Documents\\Book1.xlsx")

        def fs = new FileInputStream(new File(spreadSheet.getAbsolutePath()));
        WorkbookSettings ws = null;
        Workbook workbook ;
        ws = new WorkbookSettings();
        ws.setEncoding("Cp1252");
        workbook = Workbook.getWorkbook(fs, ws);
        Sheet sheet = workbook.getSheet(0);
        def rowCount = sheet.getRows();
        for (int i = 8; i < rowCount; i++) {
            // Get Individual Row
            Cell[] rowData = sheet.getRow(i);

println rowData

}
        fs.close()*/

       /*  String  inputString="http://media.cheqqer.com/direct/cheqqer_news_letter/th-logo.jpg";
        println DigestUtils.sha1Hex(inputString);
println Integer.parseInt(null)

        println 'no-rating'.isNumber()



        String s="aadsasd,basdasd,casdasd,dasdasd,easdad"

        def ss=s.split(',')
        ss[0]


        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
// or SimpleDateFormat sdf = new SimpleDateFormat( "MM/dd/yyyy KK:mm:ss a Z" );
        sdf.setTimeZone( TimeZone.getTimeZone( "UTC" ) );
        println new Date()
        println sdf.format(new Date())*/


       /* String s="Alleen aandacht voor elkaar Een cocktail drinken bij het zwembad en ‘ws avond dineren op het strand. In de COUPLES hotel komt u alleen volwassenen tegen. Echt ongestoord genieten van de vakantie."

        s="Alleen aandacht voor elkaar Een cocktail drinken bij het zwembad en 's avond dineren op het strand. In de COUPLES hotel komt u alleen volwassenen tegen. Echt ongestoord genieten van de vakantie."
        println StringEscapeUtils.escapeXml(s)
        println HtmlUtils.htmlEscapeDecimal(s)*/

      /*  String s="http://media.cheqqer.com/direct/tui_be_images/1/a/8/tui_be_images.12061O.jpg"
        def extension=StringUtils.split(s,'.')
        def imageExt=extension[extension.length-1]
        println imageExt*/


        /*String source = """
Uw eigen huis in een droomomgeving en geniet van de rust en natuur! Verspreid over het eiland Streymoy, het grootste eiland van de Færøer, liggen de verschillende zomerhuizen. Van hieruit kunt u allerlei excursies maken, zoals een boottocht naar het eiland Nólsoy, waar u een kolonie stormvogels kunt bewonderen of een boottocht vanuit Vestmanna door grotten en langs steile kliffen.Dit comfortabele Riu hotel heeft een ideale ligging direct aan het strand.U kunt er genieten van de overheerlijke Riu-buffetten, relaxen aan het zwembad of deelnemen aan één van de talrijke (sport) activiteiten. Hier bent u verzekerd van een zorgeloze vakantie."""

        BreakIterator bi=BreakIterator.getWordInstance(Locale.default)
        int counter = 0;
        if(source.length()>500)
        bi.setText(source.substring(0,499));

        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE) {
                String sentence = source.substring(firstIndex, lastIndex);
                System.out.println("sentence = " + sentence);
                counter++;
            }
        }

        int end = bi.last();
        int start = bi.previous();
        println bi.preceding(bi.last())
        println start
        String s=source.substring(bi.first(),bi.preceding(bi.last()))+' ...'
        println s;
        def listOfWords=source.substring(0,499);
        String[] b = listOfWords.split("\\s+");
        String lastWord = b[b.length - 1];
        String rest = listOfWords.substring(0,listOfWords.indexOf(lastWord)).trim(); // Added
        println rest + ' ...'
       // System.out.println(org.apache.commons.lang3.StringUtils.abbreviate(rest,rest.length()-1));
      //  System.out.println(org.apache.commons.lang3.StringUtils.abbreviate(s,s.length()-5))

println source.length();*/
/*
        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile(".{1,50}(?:\\s|\\$)", Pattern.DOTALL);
        Matcher regexMatcher = regex.matcher(source);
        while (regexMatcher.find()) {
            matchList.add(regexMatcher.group());
        }

        println matchList*/


/*        String description="""
De inwoners van Gibraltar stammen af van Engelsen, joden, Portugezen en Spanjaarden. De Engelsen bezetten Gibraltar in 1704 tijdens de Spaanse Successie oorlog. Negen jaar later, met de Vrede van Utrecht, kreeg Engeland de rots 'voor altijd' toegewezen. In de koloniale tijd was 'the rock' van levensbelang voor de Engelsen. Vanaf hier werd de toegang tot de Middellandse Zee bewaakt. Elk jaar bezoeken zo'n vier miljoen mensen dit stukje Engeland, dat aan Andalusië zit vastgeplakt. U vindt er pubs, ale, fish and chips, engelse ponden en bobby's. Een kabelbaan gaat van het centrum van de stad naar de 'top of the rock', het hoogste punt van Gibraltar (450 meter). The keep, het onderste deel van een Moors kasteel uit de achttiende eeuw, is nog altijd in gebruik als gevangenis. De grotten van Saint Michael deden in de Tweede Wereldoorlog dienst als militair hospitaal. Tegenwoordig worden er klassieke concerten gegeven. Apes'Den is het domein van de staartloze apen van Gibraltar. Gezegd wordt dat de Engelsen de rots net zo lang in bezit zullen hebben als er apen zijn. Vanaf Europa Point, op de zuidpunt, kijkt u over de Straat van Gibraltar naar Noord-Afrika. In het Gibraltarmuseum, gebouwd op de fundamenten van Moorse baden, wordt de geschiedenis van Gibraltar verteld.
"""
        try {
            description = description?.substring(0, 496)
            String[] b = description.split("\\s+");
            String lastWord = b[b.length - 1];
            description = description.substring(0, description.indexOf(lastWord)).trim(); // Added
            description=description+' ...'
            println description
        } catch (Exception e) {
            e.printStackTrace()
        }*/


        try {



            def xml = new StreamingMarkupBuilder().bind{
                records {
                    car(name:'HSV Maloo', make:'Holden', year:2006) {
                        country('Australia')
                        record(type:'speed', 'Production Pickup Truck with speed of 271kph')
                    }
                    car(name:'P50', make:'Peel', year:1962) {
                        country('Isle of Man')
                        record(type:'size', 'Smallest Street-Legal Car at 99cm wide and 59 kg in weight')
                    }
                    car(name:'Royale', make:'Bugatti', year:1931) {
                        country('France')
                        record(type:'price', 'Most Valuable Car at $15 million')
                    } } }

           println xml?.toString()

        } catch (IOException e) {

            e.printStackTrace();

        }
    }}

