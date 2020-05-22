/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import static org.apache.poi.ss.usermodel.IndexedColors.PINK;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class ManyetikRaporController implements Initializable {
    @FXML private Label customerlabel,musterilabel,muayeneprocedurelabel,muayeneprosedurlabel,sayfano,pageno;
    @FXML private TextField customertext,sayfanotext,muayeneproceduretext;
    @FXML private Label projeadılabel,projectnamelabel,muayenekapsamılabel,inspectionscopelabel,reportno,raporno;
    @FXML private TextField projetext,raportext,muayenekapsamıtext;
    @FXML private Label testyerilabel,inspectionplacelabel,drawnolabel,resimnolabel,reportdate,raportarihi;
    @FXML private TextField testyeritext,raportarihitext,resimtext;
    @FXML private Label muayenestandartilabel,inspectionstandartlabel,yüzeydurumulabel,surfacecondlabel,joborder,isemri;
    @FXML private TextField standarttext,isemritext;
    @FXML private ChoiceBox yuzeytext,muayeneasamasıtext,akımtipichoice;
    @FXML private Label Degerlenstandlabel,Evalutionstandlabel,muayeneasamasılabel,stageofexamlabel,teklifno,offerno;
    @FXML private TextField degerstandarttext,tekliftext;
    @FXML private Label ekipmanbilgiler,equipmentınfo;
    @FXML private Label kutupmesafesilabel,poledistancelabel,muayenebölgesilabel,examarealabel,yüzeysıcaklıgı,surfacetemp;
    @FXML private TextField kutuptext,muayenebölgesitext,sıcaktext;
    @FXML private Label cihazlabel,cihaz1label,akımtipilabel,currentypelabel,muayenebölgesi,alansiddeti,gausfield;
    @FXML private Label MPtasıyıcıortamlabel,MPcariermediumlabel,luxmetrelabel,luxmeter;
    @FXML private Label Mıknatısteklabel,magtechlabel,muayeneortamılabel,testmediumlabel,yüzeylabel,surfacelabel;
    @FXML private Label uvısıksiddeti,uvlightıntensity,mıknatısgiderimilabel,demaglabel,ısıktanımlabel,ıdentificationlabel;
    @FXML private Label ısıkmesafesilabel;
    @FXML private Label lightdistancelabel;
    @FXML private Label ısılislemlabel;
    @FXML private Label heattreatlabel;
    @FXML private Label kaldırmatestilabel;
    @FXML private Label liftingtestlabel;
    @FXML private TextField cihaztext,gaustext,mptext,luxmetertext,ısıktanımtext,demagtext;
    @FXML private TextField magtext,muayeneortamıtext,yüzeytext,uvlighttext;
    @FXML private TextField ısıkmestext;
    @FXML private TextField ısıltext;
    @FXML private TextField kaldırmatext;
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    private File imageFile;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yuzeytext.getItems().addAll("evet","hayır");
        muayeneasamasıtext.getItems().addAll("iyi","kötü");
        akımtipichoice.getItems().addAll("ac","dc");
    }    
     public void GoBack(ActionEvent event) throws IOException{
       Parent Goback = FXMLLoader.load(getClass().getResource("RaporOlustur.fxml"));
       Scene scene = new Scene(Goback);
       // this line gets stage informaiton
       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       window.setScene(scene);
       window.show();
   }
     public void ExcelButtonPushed(ActionEvent event) throws FileNotFoundException, IOException{
         XSSFWorkbook workbook = new XSSFWorkbook(); 
         XSSFSheet spreadsheet = workbook.createSheet("cell types");
         
         XSSFRow row = spreadsheet.createRow((short) 0);
         row.setHeight((short) 800);
         XSSFCell cell = (XSSFCell) row.createCell(0);
         CellStyle style1 = workbook.createCellStyle();
         style1.setBorderRight(BorderStyle.THICK);
         style1.setBorderBottom(BorderStyle.THICK);
         style1.setFillForegroundColor(IndexedColors.PINK1.getIndex());
         style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
         style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
         cell.setCellValue(musterilabel.getText() +"\n"+customerlabel.getText());
         style1.setWrapText(true);
         
         cell.setCellStyle(style1);
         
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
         cell.setCellValue(customertext.getText());
         CellStyle style2 = workbook.createCellStyle();
         style2.setAlignment(HorizontalAlignment.CENTER);
         style2.setVerticalAlignment(VerticalAlignment.CENTER);
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayeneprosedurlabel.getText() +"\n"+muayeneprocedurelabel.getText());
         cell.setCellStyle(style1);
         
         
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(0,0,4,5));
         cell.setCellValue(muayeneproceduretext.getText());
         cell.setCellStyle(style2);
       
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(sayfano.getText() +"\n"+pageno.getText());
         cell.setCellStyle(style1);
         
         
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(0,0,7,8));
         cell.setCellValue(sayfanotext.getText());
         cell.setCellStyle(style2);
         
         // row 2 
         row = spreadsheet.createRow((short) 1);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(projeadılabel.getText() +"\n"+projectnamelabel.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(1,1,1,2));
         cell.setCellValue(projetext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayenekapsamılabel.getText() +"\n"+inspectionscopelabel.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(1,1,4,5));
         cell.setCellValue(muayenekapsamıtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(raporno.getText() +"\n"+reportno.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(1,1,7,8));
         cell.setCellValue(raportext.getText());
         cell.setCellStyle(style2);
         
         //row 3
         row = spreadsheet.createRow((short) 2);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(testyerilabel.getText()+"\n"+inspectionplacelabel.getText());
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(2,2,1,2));
         cell.setCellValue(testyeritext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(resimnolabel.getText() +"\n"+drawnolabel.getText());
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(2,2,4,5));
         cell.setCellValue(resimtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(raportarihi.getText() +"\n"+reportdate.getText());
       
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(2,2,7,8));
         cell.setCellValue(raportarihitext.getText());
         cell.setCellStyle(style2);
         
         //row 4
         row = spreadsheet.createRow((short) 3);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(muayenestandartilabel.getText()+"\n"+inspectionstandartlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(3,3,1,2));
         cell.setCellValue(standarttext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(yüzeydurumulabel.getText() +"\n"+surfacecondlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(3,3,4,5));
         cell.setCellValue((String)yuzeytext.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(isemri.getText() +"\n"+joborder.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(3,3,7,8));
         cell.setCellValue(isemritext.getText());
         cell.setCellStyle(style2);
         //row5
         row = spreadsheet.createRow((short) 4);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(Degerlenstandlabel.getText()+"\n"+this.Evalutionstandlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,1,2));
         cell.setCellValue(degerstandarttext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayeneasamasılabel.getText() +"\n"+stageofexamlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,4,5));
         cell.setCellValue((String)muayeneasamasıtext.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(teklifno.getText() +"\n"+offerno.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,7,8));
         cell.setCellValue(tekliftext.getText());
         cell.setCellStyle(style2);
         //ekipman bilgilerine gecis row 6
         row = spreadsheet.createRow((short) 5);
         spreadsheet.addMergedRegion(new CellRangeAddress(5,5,0,8));
         CellStyle style3 = workbook.createCellStyle();
         style3.setAlignment(HorizontalAlignment.CENTER);
         style3.setVerticalAlignment(VerticalAlignment.CENTER);
         style3.setFillForegroundColor(IndexedColors.PINK1.getIndex());
         style3.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(ekipmanbilgiler.getText()+equipmentınfo.getText());
         cell.setCellStyle(style3);
         //row7
         row = spreadsheet.createRow((short) 6);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(kutupmesafesilabel.getText()+"\n"+this.poledistancelabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,1,2));
         cell.setCellValue(this.kutuptext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.muayenebölgesilabel.getText() +"\n"+examarealabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,4,5));
         cell.setCellValue(this.muayenebölgesitext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.yüzeysıcaklıgı.getText() +"\n"+this.surfacetemp.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,7,8));
         cell.setCellValue(this.sıcaktext.getText());
         cell.setCellStyle(style2);
         //row8
         row = spreadsheet.createRow((short) 7);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(cihazlabel.getText()+"\n"+cihaz1label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,7,1,2));
         cell.setCellValue(cihaztext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.akımtipilabel.getText() +"\n"+this.currentypelabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,7,4,5));
         cell.setCellValue((String)akımtipichoice.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.muayenebölgesi.getText() +"\n"+this.alansiddeti.getText()+"\n"+this.gausfield.getText());
   
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,8,7,8));
         cell.setCellValue(gaustext.getText());
         cell.setCellStyle(style2);
         //row 9
         row = spreadsheet.createRow((short) 8);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.MPtasıyıcıortamlabel.getText()+"\n"+this.MPcariermediumlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(8,8,1,2));
         cell.setCellValue(this.mptext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.luxmetrelabel.getText() +"\n"+luxmeter.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(8,8,4,5));
         cell.setCellValue(this.luxmetertext.getText());
         cell.setCellStyle(style2);
         //row 10
         row = spreadsheet.createRow((short) 9);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.Mıknatısteklabel.getText()+"\n"+this.magtechlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(9,9,1,2));
         cell.setCellValue(this.magtext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.muayeneortamılabel.getText() +"\n"+testmediumlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(9,9,4,5));
         cell.setCellValue(this.muayeneortamıtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.yüzeylabel.getText() +"\n"+this.surfacelabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(9,9,7,8));
         cell.setCellValue(this.yüzeytext.getText());
         cell.setCellStyle(style2);
         //row11
         row = spreadsheet.createRow((short) 10);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.uvısıksiddeti.getText()+"\n"+this.uvlightıntensity.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,1,2));
         cell.setCellValue(this.uvlighttext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.mıknatısgiderimilabel.getText() +"\n"+this.demaglabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,4,5));
         cell.setCellValue(this.demagtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.ısıktanımlabel.getText() +"\n"+this.ıdentificationlabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,7,8));
         cell.setCellValue(this.ısıktanımtext.getText());
         cell.setCellStyle(style2);
         //row12
         row = spreadsheet.createRow((short) 11);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.ısıkmesafesilabel.getText()+"\n"+this.lightdistancelabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,11,1,2));
         cell.setCellValue(this.ısıkmestext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.ısılislemlabel.getText() +"\n"+this.heattreatlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,11,4,5));
         cell.setCellValue(this.ısıltext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.kaldırmatestilabel.getText() +"\n"+this.liftingtestlabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,11,7,8));
         cell.setCellValue(this.kaldırmatext.getText());
         cell.setCellStyle(style2);
         
         FileOutputStream out = new FileOutputStream(new File("typesofcells.xlsx"));
         workbook.write(out);
         out.close();
         System.out.println("typesofcells.xlsx written successfully");
         
     }
}
