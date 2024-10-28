package filesystem;

import java.util.HashMap;
import java.util.Map;

public class CollectionNode implements FileSystemNode {

    String collectionId;
    int size;
    Map<String, FileSystemNode> nodesMap;

    public CollectionNode(String collectionId) {
        this.collectionId = collectionId;
        this.size = 0;
        this.nodesMap = new HashMap<>();;
    }

    public void addNode(FileSystemNode node) {
        addSize(node);
        nodesMap.put(node.getName() , node);        
    }

    private void addSize(FileSystemNode node) {
        int nodeSize = node.getSize();
        if(nodesMap.containsKey(node.getName())) {
            nodeSize -= nodesMap.get(node.getName()).getSize();
        }

        size += nodeSize;
    }

    public void removeNode(FileSystemNode node) {
        removeSize(node);
        nodesMap.remove(node);        
    }

    private void removeSize(FileSystemNode node) {
        // add only difference if already exists
        throw new UnsupportedOperationException("Unimplemented method 'updateSize'");
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.collectionId;
    }

    @Override
    public String getParent() {
        return null;
    }
}
