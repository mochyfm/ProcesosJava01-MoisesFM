import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);

        System.out.print("¿Cuantos notepads quieres abrir?: ");
        // ProcessUtils.callProcessNumber(lectura.nextInt();
        lectura.nextLine();
        System.out.print("¿Cuantos notepads quieres abrir? serán cerrados al pasar 500ms desde que fueron creados: ");
        // ProcessUtils.callTemporaryProcessNumber(lectura.nextInt(), 500);
        lectura.nextLine();

        ProcessUtils.pipeLineInstruction(new File("./ProcesosJava01-MoisesFM.iml"));

        // Ejemplo que falla.
        // ProcessUtils.pipeLineInstruction(new File(".gitIgnora"));
    }
}