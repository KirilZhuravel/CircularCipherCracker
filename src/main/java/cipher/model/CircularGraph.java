package main.java.cipher.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CircularGraph {

    private final char[] nodes;


    private final int size;

    public CircularGraph(String key) {

        this.nodes = key.toUpperCase().toCharArray();
        this.size = nodes.length;
    }


    public char getNode(int index) {

        return nodes[index % size];
    }


    public int indexOf(char c) {
        for (int i = 0; i < size; i++) {
            if (nodes[i] == c) return i;
        }
        return -1;
    }


    public String getKey() {
        return new String(nodes);
    }


    public static CircularGraph createRandom() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        List<Character> chars = alphabet.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.toList());

        Collections.shuffle(chars);


        StringBuilder sb = new StringBuilder();
        for (char c : chars) sb.append(c);

        return new CircularGraph(sb.toString());
    }
}