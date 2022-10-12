/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package sieteymedio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;

/**
 *
 * @author mafer
 */
public class FXMLDocumentController implements Initializable {

    private int jugadores = 2;
    private SieteyMedio juego;
    @FXML
    private MenuBar Menuitem;
    @FXML
    private Menu ItemMenuFichero;
    @FXML
    private MenuItem MenuIitemIniciar;
    @FXML
    private MenuItem MenuIitemTerminar;
    @FXML
    private MenuItem MenuIitemCerrar;
    @FXML
    private Menu ItemConfiguracion;
    @FXML
    private Label LabelJugador1;
    @FXML
    private Button BotonPedirCartas;
    @FXML
    private Button BotonPlantearse1;
    @FXML
    private Label BotonPuntos1;
    @FXML
    private TextArea TextAreaJugador1;
    @FXML
    private Button BotonPedirCartas2;
    @FXML
    private Button BotonPlantearse2;
    @FXML
    private Label BotonPuntos2;
    @FXML
    private TextArea TextAreaJugador2;
    @FXML
    private Button BotonPedirCartas3;
    @FXML
    private Button BotonPlantearse3;
    @FXML
    private Label BotonPuntos3;
    @FXML
    private TextArea TextAreaJugador3;
    @FXML
    private Label LabelJugador1111;
    @FXML
    private Button BotonPedirCartas4;
    @FXML
    private Button BotonPlantearse4;
    @FXML
    private Label BotonPuntos4;
    @FXML
    private TextArea TextAreaJugador4;

    private Button[]btnpedir;
    private Button[]btnplantarse;
    private Label[] puntos;
    private TextArea[] txtareajugador;
    @FXML
    private RadioMenuItem MenuIitemJugadorTres;
    @FXML
    private RadioMenuItem MenuIitemJugadorCuatro;
    @FXML
    private Label LabelJugadores;
    private RadioMenuItem MenuIitemJugadorD;
    @FXML
    private RadioMenuItem MenuIitemJugadorDos;
    
    
    
    @FXML
    private void TomarPedirCartas(ActionEvent event) {
        Object o = event.getSource();
        String txt;
        
        for (int i = 0; i < 4; i++) {
            if (o.equals(this.btnpedir[i])) {
                juego.juega(i);
                this.txtareajugador[i].setText(juego.getCartas(i));
                this.puntos[i].setText(Double.toString(juego.getPuntos(i)));
                
                if(juego.fin()){
                    this.deshabilitarJugadores();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Siete y Media");
                    if(juego.hayEmpate())
                        txt = "EMPATE";
                    else
                        txt = "Ganador:"+juego.getNombre(juego);
                    alert.setContentText("Fin del juego"+txt);
                    alert.showAndWait();                
                    
                    this.MenuIitemIniciar.setDisable(false);
        this.MenuIitemTerminar.setDisable(true);
        this.ItemConfiguracion.setDisable(true);
                }else{
                    this.habilitarJugador(juego.obtenerTurno());
                
                }
                break;
            }
        }
    }
        

    @FXML
    private void TomarPlantearse(ActionEvent event) {
        Object o = event.getSource();
        String txt;
        
        for(int i =0;i<jugadores;i++){
            if(o.equals(this.btnplantarse[i])){
                juego.sePlanta(i);
            }
            
            if (juego.fin()) {;
                this.deshabilitarJugadores();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Siete y Media");
                if(juego.hayEmpate())
                    txt = "EMPATE";
                else
                    txt = "Ganador" + juego.getNombre(juego);
                alert.setContentText("Fin del juego"+txt);
                alert.showAndWait();
                
                this.MenuIitemIniciar.setDisable(false);
             this.MenuIitemTerminar.setDisable(true);
             this.MenuIitemTerminar.setDisable(false);
            }else{
                this.HabilitarJugadores(juego.obtenerTurno());
            
            }
            break;
        }
    }
    
    private void habilitarJugador(int jugador){
        for(int j =0; j<4;j++){
            if(jugador==j){
                this.btnpedir[j].setDisable(false);
                this.btnplantarse[j].setDisable(false);
            }else{
                this.btnpedir[j].setDisable(true);
                this.btnplantarse[j].setDisable(true);
            }
        }
    }
    
    private void deshabilitarJugadores(){
        for(int j =0; j<4;j++){
            this.btnpedir[j].setDisable(false);
            this.btnplantarse[j].setDisable(false);
        }
    }
    
    private void limpiarMesa(){
        for(int j =0; j<4;j++){
            this.puntos[j].setText("0");
            //this.TextAreaJugador1[j].setText("");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.MenuIitemIniciar.setDisable(false);
        this.MenuIitemTerminar.setDisable(true);
        this.ItemConfiguracion.setDisable(false);

        jugadores =2;
        this.deshabilitarJugadores();
        this.InicializarArray();
    }    
    
    private void InicializarArray(){
        
        puntos = new Label[4];
        puntos[0] = BotonPuntos1;
        puntos[1] = BotonPuntos2;
        puntos[2] = BotonPuntos3;
        puntos[3] = BotonPuntos4;

        btnpedir = new Button[4];
        btnpedir[0] = BotonPedirCartas;
        btnpedir[1] = BotonPedirCartas2;
        btnpedir[2] = BotonPedirCartas3;
        btnpedir[3] = BotonPedirCartas4;

        txtareajugador = new TextArea[4];
        txtareajugador[0] = TextAreaJugador1;
        txtareajugador[1] = TextAreaJugador2;
        txtareajugador[2] = TextAreaJugador3;
        txtareajugador[3] = TextAreaJugador4;
    }
    
    @FXML
    private void IniciarPartida(ActionEvent event) {
        this.MenuIitemIniciar.setDisable(true);
        this.MenuIitemTerminar.setDisable(false);
        this.ItemConfiguracion.setDisable(true);
        juego = new SieteyMedio(jugadores);
        this.limpiarMesa();
        this.HabilitarJugadores(0);
    }

    @FXML
    private void TerminarPartida(ActionEvent event) {
        this.MenuIitemIniciar.setDisable(false);
        this.MenuIitemTerminar.setDisable(true);
        this.MenuIitemTerminar.setDisable(false);
        
        this.deshabilitarJugadores();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Siete y Media");
        alert.setContentText("Fin del juego");
        alert.showAndWait();
    }

    @FXML
    private void CerrarPartida(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void Tomarelmenufichero(ActionEvent event) {
    }

    @FXML
    private void TomarJugadores(ActionEvent event) {
        
        if (this.MenuIitemJugadorDos.isSelected()) {
            this.jugadores=3;            
        }
        if (this.MenuIitemJugadorTres.isSelected()) {
            this.jugadores=3;            
        }
        if (this.MenuIitemJugadorCuatro.isSelected()) {
            this.jugadores=4;            
        }
        this.LabelJugadores.setText(Integer.toString(jugadores));
    }

    @FXML
    private void TomarConfiguracion(ActionEvent event) {
    }
    
    private void HabilitarJugadores(int jugador) {
        for (int j = 0; j < 4; j++) {
            if (jugador == j) {
                this.btnpedir[j].setDisable(false);
                this.btnplantarse[j].setDisable(false);
            } else {
                this.btnpedir[j].setDisable(true);
                this.btnplantarse[j].setDisable(true);
            }
        }
    }
}
