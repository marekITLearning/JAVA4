package sk.itlearning.java4.a.abc;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePreJava8 {

	public static void main(String[] args) {

		// aktualny timestamp ziskany zo systemoveho casu
		Date d = new Date();

		System.out.println(d);

		// formatovanie datumu na zelany tvar
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(d));

		// extrakcia jednotlivych casti datumu
		Calendar c = new GregorianCalendar();
		c.setTime(d);
		System.out.println("Aktualny cas je: "
			+ c.get(Calendar.HOUR)
			+ ":"
			+ c.get(Calendar.MINUTE)
			+ " week: "
			+ c.get(Calendar.DAY_OF_WEEK));

		System.out.println(d.getTime());

		c.add(Calendar.HOUR, 22);
		System.out.println(c.getTime());

		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		System.out.println(c.getTime());
		
		Date d1 = Date.from(Instant.ofEpochMilli(c.getTimeInMillis()));

	}

}
