import groovy.text.GStringTemplateEngine
import groovy.text.SimpleTemplateEngine

/**
 * Created by Development on 6/19/2014.
 */
class HtmlGenerator {



    static main(String[] args) {
        def f = new File('C:\\Cheqqer\\Lab\\src\\test.template')
        def text = 'Dear "$firstname $lastname",\nSo nice to meet you in <% print city %>.\nSee you in ${month},\n${signed}'

        def binding = ["firstname":"Sam", "lastname":"Pullara", "city":"San Francisco", "month":"December", "signed":"Groovy-Dev"]

       def  engine = new GStringTemplateEngine()
       def  template = engine.createTemplate(f).make(binding)
        println template.toString()
    }
}
