package me.pasteiton.kl.utils;

import java.util.Calendar;
import java.util.Timer;

public class Scheduler{
	
	public void runOnMain() {
		Timer timer = new Timer();
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		
		//Schedule to run every sunday at midnight
		//timer.schedule(new Mailer(), date.getTime(), 1000*60*60*24*7);
	}
}
