package application;

import managingSchedule.Reader;
import managingSchedule.Schedule;
import managingSchedule.Writer;

public class MainCUI {

	public static void main(String[] args) {
		Schedule cp2 = new Schedule(1400, 200, "컴퓨터프로그래밍2");
		Schedule dy = new Schedule(1630, 130, "동양의문화와유산");
		
		Schedule[] timeTable = new Schedule[2];
		timeTable[0] = cp2;
		timeTable[1] = dy;
		
		Writer.writeSchedule(timeTable);
		
		Reader.printFile();
	}
}
