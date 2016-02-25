public class Eliminate {

	public static int variableCount = 0;
	SingleLinkedList Operands = new SingleLinkedList();  // "+" and "."

	public String[] temp2s = new String[20];  
	public	SingleLinkedList[] sll=null; // words

	
	GrayCode g = new GrayCode();
	
	public void SearchingEliminate(String SearchingWords) {  // split "+" with "." and find the number of variables
		

		String[] EliminateSearch = SearchingWords.split("\\+");
	    sll = new SingleLinkedList[EliminateSearch.length];

		for (int i = 0; i < EliminateSearch.length; i++) {
			for (int j = 0; j < EliminateSearch[i].length() - 1; j++) {

				if (EliminateSearch[i].substring(j, j + 1).equals("+")
						|| EliminateSearch[i].substring(j, j + 1).equals(".")) {
					Operands.Add(EliminateSearch[i].substring(j, j + 1));
				}
			}
		}

		for (int i = 0; i < EliminateSearch.length; i++) {
			String[] temp = EliminateSearch[i].split("\\.");
			sll[i] = new SingleLinkedList();
			for (int j = 0; j < temp.length; j++) {
				if (temp[j].endsWith("'")) {
					sll[i].Add(new Words(temp[j].substring(0,  // contain word and word's logical value(0 or 1)
							temp[j].length() - 1), 0));
					temp[j] = temp[j].substring(0, temp[j].length() - 1);
				} else {
					sll[i].Add(new Words(temp[j], 1));
				}

			}
			if (temp2s[0] == null) {
				temp2s[0] = temp[0];
				variableCount++;
			}
			for (int j = 0; j < temp.length; j++) {
				int k = 0;
				while (temp2s[k] != null) {

					if (temp2s[k].equals(temp[j])) {
						break;
					} else if (temp2s[k + 1] == null) {
						temp2s[k + 1] = temp[j];
						variableCount++;
					}
					k++;

				}

			}
			
		}

		
		g.calculate_gray(variableCount);
		g.write_matriks();
	
		
		
	}
	
	
	public int return_variableCount(){
		
		
		return variableCount;
		
	}
	
	
	
	public String[] return_temps2(){
		
		
		return temp2s;
		
	}
	
	
	
	
	
	
	public void cal_truth_table(){  // examine linked list which contain words
		
		for (int i = 0; i < sll.length; i++) {
			
		
		for (int p = 0; p < temp2s.length; p++) {
			
			if (temp2s[p]!=null)
			{sll[i].truth_table(temp2s[p],variableCount);}
			
			
		}
		
		if (i==sll.length-1) { sll[i].truth_table("change",variableCount);   sll[i].truth_table("end",variableCount); }
		else {sll[i].truth_table("change",variableCount);}
		
		}
		
	}
	
	
	

}