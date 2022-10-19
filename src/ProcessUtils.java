import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ProcessUtils {

    public static void callProcessNumber(int numberOfProcess) {

        ArrayList<Process> listOfProcess = new ArrayList<>(numberOfProcess);

        ProcessBuilder process = new ProcessBuilder();
        if (System.getProperty("os.name").startsWith("Windows")) {
            process.command("cmd.exe", "/c", "C:\\Windows\\system32\\notepad.exe");
        } else process.command("firefox");

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

            System.out.println("Proceso finalizado Existosamente, tus procesos " +
                    "han sido detenidos completamente (en total eran " + numberOfProcess + ")");

        } catch (IOException exception) {
            System.out.println("ERROR: Ha ocurrido un error durante la ejecución del programa.");
        }


    }

    public static void callTemporaryProcessNumber(int numberOfProcess, int timeToLive) {

        ArrayList<Process> listOfProcess = new ArrayList<>(numberOfProcess);

        ProcessBuilder process = new ProcessBuilder();
        if (System.getProperty("os.name").startsWith("Windows")) {
            process.command("notepad");
        } else process.command("firefox");

        try {

            long InnitialTime = 0;
            long totalTime = 0;

            int innerNumberOfProcess = 0;
            while (innerNumberOfProcess < numberOfProcess) {
                Process localProcess = process.start();
                InnitialTime = System.currentTimeMillis();
                localProcess.waitFor(timeToLive, TimeUnit.MILLISECONDS);
                long currentProcessTime = System.currentTimeMillis() - InnitialTime;
                System.out.println("\nHORA DE INICIO: " + LocalDateTime.now());
                System.out.println(" · El proceso " + (innerNumberOfProcess + 1) + " ha durado: " + (System.currentTimeMillis() - InnitialTime) + " ms.");
                System.out.println("HORA DE FIN: " + LocalDateTime.now() + "\n");
                localProcess.destroyForcibly();
                totalTime += currentProcessTime;
                innerNumberOfProcess += 1;
            }

            System.out.println("\nProceso finalizado Existosamente, tus procesos han sido ejecutados y detenidos completamente:");
            System.out.println(" - En total eran " + numberOfProcess + " con un TTL de " + timeToLive + "ms.");
            System.out.println(" - Han tardado un total de " + totalTime + "ms.");

        } catch (IOException exception) {
            System.out.println("ERROR: Ha ocurrido un error durante la ejecución del programa.");
        } catch (InterruptedException e) {
            System.out.println("ERROR: Se ha interrumpido la pausa de " + timeToLive + " ms.");
        }


    }

    public static void pipeLineInstruction(File filePath) {

        if (filePath.exists() && filePath.isFile()) {
            String fileName = filePath.getName();
            ProcessBuilder myBuildedProcess = new ProcessBuilder();
            if (System.getProperty("os.name").startsWith("Windows")) {
                myBuildedProcess.command("cmd.exe", "/c" , "type", fileName, "|", "find", "/v", "/c", "", fileName);
            } else myBuildedProcess.command("cat", fileName, "|", "wc", fileName);

            try {

                myBuildedProcess.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                myBuildedProcess.start();

            } catch (IOException e) {
                System.out.println("ERROR: Se ha producido un error a la hora de ejecutar el proceso.");
            }
        } else System.out.println("ERROR: El archivo que ha introducido no existe.");

    }


}
