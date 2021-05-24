package test;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.util.List;


public class helptest/*@bgen(jjtree)*/implements MultiSQLPaserTreeConstants, MultiSQLPaserConstants {/*@bgen(jjtree)*/
    protected JJTMultiSQLPaserState jjtree = new JJTMultiSQLPaserState();

    public static void main(String args[]) throws ParseException {

        /**
         * The following examples are based on a scene in figure "example.png":
         *
         * Example 1: Query the person's id who's name is "Amy".
         *
         * Select Person.id from Person Where Person.name = "Amy";
         *
         * Example 2: Query the person's password who's id is "001"
         *
         * Select Password.password From Password Where Password.id = "001";
         *
         * Example 3: Query the person's blogs who's id is "002" and the keywords of blogs contains "phone".
         *
         * Select Blog from Blog
         * Where Blog.Match({id:{=, "002"}, keyword:list< {value:{"like", phone}}> });
         *
         * Example 4: Query the persons's id who like Amy’s likers.
         *
         * Select Social.Path1.n3.pid from Social
         * Where Social.Path1(Person:{name:{=, "Amy"}} -> Relation:{type:{=, "like"}} -> Person:{} <- Relation:{type:{=,"like"}} <- Person:{});
         *
         * Example 5: Query the persons's age who like Amy’s likers.
         *
         * Select Person.age from Person
         * Where Person.id in
         *   (Select Social.Path1.n3.pid Where Social.Path1(Person:{name:{=, "Amy"}}  -> Relation:{type:{=, "like"}}-> Person:{} <- Relation:{type:{=,"like"}} <- Person:{}));
         *
         * Example 6: Query blogs made by persons who are 20 years old and are female.
         *
         * Select {Person.id, Person.age, Person.gender, blogs : [{Blog.keyword, Blog.content}]}
         * From JOIN Person, Blog RULE {Person.id, Person.age, Person.gender, blogs:[{Blog.keyword, Blog.content}]} WITH Person.id = Blog.person
         * Where Person.age = 20 and Person.gender = 0;
         *
         * Example 7: Query posts made by users who are female and younger than 20 in Amy's liker
         *
         * Select {Person.id, Person.age, Person.gender, blogs : [{Blog.keyword, Blog.content}]}
         *  From JOIN Person, Blog RULE {Person.id, Person.age, Person.gender, blogs : [{Blog.keyword, Blog.content}]} WITH Person.id = Blog.person
         * Where Person.age < 20 and Person.gender = 0 and Person.id in
         *   (Select Social.Path1.n2.pid Where Social.Path1(Person:{name:{=, "Amy"}} -> Relation:{type:{=, "like"}} -> Person:{}));
         */
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
