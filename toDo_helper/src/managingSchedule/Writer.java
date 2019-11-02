package managingSchedule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {

	public static void writeSchedule(Schedule schedule) {
		try {
			FileOutputStream fileStream = new FileOutputStream("schedule.txt");
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			os.writeObject(schedule);
			
			os.close();
		} catch (FileNotFoundException e) {
			makeFile();
			writeSchedule(schedule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writeSchedule(Schedule[] schedule) {
		try {
			FileOutputStream fileStream = new FileOutputStream("schedule.txt");
			
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			
			for(Schedule data : schedule) {
				os.writeObject(data);
			}
			
			os.close();
		} catch (FileNotFoundException e) {
			makeFile();
			writeSchedule(schedule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void makeFile() {
		File file = new File("schedule.txt");
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
