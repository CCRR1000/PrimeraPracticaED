
package gestionApuestas;

/**
 *
 * @author CIROSS
 */
public class ControlApuestas {
    private static ListaApostadores apostadores = new ListaApostadores();
    private static ListaApostadores apuestasAprobadas = new ListaApostadores();
    private static ListaApostadores apuestasRechazadas = new ListaApostadores();

    private static int [] ordenCaballos = new int[10];
    
    public void ingresarApuesta(String[] datos) {
        
        int[] orden = new int[10];
               
        try {
            orden[0] = Integer.parseInt(datos [2].strip());
            orden[1] = Integer.parseInt(datos [3].strip());
            orden[2] = Integer.parseInt(datos [4].strip());
            orden[3] = Integer.parseInt(datos [5].strip());
            orden[4] = Integer.parseInt(datos [6].strip());
            orden[5] = Integer.parseInt(datos [7].strip());
            orden[6] = Integer.parseInt(datos [8].strip());
            orden[7] = Integer.parseInt(datos [9].strip());
            orden[8] = Integer.parseInt(datos[10].strip());
            orden[9] = Integer.parseInt(datos[11].strip());
            
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }    
        
        Participante participante = new Participante(datos[0].strip(), datos[1].strip(), orden);
        apostadores.agregar(participante);
        
    }
    
    public void verificacionLuis() {
        for (int i = 0; i < ordenCaballos.length; i++) {
            int ordenCaballo = ordenCaballos[i];
            
        }
    }
    
    public void verificarSimple() {
        
        Participante participante = apostadores.getRaiz();
        
        for (int i = 0; i < apostadores.getTotalParticipantes(); i++) {
            
            if (participante != null) {
                
                boolean aval = elementosRepetidos(participante.getOrden());
                
                if (aval) {
                    apuestasRechazadas.agregar(participante);
                } else {
                    apuestasAprobadas.agregar(participante);
                }
                
                participante = participante.getSiguiente();
                
            } else {
                break;
            }
        }
    }
    private static boolean elementosRepetidos(int[] as) {
        
        int ref;
        
        for (int i = 1; i < as.length; i++) {
            
            ref = i-1;
            
            while (ref>=0) {
                
                if (as[i]==as[ref]) {
                    return true;
                }
                
                ref--;
            }
        }
        return false;
    }
    
    public void verificarApuestas() {
        Participante participante = apostadores.getRaiz();
        int puntero = 0;
        verificarParticipante(participante, puntero);
    }
    
    public void verificarParticipante(Participante participante, int puntero) {
        int[] order = participante.getOrden();
        
        for (int i = 0; i < order.length; i++) {
            
        }
        
        verificarParticipante(participante.getSiguiente(),puntero);
    }

    public boolean verificar(int[] orden) {
        for (int i = 0; i < orden.length; i++) {
            if (orden[i]<1 && orden[i]>10) {
                
            } else {
                return false;
            }
        }
        return true;
    }
    
    
    public void ordenarPuntos() {
        
        Participante mayor = apuestasAprobadas.getRaiz();
        Participante menor = apuestasAprobadas.getUltimo();
        Participante puntero = apuestasAprobadas.getRaiz().getSiguiente();

        
        for (int i = 0; i < (apuestasAprobadas.getTotalParticipantes()-1); i++) {
    	    
            for (int j = 1; j < (apuestasAprobadas.getTotalParticipantes()-1); j++) {

                if (puntero.getPuntuacionFinal() > mayor.getPuntuacionFinal()) {
                    Participante aux = puntero.getSiguiente();
                    apuestasAprobadas.insertarAntes(puntero, mayor);
                    puntero = aux;
                    
                } else if (puntero.getPuntuacionFinal() < menor.getPuntuacionFinal()) {
                    Participante aux = puntero.getSiguiente();
                    apuestasAprobadas.insertarDespues(puntero, menor);
                    puntero = aux;
                    
                } else {
                    puntero = puntero.getSiguiente();
                }
            }
            
            mayor = mayor.getSiguiente();
            menor = menor.getAnterior();
            
    	}
    }
    
    public void calcularPuntos() {
        
        Participante part = apuestasAprobadas.getRaiz();     // 1
        
        for (int i = 0; i < 10; i++) {                       // 2n + 2 + n(21)   =>  1 + 23n + 2 => 23n + 3
            
            if (part.getOrden()[0] == ordenCaballos[0]) {    // 1
                part.sumarPuntos(10);                        // 1
            }
            
            if (part.getOrden()[1] == ordenCaballos[1]) {    // 1
                part.sumarPuntos(9);                         // 1
            }
            
            if (part.getOrden()[2] == ordenCaballos[2]) {    // 1
                part.sumarPuntos(8);                         // 1
            }
            
            if (part.getOrden()[3] == ordenCaballos[3]) {    // 1
                part.sumarPuntos(7);                         // 1
            }
            
            if (part.getOrden()[4] == ordenCaballos[4]) {    // 1
                part.sumarPuntos(6);                         // 1
            }
            
            if (part.getOrden()[5] == ordenCaballos[5]) {    // 1
                part.sumarPuntos(5);                         // 1
            }
            
            if (part.getOrden()[6] == ordenCaballos[6]) {    // 1
                part.sumarPuntos(4);                         // 1
            }
            
            if (part.getOrden()[7] == ordenCaballos[7]) {    // 1
                part.sumarPuntos(3);                         // 1
            }
            
            if (part.getOrden()[8] == ordenCaballos[8]) {    // 1
                part.sumarPuntos(2);                         // 1
            }
            
            if (part.getOrden()[9] == ordenCaballos[9]) {    // 1
                part.sumarPuntos(1);                         // 1
            }
            
            part = part.getSiguiente();                      // 1
        }
    }
    /**
     * 1 + 2n+2 + n( 2m+2 + m( 1 + 2 ) + 1 )
     * 3 + 2n + n( 2m + 2 + 3m + 1)
     * 3 + 2n + n( 5m + 3)
     * 3 + 2n + 5mn + 3n
     * 5n + 5mn + 3  -> m = 10
     * 5n + 50n + 3
     * 55n + 3
     * O(n)
     * 
     * @return 
     */
    public void calcularPuntos2() {
        
        Participante part = apuestasAprobadas.getRaiz();     // 1   => 1 + 2n+2 + n( 2m+2 + m( 1 + 2 ) + 1 )
        
        for (int i = 0; i < apuestasAprobadas.getTotalParticipantes(); i++) { // 1 + n+1 + n = 2n+2 + n( 
            
            for (int j = 0; j < ordenCaballos.length; j++) {       // 1 m+1 + m = 2m+2 + m (
                
                if (part.getOrden()[j] == ordenCaballos[j]) {      // 1
                    part.sumarPuntos(10-j);                        // 2
                }
            }
            
            part = part.getSiguiente();                             // 1
        }
    }
    
    private void comparar(Participante menor, Participante part2) {
        
        if (part2.getPuntuacionFinal() < menor.getPuntuacionFinal()) {
            menor = part2;
        } else {
            comparar(menor, part2.getSiguiente());
        }
    }
    
    private void cambiar(Participante part1, Participante part2) {
        
        Participante aux = part1;
        part1.setAnterior(part2.getAnterior());
        part1.setSiguiente(part2);
        part2.setAnterior(aux.getAnterior());
        part2.setSiguiente(aux.getSiguiente());
        
    }

    public int[] getOrdenCaballos() {
        return ordenCaballos;
    }

    public void setOrdenCaballos(int[] ordenCaballos) {
        this.ordenCaballos = ordenCaballos;
    }
    
    public ListaApostadores getApostadores() {
        return apostadores;
    }

    public ListaApostadores getApuestasAprobadas() {
        return apuestasAprobadas;
    }

    public ListaApostadores getApuestasRechazadas() {
        return apuestasRechazadas;
    }

    public void setApostadores(ListaApostadores apostadores) {
        this.apostadores = apostadores;
    }

    public void setApuestasAprobadas(ListaApostadores apuestasAprobadas) {
        this.apuestasAprobadas = apuestasAprobadas;
    }

    public void setApuestasRechazadas(ListaApostadores apuestasRechazadas) {
        this.apuestasRechazadas = apuestasRechazadas;
    }
    
    
}
