package activity7;

import java.io.IOException; 

import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapreduce.Mapper;


public class TotalMapper extends Mapper <LongWritable,Text ,Text ,FloatWritable>  {
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
	float somme=0f;
		String line = value.toString(); 
		 String line2=line.replaceAll("\\s+", " ");
	   String[] array= line2.split(" ");
	  
	 if (array.length==6)
			{
			//String produit=array[3];
			
			Float cost= Float.parseFloat(array[4]);
			somme=somme+cost;
			
		
		context.write(new Text("Total"),new FloatWritable(somme));
		}
		
		
	}

}
