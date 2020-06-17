/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototypepts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ordinateur
 */
public class PrototypePTS extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*
        //MENU PRINCIPALE 
        
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 450, 450);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(70)); // position vertical 
        grid.setHgap(80); // position horizontal de la zone de texte
        grid.setVgap(8);
        //ColumnConstraints column1 = new ColumnConstraints(100);
        //ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        //column2.setHgrow(Priority.ALWAYS);
        //grid.getColumnConstraints().addAll(column1, column2);
        
        //joueur 1
        
        Label labelName = new Label("joueur 1 :");
        TextField tfName = new TextField ();
        Text tDisplayName = new Text();
        //Gestion postionnement et ajout du label
        GridPane.setHalignment(labelName, HPos.LEFT);
        grid.add(labelName, 0, 7);
        //Gestion et positionnement de la zone de texte
        GridPane.setHalignment(tfName, HPos.LEFT);
        grid.add(tfName, 1, 7);
        joueur person = new joueur();
        tfName.textProperty().bindBidirectional(person.getPseudo());
        tDisplayName.textProperty().bind(person.getPseudo());
        
        //Gestion et positionnement résultat nom
        GridPane.setHalignment(tDisplayName, HPos.RIGHT);
        grid.add(tDisplayName, 0, 23); 
        
        //joueur2
        
        Label labelFirstName = new Label("joueur 2 :");
        TextField tfFistName = new TextField ();
        Text tDisplayFirstName = new Text();
        //Gestion postionnement et ajout du label
        GridPane.setHalignment(labelFirstName, HPos.RIGHT);
        grid.add(labelFirstName, 0, 11);
        //Gestion et positionnement de la zone de texte
        GridPane.setHalignment(tfFistName, HPos.LEFT);
        grid.add(tfFistName, 1, 11);
        joueur person1 = new joueur();
        tfFistName.textProperty().bindBidirectional(person1.getPseudo());
        tDisplayFirstName.textProperty().bind(person1.getPseudo());
        
        //Gestion et positionnement résultat prénom
        GridPane.setHalignment(tDisplayFirstName, HPos.RIGHT);
        grid.add(tDisplayFirstName, 0, 25); 
        
        Label labelVS = new Label("VS");
        GridPane.setHalignment(labelVS, HPos.LEFT);
        grid.add(labelVS, 1, 9);
        Label equiperouge = new Label("sera l'équipe rouge !");
        Label equipebleue = new Label("sera l'équipe bleue !");
        GridPane.setHalignment(equiperouge, HPos.LEFT);
        grid.add(equiperouge, 1, 23);
        GridPane.setHalignment(equipebleue, HPos.LEFT);
        grid.add(equipebleue, 1, 25);
        Label titre = new Label("ADVANCE WARS");
        GridPane.setHalignment(titre, HPos.LEFT);
        grid.add(titre, 1, 0);
        
        Button btn = new Button();
        btn.setText("START");
        GridPane.setHalignment(btn, HPos.CENTER);
        grid.add(btn, 0, 17);
        Button but = new Button();
        but.setText("règle de jeu");
        GridPane.setHalignment(but, HPos.CENTER);
        grid.add(but, 1, 17);
        Button button = new Button();
        button.setText("score");
        GridPane.setHalignment(button, HPos.CENTER);
        grid.add(button, 1, 18);
        Button bot = new Button();
        bot.setText("quitter");
        GridPane.setHalignment(bot, HPos.CENTER);
        grid.add(bot, 0, 18);
        
        root.setCenter(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        
        
        
        
        
        //MENU IN-GAME
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 450, 450);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(70)); // position vertical 
        grid.setHgap(80); // position horizontal de la zone de texte
        grid.setVgap(8);
        //ColumnConstraints column1 = new ColumnConstraints(100);
        //ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
        //column2.setHgrow(Priority.ALWAYS);
        //grid.getColumnConstraints().addAll(column1, column2);
        
         
        
        Label titre = new Label("PAUSE");
        GridPane.setHalignment(titre, HPos.CENTER);
        grid.add(titre, 1, 0);
        
        Button btn = new Button();
        btn.setText("REPRENDRE PARTIE");
        GridPane.setHalignment(btn, HPos.CENTER);
        grid.add(btn, 1, 13);
        Button but = new Button();
        but.setText("QUITTER PARTIE");
        GridPane.setHalignment(but, HPos.CENTER);
        grid.add(but, 1, 18);
        
        
        root.setCenter(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
