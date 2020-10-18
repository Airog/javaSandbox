package algorithms;

import java.util.ArrayList;

public class IdenticalCharactersCounter {

    // it was interview task, to write method which count identical characters inside a string
    // for example 'aabbcc' will have 'a3b3c3' result.

    public String counter(String st) {
        ArrayList<Character> listOfUnicEl = new ArrayList<>();
        listOfUnicEl.add(st.charAt(0));
        for (char c : st.toCharArray()) {
            if (c != listOfUnicEl.get(0) && !listOfUnicEl.contains(c)) {
                listOfUnicEl.add(c);
            }
        }

        int counter = 0;
        StringBuilder resultSt = new StringBuilder();
        for (Character c : listOfUnicEl) {
            for (Character cIn : st.toCharArray()) {
                if (c == cIn) {
                    counter++;
                }
            }
            resultSt.append(c);
            resultSt.append(counter);
            counter = 0;
        }

        return resultSt.toString();
    }
}
