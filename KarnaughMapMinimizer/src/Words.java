

public class Words {

		
	private String word;
	private int logic_value; // 1 or 0
	private Words next;

	public Words(String word, int logic_value){
		this.word = word;
		this.logic_value = logic_value;
		this.next=null;
	}
	
	
	 
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getLogic_value() {
		return logic_value;
	}
	public void setLogic_value(int logic_value) {
		this.logic_value = logic_value;
	}

	public Words getNext() {
		return next;
	}
	public void setNext(Words next) {
		this.next = next;
	}
	
	
}
