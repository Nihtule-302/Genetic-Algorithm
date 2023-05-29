public class Main {
    public static double[] evaluate(double[] generation){
        double[] evaluation = new double[generation.length];
        for (int i = 0; i < generation.length; i++) {
            evaluation[i] = Math.pow(generation[i], 2) - (4*generation[i]) + 3;
        }
        return evaluation;
    }
    public static void select(double[] generation, double[] evaluation){}
    public static void crossOver(){}
    public static void mutate(){}

    public static void Replacment(double[] generation, double[] evaluation){
        select(generation, evaluation);
        crossOver();
        mutate();
    }

    public static void main(String[] args){
        double[] generation = {2.3, 4.1, 1.8, 3.9, .9, 1.2, 4.8, 2.5, 3.2, .5};
        double[] evaluation = evaluate(generation);
    }
}
