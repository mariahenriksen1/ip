public class Tree {

    private int age; //the tree's age in years 
    private double height; // the tree's height in meters 
    private double growthRate; // the tree's growth per year as percentage

    public Tree(double growthRate){
        this.age = 1; //initial age set to 1 year
        this.height = 0.12; //initial height set to 0,12 meters
        this.growthRate = growthRate;
    }


    public String toString() {
        return "Tree(age = " + age+ ", height = " +height+ ")";

    }

    public void growOneYear(){

        if(height < 14.0){
        height *= (1+growthRate/100); //increment height based on growth rate

        }else{
            height = 14;
        }
       age++;
        }
    }