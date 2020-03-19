/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Icesi University (Cali - Colombia)
 * ICT Departments - Algoritmos y programación II
 * Three Head Turing Machine
 * @author: Juan Sebastián Barrera Pulido <juan.barrera4@correo.icesi.edu.co>
 * Period: 2020-1
 * 
 * Last actualization : Tue  17  March  2020   15:11
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

/**
 *	Element
 *
 *	This class have the nodes of the list.<br>
 *	Here the program only can access to the node information.<br>
 */
public class Element {
	
	private Element nextE;
	private Element prevE;
	private char value;
	
	/**
	 * The constructor of the class.<br>
	 * <b>Description:</b> It only initializates the char that represents the element.<br>
	 * 
	 * @param v: The char that represents the char of the Element.<br>
	 */
	public Element(char v) {
		value = v;
	}

	/**
	 * <b>Description:</b> Method to get the next element of the list.<br>
	 * 
	 * <b>pos</b> If the element is the last one, returns <code>null</code>.<br>  
	 * 
	 * @return the next element.<br>
	 */
	public Element getNextE() {
		return nextE;
	}

	/**
	 * <b>Description:</b> Method to set the next element of the list.<br>
	 * 
	 * @param nextE:  The next element to set.<br>
	 */
	public void setNextE(Element nextE) {
		this.nextE = nextE;
	}

	/**
	 * <b>Description:</b> Method to get the previous element of the list.<br>
	 * 
	 * <b>pos</b> If the element is the first one, returns <code>null</code>.<br>  
	 * 
	 * @return the previous element.<br>
	 */
	public Element getPrevE() {
		return prevE;
	}

	/**
	 * <b>Description:</b> Method to get the previous element of the list.<br>
	 * 
	 * @param prevE: The previous to set.<br>
	 */
	public void setPrevE(Element prevE) {
		this.prevE = prevE;
	}

	/**
	 * <b>Description:</b> Method to get the char of the element.<br>
	 * 
	 * @return the char that represents the element.<br>
	 */
	public char getValue() {
		return value;
	}

	/**
	 * <b>Description:</b> Method to set the char of the element.<br>
	 * 
	 * @param value: The char that represents the element.<br>
	 */
	public void setValue(char value) {
		this.value = value;
	}

	
}
