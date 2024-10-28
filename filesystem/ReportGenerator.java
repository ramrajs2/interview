package filesystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReportGenerator {

    int totalSize;
    PriorityQueue<FileSystemNode> heap;
    Map<String, FileSystemNode> nodesMap;

    public Map<String, FileSystemNode> getNodesMap() {
        return nodesMap;
    }

    public void setNodesMap(Map<String, FileSystemNode> nodesMap) {
        this.nodesMap = nodesMap;
    }

    public ReportGenerator(Map<String, FileSystemNode> nodesMap) {
        this.nodesMap = nodesMap;
        totalSize = 0;
        heap = new PriorityQueue<>((a,b) -> b.getSize() - a.getSize());
    }

    public void addNode(FileSystemNode node) {
        // update size
        if(nodesMap.containsKey(node.getName()))
            totalSize -= nodesMap.get(node.getName()).getSize();
        totalSize += node.getSize();

        // update topN
        if(node.getParent() == null)
            heap.add(node);
        else if(!heap.contains(nodesMap.get(node.getParent())))
            heap.add(nodesMap.get(node.getParent()));
    }


    public void removeNode(FileSystemNode node) {

    }

    public List<FileSystemNode> getTopN(int n) {
        List<FileSystemNode> topN = new ArrayList<>();

        while(n > 0 && !heap.isEmpty()) {
            topN.add(heap.poll());
            n--;
        }

        addNodeBack(topN);

        return topN;
    }

    private void addNodeBack(List<FileSystemNode> topN) {
        int n = topN.size();
        while(n>0) {
            heap.add(topN.get(0));
            n--;
        }
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public PriorityQueue<FileSystemNode> getHeap() {
        return heap;
    }

    public void setHeap(PriorityQueue<FileSystemNode> heap) {
        this.heap = heap;
    }
}
