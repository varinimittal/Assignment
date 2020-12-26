import java.util.*;
import java.util.Map.Entry;
//Employee details
class Employee
{
	 String name;
	 String id;
	 Long time;
	 
	 Employee(String id,String name, Long time)
	 {
		 this.id=id;
		 this.name=name;
		 this.time=time;
	 }
	 public String getid()
	 {
		 return id;
	 }
	 public String getname()
	 {
		 return name;
	 }
	 public Long gettime()
	 {
		 
		 return time;
	 }
	 public void setTime(Long t)
	 {
	 this.time=t;
	 }
	 public String toString()
	 {
		 return name;
	 }
	 
}
public class code {
	public static void main(String args[] )
	{
		HashMap<String,Employee> hmap=new HashMap<>(); //Hash map data structure to store key value pairs.
		//List<Employee> emp=new ArrayList<>();
		while(true)
		{
		System.out.println("Enter 1 to create data and store it");
		System.out.println("Enter 2 to read data");
		System.out.println("Enter 3 to delete ");
		System.out.println("Enter 4 to display all the data that is stored ");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		switch (i)
		{
		case 1:
			
			System.out.println("Enter id");
			String id=sc.next();
			System.out.println("Enter name");
			String name=sc.next();
			System.out.println("Enter time to live");
			Long time=sc.nextLong();
			if(hmap.containsKey(id))                   //Shows error if the user creates a data with an existing key.
			{
				System.out.println("Error-This key already exists");
			}
			else
			{
				if(hmap.size()< 1024*1024*1024 && name.length()<=16*1024 ) //Checks that whether the file size is less than 1 GB and also checks that whether the size of value is less than 16kb.
				{
					Long timestamp=0L;
					if(time!=0) 
					timestamp=System.currentTimeMillis()/1000+time;
					if(id.length()<=32)   //To check if key is always a string -capped at 32chars.
					{
					//emp.add(new Employee(id,name,timestamp));
					hmap.put(id,new Employee(id,name,timestamp));
					}
				}
				else
				{
					System.out.println("Memory limit exceeded:File should be less than 1 GB and value should be less than 16KB");
				}
			}
			
			break;
		case 2:
			System.out.println("Enter id which you want to read");
			String id1=sc.next();
			if(!hmap.containsKey(id1)) //Show error if user reads a key that does not exist.
			{
				System.out.println("Error:It does not contains this key.Enter a valid Key");
			}
			else
			{
				Long timestamp2=System.currentTimeMillis()/1000;
				Employee e=hmap.get(id1);
				
				if(e.time!=0 )
				{
				if(timestamp2<e.time)   //Checks current time with the time assigned to the object.
				{
				String s= id1 +":"  + e.name;
				System.out.println(s);
				}
				else                   //If the time to live has been exceeded then it will show error.
				{
					System.out.println("The time to live of "+id1+" has ben expired");
				}
				}
				else                //If no time stamp was given by the user then it simply read the data
				{
					String s= id1 +":"  + e.name;
					System.out.println(s);
				}
			}
			
			break;
		case 3:
			System.out.println("Enter id which you want to delete");
			String id2=sc.next();
			if(!hmap.containsKey(id2))      //Shows error if user is trying to delete data that does not exist.
			{
				System.out.println("Error:It does not contains this key.Enter a valid Key");
			}
			else
			{
				Long timestamp2=System.currentTimeMillis()/1000;
				Employee e=hmap.get(id2);
			
				if(e.time!=0 )
				{
				if(timestamp2<e.time)
				{
					hmap.remove(id2);
					System.out.println("Key deleted successfully");
				}
				else
				{
					System.out.println("The time to live of "+id2+" has ben expired");
				}
				}
				else
				{
					hmap.remove(id2);
					System.out.println("Key deleted successfully");
				}
				
			}
			
			break;
		case 4:
			for (Map.Entry<String, Employee> e : hmap.entrySet())  //Display all the values present in hashmap.
	            System.out.println(e.getKey() 
	                               + " : " + e.getValue());   
			break;
		default:
			System.out.println("Enter a valid number");
		}
		}
         	
	}

}



