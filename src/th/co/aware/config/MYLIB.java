package th.co.aware.config;

import java.text.DecimalFormat;

public class MYLIB {
	public static String generate(){
		int ran = (int)(Math.random()*999999999)%999999999;
		DecimalFormat df = new DecimalFormat("0000");
		return df.format(ran);
	}
}
