package codechef;

import java.io.*;
import java.util.*;

public class TestCase {
    public  static void  main(String[] args)    throws Exception{
        File file = new File("out.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        for(int i=0;i<6000000;i++)  {
            bw.write("0");
        }

        bw.close();
    }
}
