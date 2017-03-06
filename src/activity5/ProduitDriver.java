package activity5;


import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class ProduitDriver extends Configured implements Tool {

  @Override
    public int run(String[] args) throws Exception {
    	 
    	@SuppressWarnings("deprecation")
		Job job = new Job(getConf());
    	 job.setJarByClass(ProduitDriver.class);
         job.setJobName("Cost Per Product");

         FileInputFormat.addInputPath(job, new Path(args[0]));
         FileOutputFormat.setOutputPath(job,new Path(args[1]));

         job.setMapperClass(ProduitMapper.class);
         job.setReducerClass(ProduitReducer.class);
         job.setMapOutputKeyClass(Text.class);
         job.setMapOutputValueClass(FloatWritable.class);

         job.setOutputKeyClass(Text.class);
         job.setOutputValueClass(FloatWritable.class);

         System.exit(job.waitForCompletion(true) ? 0:1); 
         boolean success = job.waitForCompletion(true);
         return success ? 0 : 1;
    }

    public static void main(String[] args) throws Exception {
    	ProduitDriver driver = new ProduitDriver();
        int exitCode = ToolRunner.run(driver, args);
        System.exit(exitCode);;
      // System.exit(ToolRunner.run(driver,args));
       }
    	
		
}
