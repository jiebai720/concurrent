package com.bb;

import org.apache.commons.io.FileUtils;
import sun.nio.cs.StandardCharsets;

import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2018/1/10.
 */
public class FileTest {


    public static void main(String[] args)  {

        File file = new File("E:\\AppServ\\Apache24\\bin\\post.txt");
        for( int i=0; i< 200000; i++){

            String str = "type=1&id="+i + "\r\n";
//            try {
//                FileUtils.writeStringToFile(  file , str , StandardCharsets. , true );
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }


}
