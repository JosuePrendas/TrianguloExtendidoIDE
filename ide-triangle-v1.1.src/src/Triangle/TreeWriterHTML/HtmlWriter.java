package Triangle.TreeWriterHTML;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlWriter {
    private String fileName;
    private String htmlBuffer;
    private String htmlBufferComment;
    private String htmlSpaces;
    private int counter;
    private Boolean hasError = false;

    public HtmlWriter(String fileName) {
        this.fileName = fileName.replace(".tri", ".html");

        htmlBuffer = "";
        htmlSpaces = "";
        htmlBufferComment = "";
        counter = 0;
    }

    public void addHtmlReservedWord(StringBuffer currentSpelling) {
        htmlBuffer+="<FONT FACE= \"monospace\" SIZE =3 COLOR=#000000><strong>"+htmlSpaces+currentSpelling.toString()+"</strong></FONT>";
        htmlSpaces = "";
        counter++;

    }
    public void addHtmlIdentifier(StringBuffer currentSpelling, Boolean isReservedWord) {
        String token = currentSpelling.toString();
        if(isReservedWord) {
            addHtmlReservedWord(currentSpelling);
        }else {
            htmlBuffer+="<FONT FACE= \"monospace\" SIZE =3 COLOR=#000000>"+htmlSpaces+token+"</FONT>";
            htmlSpaces = "";
            counter++;
        }
    }

    //agrega texto con formato para las literales
    public void addHtmlLiteral(StringBuffer currentSpelling) {
        htmlBuffer+="<FONT FACE= \"monospace\" SIZE =3 COLOR=#000099>"+htmlSpaces+currentSpelling.toString()+"</FONT>";
        htmlSpaces = "";
        counter++;
    }
    public void addToHtmlComment(String newChar) {
        htmlBufferComment+=newChar;
    }
    //agrega texto con formato para las comentarios
    public void addHtmlComment() {
        htmlBuffer+="<FONT FACE= \"monospace\" SIZE =3 COLOR=#008000>"+htmlSpaces+htmlBufferComment+"</FONT>";
        htmlBufferComment = "";
        htmlSpaces = "";
        counter++;
    }

    //agrega los espacios que se van acumulando cuando se lee
    public void addHtmlSpace(StringBuffer currentSpelling) {
        htmlBuffer+="<FONT FACE= \"monospace\" SIZE =3 COLOR=#000000>"+htmlSpaces+currentSpelling.toString()+"</FONT>";
        htmlSpaces = "";
        counter++;
    }

    public void addHtmlSpace(){
        htmlSpaces+="&nbsp;";
    }

    //agrega el salto de linea al html
    public void addHtmlJumpLine() {
        htmlBuffer+="<br/>";
        htmlSpaces = "";
        counter++;
    }

    public void addHtmlTab() {
        htmlBuffer+="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    }

    public void reportError() {
        hasError = true;
    }

    // Draw the AST representing a complete program.
    //public void write(Program ast) {
    public void write() {
        // Prepare the file to write
        try {
            if(!hasError) {
                FileWriter fileWriter = new FileWriter(fileName);
                //HTML header
                fileWriter.write("<html><body>" + htmlBuffer + "</body></html>");
                fileWriter.close();
            }
            else{
                System.err.println("Error lexico mientras se escribia el HTML");
            }

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST in HTML");
            e.printStackTrace();
        }
    }
}