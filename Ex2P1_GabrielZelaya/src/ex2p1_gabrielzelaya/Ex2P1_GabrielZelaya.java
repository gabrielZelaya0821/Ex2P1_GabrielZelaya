package ex2p1_gabrielzelaya;
import java.util.Scanner;
public class Ex2P1_GabrielZelaya {

    public static void play(){
        String nombre;
        Scanner entrada = new Scanner(System.in);
        int numDias = 1;
        boolean hayCosechas = false;
        
        System.out.println("Ingrese el nombre de su granja: ");
        nombre = entrada.nextLine();
        entrada = new Scanner(System.in);
        Granja granja = new Granja(nombre);
        int maxDias = 6;
        int diasCosechas = 5;
        System.out.println("Bienvenido a la granja: " + granja.getNombre());
        do {
            System.out.println("<---------- Dia: " + numDias + " ---------->");
            if (hayCosechas) {
                System.out.println("Faltan " + diasCosechas + " para que estén listas las cosechas");
            } else if (diasCosechas == 0 && hayCosechas){
                System.out.println("YA ESTÁN LISTAS LAS COSECHAS");
            } else {
                System.out.println("No hay cosechas");
            }
            System.out.println("¿Qúe desea hacer?");
            System.out.println("1.-Plantar Cosechas\n2.-Cosechar las cosechas\n3.-Conseguir animales\n4.-Vender cosas\n5.-Dormmir");
            int opcion = entrada.nextInt();
            int cosechas = 0;
            switch (opcion){
                case 1 -> {
                    System.out.println("¿Cuántas cosechas desea plantar?");
                    cosechas = entrada.nextInt();
                    System.out.println("PLANTANDO COSECHAS...");
                    System.out.println("Las cosechas tardarán 5 días en estar");
                    hayCosechas = true;
                }
                case 2 -> {
                    if(hayCosechas == false){
                        System.out.println("No hay cosechas por cosechar");
                    }else if (diasCosechas>0){
                        System.out.println("LAS COSECHAS NO ESTÁN LISTAS");
                    } else {
                        for (int i = cosechas; i > 0; i--) {
                            Vegetales vegetal = new Vegetales();
                            granja.addVegetales(vegetal);
                        }  
                        System.out.println("Se cosecharon exitosamente las cosechas");
                        hayCosechas = false;
                        diasCosechas = 5;
                    }
                    
                }
                case 3 -> {
                    System.out.println("Cantidad de dinero actual: " + granja.getDinero());
                    System.out.println("¿Qué animales desea?\n1.-Conejos -> 150 monets\n2.-Vacas -> 350 monets");
                    int animal = entrada.nextInt();
                    int costo = 0;
                    switch (animal){
                        case 1 -> {
                            System.out.println("¿Cuántos conejos desea?");
                            int cantidad = entrada.nextInt();
                            costo = cantidad * 150;
                            if (cantidad > 0 && costo <= granja.getDinero()){
                                System.out.println("Conejos comprados $$$");
                                for (int i = 0; i < cantidad; i++) {
                                    System.out.println("Ingrese el nombre de su nuevo conejo:");
                                    entrada = new Scanner(System.in);
                                    String nombreConejo = entrada.nextLine();
                                    Conejo conejo = new Conejo(nombreConejo);
                                    granja.addConejos(conejo);
                                    System.out.println(granja.listaConejos.get(0).getNombre() + " ha sido enviado(a) a la granja!");
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("¿Cuántas vacas desea?");
                            int cantidad = entrada.nextInt();
                            costo = cantidad * 350;
                            if (cantidad > 0 && costo <= granja.getDinero()){
                                System.out.println("Vacas compradas $$$");
                                for (int i = cantidad; i > 0; i--) {
                                    System.out.println("Ingrese el nombre de su nueva vaca:");
                                    entrada = new Scanner(System.in);
                                    String nombreVaca = entrada.nextLine();
                                    Vaca vaca = new Vaca(nombreVaca);
                                    granja.addVacas(vaca);
                                    System.out.println(granja.listaVacas.get(0).getNombre() + " ha sido enviado(a) a la granja!");
                                }
                            }
                        }
                        default -> {
                            System.out.println("Número no es válido");
                        }
                    }
                    if (costo > granja.getDinero()) {
                        System.out.println("ERES DEMASIADO POBRE PARA COMPRAR");
                    } else { 
                        int nuevoDinero = granja.getDinero() - costo;
                        granja.setDinero(nuevoDinero);
                    }
                    System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
                }
                case 4 -> {
                    System.out.println("¿Qué deseas vender?");
                    System.out.println("----------ANÁLISIS DE LA GRANJA----------");
                    System.out.println("Tienes " + granja.listaVegetales.size() + " vegetales");
                    System.out.println("Tienes " + granja.listaVacas.size() + " vacas") ;
                    System.out.println("Tienes " + granja.listaConejos.size() + " conejos");
                    System.out.println("Tines " + granja.getDinero() + " monets");
                    System.out.println("----------------------------------------");
                    System.out.println("Selecciona:\n1.-Vegetales\n2.-Conejos\n3.-Vacas");
                    int seleccion = entrada.nextInt();
                    switch (seleccion){
                        case 1 -> {
                            System.out.println("La cantidad de vegetales es: " + granja.listaVegetales.size());
                            System.out.println("Ingrese la cantidad a vender: ");
                            int vender = entrada.nextInt();
                            for (int i = 0; i < vender; i++) {
                                granja.listaVegetales.remove(0);
                            }
                            System.out.println("Se han vendido " + vender + " vegetales");
                            int precioVegetales = 100;
                            System.out.println("Su dinero es: " + granja.getDinero()+precioVegetales*vender);
                    }
                        case 2 -> {
                            System.out.println("La cantidad de conejos es: " + granja.listaConejos.size());
                            System.out.println("Ingrese la cantidad a vender: ");
                        int vender = entrada.nextInt();
                        for (int i = 0; i < vender; i++) {
                            granja.listaConejos.remove(0);
                        }
                        System.out.println("Bye bye " + granja.listaConejos.get(0).getNombre());
                        System.out.println("Se han vendido " + vender + " conejos");
                        int precioConejos = 170;
                        System.out.println("Su dinero es: " + granja.getDinero()+precioConejos*vender);
                    }
                        case 3 -> {
                            System.out.println("La cantidad de vacas es: " + granja.listaVacas.size());
                            System.out.println("Ingrese la cantidad a vender: ");
                        int vender = entrada.nextInt();
                        for (int i = 0; i < vender; i++) {
                            granja.listaVacas.remove(0);
                        }
                        System.out.println("Bye bye " + granja.listaVacas.get(0).getNombre());
                        System.out.println("Se han vendido " + vender + " vacas");
                        int precioVacas = 400;
                        System.out.println("Su dinero es: " + granja.getDinero()+precioVacas*vender);
                    }
                        default -> System.out.println("Número no es válido");
                    }
  
                }
                case 5 -> {
                    System.out.println("Durmiendo...");
                    System.out.println("ZzZzZzZzZzZz");
                }
                default -> {
                    System.out.println("Número no es válido");
                }
            }
            diasCosechas--;
            numDias++;
            maxDias--;
            System.out.println("<---------- Fin del día ---------->");    
        } while (maxDias>0);
        System.out.println("\n\n\n\nDespués del día " + maxDias + " el dueño de la granja fue asesinado por una de las granjas rivales que competian por ser la más grande del país");
        System.out.println("\nFIN");    
    }

    public static void main(String[] args) {
        play();
    }
    
}
