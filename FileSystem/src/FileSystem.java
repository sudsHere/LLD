public class FileSystem {
    String name;

    boolean isFolder() {
        return false;
    }

    public FileSystem(String name) {
        this.name = name;
    }

    public void ls(int indent) {
        System.out.printf(this.name);
        System.out.print("\n");
    }
}
