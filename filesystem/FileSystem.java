package filesystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    Map<String, FileSystemNode> nodesMap;
    ReportGenerator reportGenerator;
    /**
     * {
     * "f1" : fileNode
     * "c1" : collectionNode
     * }
     */

    public FileSystem() {
        nodesMap = new HashMap<>();
        reportGenerator = new ReportGenerator(nodesMap);
    }

    public void addNode(String fileName, int size) {
        addNode(fileName, size, null);
    }

    public void addNode(String fileName, int size, String collectionId) {
        FileNode fileNode = new FileNode(fileName, size, collectionId);
        nodesMap.put(fileName, fileNode);

        if(collectionId != null) {
            CollectionNode collectionNode = (CollectionNode) nodesMap.getOrDefault(collectionId, new CollectionNode(collectionId));
            collectionNode.addNode(fileNode);
            nodesMap.put(collectionId, collectionNode);
        }

        reportGenerator.addNode(fileNode);
    }

    public void removeNode(String fileName) {

    }


    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.addNode("file1", 100, "c1");
        fileSystem.addNode("file5", 500, "c1");
        fileSystem.addNode("file2", 500, "c2");
        fileSystem.addNode("file3", 100, "c1");
        fileSystem.addNode("file4", 1000);

        System.out.println(fileSystem.getReportGenerator().getTotalSize());

        System.out.println("Top N");
        for(FileSystemNode node: fileSystem.getReportGenerator().getTopN(4)) {
            System.out.println(node.getName());
        }
    }

    public Map<String, FileSystemNode> getNodesMap() {
        return nodesMap;
    }

    public ReportGenerator getReportGenerator() {
        return reportGenerator;
    }
}

