import org.apache.commons.lang.StringUtils
import org.apache.commons.lang3.StringUtils

import java.text.DecimalFormat

/**
 * Created by Development on 5/22/2014.
 */
class Geo {

    static main(String[] args) {

        String coord="0.0006"
        String coordStr =coord.toString()
        Double ret = null
        try
        {
        println "sds"


        if (StringUtils.isNotBlank(coordStr))
        {

                BigDecimal bd = new BigDecimal(coordStr)
                DecimalFormat nf = new DecimalFormat("#.0000");
                String formattedDblStr = nf.format(bd.doubleValue())
                if (formattedDblStr)
                {
                    ret = new Double(formattedDblStr)
                }
                else
                {
                    //log.error("Unable to get formatted double, returning double value of BigDecimal")
                    ret = bd.doubleValue()
                }

        } }
        catch (Exception e)
        {
            //  log.error("${e} thrown while trying to parse ${coordStr} to BigDecimal - trying to return it as double.")
            ret = new Double(coordStr)
        }
    }
    }
