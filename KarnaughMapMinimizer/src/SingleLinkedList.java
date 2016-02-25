

public class SingleLinkedList {
	GrayCode code = new GrayCode();
	public static Object [] truth_tablearray=new Object[100];  // contain 0,1 or 5
	private Node head ;
	private int ListCount ;

	public SingleLinkedList(){
		
		head = null;
		ListCount = 0;
		
	}
	
	public void Add(Object word){
		
		if (head == null) {
			head = new Node(word);
		}
		else{
			
			Node current = head;
			
			while (current.getLink() != null) {
				current = current.getLink();
			}
			current.setLink(new Node(word));
		}
		ListCount++;
	}
	
	
	public int size(){
		
		return ListCount;
	
	}
	
	
	
	
	int count=0,returnk=0;
	String replace1="";
	public void truth_table(String x,int truth_table){  // create values (like 0110 ) according to words 
		
		
		
		
	if( head == null){
			
			System.out.println("List is empty");
		}
	
	if (x.equals("change")){  
		
		
		// if count reach variable number,combine all of them (0,1,5,1 --> 0151)
			for (int p = 0; p <truth_table ; p++) {
				
				if (truth_tablearray[p]==null){   break;}  
				else {replace1+=truth_tablearray[p];  truth_tablearray[p]=null;   }  
			}
		    
			
			code.replace_gray(replace1,truth_table);
			
			
	        count=0; 
	        
	  }
		
		
		
		if (x.equals("end"))  {     code.replace_gray("end",truth_table);}
		
			
			
		
		
	 if    (  (!(x.equals("change")))    &&  (!(x.equals("end")))  ){
	
		
			Node temp = head;
			// if word exist,add ıts logical value into the matrix
			while ( temp != null) {    
				Words wtemp = (Words)temp.getData();
				if (wtemp.getWord().equals(x))  { returnk=wtemp.getLogic_value();    break; }
				else {   temp = temp.getLink();  }
			}	
			
			if (temp==null) {returnk=5;} //// if word dosen't exist,add 5 into the matrix ( my fake number:5 )
		
	
		  truth_tablearray[count]=(int) returnk;  count++;  
		
		}
	   
	

		
	}
	
	

	
	public void Set(int index, Integer a) {

		Node temp = head;
		int count = 0;
		while (temp != null) {
			if (count == index) {
				temp.setData(a);
				break;
			}
			count++;
			temp = temp.getLink();
		}
	}
	
	
	public Object Get(int index) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			if (count == index) {
				return temp.getData();
			}
			count++;
			temp = temp.getLink();
		}
		return null;
	}
	

	
}