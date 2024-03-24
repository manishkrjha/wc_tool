package com.cli.wctool.commandHandler;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class FileHandler {

    public long getFileBytes(String filePath){
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            long totalBytes = 0;
            while(file.read()!=-1){
                totalBytes++;
            }
            file.close();
            return totalBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getLineCount(String filePath){
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));

            long totalLines = 0;
            String currentLine;
            while((currentLine = file.readLine())!= null){
                totalLines++;
            }

            file.close();
            return totalLines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long getWordCount(String filePath){
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));

            long totalNoOfWords = 0;
            String newLine;

            while ((newLine = file.readLine())!=null){
                String[] totalWords = newLine.split(" ");
                totalNoOfWords += totalWords.length;
            }

            file.close();
            return totalNoOfWords;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
