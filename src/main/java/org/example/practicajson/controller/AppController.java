package org.example.practicajson.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.practicajson.clases.Pelicula;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AppController {
    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    @FXML
    public Button btnImportar;
    @FXML
    public TextField titulo;
    @FXML
    public TextField fecha;
    @FXML
    public TextField genero;
    @FXML
    public TextField director;
    @FXML
    public ListView lista;

    @FXML
    public void onBtnImportar(ActionEvent actionEvent) throws IOException {
        try {
            ArrayList<Pelicula> peliculas =
                    JSON_MAPPER.readValue(new File("src/main/resources/peliculas.json"),
                    JSON_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, Pelicula.class));
            lista.getItems().clear();
            lista.getItems().addAll(peliculas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void listaSeleccionar(MouseEvent mouseEvent) {
        Pelicula a = new Pelicula();
        a = (Pelicula) lista.getSelectionModel().getSelectedItem();
        titulo.setText(a.getTitulo());
        fecha.setText(a.getFecha());
        director.setText(a.getDirector());
        genero.setText(a.getGenero());
    }
}