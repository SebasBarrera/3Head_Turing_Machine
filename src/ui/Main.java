/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * ICT Departments - Algoritmos y programación II
 * Three Head Turing Machine
 * @author: Juan Sebastián Barrera Pulido <juan.barrera4@correo.icesi.edu.co>
 * Period: 2020-1
 * 
 * Last actualization : Wed  18  March  2020   22:12
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

/**
 *	Main
 *	This is the Main class.<br>
 *	This class is the encharged to read and write the files.<br>
 */
public class Main {
	
	public final static char WRITE = 48;
	public final static char ADD = 49;
	public final static char REMOVE = 50;
	public final static char NO_VALUE_TO_WRITE = 45;
	public final static String INPUT = "data/input.txt";
	public final static String OUTPUT = "data/input.txt";
	public final static String EXAMPLE = "data/example.txt";
	
	private Machine turing;
	
	/**
	 * <b>Description:</b> The <u><i>main method</i></u>.<br>
	 * Here the program starts.
	 * 
	 * @param args: an array of the Strings that represents the arguments with which the program is invoked.<br> 
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.read();
	}
	
	/**
	 * The constructor of the class.<br>
	 * 
	 * <b>Description:</b> Create an object of the Machine class.<br>
	 */
	public Main() {
		turing = new Machine();
	}
	
	/**
	 * <b>Description:</b> The principal method of the program.<br>
	 * Here the interaction with the files happens and print the time that will be taked in the program.<br>
	 * 
	 */
	public void read() {
		long initial = System.currentTimeMillis();
		try {
			BufferedReader br = new BufferedReader(new FileReader(INPUT));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));
			String line = br.readLine();
			while (line != null) {
				int i = 0;
				char[] array = line.toCharArray();
				while(i < line.length()) {
					char head = array[i];
					char action = array[i+1];
					char value = NO_VALUE_TO_WRITE;
					if (action == ADD) {
						value = array[i+2];
						i++;
					}
					i++;
					i++;
					if (value == NO_VALUE_TO_WRITE) {
						switch (action) {
							case WRITE:
								bw.write(turing.readElement(head));
								bw.newLine();
							break;
							case REMOVE:
								turing.removeElement(head);
						}
					} else {
						turing.addElement(head, value);
					}
				}
				line = br.readLine();
				turing.removeAllElements();
			}
			bw.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		long finalt = System.currentTimeMillis();
		long time = finalt - initial;
		System.out.println(time);
		
	}

}
