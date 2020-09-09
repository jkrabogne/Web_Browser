/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web_browser;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Administrator
 */
public class Web_Browser extends Application {
    //Toolbar
    ToolBar tb = new ToolBar();
    Button b1 = new Button("Refresh");
    Button b2 = new Button ("Go");
    TextField tf1 = new TextField();
    
    //TabPane
    TabPane tp = new TabPane();
    Tab tab1 = new Tab("URL Address");
    
    WebView view = new WebView();
    WebEngine engine = view.getEngine();
    
    
    VBox v1 = new VBox();
    public void start(Stage primaryStage) {
        
        tf1.setPromptText("URL Address");
        tp.getTabs().add(tab1);
        
        
        tb.getItems().addAll(b1,tf1,b2);
        v1.getChildren().addAll(tb,tp);
        
        //Action to Browser
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String s = tf1.getText();
                engine.load("http://"+s);
                tab1.setText(s);
            }
        });
        
        //Action to Refresh
        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                engine.reload();
            }
        
        });
                
        
        tab1.setContent(view);
        
        try {
            Scene scene = new Scene (v1);
                primaryStage.setScene(scene);
                primaryStage.setMaximized(true);
            primaryStage.show();    
        
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments;
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
