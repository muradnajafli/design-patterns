package com.epam.rd.autocode.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        int[] twoTimesArray = new int [array.length * 2];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            twoTimesArray[index++] = element;
            twoTimesArray[index++] = element;


        }
        Iterator<Integer> result = Arrays.stream(twoTimesArray).iterator();
        return result;
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        int[] threeTimesArray = new int [array.length * 3];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            threeTimesArray[index++] = element;
            threeTimesArray[index++] = element;
            threeTimesArray[index++] = element;
        }
        Iterator<Integer> result = Arrays.stream(threeTimesArray).iterator();
        return result;
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        int[] fiveTimesArray = new int [array.length * 5];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            fiveTimesArray[index++] = element;
            fiveTimesArray[index++] = element;
            fiveTimesArray[index++] = element;
            fiveTimesArray[index++] = element;
            fiveTimesArray[index++] = element;
        }
        Iterator<Integer> result = Arrays.stream(fiveTimesArray).iterator();
        return result;
        }

    public static Iterable<String> table(String[] columns, int[] rows){
        List<String> result = new ArrayList<>();
        for (String column : columns) {
            for (int row : rows) {
                result.add(column + row);

            }
        }
        return result;
    }



}
