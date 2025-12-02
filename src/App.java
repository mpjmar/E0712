public class App {
    public static void main(String[] args) throws Exception {

        int posInic = 0, posFin = 0;
        int numeros[] = pideNumeros(10);
        imprimeTabla(numeros);
        try {
            System.out.print("Introduzca la posición inicial: ");
            posInic = Integer.parseInt(System.console().readLine());
            System.out.print("Introduce la posición final: ");
            posFin = Integer.parseInt(System.console().readLine());
            System.out.println();
        }
        catch (NumberFormatException e) {
            System.out.println("El número debe ser un entero.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        System.out.println("Array original:");
        imprimeTabla(numeros);
        System.out.println("Array resultante:");
        imprimeTabla(rotaArray(numeros, posInic, posFin));
    }

    public static void imprimeTabla(int array[]) {
        System.out.print("┌────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┬─────");
        System.out.println("┐");

        System.out.print("│ Indice ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", i);
        System.out.println("│");

        System.out.print("├────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┼─────");
        System.out.println("┤");

        System.out.print("│ Valor  ");
        for (int i = 0; i < array.length; i++)
            System.out.printf("│%4s ", array[i]);
        System.out.println("│");

        System.out.print("└────────");
        for (int i = 0; i < array.length; i++)
            System.out.print("┴─────");
        System.out.println("┘");
        System.out.println();
    }

    public static int[] rotaArray(int array[], int posInic, int posFin) {
        int temp = array[posInic];
        for (int i = posInic; i > 0; i--)
            array[i] = array[i - 1];
        array[0] = array[array.length - 1];
        for (int i = array.length - 1; i > posFin; i--)
            array[i] = array[i - 1];
        array[posFin] = temp;
        return array;
    }

    public static int[] pideNumeros(int cantidad) {
        int numeros[] = new int[cantidad];
        System.out.printf("Introduzca %d números separados por INTRO: ", cantidad);
        try {
            for (int i = 0; i < numeros.length; i++)
                numeros[i] = Integer.parseInt(System.console().readLine());
        }
        catch (NumberFormatException e) {
            System.out.println("Los números deben ser enteros.");
        }
        catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
        System.out.println();
        return numeros;
    }

}
