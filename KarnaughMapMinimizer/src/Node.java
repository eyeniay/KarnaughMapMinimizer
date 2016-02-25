

public class Node {

	private Object data;
	private Node link;
	private Node prev;



	public Node(Object data){

		this.data = data;
		link = null;
		prev = null;

	}



	public Node getPrev() {
		return prev;
	}
	public void setPrev(Node prev) {
		this.prev = prev;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Node getLink() {
		return link;
	}
	public void setLink(Node link) {
		this.link = link;
	}






}
