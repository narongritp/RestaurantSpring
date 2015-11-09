package th.co.aware.config;

import java.util.Calendar;
import java.util.Date;

public class MYLOG {

	public static final void print(String text){
		Date d = Calendar.getInstance().getTime();
		String time = (d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+
				d.getDate()+"  "+d.getHours()+"H:"+d.getMinutes()+"M:"+d.getSeconds()+"S";
		String textRow = "[PRINT]["+time+"] "+text;
		System.out.println(textRow);
	}
	
	public static final void printError(String text){
		Date d = Calendar.getInstance().getTime();
		String time = (d.getYear()+1900)+"/"+(d.getMonth()+1)+"/"+
				d.getDate()+"  "+d.getHours()+"H:"+d.getMinutes()+"M:"+d.getSeconds()+"S";
		String textRow = "[ERROR]["+time+"] "+text;
		System.err.println(textRow);
	}
}
