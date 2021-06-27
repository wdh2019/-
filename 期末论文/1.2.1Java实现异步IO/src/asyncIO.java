import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Future;
import java.nio.charset.Charset;

    public class asyncIO{
        public static void main(String[] args) throws Exception{
            asyncRead("src/passage.txt");
            System.out.println("Start computing");
            long start1 = System.currentTimeMillis();
            int result1 = fn(44);
            long end1 = System.currentTimeMillis();
            System.out.println("Finish computing, the result is " + result1 + " and it takes " + (end1 - start1) + "ms");

        }

        //异步io
        public static void asyncRead(String path) throws Exception{
            System.out.println("Start reading");
            long start = System.currentTimeMillis();

            Path file = Paths.get(path);
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(file);

            ByteBuffer buffer = ByteBuffer.allocate(100000);
            // 回调式
            channel.read(buffer, 0, buffer,new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    long end = System.currentTimeMillis();
                    //反转buffer
                    buffer.flip();
                    //System.out.println(Charset.forName("UTF-8").decode(attchment).toString());
                    System.out.println("Finish reading, words read " + result + " and it takes " + (end - start) + "ms");
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("read error");
                }
            });
        }

        //斐波那契数列
        public static int fn(int n){
            if(n == 0) return 0;
            if(n == 1) return 1;

            return fn(n-1)+fn(n-2);
        }
    }


