package application;
	
import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

import com.pl.configuration.Config;
import com.pl.musicManager.management.Library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {        
		
		try {
        // Read file fxml and draw interface.
        Parent root = FXMLLoader.load(getClass()
                .getResource("/view/MainScene.fxml"));
        
        Font.loadFont(getClass().getResourceAsStream("/resources/font/Uniform-Rounded.ttf"), 14);
        //System.out.println(Font.getFontNames());
        
        final Scene scene = new Scene(root);
        primaryStage.setTitle("My Application");
        primaryStage.setScene(scene);
        primaryStage.show();
     
    } catch(Exception e) {
        e.printStackTrace();
    }
}
	
	public static void main(String[] args) {
		//launch(args);
//		List<Song> songs = new LinkedList<>();
//		Duration length = Duration.between(Instant.EPOCH, Instant.now());
//		
//		Explorer explorer = new Explorer("C:/Users/Błażej/Desktop/test");
//		explorer.exploreDirectories(".mp3");
//		for(File file : explorer.getFileList()) {
//			songs.add(new Song(null, null, null, length, 0, file.getAbsolutePath()));
//		};
		String[] directories = {"C:/Users/Błażej/Desktop/test"};
		String[] extensions = {".pdf", ".mp3", ".png"};
		Config config = new Config(directories, extensions);	
		Config.printConfig();
		Library library = new Library();
		library.writeToJSON();
	}
}
