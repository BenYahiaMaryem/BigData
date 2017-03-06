package training;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class StoreReducer  extends Reducer <Text,FloatWritable,Text ,FloatWritable >{
	
	public void reduce(Text key,Iterable<FloatWritable> value,Context context) throws IOException,InterruptedException{
		
		FloatWritable result=new FloatWritable();
		 Float salesTotal = 0f;
			/*String oldKey = null;  
			if ((oldKey!= null) && (oldKey != key.toString()))
			{
				context.write(new Text(oldKey), new FloatWritable(salesTotal));
			salesTotal = 0f;  
			}
		oldKey=key.toString();
		salesTotal =Float.parseFloat(value.toString())+salesTotal;*/
		
		for(FloatWritable val : value)
		{
			salesTotal+=val.get();
		}
		
		result.set(salesTotal);
		context.write(key, result);
	}
	
	/*if (oldKey != null)
		context.write(new Text(oldKey), new FloatWritable(salesTotal));*/
	

}
