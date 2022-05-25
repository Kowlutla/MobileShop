import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
public class MainClass 
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Mobile> mobilelist=new ArrayList<Mobile>();
		FileReader fr=new FileReader("mobiles.txt");
		BufferedReader br=new BufferedReader(fr);
		String s="";
		while((s=br.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(s,"\t");
			while(st.hasMoreTokens())
			{
				String company_name=st.nextToken();
				String model_name=st.nextToken();
				float price=Float.parseFloat(st.nextToken());
				mobilelist.add(new Mobile(company_name,model_name,price));
			}
		}
		System.out.println("Choice 1: Continue (Press 1)");
		System.out.println("Choice 2: Exit (Press Any Key)");
		System.out.print("Your Choice: ");
		int choice=Integer.parseInt(br1.readLine());
		while(choice==1)
		{
			System.out.println("- - Enter your option - - \nOption1:Add Mobile\nOption2:Remove Mobile\nOption3:Display\nOption4:Update MObile\nOption5:Sort Mobiles\nOption6.Write into file");
			System.out.print("Enter your option: ");
			int option=Integer.parseInt(br1.readLine());
			switch(option)
			{
				case 1:
				{
					System.out.println("- - - SELECTED TO ADD A NEW PHONE - - -");
					System.out.print("Company Name: ");
					String company_name=br1.readLine();
					System.out.print("Model Name: ");
					String model_name=br1.readLine();
					System.out.print("Price: ");
					float price=Float.parseFloat(br1.readLine());
					AddMobile(mobilelist,company_name,model_name,price);
					System.out.println("- - - NEW PHONE IS ADDED TO LIST - - -");
					break;
				}
				case 2:
				{
					System.out.println("- - -SELECTED TO REMOVE PHONE DETAILS - - -");
					remove(mobilelist);
					break;
				}
				case 3:
				{
					System.out.println("- - - SELECTED TO DISPLAY THE PHONE DETAILS- - -");
					display(mobilelist);
					break;
				}
				case 4:
				{
					System.out.println("- - - SELECTED TO UPDATE MOBILE - - -");
					update(mobilelist);
					break;
				}
				case 5:
				{
					System.out.println("- - -SELECTED TO SORT MOBILES - - - ");
					sort(mobilelist);
					break;
				}
				case 6:
				{
					System.out.println("- - - SELECTED TO WRITE DETAILS INTO FILE- - -");
					writeFile(mobilelist);
					break;
				}
				default:
				{
					System.out.println("- - -Invalid option - - -");
					break;
				}
			}
			System.out.println("Choice 1: Continue (Press 1)");
			System.out.println("Choice 2: Exit (Press Any Key)");
			System.out.print("Your Choice: ");
			choice=Integer.parseInt(br1.readLine());
		}
		System.out.println("- - -THANK YOU FOR YOUR TIME ON ME... ");
		br.close();
	}
	
	//METHOD THAT ADD THE NEW MOBILE INTO LIST
	private static void AddMobile(ArrayList<Mobile> mobilelist, String company_name, String model_name, float price) 
	{
		mobilelist.add(new Mobile(company_name,model_name,price));
		System.out.println(" - -mobile is added to list - - -");
		
	}
	
	
	//METHOD THAT REMOVEMOBILE FROM LIST BASED ON DIFFERENT SCENARIOS
	private static void remove(ArrayList<Mobile> mobilelist) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("- - -Remove base on - - -\n1.Company Name\n2.Model Name\n3.Price");
		System.out.print("Enter your Option:");
		int removeoption=Integer.parseInt(br.readLine());
		switch(removeoption)
		{
			case 1:
			{
				System.out.print("Enter Company Name: ");
				String company_name=br.readLine();
				int array[]=removeByCompanyName(mobilelist,company_name);
				if(array.length==0)
				{
					System.out.println("NO Phone are Matched .....");
				}
				else 
				{
					for(int i=array.length-1;i>=0;i--)
					{
						mobilelist.remove(array[i]);
					}
				}
				System.out.println("- - -REMOVED PHONE BASED ON COMPANY NAME- - - ");
				break;
			}
			case 2:
			{
				System.out.print("Enter Model Name: ");
				String model_name=br.readLine();
				int array[]=removeByModelName(mobilelist,model_name);
				if(array.length==0)
				{
					System.out.println("NO Phone are Matched .....");
				}
				else 
				{
					for(int i=array.length-1;i>=0;i--)
					{
						mobilelist.remove(array[i]);
					}
				}
				System.out.println("- - - REMOVED PHONE BASED ON MODEL NAME - - -");
				break;
			}
			case 3:
			{
				System.out.print("Enter price: ");
				float price=Float.parseFloat(br.readLine());
				int array[]=removeByPrice(mobilelist,price);
				if(array.length==0)
				{
					System.out.println("NO Phone are Matched .....");
				}
				else 
				{
					for(int i=array.length-1;i>=0;i--)
					{
						mobilelist.remove(array[i]);
					}
				}
				System.out.println("- - - REMOVED PHONE BASED ON PRICE - - -");
				break;
			}
			default:
			{
				System.out.println("Invalid input");
				break;
			}
		}
	}
	
	
	//METHOD TO REMOVE THE MOBILE BASED ON COMPANY NAME
	private static int[] removeByCompanyName(ArrayList<Mobile> mobilelist, String company_name)
	{
		//System.out.println("- - - REMOVING PHONE BASED ON COMPANY NAME - - -");
		int array[]=new int[10];
		int k=0,index=0;
		for(Mobile mobile:mobilelist)
		{
			if(mobile.company_name.equalsIgnoreCase(company_name))
			{
				array[k++]=index;
			}
			index++;
		}
		int indexarray[]=new int[k];
		for(int i=0;i<k;i++)
		{
			indexarray[i]=array[i];
		}
		return indexarray;
	}
	
	
	//METHOD TO REMOVE THE MOBILE BASED ON MODEL NAME
	private static int[] removeByModelName(ArrayList<Mobile> mobilelist, String model_name) 
	{
		//System.out.println("- - - REMOVING PHONE BASED ON MODEL NAME - - -");
		int array[]=new int[10];
		int k=0,index=0;
		for(Mobile mobile:mobilelist)
		{
			if(mobile.model_name.compareToIgnoreCase(model_name)==0)
			{
				array[k++]=index;
			}
			index++;
		}
		int indexarray[]=new int[k];
		for(int i=0;i<k;i++)
		{
			indexarray[i]=array[i];
		}
		return indexarray;
	}
	
	
	//METHOD TO REMOVE THE MOBILE BASED ON PHONE PRICE
	private static int[] removeByPrice(ArrayList<Mobile> mobilelist, float price) 
	{
		//System.out.println("- - - REMOVING PHONE BASED ON PRICE - - -");
		int array[]=new int[10];
		int k=0,index=0;
		for(Mobile mobile:mobilelist)
		{
			if(mobile.price==price)
			{
				array[k++]=index;
			}
			index++;
		}
		int indexarray[]=new int[k];
		for(int i=0;i<k;i++)
		{
			indexarray[i]=array[i];
		}
		return indexarray;
	}

	//METHOD TO UPDATE THE PHONE DETAILS BASED ON DIFFERENT SCENARIOS
	private static void update(ArrayList<Mobile> mobilelist)throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter model name: ");
		String model_name=br.readLine();
		System.out.println("Update the Following \n1.Model Name\n2.Price\n3.Both Model Name and Price");
		System.out.println("Enter your Update Choice");
		int updatechoice=Integer.parseInt(br.readLine());
		switch(updatechoice)
		{
			case 1:
			{
				updateModel(mobilelist,model_name);
				System.out.println("- - -PHONE IS UPDATED WITH NEW MODEL - - -");
				break;
			}
			case 2:
			{
				updatePrice(mobilelist,model_name);
				System.out.println("- - -PHONE IS UPDATED WITH NEW PRICE - - -");
				break;
			}
			case 3:
			{
				updateModelAndPrice(mobilelist,model_name);
				System.out.println("- - -PHONE IS UPDATED WITH NEW MODEL AND NEW PRICE - - -");
				break;
			}
			default:
			{
				System.out.println("- - - Invalid Update option selected - - -");
				break;
			}
		}
		
	}
	

	//METHOD TO UPDATE MOBILE MODEL
	private static void updateModel(ArrayList<Mobile> mobilelist, String model_name)  throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		System.out.print("Enter new Model name: ");
		String new_model_name=br.readLine();
		for(Mobile mobile:mobilelist)
		{
			if(mobile.model_name.compareToIgnoreCase(model_name)==0)
			{
				mobile.setModelName(new_model_name);
			}
		}
		
	}

	//METHOD TO UPDATE PRICE BASED ON MOBILE MODEL 
	private static void updatePrice(ArrayList<Mobile> mobilelist, String model_name) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		System.out.print("Enter New Price: ");
		float new_price=Float.parseFloat(br.readLine());
		for(Mobile mobile:mobilelist)
		{
			if(mobile.model_name.compareToIgnoreCase(model_name)==0)
			{
				mobile.setPrice(new_price);
			}
		}
	}
	
	//METHOD TO UPDATE BOTH MODEL NAME AND PRICE OF PHONE
	private static void updateModelAndPrice(ArrayList<Mobile> mobilelist, String model_name)throws Exception
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		System.out.print("Enter New Model: ");
		String new_model_name=br.readLine();
		System.out.print("Enter New Price: ");
		float new_price=Float.parseFloat(br.readLine());
		for(Mobile mobile:mobilelist)
		{
			if(mobile.model_name.compareToIgnoreCase(model_name)==0)
			{
				mobile.setModelName(new_model_name);
				mobile.setPrice(new_price);
			}
		}
	}
	//METHOD THAT DISPLAY THE PHONES IN THE LIST
	private static void display(ArrayList<Mobile> mobilelist) 
	{
		System.out.println("- - - Mobile Details are - - - ");
		if(mobilelist.size()==0)
		{
			System.out.println("NO PHONES IN THE SHOP");
		}
		else
		{
			for(Mobile mobile:mobilelist)
			{
				System.out.println(mobile);
			}
		}	
	}

	
	//METHOD TO SORT THE PHONES BASED ON DIFFERENT SCENARIOS
	private static void sort(ArrayList<Mobile> mobilelist) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(" - -Sorting Based on- - -\n1.Company Name\n2.Model Name\n3.Price");
		System.out.print("Enter your Sorting Option: ");
		int sortoption=sc.nextInt();
		switch(sortoption)
		{
			case 1:
			{
				//System.out.println("- - - SELECTED SORTING BASED ON COMPANY NAME- - -");
				sortByCompanyName(mobilelist);
				System.out.println("- - - PHONES ARE SORTED BASED ON COMPANY NAME- - -");
				break;
			}
			case 2:
			{
				sortByModelName(mobilelist);
				System.out.println("- - - PHONES ARE SORTED BASED ON MODEL NAME- - -");
				break;
			}
			case 3:
			{
				//System.out.println("- - - SELECTED SORTING BASED ON PRICE- - -");
				sortByPrice(mobilelist);
				System.out.println("- - - PHONES ARE SORTED BASED ON PRICE- - -");
				break;
			}
			default:
			{
				System.out.println("Invalid sort option");
				break;
			}
		}
	}	
	
	
	//METHOD TO SORT THE PHONE DETAILS BASED ON COMPANY NAME
	private static void sortByCompanyName(ArrayList<Mobile> mobilelist) 
	{
		Collections.sort(mobilelist, (mobile1,mobile2)->
		{
			if(mobile1.company_name.compareToIgnoreCase(mobile2.company_name)>0)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		});	
	}
	
	
	//METHOD TO SORT THE PHONES BASED ON MODEL NAME
	private static void sortByModelName(ArrayList<Mobile> mobilelist) 
	{
		// TODO Auto-generated method stub
		Collections.sort(mobilelist, (mobile1,mobile2)->
		{
			if(mobile1.model_name.compareToIgnoreCase(mobile2.model_name)>0)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		});	
	}
	
	//METHOD TO SORT THE PHONES BASED ON PRICE
	private static void sortByPrice(ArrayList<Mobile> mobilelist)
	{
		Collections.sort(mobilelist, (mobile1,mobile2)->
		{
			if(mobile1.price>mobile2.price)
			{
				return 1;
			}
			else
			{
				return -1;
			}
		});
		
	}
	
	//METHOD TO WRITE THE LIST DETAILS INTO FILE
	private static void writeFile(ArrayList<Mobile> mobilelist) 
	{
		try 
		{
			FileWriter fw=new FileWriter("mobiles.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			if(mobilelist.size()==0)
			{
				System.out.println("No phones are in the list......");
			}
			else
			{
				for(Mobile mobile:mobilelist)
				{
					bw.write(mobile+"\n");
				}
			}
			bw.close();
			fw.close();
		}
		catch(Exception e) {}
	}
}


