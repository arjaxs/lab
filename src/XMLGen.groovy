import groovy.xml.StreamingMarkupBuilder

/**
 * Created by Development on 12/2/2014.
 */
class XMLGen {

    public static void main(String[] args) {

        println "test"

        def xml = new StreamingMarkupBuilder().bind{
            records {
def a="s"
                AccommodationType()
                car(name:'P50', make:'Peel', year:1962) {
                    country('Isle of Man')
                    record(type:'size', 'Smallest Street-Legal Car at 99cm wide and 59 kg in weight')
                }
                car(name:'Royale', make:'Bugatti', year:1931) {
                    country('France')
                    record(type:'price', 'Most Valuable Car at $15 million')
                } } }

        println xml?.toString()
    }

    def AccommodationType ={

            "car"(name: 'HSV Maloo', make: 'Holden', year: 2006) {
                country('Australia')
                record(type: 'speed', 'Production Pickup Truck with speed of 271kph')
            }

    }
}
