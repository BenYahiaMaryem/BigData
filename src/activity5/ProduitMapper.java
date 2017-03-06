package activity5;

import java.io.IOException; 

import org.apache.hadoop.io.*; 
import org.apache.hadoop.mapreduce.Mapper;


public class ProduitMapper extends Mapper <LongWritable,Text ,Text ,FloatWritable>  {
	
	public void map(LongWritable key,Text value,Context context) throws IOException,InterruptedException
	{
	
		String line = value.toString(); 
		 String line2=line.replaceAll("\\s+", " ");
	   String[] array= line2.split(" ");
	  
	 if (array.length==6)
			{
			String produit=array[3];
			
			Float cost= Float.parseFloat(array[4]);
			
		
		context.write(new Text(produit),new FloatWritable(cost));
		}
		
		
	}

}
