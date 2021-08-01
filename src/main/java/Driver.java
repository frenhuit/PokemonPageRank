import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        UnitMultiplication multiplication = new UnitMultiplication();
        UnitSum sum = new UnitSum();

        String transitionMatrix = args[0];
        String prMatrix = args[1];
        String unitState = args[2];
        int count = Integer.parseInt(args[3]);
        for (int i = 0; i < count; i++) {
            String[] args1 = {transitionMatrix, prMatrix + i, unitState + i};
            multiplication.main(args1);
            String[] args2 = {unitState + i, prMatrix + (i + 1)};
            sum.main(args2);
        }
    }
}
