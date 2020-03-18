package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

public class Main {
	
	public final static char WRITE = 48;
	public final static char ADD = 49;
	public final static char REMOVE = 50;
	public final static char NO_VALUE_TO_WRITE = 45;
	private Machine turing;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.read();
	}
	public Main() {
		turing = new Machine();
	}
	
	private void read() {
		long initial = System.currentTimeMillis();
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/input.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/output.txt"));
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
