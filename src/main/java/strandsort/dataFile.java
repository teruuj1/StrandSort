package strandsort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class dataFile {
    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("test");
        PrintWriter pw = new PrintWriter(f);

        int a = random(50, 100); //кол-во наборов
        for ( int i = 0; i < a; i++ ) {
            int b = random(100, 10000); //кол-во элементов в наборе
            for ( int j = 0; j < b; j++ ) {
                pw.print(random(0, 10000) + " ");
            }
            pw.println();
        }
        pw.close();
    }

    public static int random(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
