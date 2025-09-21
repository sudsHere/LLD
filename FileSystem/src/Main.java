//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("f1");
        File file2 = new File("f2");
        File file3 = new File("f4");
        File file4 = new File("f3");
        Directory d1 = new Directory("d1");
        Directory d2 = new Directory("d2");
        root.Add(file1);
        root.Add(d1);
        root.Add(file2);
        d1.Add(file3);
        d1.Add(d2);
        d1.Add(file4);

        // print all the file and directory
        root.ls(0);
    }
}