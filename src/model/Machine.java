/**
 * 
 */
package model;

/**
 * @author sebasbarrera
 *
 */
public class Machine {
	
	public final static char FIRST = 48;
	public final static char MIDDLE = 49;
	public final static char LAST = 50;
	
	private Element c1;
	private Element c2;
	private Element c3;
	private Element firstE;
	private int amount;
	
	/**
	 * 
	 */
	public Machine() {
		amount = 0;
	}

	public void addElement(char head, char value) {
		Element toAdd = new Element(value);
		if (firstE == null) {
			firstE = toAdd;
			c1 = toAdd;
			c2 = toAdd;
			c3 = toAdd;
		} else {
			switch (head) {
				case FIRST:
					toAdd.setNextE(c1);
					c1.setPrevE(toAdd);
					c1 = toAdd;
					firstE = toAdd;
					if (amount == 1) {
						c2 = c1;
					} else if (!isEven()) {
						c2 = c2.getPrevE();
					} 
				break;
				case MIDDLE:
					if (amount == 1) {
						c1 = toAdd;
						firstE = toAdd;
						c3.setPrevE(toAdd);
						toAdd.setNextE(c3);
					} else if (amount == 2) {
						toAdd.setNextE(c3);
						toAdd.setPrevE(c1);
						c1.setNextE(toAdd);
						c3.setPrevE(toAdd);
					} else {
						if (isEven()) {
							toAdd.setPrevE(c2);
							toAdd.setNextE(c2.getNextE());
							c2.getNextE().setPrevE(toAdd);
							c2.setNextE(toAdd);
						} else {
							toAdd.setNextE(c2);
							toAdd.setPrevE(c2.getPrevE());		
							c2.getPrevE().setNextE(toAdd);
							c2.setPrevE(toAdd);
						}
					}
					c2 = toAdd;				
				break;
				case LAST:
					c3.setNextE(toAdd);
					toAdd.setPrevE(c3);
					c3 = toAdd;
					if (isEven())
						c2 = c2.getNextE();
			} 
		}
		amount++;
	}
	
	
	public String readElement(char head) {
		String msg = "";
		if (firstE == null) {
			msg = "#";
		} else {
			switch (head) {
				case FIRST:
					msg = String.valueOf(c1.getValue());
				break;
				case MIDDLE:
					msg = String.valueOf(c2.getValue());
				break;
				case LAST:
					msg = String.valueOf(c3.getValue());
			}
		}
		return msg;
	}
	
	public void removeElement(char head) {
		if (firstE != null) {
			if (firstE.getNextE() == null) {
				removeAllElements();
			} else {
				switch (head) {
					case FIRST:
						firstE = firstE.getNextE();
						firstE.setPrevE(null); 
						c1 = firstE;
						if (amount == 2) {
							c2 = c1;
						} else {
							if (isEven())
								c2 = c2.getNextE(); 
						}
						
					break;
					case MIDDLE:
						if (amount == 2) {
							c1 = c3;
							c2 = c3;
							firstE = c1;
						} else {
							c2.getPrevE().setNextE(c2.getNextE());
							if(c2.getNextE() != null)
							c2.getNextE().setPrevE(c2.getPrevE());
							if (!isEven()) {
								c2 = c2.getPrevE();
							} else {
								c2 = c2.getNextE();
							}
						}
					break;
					case LAST:
						c3 = c3.getPrevE();
						c3.setNextE(null);
						if (amount != 2) {
							if (!isEven())
								c2 = c2.getPrevE();
						}
				}
			}
		}
		if (amount > 0) 
			amount--;
	}
	
	
	
	public void removeAllElements() {
		firstE = null;
		c1 = null;
		c2 = null;
		c3 = null;
		amount = 0;
	}
	

	
	public boolean isEven() {
		boolean even = false;
		if (amount%2 == 0) 
			even = true;
		return even;
	}
	
}
