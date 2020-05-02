package demo.fileInout;





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Scanner;

public class FileInout {

    private static Logger logger = LoggerFactory.getLogger(FileInout.class);


    public static   int toFile(String path,String str) throws FileNotFoundException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path,true));
        try {
            logger.debug(str);
            outputStreamWriter.write(str+" ");
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }catch (IOException e){
            e.printStackTrace();
            logger.debug("写入文件异常");
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {


        String path = "G:\\demo\\demoFile.txt";
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            if(str.equals("")) break;
            logger.debug(str);
            int res = toFile(path,str);
            if(res == 1){
                logger.debug("插入文件失败");
            }
        }
        inFile(path);
        return;
    }

    public static int inFile(String path) {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer str = new StringBuffer();
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                    str.append(temp);
            }
            logger.debug(str.toString());
        }catch (IOException e){
            e.printStackTrace();
            logger.debug("读取文件内容异常");
            return 1;
        }
        return 0;
    }
}
