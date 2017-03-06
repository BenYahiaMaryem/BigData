package training;

import java.util.*; 
import java.io.IOException; 

import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapreduce.Mapper;


public class StoreMapper extends Mapper <LongWritable,Text ,Text ,FloatWritable>  {
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
	
		String line = value.toString(); 
		 String line2=line.replaceAll("\\s+", " ");
	   String[] array= line2.split(" ");
	  
	 if (array.length==6)
			{
			String store=array[2];
			
			Float cost= Float.parseFloat(array[4]);
			
		
		context.write(new Text(store),new FloatWritable(cost));
		}
		
		
	}

}
