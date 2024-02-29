package IO;

import java.io.*;

public class Utils {
    public static <T> void fileRead(T obj, String file) {

        try {
            // el true es para que de inserte debajo de lo que ya existe
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(obj.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static <T> boolean checkInFiles(T obj, String file) {

        boolean found = false;
        try {
            FileInputStream fileIn = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileIn));
            String lineFile;
            if (obj.equals(IUser)) {
                String[] dataUser = obj.toString().split(" ");

                while ((lineFile = bufferedReader.readLine()) != null && !found) {
                    String[] parts = lineFile.split(":");
                    found = (dataUser[0].equals(parts[0]) && (dataUser[2].equals(parts[2])));
                }
            }else {

                while ((lineFile = bufferedReader.readLine()) != null && !found) {
                    found = (obj.toString().equals(lineFile));
                }
            }
            bufferedReader.close();
            fileIn.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return found;
    }
}
