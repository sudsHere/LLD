import java.util.ArrayList;

public class Directory extends FileSystem{
    ArrayList<FileSystem> file_system;

    public Directory (String name) {
        super(name);
        file_system = new ArrayList<>();
    }

    public void Add(FileSystem file_system) {
        this.file_system.add(file_system);
    }

    @Override
    boolean isFolder() {
        return true;
    }

    @Override
    public void ls(int indent) {
        // 1. Print this folder
        System.out.println(" ".repeat(indent) + "[" + name + "]");

        // 2. Print each file
        for(FileSystem fs: file_system){
            if (!fs.isFolder()) {
                fs.ls(indent + 2);
            }
        }

        // 3. Recursively print for folder
        for(FileSystem fs: file_system){
            if (fs.isFolder()) {
                fs.ls(indent + 2);
            }
        }
    }
}