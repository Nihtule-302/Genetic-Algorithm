public class Main {

    public static double[] evaluate(double[] generation){
        double[] evaluation = new double[generation.length];
        for (int i = 0; i < generation.length; i++) {
            evaluation[i] = Math.pow(generation[i], 2) - (4*generation[i]) + 3;
        }
        return evaluation;
    }

    public static double[] select(double[] generation, double[] evaluation){
        double[] parents = new double[5];
        double min = generation[0];
        for (int i = 0; i < parents.length; i++) {
            for (int j = 0; j < parents.length; j++) {
                if (min > generation[j]){
                    min = generation[j];
                    generation[j] = 10000 // large number to avoid checking it again
                }
            }
            parents[i] = min;
        }
        return parents
    }

    public static void crossOver(double[] parents){}
    public static void mutate(double[] children){}

    public static double[] newGen(double[] generation, double[] evaluation){
        double[] parents = select(generation, evaluation);
        double[] children = crossOver(parents);
        children = mutate(children);
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
