import java.util.Scanner;
class Main {
    public static void main(String[] args)
    {
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Virtual file system");
        System.out.print(":> ");
        while (!exit)
        {
            String command = in.nextLine();
            String[] tokens = UI.parseCommand(command);
            exit = (tokens[0].equals("exit"));
            if (tokens[0].equals("import"))
                UI.importFile(tokens);
            else if (tokens[0].equals("export"))
                UI.exportFile(tokens);
            else if (tokens[0].equals("ls"))
                UI.ls(tokens);
            else if (!exit)
            {
                System.out.println("command not recognized.");
            }

            if (!exit)
            {
                System.out.print(":> ");
            }
        }
        System.out.println("Program terminated.");
    }
}