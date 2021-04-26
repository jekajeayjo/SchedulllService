package md.testsceduler.service.impl;

import javassist.NotFoundException;
import md.testsceduler.service.FileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {
    @Value("${file.path}")
    private String pathFile;
    final Logger logger = Logger.getLogger(FileServiceImpl.class);

    @Override
    public String readFile() {
        logger.info(" start read from file ");
        String st = "";
        try {
            File file = new File(pathFile);
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            st = buffer.lines().collect(Collectors.joining());
        } catch (Exception e) {
            logger.error("error read data from file");
        }

        return st;


    }
}
