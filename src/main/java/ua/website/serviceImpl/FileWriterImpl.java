package ua.website.serviceImpl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.website.service.FileWriter;
import ua.website.util.Engine;

/**
 * Service that is responsible for saving pictures from client
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.service.FileWriter
 */
@Service
public class FileWriterImpl implements FileWriter {

	/**
	 * Saves picture that came from client
	 * @param folder folder to save picture
	 * @param file file you want to save
	 * @param id id of picture
	 * @return
	 */

	@Override
	public boolean write(Folder folder, MultipartFile file, int id) {
		if(file!=null&&!file.isEmpty()){
			File pathToHome = new File(System.getProperty("catalina.home"));
			File pathToFolder = new File(pathToHome, "images" + File.separator + folder.name().toLowerCase());
			if(!pathToFolder.exists()){
				pathToFolder.mkdirs();
			}
			try {
				InputStream in = new ByteArrayInputStream(file.getBytes());
				BufferedImage old = ImageIO.read(in);
				Engine engine = new Engine(old);
				BufferedImage present = engine.crop();
				File pathToFile = new File(pathToFolder, String.valueOf(id)+".jpg");
				ImageIO.write(present, "jpg", pathToFile);
				return true;
			} catch (IOException e) {}
		}
		return false;
	}

}
