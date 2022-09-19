import java.io.*;
import java.nio.file.Files;

public class UI
{
    Drive c = new Drive();
    public static String[] parseCommand(String command)
    {
        return command.split("\\s+");
    }

    public static void importFile(String[] tokens) {

        InputStream is = null;
        OutputStream os = null;
        if (tokens.length != 3) {
            System.out.println("Invalid Arguments: import <FILE> <PATH>");
        } else {
            try {
                File f = new File(tokens[1]);
                File check = new File(Drive.getWd() + "/" + tokens[2]);
                if (f.exists() && !f.isDirectory()) {
                    if (check.exists()) {
                        System.out.println("File " + tokens[2] + " already exist!");
                    } else {
                        is = new FileInputStream(tokens[1]);
                        os = new FileOutputStream(Drive.getWd() + "/" + tokens[2]);
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = is.read(buffer)) > 0) {
                            os.write(buffer, 0, length);
                        }
                        is.close();
                        os.close();
                    }
                } else {
                    System.out.println("File does not exist!");
                }
            } catch (IOException e) {
                System.out.println("File error: " + e.getMessage());
            }
        }
    }

    public static void exportFile(String[] tokens)
    {
        if (tokens.length == 3) {
            File curFile = new File(Drive.getWd() + "/" + tokens[1]);
            File copyTo = new File(tokens[2]);
            InputStream is = null;
            OutputStream os = null;
            if (copyTo.exists()) {
                System.out.println("File already exist!");
            } else {
                try {
                    is = new FileInputStream(Drive.getWd() + "/" + tokens[1]);
                    os = new FileOutputStream(Drive.getWd() + "/" + tokens[2]);
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                    is.close();
                    os.close();
                } catch (Exception e) {
                    System.out.println("Export error: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Invalid command arguments: export <FILE> <PATH>");
        }

    }

    public static void ls(String[] tokens)
    {
        try {
            File f = Drive.getWd();
            File[] files = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                System.out.println(files[i].getName() + " " + Files.size(files[i].toPath()));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage() + e.getCause());
        }
    }

}