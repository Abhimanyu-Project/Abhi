
package com.shopperStackGenericUtility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public class Java_Utility {
public int generateRandomNumber() {
	Random random=new Random();
	int num = random.nextInt(1000);
	return num;
}

public String localDate() {
	String date=LocalDate.now().toString().replace("-","");
	return date;
}

public String localDateTime() {
	String time = LocalDateTime. now().toString().replace("-","").replace(":","").replace(".","");
			return time;
}
}
