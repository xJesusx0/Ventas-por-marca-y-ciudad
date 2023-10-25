package jesusperea_y_diegovasquez;

/**
 * @param args
 * Diego estan son las convenciones del codigo
 * 
 * Nombres de variables
 * 
 * int cantidadp NO 
 * int CantidadPersonas SI
 * 
 * -----------------------
 * 
 */

//Librerias
import javax.swing.*; //Libreria del joptionpane
import java.io.*; //Libreria para guardar en txt

public class JesusPerea_Y_DiegoVasquez {
    
    //Metodos para que el usuario ingrese datos
  public static String InputString(String mensaje){
       while (true) {
            String UserInput = JOptionPane.showInputDialog(null,mensaje);

            // Verificar si la entrada no está vacía
            if (!UserInput.trim().isEmpty()) {
                return UserInput; // Si no está vacía, salir del bucle
            } else {
                JOptionPane.showMessageDialog(null,"La entrada esta vacia, intentelo denuevo");
            }
        }

  }
  
  public static int InputInt(String mensaje){
       while (true) {
           String UserInput = JOptionPane.showInputDialog(null,mensaje); 
           
            // Verificar si la entrada no está vacía y es un número
            if (!UserInput.trim().isEmpty()) {
                try {
                    // Intentar convertir la entrada a int
                    return Integer.parseInt(UserInput);
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"La entrada es invalida, intente de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null,"La entrada esta vacia, intentelo denuevo");
            }
        }
  }
  
  public static double InputDouble(String mensaje){
       while (true) {
           String UserInput = JOptionPane.showInputDialog(null,mensaje); 
           
            // Verificar si la entrada no está vacía y es un número
            if (!UserInput.trim().isEmpty()) {
                try {
                    // Intentar convertir la entrada a double
                    return Double.parseDouble(UserInput);
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"La entrada es invalida, intente de nuevo");
                }
            } else {
                JOptionPane.showMessageDialog(null,"La entrada esta vacia, intentelo denuevo");
            }
        }
  }
  
  //Metodo para obtener el elemento mayor
  public static double ObtenerMayor(double[] vector){
    double Mayor = vector[0];
    for(int i = 1; i < vector.length; i++){
      if(vector[i] > Mayor){
        Mayor = vector[i];
      }
    }
    return Mayor;  
  }
  
  //Metodo para obtener el elemento menor
  public static double ObtenerMenor(double[] vector){
    double Menor = vector[0];
    for(int i = 1; i < vector.length; i++){
      if(vector[i] < Menor){
        Menor = vector[i];
      }
    }
    return Menor;  
   }
  
  //Metodo de insertion sort
  public static double[] insertion_sort(double array[]){
        
        for(int i = 1 ; i < array.length ; i++){
            double aux = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > aux){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = aux;
        }
        return array;
    }      
  
   public static String imprimirMatriz(double[][] matriz){
       String men = "";
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                men += (matriz[i][j] + "\t"); // \t agrega una tabulación entre los elementos
            }
            men += "\n";
        }
        return men;
    }
 
   public static void MostrarYGuardar(PrintWriter archivo,String texto){
       System.out.println(texto);
       archivo.println(texto);
   }
  
   public static String Separador(String texto){
       return texto + "\n" +"==============";
   }
   
  public static void main(String[] args) throws IOException {
      PrintWriter file = new PrintWriter(new FileWriter("registro.txt",true));
 
      int CantidadMarcas = InputInt("Ingrese la cantidad de marcas");
      int CantidadCiudades = InputInt("Ingrese la cantidad de ciudades");

      //Vector que contiene el nombre de cada marca
      String NombresMarcas[] = new String[CantidadMarcas];
      
      //Rellenamos el vector
      for (int i = 0 ; i < CantidadMarcas ; i++){
          NombresMarcas[i] = InputString("Ingrese el nombre de la marca " + (i + 1));
      }

      //Vector que contiene los nombres de las ciudades
      String NombresCiudades[] = new String[CantidadCiudades];

      //Rellenamos el vector
      for(int i = 0 ; i < CantidadCiudades ; i++){
          NombresCiudades[i] = InputString("Ingrese el nombre de la ciudad " + (i+1));
      }

      //Matriz principal que contiene todos los datos 
      double Datos[][] = new double[CantidadMarcas][CantidadCiudades];
    
      //Matriz con los datos ordenados 
      double DatosOrdenados[][] = new double[CantidadMarcas][CantidadCiudades];              
      //Acumulados por marca y ciudad
      double AcumuladoPorMarca[] = new double[CantidadMarcas];
      double AcumuladoPorCiudad[] = new double[CantidadCiudades];
      
      //Promedios por mrcca y ciudad
      double PromedioPorMarca[] = new double[CantidadMarcas];
      double PromedioPorCiudad[] = new double[CantidadCiudades];
      
      //Mayor y menor por ciudad
      double MayorPorCiudad[] = new double[CantidadCiudades];
      double MenorPorCiudad[] = new double[CantidadCiudades];  

      int CantidadVentas = CantidadMarcas * CantidadCiudades;

      double TotalVentas = 0;

      //Cantidad de ventas mayores a 5 millones de cada ciudad
      int VentasMayorA5m[] = new int[CantidadCiudades];

      for (int i = 0 ; i < CantidadMarcas ; i++){
          for (int j = 0 ; j < CantidadCiudades ; j++){
              Datos[i][j] = InputDouble("Ingrese las ventas de " + NombresMarcas[i] + " en " + NombresCiudades[j]);
              TotalVentas += Datos[i][j];
          }
      }
      double PromedioTotal = TotalVentas / CantidadVentas;
      
      
      //Procedimientos
      for (int i = 0 ; i < CantidadMarcas ; i++){
          double AcumuladoMarca = 0;      
        
          //Recorremos la columna
          for (int j = 0 ; j < CantidadCiudades ; j++){
              AcumuladoMarca += Datos[i][j];
              AcumuladoPorCiudad[j] += Datos[i][j];
              
          }
          AcumuladoPorMarca[i] = AcumuladoMarca;
          
      }
      for(int j = 0 ; j < CantidadCiudades ; j++){
          double VentasCiudad[] = new double[CantidadMarcas];
          for(int i = 0 ; i < CantidadMarcas ; i++){
              VentasCiudad[i] = Datos[i][j];
          }
          MayorPorCiudad[j] = ObtenerMayor(VentasCiudad);
          MenorPorCiudad[j] = ObtenerMenor(VentasCiudad);
      }

      
      //En este ciclo hallamos los promedios por ciudad
      for(int i=0 ; i < CantidadCiudades ; i++){
          PromedioPorCiudad[i] = AcumuladoPorCiudad[i] / CantidadMarcas; 
      }
      //En este ciclo hallamos los promedios por marca
      for(int i=0 ; i < CantidadMarcas ; i++){
          PromedioPorMarca[i] = AcumuladoPorMarca[i] / CantidadCiudades; 
      }
      //Hallamos la cantidad de ciudades que tienen ventas mayor a 5 millones
      for(int i = 0; i < CantidadMarcas ; i++){
          for(int j = 0 ; j < CantidadCiudades ; j++){
              
              if(Datos[i][j] >= 5000000){
                  VentasMayorA5m[j] ++;
              }
          } 
      }
      
      //Ordenamiento de las ventas
      for(int i = 0 ; i < CantidadMarcas ; i++){
          double VectorAuxiliar[] = new double[CantidadCiudades];
          for(int j = 0 ; j < CantidadCiudades ; j++){
              VectorAuxiliar[j] = Datos[i][j];
          }
          VectorAuxiliar = insertion_sort(VectorAuxiliar);
          for(int j = 0 ; j < CantidadMarcas ; j++){
              DatosOrdenados[i][j] = VectorAuxiliar[j];
          }
      }
      
      //Hallamos las ventas en dolares y euros
      //Tasa de conversion de peso a dolar : 1 dolar = 4215.50 pesos
      double TotalVentasDolares = TotalVentas/4215.50;
      //Tasa de conversion de peso a euro : 1 euro = 4495.83 pesos
      double TotalVentasEuros = TotalVentas/4495.83;
      
      //Mostrar los resultados
      MostrarYGuardar(file, Separador("Cantidad de marcas: " + CantidadMarcas));
      MostrarYGuardar(file, "Nombre de las marcas y acumulado total");
      for(int i = 0 ; i < CantidadMarcas ; i++){
          MostrarYGuardar(file, NombresMarcas[i] + " - " + AcumuladoPorMarca[i]);
      }
      MostrarYGuardar(file,"=============");
      //---------
      
      MostrarYGuardar(file, Separador("Cantidad de ciudades: " + CantidadCiudades));
      MostrarYGuardar(file,"Nombre de las ciudades y acumulado total");
      for(int i = 0 ; i < CantidadCiudades ; i++){
          MostrarYGuardar(file, NombresCiudades[i] + " - " + AcumuladoPorCiudad[i]);
      }
      
      MostrarYGuardar(file, Separador("Matriz con los datos recogidos"));
      MostrarYGuardar(file,Separador(imprimirMatriz(Datos)));
      
      MostrarYGuardar(file,Separador("Mayor y menor por tienda"));
      for(int i = 0 ; i < CantidadCiudades ; i++){
          MostrarYGuardar(file,"La venta mas alta de la tienda de " + NombresCiudades[i] + " Fue de " + MayorPorCiudad[i]);
          MostrarYGuardar(file,Separador("La venta mas baja de la tienda de " + NombresCiudades[i] + " Fue de " + MenorPorCiudad[i]));
          
      }
      MostrarYGuardar(file,Separador("Total de ventas en pesos: " + TotalVentas));
      MostrarYGuardar(file,Separador("Total de ventas en dolares: " + TotalVentasDolares));
      MostrarYGuardar(file,Separador("Total de ventas en euros: " + TotalVentasEuros));
      
      MostrarYGuardar(file,Separador("Cantidad de ventas mayores a 5000000"));
      int CantidadMayorA5m = 0;
      for(int i = 0 ; i < CantidadCiudades ; i++){
          MostrarYGuardar(file,"La cantidad de ventas mayores a 5000000 de la tienda de " + NombresCiudades[i] + " es de " + VentasMayorA5m[i]);
          CantidadMayorA5m+= VentasMayorA5m[i];
      }
      MostrarYGuardar(file, Separador("Las ventas mayores a 5000000 en total fueron " + CantidadMayorA5m));
      MostrarYGuardar(file,"=============");
      
      MostrarYGuardar(file, Separador("Promedio de ventas por ciudad"));
      for(int i = 0 ; i < CantidadCiudades ; i++){
          MostrarYGuardar(file,"El promedio de ventas en " + NombresCiudades[i] + " es de " +PromedioPorCiudad[i]);
      }
      MostrarYGuardar(file,"=============");
      for(int i = 0 ; i < CantidadMarcas ; i++){
          MostrarYGuardar(file,"El promedio de ventas de " + NombresMarcas[i] + " es de " +PromedioPorMarca[i]);
      }
      MostrarYGuardar(file,"=============");
      
      MostrarYGuardar(file, Separador("Matriz con las ventas por mes ordenadas de menor a mayor"));
      MostrarYGuardar(file,Separador(imprimirMatriz(DatosOrdenados)));
      
      MostrarYGuardar(file, Separador("El promedio total es de " + PromedioTotal));
      
      file.close();
  }   
}
