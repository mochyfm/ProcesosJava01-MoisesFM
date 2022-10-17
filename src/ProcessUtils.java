import java.io.IOException;
import java.util.ArrayList;

public class ProcessUtils {

    public static void callProcessNumber(int numberOfProcess) {

        ArrayList<Process> listOfProcess = new ArrayList<>(numberOfProcess);

        ProcessBuilder process = new ProcessBuilder();
        if (System.getProperty("os.name").startsWith("Windows")) {
            process.command("cmd.exe", "/c", "C:\\Windows\\system32\\notepad.exe");
        } else process.command("firefox");

        System.out.println();

        try {

            int innerNumberOfProcess = numberOfProcess;

            while (innerNumberOfProcess != 0) {
                listOfProcess.add(process.start());
                innerNumberOfProcess -= 1;
            }

            int processCounter = 0;
            while (listOfProcess.size() != 0) {
                if (!listOfProcess.get(processCounter).isAlive()) {
                    listOfProcess.remove(processCounter);
                }
            }

            System.out.println("Proceso finalizado Existosamente, tus procesos han sido detenidos completamente (en total eran " + numberOfProcess + ")");

        } catch (IOException exception) {
            System.out.println("ERROR: Ha ocurrido un error durante la ejecución del programa.");
        }


    }

}
