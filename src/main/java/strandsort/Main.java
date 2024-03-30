package strandsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("test");
        Scanner s = new Scanner(file);

        while ( s.hasNext() ) {
            String line = s.nextLine();
            ArrayList<Integer> a = new ArrayList<>();
            for ( String i : line.split(" ") ) {
                a.add(Integer.parseInt(i));
            }

            System.out.println(a);
            System.out.println("array size = " + a.size());
            System.out.println(strandSort(a));
            System.out.println();
        }
        s.close();

    }

    public static ArrayList<Integer> strandSort(ArrayList<Integer> originalList) {
        int n = 0;
        ArrayList<Integer> solutionList = new ArrayList<>();

        int op = 0;
        long start = System.nanoTime();

        while ( !originalList.isEmpty() ) {
            ArrayList<Integer> subList = new ArrayList<>();
            subList.add(originalList.get(0));
            originalList.remove(0);

            int index = 0;
            for (int j = 0; j < originalList.size(); j++) {
                if (originalList.get(j) > subList.get(index)) {
                    subList.add(originalList.get(j));
                    originalList.remove(j);
                    j--;
                    index++;
                    op++;
                }
            }

            if (n == 0) {
                for (Integer i : subList) {
                    solutionList.add(i);
                    n++;
                }

            } else {
                int subEnd = subList.size() - 1;
                int solutionStart = 0;
                while (!subList.isEmpty()) {
                    if (subList.get(subEnd) > solutionList.get(solutionStart)) {
                        solutionStart++;

                    } else {
                        solutionList.add(solutionStart, subList.get(subEnd));
                        subList.remove(subEnd);
                        subEnd--;
                        solutionStart = 0;
                    }
                    op++;
                }
            }
            op++;
        }
        long finish = System.nanoTime();
        long res = (finish-start)/1_000_000;
        System.out.println("time in msec = " + res);
        System.out.println("numb of iterations = " + op);

        return solutionList;
    }
}