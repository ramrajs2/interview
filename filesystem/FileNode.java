package filesystem;

public class FileNode implements FileSystemNode {
    String name;
    int size;
    String collectionId;

    public FileNode(String name, int size, String collectionId) {
        this.name = name;
        this.size = size;
        this.collectionId = collectionId;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public String getParent() {
        return this.collectionId;
    }    
}
