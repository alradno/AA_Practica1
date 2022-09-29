public class Main {
    public static void main(String[] args) {
        int [] tareas = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(tareasOrdenadas(tareas,3));
        int [] tareas2 = {6, 2, 3, 8, 1, 4, 5, 9, 7, 10};
        System.out.println(tareasSinOrdenar(tareas2,3));
    }

    public static int tareasOrdenadas(int [] ts, int n){
        //Algoritmo voraz que resuelve el problema de las tareas ordenadas
        //ts: array de enteros con los tiempos de ejecución de las tareas
        //n: numero de procesadores que resuelven las tareas
        //Devuelve el tiempo mínimo que tardan en ejecutarse todas las tareas

        int tiempoTotal = 0;
        int [] tiempoProcesadores = new int[n];

        for(int i = 0; i < ts.length; i++){
            tiempoProcesadores[i%n] += ts[i];
            tiempoTotal = tiempoTotal + tiempoProcesadores[i%n];
        }

        return tiempoTotal;
    }

    public static int tareasSinOrdenar(int [] ts, int n){

        for(int i=0; i<ts.length; i++){
            for(int j=i+1; j<ts.length; j++){
                if(ts[i] > ts[j]){
                    int aux = ts[i];
                    ts[i] = ts[j];
                    ts[j] = aux;
                }
            }
        }
        int tiempoTotal = 0;
        int [] tiempoProcesadores = new int[n];

        for(int i = 0; i < ts.length; i++){
            tiempoProcesadores[i%n] += ts[i];
            tiempoTotal = tiempoTotal + tiempoProcesadores[i%n];
        }

        return tiempoTotal;
    }
}
