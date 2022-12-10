package ex2p1_gabrielzelaya;
import java.util.ArrayList;

public class Granja {
    String nombre;
    ArrayList<Vaca> listaVacas = new ArrayList<>();
    ArrayList<Conejo> listaConejos = new ArrayList<>();
    ArrayList<Vegetales> listaVegetales = new ArrayList<>();
    int dinero = 500;

    public Granja(String nombre) {
        this.nombre = nombre;
        listaVacas = new ArrayList<>();
        listaConejos = new ArrayList<>();
        listaVegetales = new ArrayList<>();
    }
    
    public static void printGranja(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    
    public void addVegetales(Vegetales vegetal){
        listaVegetales.add(vegetal);
    }
    
    public void addConejos(Conejo conejos){
        listaConejos.add(conejos);
    }
    
    public void addVacas(Vaca vacas){
        listaVacas.add(vacas);
    }
    
}
