package com.development.thomas.mobile_phone_masts.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

    /**
     * Reads a CSV file InputStream and returns a list of rows
     * @param inputStream   InputStream of the CSV file to read
     * @param skipFirstRow  Flag indicating if the first row (sometimes a header row) should be ignored
     * @param columnSplitBy String representing how each column is seperated in the CSV
     * @return List of rows
     * @throws IOException
     */
    public List<String[]> readCSV(InputStream inputStream,
                                  boolean skipFirstRow,
                                  String columnSplitBy) throws IOException {

        String line;
        List<String[]> rows = new ArrayList<>();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        if (skipFirstRow) {
            bufferedReader.readLine();
        }

        while((line = bufferedReader.readLine()) != null) {
            String[] row = line.split(columnSplitBy);
            rows.add(row);
        }

        return rows;
    }

}
