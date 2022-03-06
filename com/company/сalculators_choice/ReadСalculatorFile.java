package com.company.сalculators_choice;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

/**
 * Предназначен для модуля FileCalculator в методе file_calculator
 */

public class ReadСalculatorFile {

    private StringBuilder file_text;
    public String give_file_text(){
        return file_text.toString();
    }

    public void reading(java.util.Scanner scanner_files_names){

        file_text=new StringBuilder();
        BufferedReader EMPTY_READ=null;
        BufferedReader read=EMPTY_READ;
        String file_name=scanner_files_names.next();
        try{
            read = new BufferedReader(new FileReader(file_name));
        }
        catch (IOException e) {
            final String ERROR_NOT_FOUND="Error while reading file: " + e.getLocalizedMessage();
            System.err.println(ERROR_NOT_FOUND);
        }
        finally {
            if (EMPTY_READ != read)
            {
                try {
                    String string= read.readLine();

                    final char COMMENTS='#';
                    final Integer COMMENT_ELEMENT=0;

                    final String SPACE=" ";
                    final String STOP=null;

                    while (string != STOP) {
                        if(string.charAt(COMMENT_ELEMENT)!=COMMENTS)
                            file_text.append(string+SPACE);
                        string = read.readLine();
                    }
                    System.out.print(file_text.toString());
                }
                catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }

        }
    }
}
