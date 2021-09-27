import java.util.LinkedHashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {

        Map<String, String> indexValueMap = new LinkedHashMap<>();

        String[] valueLine = new String[]{"1234", "PODC", "CHANNEL", "STYPE", "21", "1991"};

        for (int i = 0; i < valueLine.length; i++) {
            indexValueMap.put(i + "", valueLine[i]);
        }

        int i = 0;
        final String employeeId = indexValueMap.get("" + i++).trim();
        final String stationCode = indexValueMap.get("" + i++).trim();
        final String channel = indexValueMap.get("" + i++).trim();
        final String stationType = indexValueMap.get("" + i++).trim();
        final String weekNum = indexValueMap.get("" + i++).trim();
        final String year = indexValueMap.get("" + i++).trim();

        System.out.println(employeeId + "," + stationCode + "," + channel + "," + stationType + "," + weekNum + "," + year);
    }
}
