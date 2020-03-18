/**
 * 
 */
package model;

/**
 * @author sebasbarrera
 *
 */
public class Element {
	
	private Element nextE;
	private Element prevE;
	private char value;
	
	/**
	 * 
	 */
	public Element(char v) {
		value = v;
	}

	/**
	 * @return the nextE
	 */
	public Element getNextE() {
		return nextE;
	}

	/**
	 * @param nextE the nextE to set
	 */
	public void setNextE(Element nextE) {
		this.nextE = nextE;
	}

	/**
	 * @return the prevE
	 */
	public Element getPrevE() {
		return prevE;
	}

	/**
	 * @param prevE the prevE to set
	 */
	public void setPrevE(Element prevE) {
		this.prevE = prevE;
	}

	/**
	 * @return the value
	 */
	public char getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(char value) {
		this.value = value;
	}

	
}
