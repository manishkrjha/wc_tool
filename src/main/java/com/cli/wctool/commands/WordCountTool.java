package com.cli.wctool.commands;

import com.cli.wctool.commandHandler.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.io.File;

@Command(command = "ccwc")
public class WordCountTool {

    @Autowired
    public FileHandler fileHandler;

    String filePath = "C:\\Users\\ASUS\\Desktop\\Projects\\wc_tool\\wctool\\externalFiles\\defaultPath\\defaultFile.txt";

    @Command(command = " -c")
    public String getBytes(@Option(required = false) String filePath){
        if(filePath==null || filePath.isEmpty()){
            filePath = this.filePath;
        }

        long byteCount = fileHandler.getFileBytes(filePath);
        return "File: " + byteCount + " bytes.";
    }

    @Command(command = " -l")
    public String getNumberOfLines(@Option(required = false) String filePath){
        if(filePath==null || filePath.isEmpty()){
            filePath = this.filePath;
        }

        long numberOfLines = fileHandler.getLineCount(filePath);
        return "File: " + numberOfLines + " lines.";
    }

    @Command(command = " -w")
    public String getNumberOfWords(@Option(required = false) String filePath){
        if(filePath==null || filePath.isEmpty()){
            filePath = this.filePath;
        }

        long wordCount = fileHandler.getWordCount(filePath);
        return "File: " + wordCount +  " words";
    }

    @Command(command = " -m")
    public String getNumberOfCharacters(@Option(required = false) String filePath){
        if(filePath==null || filePath.isEmpty()){
            filePath = this.filePath;
        }

        long characterCount = fileHandler.getFileBytes(filePath);
        return "File: " + characterCount + " characters";
    }

    @Command(command = "")
    public String defaultHandler(@Option(required = false) String filePath){

        if(filePath==null || filePath.isEmpty()){
            filePath = this.filePath;
        }

        long byteCount = fileHandler.getFileBytes(filePath);
        long wordCount = fileHandler.getWordCount(filePath);
        long lineCount = fileHandler.getLineCount(filePath);
        return "File: " + byteCount + " " + wordCount + " " + lineCount;
    }
}
