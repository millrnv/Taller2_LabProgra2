package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaMenuBienvenida extends Ventana{
    public static void main(String[] args) {
        VentanaMenuBienvenida ventana = new VentanaMenuBienvenida();
    }

    private JLabel textoMenu, textoBienvenida;
    private JButton crearNuevaEleccion, registrarCandidato, registrarVotante, votar, resultados, salir;

    public VentanaMenuBienvenida() {
        super("Elecciones transparentes", 500, 520);
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonCrearEleccion();
        generarBotonRegistrarCandidato();
        generarBotonRegistrarVotante();
        generarBotonVotar();
        generarBotonResultados();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Elecciones transparentes";
        super.generarJLabelEncabezado(textoMenu, textoBienvenida, 150, 10, 300, 50);
    }

    private void generarBotonCrearEleccion() {
        crearNuevaEleccion = super.generarBoton("Crear Elección", 150, 70, 200, 40);
        crearNuevaEleccion.addActionListener(this);
        this.add(crearNuevaEleccion);
    }

    private void generarBotonRegistrarCandidato() {
        registrarCandidato = super.generarBoton("Registrar Candidato", 150, 120, 200, 40);
        registrarCandidato.addActionListener(this);
        this.add(registrarCandidato);
    }

    private void generarBotonRegistrarVotante() {
        registrarVotante = super.generarBoton("Registrar Votante", 150, 170, 200, 40);
        registrarVotante.addActionListener(this);
        this.add(registrarVotante);
    }

    private void generarBotonVotar() {
        votar = super.generarBoton("Votar", 150, 220, 200, 40);
        votar.addActionListener(this);
        this.add(votar);
    }

    private void generarBotonResultados() {
        resultados = super.generarBoton("Resultados", 150, 270, 200, 40);
        resultados.addActionListener(this);
        this.add(resultados);
    }

    private void generarBotonSalir() {
        salir = super.generarBoton("Salir", 150, 380, 200, 40);
        salir.addActionListener(this);
        this.add(salir);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == crearNuevaEleccion) {
            VentanaRegistrarEleccion ventanaEleccion = new VentanaRegistrarEleccion();
        } else if (e.getSource() == registrarCandidato) {
            VentanaRegistrarCandidato ventanaRegistrarCandidato = new VentanaRegistrarCandidato();
        } else if (e.getSource() == registrarVotante) {
            VentanaRegistrarVotante ventanaRegistrarVotante = new VentanaRegistrarVotante();
        } else if (e.getSource() == votar) {
            VentanaParaVotar ventanaVotar = new VentanaParaVotar();
        } else if (e.getSource() == salir) {
            System.exit(0);
        }
    }

}
