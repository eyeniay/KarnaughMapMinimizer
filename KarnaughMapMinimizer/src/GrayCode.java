   public class GrayCode {
	public static Object [][] matriks=null;
	public static Object [][] matriks_copy=null;
	public static Object [] basic_karno=null;  // contain frame size
	public static Object [] basic_karno_scanner=null;
	String h="";  //  gray code
	public Object [] q=null;
	public int count=0;
	public int counter=0, vertical=0;
	public boolean flag =true;

	public String basic_end=""; // simplified query
	public static double  k=0,p=0,z=0,x=0; // to matrix size and travel it

	public  void yarg(String prefix, double n) {  // to find gray code
		if (n == 0) 

		{

			h=prefix+" "+h;

		}	

		else {
			gray(prefix + "1", n - 1);
			yarg(prefix + "0", n - 1);
		}
	}  


	public  void gray(String prefix, double n) {  // to find gray code
		if (n == 0) {


			h=prefix+" "+h;

		}


		else {
			gray(prefix + "0", n - 1);
			yarg(prefix + "1", n - 1);
		}
	}  


	public  void calculate_gray(double N) {   //  calculate the number of line and column


		if (N % 2 == 0) { z=N; x=N; counter=(int) N;  matriks=new Object[(int) N][(int) N]; matriks_copy=new Object[(int) N][(int) N];}// girilen deðiþken çift ise matriksin satýr,sütün sayýsý}
		if (N % 2 == 1) {  k= Math.ceil(N/2); p= Math.floor(N/2); z=Math.pow(2,p); x= Math.pow(2,k); counter= (int) Math.pow(2,k)   ; matriks=new Object[(int) z ][(int) x]; matriks_copy=new Object[(int) z ][(int) x];}

		gray("", N);
	}



	public void write_matriks(){ // add gray code into the array 

		boolean flag2=false;
		q=h.split(" "); int w=0, u=0, ver=(int) (z-1),hor=0;
		for (int i = 0; i < q.length; i++) {



			if (w==x){ w=0; u++; ver--; hor--; flag2=true;   }
			if ((u!=0) && (u % 2 == 0)){u=0; w=0 ;  hor=hor+2; flag2=false;}

			matriks[ver][hor]=q[i];

			w++;
			if (flag2==false){hor++;}
			if (flag2==true){hor--;}



		}
       
		
		for (int l = 0; l < z; l++) {    // Make a copy for use later
			for (int j = 0; j < x; j++) {
				matriks_copy[l][j]=matriks[l][j];



			}
		}
		
		
		
		
	}



	public void replace_gray(String replace1,int variableCount){  // gray code change with 1 or 0  
		int a=0;
		boolean flaggg=false;

		

		for (int l = 0; l <z; l++) {



			for (int j = 0; j < x; j++) {

				if	(matriks[l][j].toString().length()==variableCount){



					if (replace1.equals("end")){ matriks[l][j]=0; }


					else if (!(replace1.equals("end"))){

						while (a!=variableCount){





							if (replace1.charAt(a)!='5'){


								if  (replace1.charAt(a)==matriks[l][j].toString().charAt(a))
								{  flaggg=true;   }

								else if (replace1.charAt(a)!=matriks[l][j].toString().charAt(a))
								{flaggg=false; break; }


							}

							a++;


						}
					}
				}

				if (flaggg==true) {  matriks[l][j]=1;   }

				a=0;
				flaggg=false;
			}
		}

		
		

	}




	public void BasicKarno(int variableCount){ // create a frame to minimize

		int count=0;
		basic_karno=new Object[(int) (z*x)];  
		for (int i = 0; i < z; i++) {   // right descending
			for (int j = 0; j < x; j++) {

				if (((Math.pow(2, i))<=z) && ((Math.pow(2, j))<=x)){

					if (i==0 && j==0){}
					else{

						
						basic_karno[count]=((int)Math.pow(2, i))+","+((int)Math.pow(2, j));  // frame size add basic_karno array

						count++;
					}
				}
			
				
			}
		}

	}

	public void BasicKarnoScanner(int variableCount,String[] return_temps2){   // travel matrix array owing to frame
		
		

		for (int i = basic_karno.length-1; i >= 0; i--) {
			 
			if (basic_karno[i]!=null)   {

			basic_karno_scanner=basic_karno[i].toString().split(",");

			
			int f=Integer.parseInt((basic_karno_scanner[0].toString()));
			int m=Integer.parseInt((basic_karno_scanner[1].toString()));
			int k=f;
			
			boolean flag=false;
			boolean flagcontrol=false;
			int w=0,y=0;

			int control=0,control2=0;
			
			
			while(m<=x+1){

				while(k<=z+1){
					
					
					
					for (int j = y; j < k; j++) {
						
						if (j==z) { control=j;      j=(int) (j % z);       }
						
						for (int j2 = w; j2 < m; j2++) {

							
							
							if (j2==x)  {   control2=j2;    j2=(int) (j2 % x);     }
							

							if ((int)matriks[j][j2]==1) { flag=true; }
							
							if ((int)matriks[j][j2]==5) { flagcontrol=true; }
							
							if (((int)matriks[j][j2]!=1) && ((int)matriks[j][j2]!=5)) {flag=false; break;}

							
							if (control2==x){ j2=control2; control2=0;}
							
							
							
						}
						if (control==z){ j=control; control=0;}  
						if (flag==false){break;}
					}

                     
					
					if (flag==true){ //  to write not a (a')  
						
						boolean sekil_flag=false;
						
						boolean flagstr=false;
						String str="";
						Object [] str_split=null;
						int count=0;
						char value=' ';
					
						
						
						control=0; control2=0;
						
						for (int j = y; j < k; j++) {

							for (int j2 = w; j2 < m; j2++) {
								
								
								
								if (j==z) { control=j;     j=(int) (j % z);     }
								if (j2==x)  {   control2=j2;   j2=(int) (j2 % x);      }

								
                                     matriks[j][j2]=5; 
                                  str+=matriks_copy[j][j2]+" ";
								
                                  
								if (control==z){ j=control; control=0;}  
								if (control2==x){ j2=control2; control2=0;}
								
								}
							}
						
						str_split=str.split(" ");
						
						while (count!=variableCount){
						for (int h = 0; h < str_split.length-1; h++) {
							
							if ( str_split[h].toString().charAt(count)==str_split[h+1].toString().charAt(count) ) { flagstr=true; value=str_split[h].toString().charAt(count);   }
							else { flagstr=false; break;}
						}
						
						
						if (flagstr==true) {         
							
							
							if (sekil_flag==true){basic_end+=".";}  sekil_flag=true; 
							
							if (value=='1'){    basic_end+=return_temps2[count]; }
							else { basic_end+=return_temps2[count]+"'"; }
						}
						
						count++; flagstr=false; 
						}
						
						
						
						
						basic_end+="+";  sekil_flag=false; str_split=null; str=null; count=0; flagstr=false;
					
					}
					
					
					
					
					
					
					flag=false;
					flagcontrol=false;
					k++; y++;
				}

				
				

				k=f; y=0; m++; w++;
			}
			basic_karno_scanner=null; 
		}
	}
		
		if(basic_end.endsWith("+")){    basic_end=basic_end.substring(0, basic_end.length()-1);   }  
		
		
	}



             
       public String return_basicEnd(){ return basic_end;}





}