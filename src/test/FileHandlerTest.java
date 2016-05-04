/**
 * This class does the JUit Testing to verify the logic
 * and functionality of the File Handler Class when
 * uploading and reading a file from the disk.
 *
 * @author Rudi André Dahle
 */

package test;

import org.junit.Before;
import org.junit.Test;
import sample.FileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileHandlerTest {


    /**
     * File Handler's constructor receives
     * no arguments
     */
    public FileHandlerTest(){

    }

    //Object and data field
    FileHandler fileHandler = new FileHandler();
    String rleCode;


    /**
     * The initial setup when uploading a file used to test
     * if the functionality works as it should.
     *
     * @author Rudi André Dahle
     * @throws Exception if an error occurs while testing
     */
    @Before
    public void setUp() throws Exception {
        File file = new File(System.getProperty("user.dir")+"/rle/glider.rle");

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        rleCode = "";

        while ((line = br.readLine()) != null) {
            if ((line.matches("[b, o, $, !, 0-9]*"))) {
                rleCode = rleCode.concat(line + "\n");
            }
        }
    }


    /**
     * Method called to test the logic of the function to
     * check if the file prints out the expected output.
     *
     * @author Rudi André Dahle
     * @throws Exception if an error occurs while testing
     */
    @Test
    public void testFromRleToSimplified() throws Exception {
        assertEquals("bob$bbo$ooo", fileHandler.fromRleToSimplified(rleCode));
    }
}