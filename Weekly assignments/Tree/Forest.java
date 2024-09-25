import java.util.ArrayList;

public class Forest {
    
    private ArrayList<Tree>trees;

    public Forest() {
        trees = new ArrayList<>(); //an emptylist
    }
    public void addTree(double growthRate){
       trees.add(new Tree(growthRate));
    }

    public String toString() {
        String t;
        t = "Forest(";
        for (Tree tree : trees) {
            t = t + tree;
        }
        t = t + ")";
        return t;
    }

    public void growOneYear(){
        for (Tree tree : trees) {
            tree.growOneYear();
        }
    }
}
