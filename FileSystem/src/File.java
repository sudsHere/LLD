public class File extends FileSystem{
    public File(String name) {
        super(name);
    }

    @Override
    public void ls(int indent) {
        System.out.println(" ".repeat(indent) + this.name);
    }
}
