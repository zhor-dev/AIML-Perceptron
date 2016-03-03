public class Perceptron {

    private double []weight = new double[3];
    private int []input = new int[3];
    private int desiredOutput;

    public Perceptron(double []w, int []i, int d) {
        this.weight = w;
        this.input = i;
        this.desiredOutput = d;
    }

    public void setInput(int []i) {
        this.input = i;
    }

    public void setDesiredOutput(int d) {
        this.desiredOutput = d;
    }

    public double[] getWeight() {
        return this.weight;
    }

    double sum() {
        double sum = 0;
        for (int i = 0; i < weight.length; ++i) {
            sum += input[i] * weight[i];
        }
        return sum;
    }

    double output(double S) {
        return sign(S);
    }

    double sign(double x) {
        return Math.signum(x);
    }

    void correctWeights() {
        for (int i = 0; i < weight.length; ++i) {
            /*W(i + 1)[k] = W(i)[k] + (desired_output - network_output) * input[k] * ABS(W(i)[k]) * epsilon
            * epsilon1 = ABS(W(i)[k] * epsilon
            */
            weight[i] = weight[i] + (desiredOutput - output(sum())) * input[i] * /*Math.abs(weight[i]) **/ 0.1;
        }
    }
}
