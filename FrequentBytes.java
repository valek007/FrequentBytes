import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FrequentBytes {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(FileInputStream fileIn = new FileInputStream(reader.readLine())){

            ArrayList<Integer> list = new ArrayList<>();
            Map<Integer, Integer> mapList = new HashMap<>();



            while(fileIn.available()>0){
                list.add(fileIn.read());
            }

            for(Integer x: list){
                int count = Collections.frequency(list,x);
                mapList.put(x,count);
            }

            int max = Collections.max(mapList.values());

            for(Map.Entry<Integer,Integer> pair: mapList.entrySet()){
                if(pair.getValue() == max){
                    System.out.print(pair.getKey() + " ");
                }
            }


        } catch (Exception e){}

        reader.close();
    }
}