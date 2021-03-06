package main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmException;

import corpus.Bigrams;
import jdk.nashorn.internal.ir.annotations.Ignore;



public class XMLUtilsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Ignore
    public void testGetLangueList() {
        Map<String, Bigrams> langue = XMLUtils.getLangueList();
        System.out.println(langue);
    }
    
    @Ignore
    public void testAddLangue() {
        XMLUtils.addLangue("Frence", "hempdf");
        Map<String, Map<String, Long>> langue = XMLUtils.getLangueList();
        System.out.println(langue);
    }

    @Ignore
    public void testRemoveLangue() {
        System.out.println("Test remove langue");
        XMLUtils.addLangue("Frence", "hempdf");
        XMLUtils.removeLangue("Frence");
        Map<String, Map<String, Long>> langue = XMLUtils.getLangueList();
        System.out.println(langue);
    }
    
    @Ignore
    public void testAddCorpus() {
        XMLUtils.addCorpus("FRANCE", "res/corpus/ALLEMAND/example2.txt");
        Map<String, Map<String, Long>> langue = XMLUtils.getLangueList();
        System.out.println(langue);
    }
    
    @Ignore
    public void testremoveCorpus(){
        XMLUtils.addCorpus("Frence", "res/corpus/ALLEMAND/example2.txt");
        XMLUtils.removeCorpus("res/corpus/ALLEMAND/example2.txt");
        
    }
    
    @Ignore
    public void testDetectEncoding() throws EncodingAlgorithmException, FileNotFoundException, IOException{
        File file = new File("res/corpus/CHINOIS/1044.txt");
        String encoding_name = XMLUtils.detectEncoding(file);
        System.out.println(encoding_name);
        System.out.println(System.getProperty("file.encoding"));  
    }
    

}
