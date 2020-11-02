package algorithms;

import helpers.PathHelper;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseLogs {

    @Test
    public void findUniqueValuesFromLog() throws IOException {
        Stream<String> fileRows = new PathHelper().getFileStream("1may2020.log");
        var allUniqValues = fileRows.map(x -> StringUtils.substringBetween(x, ":", ":="))
                .collect(Collectors.toSet());
        allUniqValues.forEach(System.out::println);
    }

    @Test
    public void findCountOfUniqueValues() throws IOException {
        Stream<String> fileRows = new PathHelper().getFileStream("1may2020.log");
        Map<String, Integer> result = Maps.newHashMap();
        fileRows.map(x -> StringUtils.substringBetween(x, ":", ":="))
                .forEach(x -> {
                    if (result.containsKey(x)) {
                        int count = result.get(x);
                        count++;
                        result.put(x, count);
                    } else {
                        result.put(x, 1);
                    }
                });

        result.forEach((x, y) -> System.out.println("key: " + x + ", val: " + y));
    }

    /*
    TODO

    write test how to parse string line with 2 or more entrance of same pattern.
    For example:
        [123123]:APPL:=25;ajsd;jfa[123456]:UBS:=25;dfgsdf[789101]:MGN:=13;dfgsdfjhs
     */
}
