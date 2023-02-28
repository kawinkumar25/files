package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fileslogic {
    String[] str1;
    Logger l = Logger.getLogger("kawin");
    Fileslogic(String[] str1)
    {
        this.str1=str1;
    }
    void hash() {

        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < str1.length; i++) {
            if (hash.containsKey(str1[i])) {
                hash.put(str1[i], hash.get(str1[i]) + 1);
            } else {
                hash.put(str1[i], 1);
            }
        }
        l.log(Level.INFO, () -> ("Frequncy " + hash));
        l.log(Level.INFO, () -> ("Size " + str1.length));

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });

        q.addAll(hash.entrySet());

        while (!q.isEmpty()) {
            l.log(Level.INFO, () -> "\n" + q.poll());
        }

    }
}
