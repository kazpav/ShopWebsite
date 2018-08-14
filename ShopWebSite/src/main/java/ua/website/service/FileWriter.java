package ua.website.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Service interface that is responsible for saving pictures from client
 * @author Pavel Kazarin
 * @version 1.0
 * @see ua.website.serviceImpl.FileWriterImpl
 */
public interface FileWriter {

	enum Folder{
		COMMODITY
	}

	/**
	 * Saves picture that came from client
	 * @param folder folder to save picture
	 * @param file file you want to save
	 * @param id id of picture
	 * @return
	 */
	boolean write(Folder folder, MultipartFile file, int id);

}
