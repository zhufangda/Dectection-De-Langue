package main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;


import corpus.Propriete;
import testCorpus.TestSingleText;

public class DetectionPanel extends JPanel implements ActionListener {
    /**
     * 
     */
    private static final long serialVersionUID = 3734553252555241824L;

    
    
    private JTable table;
    private JButton analyzeButton;
    private JButton openButton;
    private JTextArea textArea;
    private JPanel panel;
    DetectionModel tableModel;
    
    TestSingleText tester;
    
    /**
     * Create the panel.
     */
    public DetectionPanel() {

        setLayout(new BorderLayout(0, 0));
        
        panel = new JPanel();
        add(panel,BorderLayout.PAGE_START);
        
        
        openButton = new JButton("Open File");
        panel.add(openButton);
        analyzeButton = new JButton("Analyze");
        panel.add(analyzeButton);
        
        analyzeButton.addActionListener(this);        
        openButton.addActionListener(this);

        textArea = new JTextArea();
        textArea.setLineWrap(true);    
        textArea.setWrapStyleWord(true);
        this.add(textArea,BorderLayout.CENTER);
        
        
        
        table = new JTable();
        table.setEnabled(false);
        tableModel = new DetectionModel();
        table.setModel(tableModel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setPreferredSize(new Dimension(3 * table.getRowHeight(),3 * table.getRowHeight()));
        add(scrollPane,BorderLayout.PAGE_END);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == openButton){
            openButtionAction();

        }else if(e.getSource() == analyzeButton){
            anaLyzeButtonAction();
        }
            
    }

    /**
     * 
     */
    private void anaLyzeButtonAction() {
       tableModel.update(textArea.getText());
        repaint();
        revalidate();
    }

    /**
     * Defined the action of open button
     */
    private void openButtionAction() {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(Propriete.PATH_TEXT));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
       

        int returnVal = chooser.showOpenDialog(this); //replace null with your swing container
        File file = null;
        if(returnVal == JFileChooser.APPROVE_OPTION)     
          file = chooser.getSelectedFile(); 
        if(file == null) return;
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            this.textArea.setText("");
            while(line != null){
                this.textArea.append(line + "\n");
                line = in.readLine();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

