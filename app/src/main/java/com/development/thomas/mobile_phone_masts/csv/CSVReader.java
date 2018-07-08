package com.development.thomas.mobile_phone_masts.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

            ArrayList<String> rowsSplitByApostrophe;

            ArrayList<String> row = new ArrayList<>();

            // Check for columns that should contain a comma
            if (line.contains("\"")) {
                rowsSplitByApostrophe =  new ArrayList<>(Arrays.asList(line.split("\"")));

                for (int i = 0; i < rowsSplitByApostrophe.size(); i++) {
                    String rowSplitByApostrophe = rowsSplitByApostrophe.get(i);

                    if (i + 1 < rowsSplitByApostrophe.size()
                            && rowsSplitByApostrophe.get(i + 1).startsWith(columnSplitBy)) {
                        // This column contained ", just need to add it
                        row.add(rowSplitByApostrophe);
                    } else {
                        // Column before was surronded by ", need to clean up leading ,
                        if (rowSplitByApostrophe.startsWith(columnSplitBy)) {
                            rowSplitByApostrophe = rowSplitByApostrophe.substring(1);
                        }
                        String[] splitString = rowSplitByApostrophe.split(columnSplitBy);
                        row.addAll(Arrays.asList(splitString));
                        int occurrencesOfComma = rowSplitByApostrophe.length() - rowSplitByApostrophe.replace(",", "").length();

                        // Columns with no data may get discarded by split, especially those before a column surronded by ". Check we have the expected number of columns
                        while (occurrencesOfComma > splitString.length) {
                            row.add("");
                            occurrencesOfComma = occurrencesOfComma -1;
                        }
                    }
                }

                rows.add(row.toArray(new String[row.size()]));
            } else {
                rows.add(line.split(columnSplitBy, -1));
            }
        }

        return rows;
    }

}
