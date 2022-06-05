package littlepay.LittlePay_Test;

import beans.Properties;
import helper.CsvHelper;

/**
 * @author stefanuskj
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	ApplicationConfiguration config = new ApplicationConfiguration();
		Properties applicationProperties = config.initProperties();
		CsvHelper.readFromCsv(applicationProperties.get_inputPath(),applicationProperties.get_outputPath());
    }
}
