package managingSchedule;

import java.io.Serializable;
import java.util.Arrays;

@SuppressWarnings("serial")
public class Schedule implements Comparable<Schedule>, Serializable {

	private int 	startTime; // ex) 일정 시작 시간, 2120
	private int 	duration; // 일정 지속 시간, 분 단위
	private String 	title;
	
	public Schedule(int startTime, int duration, String title) {
		this.startTime = startTime;
		this.duration = duration;
		this.title = title;
	}
	
	public static Schedule[] scheduleSort(Schedule[] schedule) {
		Arrays.sort(schedule);
		
		return schedule;
	}
	
	public static int addTime(int time1, int time2) {
		int min, result = 0;
		min = time1 % 100 + time2 % 100;
		while((min % 1000) / 100 >= 1 || (min % 100) / 10 >= 6) {
			result += 1;
			min -= 60;
		}
		
		result += time1 / 100 + time2 / 100;
		result *= 100;
		result += min;
		
		return result;
	}

	@Override
	public int compareTo(Schedule o) {
		return this.startTime - o.startTime;
	}

	public String toString() {
		return "시작 시각: " + startTime + ", 끝나는 시각: " + addTime(startTime, duration)
		+ ", 내용: " + title;
		
	}
}
