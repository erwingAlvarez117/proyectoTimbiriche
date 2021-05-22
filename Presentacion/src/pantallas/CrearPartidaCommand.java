/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import java.util.ArrayList;
import java.util.List;
import timbiriche.Cliente;
import timbiriche.Jugador;

/**
 *
 * @author Erwing
 */
public class CrearPartidaCommand implements Command {
    private PaginaDeInicio pantalla;
    
    public CrearPartidaCommand(PaginaDeInicio pantalla) {
        this.pantalla = pantalla;
    }
    
    @Override
    public void execute() {        
        ((Jugador) pantalla.obtenerJugador()).setPreparado(false);
        int capacidadDePartida = pantalla.obtenerCapacidadDePartida();
        List<Cliente> listaDeJugadores = new ArrayList<>();
        if (capacidadDePartida > 0) {
            pantalla.obtenerFacadaControl().guardarPartida(pantalla.obtenerJugador(), capacidadDePartida);
            PantallaSalaDeEspera pantallaSalaDeEspera = PantallaSalaDeEspera.getInstacia(pantalla, true, pantalla.obtenerJugador(), listaDeJugadores, capacidadDePartida, pantalla.obtenerFacadaControl());
            pantalla.obtenerFacadaControl().unirseAPartida(pantalla.obtenerJugador(), pantalla.obtenerJugador().getIpCliente());
            pantallaSalaDeEspera.mostrarPantalla();
            if (listaDeJugadores.size() > 1) {

                FrameJuego frameJuego = new FrameJuego(listaDeJugadores, pantalla.obtenerJugador(), pantalla.obtenerFacadaControl());
                frameJuego.mostrarPantalla();
            }

        }
    }

}
