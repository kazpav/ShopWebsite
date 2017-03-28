package ua.website.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder{
		COMMODITY
	}
	
	boolean write(Folder folder, MultipartFile file, int id);

}
