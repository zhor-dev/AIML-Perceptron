public class PerceptronLearning {

    private int[] and() {
        return new int[] {-1, -1, -1, 1};
    }

    private int[] or() {
        return new int[] {-1, 1, 1, 1};
    }

    private int[] xor() {
        return new int[] {-1, 1, 1, -1};
    }

    private int [][]input = {
            {1, -1, -1},
            {1, -1, 1},
            {1, 1, -1},
            {1, 1, 1}
    };

    private double []w = {
            0, 0.9, 0.2
    };

    private int []desiredOutput = and();

    Perceptron p = new Perceptron(w, input[0], desiredOutput[0]);

    private double []resultWeight;

    public double learnPerceptron(int []i) {
        int j = 0;
        while (!isCorrect()) {
            while (p.sign(p.sum()) != desiredOutput[j]) {
                System.out.println("index = " + j); //Log
                p.correctWeights();
            }
            ++j;
            if (j == 1) {
                setInputAndDesiredOutput(input[1], desiredOutput[1]);
            } else if (j == 2) {
                setInputAndDesiredOutput(input[2], desiredOutput[2]);
            } else if (j == 3) {
                setInputAndDesiredOutput(input[3], desiredOutput[3]);
            } else {
                setInputAndDesiredOutput(input[0], desiredOutput[0]);
                j = 0;
            }
        }
        resultWeight = p.getWeight();
        p.setInput(i);
        return p.sign(p.sum());
    }

    private boolean isCorrect() {
        setInputAndDesiredOutput(input[0], desiredOutput[0]);
        if (p.sign(p.sum()) == desiredOutput[0]) {

            setInputAndDesiredOutput(input[1], desiredOutput[1]);
            if (p.sign(p.sum()) == desiredOutput[1]) {
                setInputAndDesiredOutput(input[2], desiredOutput[2]);
            }
            if (p.sign(p.sum()) == desiredOutput[2]) {
                setInputAndDesiredOutput(input[3], desiredOutput[3]);
                if (p.sign(p.sum()) == desiredOutput[3]) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setInputAndDesiredOutput(int []i, int d) {
        p.setInput(i);
        p.setDesiredOutput(d);
    }

    public int[][] getInput() {
        return input;
    }

    public double[] getResultWeight() {
        return resultWeight;
    }
}
