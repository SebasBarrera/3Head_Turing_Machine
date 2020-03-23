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
package model;

/**
 *	Machine
 *
 *	This class is the owner of the first element of the list.<br>
 *	Here all the operations over the list will pass.<br>
 */
public class Machine {
	
	public final static char FIRST = 48;
	public final static char MIDDLE = 49;
	public final static char LAST = 50;
	
	private Element c0;
	private Element c1;
	private Element c2;
	private Element firstE;
	private int amount;
	
	/**
	 * The constructor of the class.<br>
	 * 
	 * <b>Description:</b> It only start in cero the counter that says hoy many elements have the list.<br>
	 */
	public Machine() {
		amount = 0;
	}
	
	/**
	 * <b>Description:</b> This method is going to add elements to the list in the indicated position.<br>
	 * 
	 * <b>pre:</b> The <i><b>head</b></i> will take a value between FIRST, MIDDLE and LAST.<br>
	 * <b>pre:</b> The <i><b>value</b></i> will take a <code>char</code> between A and Z in the english alphabet. 26 letters.<br>
	 * <b>pos:</b> A new Element will be added to the list in the correct position.<br>
	 * <b>pos:</b> The first head will point to the first element of the list.<br>
	 * <b>pos:</b> The second head will point to the middle element of the list.<br>
	 * <b>pos:</b> The third head will point to the last element of the list.<br>
	 * <b>pos:</b> The size of the list will be the last one plus one.<br>
	 * 
	 * @param head: Indicates where is going to be added the element to the list.<br>
	 * @param value: It will be the <code>char</code> of the Element to add.<br>
	 */
	public void addElement(char head, char value) {
		Element toAdd = new Element(value);
		if (firstE == null) {
			firstE = toAdd;
			c0 = toAdd;
			c1 = toAdd;
			c2 = toAdd;
		} else {
			switch (head) {
				case FIRST:
					toAdd.setNextE(c0);
					c0.setPrevE(toAdd);
					c0 = toAdd;
					firstE = toAdd;
					if (amount == 1) {
						c1 = c0;
					} else if (!isEven()) {
						c1 = c1.getPrevE();
					} 
				break;
				case MIDDLE:
					if (amount == 1) {
						c0 = toAdd;
						firstE = toAdd;
						c2.setPrevE(toAdd);
						toAdd.setNextE(c2);
					} else if (amount == 2) {
						toAdd.setNextE(c2);
						toAdd.setPrevE(c0);
						c0.setNextE(toAdd);
						c2.setPrevE(toAdd);
					} else {
						if (isEven()) {
							toAdd.setPrevE(c1);
							toAdd.setNextE(c1.getNextE());
							c1.getNextE().setPrevE(toAdd);
							c1.setNextE(toAdd);
						} else {
							toAdd.setNextE(c1);
							toAdd.setPrevE(c1.getPrevE());		
							c1.getPrevE().setNextE(toAdd);
							c1.setPrevE(toAdd);
						}
					}
					c1 = toAdd;				
				break;
				case LAST:
					c2.setNextE(toAdd);
					toAdd.setPrevE(c2);
					c2 = toAdd;
					if (isEven())
						c1 = c1.getNextE();
			} 
		}
		amount++;
	}
	
	/**
	 * <b>Description:</b> This method is going to read an element of the list in the indicated position.<br>
	 * 
	 * <b>pre:</b> The <i><b>head</b></i> is a value between FIRST, MIDDLE and LAST.<br>
	 * <b>pre:</b> The <i><b>return</b></i> will be a <code>char</code> between A and Z in the english alphabet. 26 letters.<br>
	 * <b>pre:</b> Every element of the list have a <code>char</code> to return.<br>
	 * <b>pos:</b> The char of the element will be added with a line break to the output file.<br>
	 * <b>pos:</b> The size of the list will be the same.<br>
	 * <b>pos:</b> The all heads will point to the same element of the list.<br>
	 * <b>pos:</b> If the list <i><b>is empty</b></i>, this method will return a #.<br>
	 * 
	 * @param head: Indicates where is going to read the element to the list.<br>
	 * @return a <code><i><b>char</b></i></code> that indicate the value of the element. If the list <i><b>is empty</b></i>, returns a #.<br>
	 */
	public char readElement(char head) {
		char msg = '#';
		if (firstE != null) {
			switch (head) {
				case FIRST:
					msg = c0.getValue();
				break;
				case MIDDLE:
					msg = c1.getValue();
				break;
				case LAST:
					msg = c2.getValue();
			}
		}
		return msg;
	}
	
	/**
	 * <b>Description:</b> This method is going to remove an element of the list in the indicated position.<br>
	 * 
	 * <b>pre:</b> The <i><b>head</b></i> will take a value between FIRST, MIDDLE and LAST.<br>
	 * <b>pos:</b> An Element will be removed of the list in the indicated position position.<br>
	 * <b>pos:</b> The first head will point to the first element of the list.<br>
	 * <b>pos:</b> The second head will point to the middle element of the list.<br>
	 * <b>pos:</b> The third head will point to the last element of the list.<br>
	 * <b>pos:</b> If the list <i><b>is empty</b></i>, this method will not do anything and the size of the list will be the same.<br>
	 * <b>pos:</b> The size of the list will be the last one minus one.<br>
	 * 
	 * @param head: Indicates where is going to be added the element to the list.<br>
	 */
	public void removeElement(char head) {
		if (firstE != null) {
			if (firstE.getNextE() == null) {
				removeAllElements();
			} else {
				switch (head) {
					case FIRST:
						firstE = firstE.getNextE();
						firstE.setPrevE(null); 
						c0 = firstE;
						if (amount == 2) {
							c1 = c0;
						} else {
							if (isEven())
								c1 = c1.getNextE(); 
						}
						
					break;
					case MIDDLE:
						if (amount == 2) {
							c0 = c2;
							c1 = c2;
							firstE = c0;
						} else {
							c1.getPrevE().setNextE(c1.getNextE());
							if(c1.getNextE() != null)
							c1.getNextE().setPrevE(c1.getPrevE());
							if (!isEven()) {
								c1 = c1.getPrevE();
							} else {
								c1 = c1.getNextE();
							}
						}
					break;
					case LAST:
						c2 = c2.getPrevE();
						c2.setNextE(null);
						if (amount != 2) {
							if (!isEven())
								c1 = c1.getPrevE();
						}
				}
			}
		}
		if (amount > 0) 
			amount--;
	}
	
	/**
	 * <b>Description:</b> This method is going to empty the list.<br>
	 *
	 * <b>pos:</b> All the refereces; first element and the heads, will lost the references and point to null.<br>
	 * <b>pos:</b> The size of the list will be cero.<br>
	 */
	public void removeAllElements() {
		firstE = null;
		c0 = null;
		c1 = null;
		c2 = null;
		amount = 0;
	}
	

	/**
	 * <b>Description:</b> This method is going to verify is the list is even or odd.<br>
	 *
	 * @return a <code><i><b>boolean</b></i></code> that indicate if the list is even or odd.<br>
	 */
	public boolean isEven() {
		boolean even = false;
		if (amount%2 == 0) 
			even = true;
		return even;
	}
	
}
