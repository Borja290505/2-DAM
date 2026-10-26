import java.util.*;
import java.util.concurrent.*;
public class Prueba {
    static class Multiplication implements Callable<Integer> {
        private int op1;
        private int op2;
        public Multiplication(int operador1, int operador2) {
            this.op1 = operador1;
            this.op2 = operador2;
        }
        // Implementación de la interfaz
        @Override
        public Integer call() throws Exception {
            return op1 * op2;
        }
    }
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<Multiplication> taskList = new ArrayList<Multiplication>();

        for (int i = 0; i < 10; i++) {
            int op1 = (int) (Math.random() * 10);
            int op2 = (int) (Math.random() * 10);
            Multiplication calcula = new Multiplication(op1, op2);
            System.out.println("Task " + i + " is:" + op1 + " * " + op2);
            taskList.add(calcula);
        }

        List<Future<Integer>> resultList;
        try {
            resultList = executor.invokeAll(taskList);

            executor.shutdown();

            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> res = resultList.get(i);
                System.out.println("Result of task " + i + " is:" + res.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }
    }
}