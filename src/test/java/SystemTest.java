import junit.framework.Assert;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SystemTest extends TestCase {
  public void test() {
    String expectedResultPath = "data/test_weights_1_expected";
    String actualResultPath = "data/test_weights_1_actual";
    Map<String, String> expectedResult = loadWeights(expectedResultPath);
    Map<String, String> actualResult = loadWeights(actualResultPath);
    Assert.assertEquals(expectedResult, actualResult);
  }

  /**
   * Loads weights in a file, save the result into hashmap.
   * @param filePath String
   * @return HashMap
   */
  private HashMap<String, String> loadWeights(String filePath) {
    HashMap<String, String> resultMap = new HashMap<>();

    try {
      File expectedResultFile = new File(filePath);
      if (expectedResultFile.isFile() && expectedResultFile.exists()) {
        InputStreamReader read = new InputStreamReader(
            new FileInputStream(expectedResultFile)
        );
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt;

        while ((lineTxt = bufferedReader.readLine()) != null) {
          String[] pr = lineTxt.trim().split("\t");
          resultMap.put(pr[0], pr[1]);
        }
        bufferedReader.close();
        read.close();
      }
    } catch (Exception e) {
      System.out.println("Error on loading files.");
      e.printStackTrace();
    }

    return resultMap;
  }
}