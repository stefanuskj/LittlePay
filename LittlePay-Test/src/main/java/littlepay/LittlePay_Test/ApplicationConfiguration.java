package littlepay.LittlePay_Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.Properties;

/**
 * @author stefanuskj
 *
 */
public class ApplicationConfiguration {
	private static final Logger logger = LogManager.getLogger(ApplicationConfiguration.class);
	
	private static final String INPUT_FILE_PATH = "input_file_path";
	private static final String OUTPUT_FILE_PATH = "output_file_path";
	private static final String DEFAULT_PROPERTIES_FILE = "./properties/littlepay.properties";
	
	public Properties initProperties() {
		Properties filePath = new Properties();
		Scanner fileReader = null;
		try {
			File propertiesFile = new File(DEFAULT_PROPERTIES_FILE);
			fileReader = new Scanner(propertiesFile);
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] temp = line.split("=");
				if (temp[0].equals(INPUT_FILE_PATH)) {
					filePath.set_inputPath(temp[1]);
				}
				else if (temp[0].equals(OUTPUT_FILE_PATH)) {
					filePath.set_outputPath(temp[1]);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("Cannot found .properties file", e);
		}
		return filePath;
	}
	
	
}
