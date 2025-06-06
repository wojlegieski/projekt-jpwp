import MyException.Record;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Record> records = new ArrayList<Record>();
        FileParser fp = new FileParser();
        records = fp.parseFile("projeckt/data/data.txt");
        for (Record record : records) {
            System.out.println(record);
        }
    }
}