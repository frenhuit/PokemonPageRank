import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Helper {
    public static void main(String[] args) throws IOException {
        BufferedReader pr = new BufferedReader(new FileReader("path_to_the_final_prN.txt"));
        BufferedReader transition = new BufferedReader(new FileReader("path_to_transition.txt"));
        FileWriter fileWriter = new FileWriter("path_to_where_you_want_to_save_result.cvs");

        Map<String, String> pagePr = new HashMap<String, String>();

        String line = pr.readLine();
        while(line != null) {
            pagePr.put(line.split("\t")[0], line.split("\t")[1]);
            line = pr.readLine();
        }
        pr.close();

        line = transition.readLine();
        fileWriter.write("source,target,value\n");

        while(line != null) {
            String[] fromTos = line.split("\t");
            String[] tos = fromTos[1].split(",");
            for (String to : tos) {
                String value = pagePr.get(to);
                fileWriter.write(fromTos[0] + "," + to + "," + value + "\n");
            }
            line = transition.readLine();
        }

        transition.close();
        fileWriter.close();
    }
}
