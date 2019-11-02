package managingSchedule;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Reader {

	private static ArrayList<Schedule> scheduleList;
	
	public static void readFile() {
		File file = new File("schedule.txt");
		scheduleList = new ArrayList<>();
		
		try {
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream os = new ObjectInputStream(fileStream);
			
			Object schedule = os.readObject();
			while(schedule != null) {
				scheduleList.add((Schedule) schedule);
				schedule = os.readObject();
			}
			
			os.close();
		} catch (EOFException eof) {
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Writer.makeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printFile() {
		readFile();
		
		for(Schedule data : scheduleList) {
			System.out.println(data);
		}
	}
}
