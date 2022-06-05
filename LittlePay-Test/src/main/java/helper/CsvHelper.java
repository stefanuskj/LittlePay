package helper;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import beans.Taps;
import beans.Trips;

/**
 * @author stefanuskj
 *
 */
public class CsvHelper {
	private static final Logger logger = LogManager.getLogger(CsvHelper.class);
	
	public static void readFromCsv (String inputPath, String outputPath) {
		Reader reader = null;
		CSVReader csvReader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(inputPath));
			csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
			boolean check = true;
			Taps nextData = new Taps();
			Taps currentData = new Taps();
			csvGenerator(outputPath);
			String[] tempData;
			String[] data;
			Iterator<String[]> csvIterator = csvReader.iterator();
			while(csvIterator.hasNext()) {
				if (check==true) {
					tempData = csvIterator.next();
					data = tempData[0].split(",");
					currentData = new Taps();
					currentData.set_dateTimeUTC(data[1]);
					currentData.set_tapType(data[2]);
					currentData.set_stopId(data[3]);
					currentData.set_companyId(data[4]);
					currentData.set_busId(data[5]);
					currentData.set_pan(data[6]);
				}
				ArrayList<Taps> contents = new ArrayList<Taps>();
				check = true;
				if (currentData.get_tapType().equals("ON")) {
					if (csvIterator.hasNext()) {
						tempData = csvIterator.next();
						data = tempData[0].split(",");
						nextData = new Taps();
						nextData.set_dateTimeUTC(data[1]);
						nextData.set_tapType(data[2]);
						nextData.set_stopId(data[3]);
						nextData.set_companyId(data[4]);
						nextData.set_busId(data[5]);
						nextData.set_pan(data[6]);
						if (nextData.get_tapType().equals("OFF")) {
							contents.add(currentData);
							contents.add(nextData);
							writeToCsv(outputPath, contents);
						}
						else {
							contents.add(currentData);
							writeToCsv(outputPath, contents);
							currentData = nextData;
							check = false;
							if (!csvIterator.hasNext()) {
								contents.clear();
								contents.add(currentData);
								writeToCsv(outputPath, contents);
							}
						}
					}
					else {
						contents.add(currentData);
						writeToCsv(outputPath, contents);
					}
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("Cannot find csv file",e);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		}
	}
	public static void csvGenerator (String path) {
		CSVWriter csvWriter = null;
		try {
			csvWriter = new CSVWriter(new FileWriter(path));
			String[] header = "Started,Finished,DurationSecs,FromStopId,ToStopId,ChargeAmount,CompanyId,BusID,PAN,Status".split(",");
			csvWriter.writeNext(header);
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} 
		if (csvWriter!=null) {
			try {
				csvWriter.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
	}
	public static void writeToCsv (String path, ArrayList<Taps> contents) {
		CSVWriter csvWriter = null;
		Trips trips = new Trips();
		try {
			csvWriter = new CSVWriter(new FileWriter(path, true));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			if (contents.size() > 1) {
				trips.set_started(contents.get(0).get_dateTimeUTC());
				trips.set_finished(contents.get(1).get_dateTimeUTC());
				
				Date startDate = formatter.parse(contents.get(0).get_dateTimeUTC());
				Date endDate = formatter.parse(contents.get(1).get_dateTimeUTC());
				trips.set_durationSecs((endDate.getTime()-startDate.getTime())/1000);
				
				trips.set_fromStopId(contents.get(0).get_stopId());
				trips.set_toStopId(contents.get(1).get_stopId());
				
				ArrayList<String> status = getStatus(trips.get_fromStopId(),trips.get_toStopId());
				trips.set_chargeAmount(status.get(0));
				trips.set_status(status.get(1));
				
				trips.set_companyId(contents.get(0).get_companyId());
				
				trips.set_busId(contents.get(0).get_busId());
				
				trips.set_pan(contents.get(0).get_pan());
			}
			else {
				trips.set_started(contents.get(0).get_dateTimeUTC());
				trips.set_finished("N/A");
				
				trips.set_durationSecs(0);
				
				trips.set_fromStopId(contents.get(0).get_stopId());
				trips.set_toStopId("N/A");
				
				ArrayList<String> status = getStatus(trips.get_fromStopId(),trips.get_toStopId());
				trips.set_chargeAmount(status.get(0));
				trips.set_status(status.get(1));
				
				trips.set_companyId(contents.get(0).get_companyId());
				
				trips.set_busId(contents.get(0).get_busId());
				
				trips.set_pan(contents.get(0).get_pan());
			}
			csvWriter.writeNext(trips.getCsvFormat().split(","));
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
		} catch (ParseException e) {
			logger.error(e.getMessage(),e);
		} 
		if (csvWriter!=null){
			try {
				csvWriter.close();
			} catch (IOException e) {
				logger.error(e.getMessage(),e);
			}
		}
	}
	
	public static ArrayList<String> getStatus(String from, String to) {
		ArrayList<String> status = new ArrayList<String>();
		if (to.equals("Stop1") && from.equals("Stop1") || to.equals("Stop2") && from.equals("Stop2") || from.equals("Stop3") && to.equals("Stop3")) {
			status.add("$0.00");
			status.add("CANCELLED");
			return status;	
		}
		else if (to.equals("N/A")) {
			if (from.equals("Stop1") || from.equals("Stop3")) {
				status.add("$7.30");
				status.add("INCOMPLETE");
				return status;
			}
			else if (from.equals("Stop2")) {
				status.add("$5.50");
				status.add("INCOMPLETE");
				return status;
			}
		}
		else if (from.equals("Stop1") || to.equals("Stop1")) {
			if (to.equals("Stop2") || from.equals("Stop2")) {
				status.add("$3.25");
				status.add("COMPLETED");
				return status;
			}
			else if (to.equals("Stop3") || from.equals("Stop3")) {
				status.add("$7.30");
				status.add("COMPLETED");
				return status;
			}
		}
		else if (from.equals("Stop2") || to.equals("Stop2")) {
			if (to.equals("Stop3") || from.equals("Stop3")) {
				status.add("$5.50");
				status.add("COMPLETED");
				return status;
			}
		}
		return status;
	}
}
