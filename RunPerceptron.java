import java.util.Arrays;

public class RunPerceptron {

    public static void main(String... args) {
        PerceptronLearning lp = new PerceptronLearning();
        System.out.println(lp.learnPerceptron(lp.getInput()[0]));
        System.out.println(lp.learnPerceptron(lp.getInput()[1]));
        System.out.println(lp.learnPerceptron(lp.getInput()[2]));
        System.out.println(lp.learnPerceptron(lp.getInput()[3]));
        System.out.println(Arrays.toString(lp.getResultWeight()));
    }

}


