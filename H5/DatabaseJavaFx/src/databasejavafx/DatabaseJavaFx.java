/*
 * Eder Mazariegos
 * COP3330
 * Fall 2016
 */
package databasejavafx;

import dataModel.FilmDAO;
import inputOutput.ConnectionData;
import inputOutput.PostgreSQLConnect;
import inputOutput.XmlParser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author eder
 */
public class DatabaseJavaFx extends Application
{
    private static final Logger logger = Logger.getLogger(DatabaseJavaFx.class.getName());
    private ObservableList<FilmDAO> data = FXCollections.observableArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //calls the overridden method below
        launch(args);
    }
    
    @Override 
    public void start(Stage stage)
    {
        //set the table and not let it be changed
        
        //call make table constructor
        TableView tableView = new TableView();
        
        //set table properties
        //don't let user change it
        tableView.setEditable(false); 
        final Label label = new Label("Films");
        label.setFont(new Font("Calibri", 20));        
        
        //Make and set colums to display data
        //same idea as above
        
        //DAO = data access object   
        TableColumn title = new TableColumn("Title");
        title.setMinWidth(200);
        title.setCellValueFactory(new PropertyValueFactory<FilmDAO, String>("filmName"));
        
        TableColumn description = new TableColumn("Description");
        description.setMinWidth(700);
        description.setCellValueFactory(new PropertyValueFactory<FilmDAO, String>("filmDescription"));        
        
        TableColumn rate = new TableColumn("Rental Rate");
        rate.setMinWidth(100);
        rate.setCellValueFactory(new PropertyValueFactory<FilmDAO, Double>("filmPrice"));
        
        TableColumn rating = new TableColumn("Rental Rate");
        rating.setMinWidth(100);
        rating.setCellValueFactory(new PropertyValueFactory<FilmDAO, String>("filmRating"));
        
        //add columns to the view
        
        tableView.getColumns().addAll(title, description, rate, rating);
        //make a button
        final Button fetchData = new Button("Fetch films from database");
        
        //action listener
        
        fetchData.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle (ActionEvent event)
            {
                fetchData(tableView);
            }
        }    );
        
        //set the scene
        Scene scene = new Scene(new Group());
        
        //create the layout and dimensions
        final VBox vbox = new VBox();
        vbox.setPrefHeight(500);
        
        vbox.setStyle("-fx-background-color: cornsilk; -fx-padding: 50;");
        
        vbox.getChildren().addAll(label, tableView);
        
        //add to overall scene
        ((Group) scene.getRoot()).getChildren().addAll(vbox, fetchData);
        
        //setting it up
        stage.setTitle("Films for rent");
        
        //create
        stage.setScene(scene);
        
        //start the play
        stage.show();
                
    }
    
    private void fetchData(TableView tableView)
    {
        logger.info("Attempting to fetch data");
        //try to make a connection
        try (Connection con = getConnection())
        {
           tableView.setItems(fetchFilms(con)); 
        }
        // in case of failure log as severe
        catch (SQLException | ClassNotFoundException ex)
        {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException
    {
        //logging each step the application is making
        logger.info("Attempting to connect to database");
        
        //pass location of XML file and read the database properties (log in info)
        
        //just like in previous assignment 
        XmlParser xml = new XmlParser("inputOutput/properties.xml");
        ConnectionData data = xml.getConnectionData();
        
        PostgreSQLConnect connect = new PostgreSQLConnect(data);
        Connection dbConnect = connect.getConnection();
        
        return dbConnect;
        
    }
    
    private ObservableList<FilmDAO> fetchFilms(Connection con) throws SQLException
    {
        logger.info("Getting films from database");
        ObservableList<FilmDAO> films = FXCollections.observableArrayList();
        
        //SQL COMMAND/STATEMENT
        String select = "select title, rental_rate, rating, description " +
                "from film " + "order by title;"; //semicolon inside "" is to make sure it's a valid SQL statement
        
        //logging the command
        logger.info("Select statement " + select);
        
        Statement st = con.createStatement();
        
        //executes statement and saves whatever it gets back in rs
        ResultSet rs = st.executeQuery(select);
        
        while(rs.next())
        {
            //packaging the DAO together
            
            //info inside the "" is the name of the fields in the actual DB
            FilmDAO film = new FilmDAO();
            film.setFilmName(rs.getString("title"));
            film.setFilmRating(rs.getString("rating"));
            film.setFilmDescription(rs.getString("description"));
            film.setFilmPrice(rs.getDouble("rental_rate"));
            
            //add the whole package
            films.add(film);
        }
        
        logger.info("Found " + films.size() + " films");
        
        return films;
    }
}
 