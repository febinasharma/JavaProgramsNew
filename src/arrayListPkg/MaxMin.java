
package arrayListPkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MaxMin {


	static int key=0;
	static int sum=0, count=0, index=0,tempListSum=0;
	
	
	public static void main(String args[])
	{
	List<Object> imvList=new ArrayList<Object>(Arrays.asList(1,5,null,1,2,2,null,3));
	
	System.out.println("MaxSum for the given list is : "+maxSum(imvList));
	System.out.println("MinAvg for the given list is : "+minAvg(imvList));
	}

	public static List<Integer> maxSum(List<Object> imvList) {

		List<Integer> tempList=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
		System.out.println("Monitoring Window: "+imvList);
		
		for(Object arr:imvList)
		{
			if(arr!=null)
			{
				tempList.add((Integer) arr);
			}		
			else
			{
				if(tempList.size()>0)
				{

					map.put(key, new ArrayList<Integer>(tempList));
					key=key+1;
					listSum(tempList);

					if(tempListSum==sum)
					{
						if(tempList.size()>count)
						{
							findMax(tempList);
						}
					}
					else if(tempListSum>sum)
					{
						findMax(tempList);
					}
    				tempListSum=0;
					tempList.clear();
					
				}
			}
		}
		if(tempList.size()>0)
		{
			map.put(key, new ArrayList<Integer>(tempList));
			listSum(tempList);
			if(tempListSum>sum)
			{
				findMax(tempList);
				index = key;
			}
			else if(tempListSum==sum && tempList.size()>count)
			{
				findMax(tempList);
				index = key;
			}
		}
		if(map.size()==0)
		{	
				return Collections.emptyList();			
		}
	
	return map.get(index);
	}

	public static void findMax(List<Integer> list)
	{
		sum=tempListSum;
		count=list.size();
		index = (key-1);
	}

	public static void listSum(List<Integer> list)
	{
		for(int j=0;j<list.size();j++)
		{			
			tempListSum+=list.get(j);
		}
	}
	
	public static int minlistSum(List<Integer> list)
	{
		int tempsum=0;
		for(int j=0;j<list.size();j++)
		{			
			tempsum+=list.get(j);
		}
		return tempsum;
	}
	
	public static List<Integer> minAvg(List<Object> minList)
	{
		int minKey=0,indexMin=0,listcount=0;
		float tempListAvg=0,avg=0;
		List<Integer> tempListMin=new ArrayList<Integer>();
		HashMap<Integer,List<Integer>>  map= new HashMap<Integer,List<Integer>>();
				
		for(Object arr:minList)
		{
			if(arr!=null)
			{
				tempListMin.add((Integer) arr);
			}		
			else
			{
				if(tempListMin.size()>0)
				{

					map.put(minKey, new ArrayList<Integer>(tempListMin));
					minKey=minKey+1;
					listcount=minlistSum(tempListMin);
					tempListAvg=listcount/(float)tempListMin.size();
					
					if(map.size()==1)
					{
						avg=tempListAvg;
						indexMin=map.size()-1;
					}
					else if(tempListAvg<avg)
					{
						avg=tempListAvg;
						indexMin=map.size()-1;
					}
					
					listcount=0;
					tempListMin.clear();
				}
	         }
	   }
		if(tempListMin.size()>0)
		{
			map.put(minKey, new ArrayList<Integer>(tempListMin));
			listcount=minlistSum(tempListMin);
			tempListAvg=listcount/(float)tempListMin.size();
			if(tempListAvg<avg)
			{
				avg=tempListAvg;
				indexMin=map.size()-1;
			}
		}
		if(map.size()==0)
		{	
				return Collections.emptyList();			
		}
		return(map.get(indexMin));
	}

}
