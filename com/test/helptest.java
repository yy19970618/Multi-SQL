package test;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class helptest/*@bgen(jjtree)*/implements MultiSQLPaserTreeConstants, MultiSQLPaserConstants {/*@bgen(jjtree)*/
    protected JJTMultiSQLPaserState jjtree = new JJTMultiSQLPaserState();

    public static void main(String args[]) throws ParseException {
        ArrayList<String> example = new ArrayList<String>(getFileContent("com/test/example.txt"));
        for(int i = 0; i < example.size(); i++) {
            System.out.println("Reading from standard input...");
            InputStream stream = new ByteArrayInputStream(example.get(i).getBytes(StandardCharsets.UTF_8));
            test.MultiSQLPaser p = new test.MultiSQLPaser(stream);
            System.out.println(example.get(i));
            try {
                SimpleNode n = p.Start();
                n.dump("");
                System.out.println("Thank you.");
            } catch (Exception e) {
                System.out.println("Oops.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }



    public static ArrayList<String> getFileContent(String path) {
        ArrayList<String> strList = new ArrayList<>();
        File file = new File(path);
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {
            // 将字节流向字符流转换
            inputStreamReader = new InputStreamReader(new FileInputStream(file), "utf-8");
            // 创建字符流缓冲区
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            // 按行读取
            while ((line = bufferedReader.readLine()) != null) {
                strList.add(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return strList;
    }

}
