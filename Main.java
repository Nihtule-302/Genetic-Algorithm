public class Main {

    public static double[] evaluate(double[] generation){
        double[] evaluation = new double[generation.length];
        for (int i = 0; i < generation.length; i++) {
            evaluation[i] = Math.pow(generation[i], 2) - (4*generation[i]) + 3;
        }
        return evaluation;
    }

    public static double[] select(double[] generation, double[] evaluation){
        double[] parents = new double[6];
        double min = generation[0];
        for (int i = 0; i < parents.length; i++) {
            for (int j = 0; j < parents.length; j++) {
                if (min > generation[j]){
                    min = generation[j];
                    generation[j] = 10000; // large number to avoid checking it again
                }
            }
            parents[i] = min;
        }
        return parents;
    }

    public static double[] crossOver(double[] parents){
        double[] children = new double[parents.length];
        for(int i = 0; i< parents.length; i+=2){
            double father = parents[i];
            int fatherGene1 = (int)father; // 2.3 -> 2
            double fatherGene2 = father - (double)fatherGene1; // .3 -> .299999999...

            double mother = parents[i+1];
            int motherGene1 = (int)mother;
            double motherGene2 = mother - (double)motherGene1;

            children[i] = fatherGene1 + motherGene2;
            children[i+1] = motherGene1 + fatherGene2;
        }
        return children;
    }

    public static double[] mutate(double[] children){
        double chance = Math.random();
        double mutation = .2;
        for (int i = 0; i < children.length; i++) {
            if (chance > .5)
                children[i] += .2;
            else if (chance < .5)
                children[i] -= .2;
        }
        return children;
    }

    public static double[] newGen(double[] generation, double[] evaluation){
        double[] parents = select(generation, evaluation);
        double[] children = crossOver(parents);
        children = mutate(children);


        return generation;
    }

    public static void main(String[] args){
        double[] generation = {2.3, 4.1, 1.8, 3.9, .9, 1.2, 4.8, 2.5, 3.2, .5};
        double[] evaluation = evaluate(generation);

        for (int i = 0; i < 2; i++) {
            generation = newGen(generation, evaluation);
            evaluation = evaluate(generation);
        }
    }
}
