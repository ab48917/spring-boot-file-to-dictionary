package com.example.filedemo.controller;

import com.example.filedemo.model.DBFile;
import com.example.filedemo.payload.UploadFileResponse;
import com.example.filedemo.service.ConvertFileToDictionary;
import com.example.filedemo.service.DBFileStorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/*
 * This is controller class which receives the request\files and stores to database for data validation and privacy process
 * This further calls the ConverFileToDictionary service layer and store words to different lists based on the starting alphaber
 * This is to avoid the huge data set and list is further divided to 26 parts based on alphabets type.
 * This can almost solve the medium range problem with O(n) insertion and O(n/26) retrieval
 * 
 */

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;
    
    private ConvertFileToDictionary fileToDictionary;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        DBFile dbFile = dbFileStorageService.storeFile(file);
        fileToDictionary.storeFileToDictionary(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

   
    @GetMapping("/search/{word}")
    public ResponseEntity<Boolean > serchAWord(@PathVariable String word) {
         Boolean flag = fileToDictionary.checkIfWordExists(word);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(flag);
  

    }

}
