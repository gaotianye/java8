package cn.gaotianye.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    private enum Status {
        OPEN, CLOSED
    };
     
    private static final class Task {
        private final Status status;
        private final Integer points;
 
        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }
         
        public Integer getPoints() {
            return points;
        }
         
        public Status getStatus() {
            return status;
        }
         
        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }
    public static void main(String[] args) throws Exception {
    	final Collection< Task > tasks = Arrays.asList(
    		    new Task( Status.OPEN, 5 ),
    		    new Task( Status.OPEN, 13 ),
    		    new Task( Status.CLOSED, 8 ) 
    		);
    	System.out.println("========java 7===========");
    	int sum = 0;
    	for (Task task : tasks) {
    		if(task.status==Status.OPEN){
    			Integer points = task.getPoints();
    			sum +=points;
    		}
		}
    	System.out.println("sum is :"+sum);
    	System.out.println("==========java 8============");
    	/**
    	 * 	task集合被转换化为其相应的stream表示。
    	 * 	filter操作过滤掉状态为CLOSED的task。
    	 * 	mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法，
    	 * 		把Task的stream转化为Integer的stream。
    	 * 	用sum函数把所有的分数加起来，得到最终的结果。
    	 */
    	final long totalPointsOfOpenTasks = tasks
    		    .stream()
    		    .filter( task -> task.getStatus() == Status.OPEN )
    		    .mapToInt( Task::getPoints )
    		    .sum();
    	System.out.println( "Total points: " + totalPointsOfOpenTasks );
    	System.out.println("==============java 8 另外一种写法=============");
    	final double totalPoints = tasks
    			   .stream()
    			   .parallel()
    			   .map( task -> task.getPoints() ) // or map( Task::getPoints ) 
    			   .reduce( 0, Integer::sum );
    	System.out.println( "Total points (all tasks): " + totalPoints );
    	System.out.println("========我们需要按照某种准则来对集合中的元素进行分组================");
    	//{OPEN=[[OPEN, 5], [OPEN, 13]], CLOSED=[[CLOSED, 8]]}
    	final Map< Status, List< Task > > map = tasks
    		    .stream()
    		    .collect( Collectors.groupingBy( Task::getStatus ) );
    	System.out.println( map );
    	System.out.println("=============求平均================");
    	final Collection< String > result = tasks
    		    .stream()                                        // Stream< String >
    		    .mapToInt( Task::getPoints )                     // IntStream
    		    .asLongStream()                                  // LongStream
    		    .mapToDouble( points -> points / totalPoints )   // DoubleStream
    		    .boxed()                                         // Stream< Double >
    		    .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
    		    .mapToObj( percentage -> percentage + "%" )      // Stream< String> 
    		    .collect( Collectors.toList() );                 // List< String > 
    	System.out.println( result );
    	System.out.println("=========I/O操作===============");
    	/**
    	 * Stream API不仅仅处理Java集合框架。
    	 * 像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理
    	 */
    	final Path path = new File("E:/data/java8/file.txt").toPath();
    	try( Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
    		/**
    		 * 对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，
    		 * 当对stream对象调用close()方法时，与关闭相关的处理器就会执行。
    		 */
    	    lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
    	}
	}
}
