package com.open.capacity.security.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.open.capacity.security.model.FileInfo;

public interface FileService {

	FileInfo save(MultipartFile file) throws IOException;

	void delete(String id);

}
