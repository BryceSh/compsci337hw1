import java.io.File;

public class Drive
{
    private static File wd = new File("C");

    public void setFile(char name, String data) {
    }

    public String getFile(char name)
    {
        return "";
    }

    public char[] names()
    {
        return new char[1];
    }

    public static File getWd() {
        return wd;
    }

}