/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import static org.apache.poi.ss.usermodel.IndexedColors.PINK;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
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
    @FXML private Label ısıkmesafesilabel,lightdistancelabel,ısılislemlabel,heattreatlabel,kaldırmatestilabel,liftingtestlabel;
    @FXML private Label süreksizliğinyeri,locaoflabel,bmlabel,hazlabel,wlabel,blabel,anametallabel,basemetallabel;
    @FXML private Label standartsapmalabel,standartdeviatlabel,muayenetarih,muayenesonuculabel,inspectionresultlabel,inspectiondate;
    @FXML private Label sıranolabel,serialnolabel,kaynakparçano,açıklama,descriptions,weldpice,kontroluzun,testlength;
    @FXML private Label seri1label,seri2label,seri3label,seri4label,seri5label;
    @FXML private ChoiceBox box1,box2,box3,box4,box5;
    @FXML private TextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14;
    @FXML private TextField text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27;
    @FXML private TextField text28,text29,text30,text31,text32,text33,text34,text35;
    @FXML private Label kaynakyöntemi,kalınlık,thickness,çap,diameter,hatatipi,defecttyp,hatanınyeri,defectloc,sonuc,result;
    @FXML private Label weldingprocess;
    @FXML private Label personalbilgiler;
    @FXML private Label personınfo;
    @FXML private Label operator1;
    @FXML private Label operater2;
    @FXML private Label degerlendiren;
    @FXML private Label evaluatedby;
    @FXML private Label onay;
    @FXML private Label confirmation;
    @FXML private Label müşteri;
    @FXML private Label customer;
    @FXML private Label adsoyad;
    @FXML private Label namesur;
    @FXML private Label seviye;
    @FXML private Label level;
    @FXML private Label tarih;
    @FXML private Label date;
    @FXML private Label imza;
    @FXML private Label signature;
    @FXML private TextField adsoyadtextop;
    @FXML private TextField adsoyaddeger;
    @FXML private TextField adsoyadonay;
    @FXML private TextField levelop;
    @FXML private TextField leveldeger;
    @FXML private TextField levelonay;
    @FXML private TextField tarihop;
    @FXML private TextField tarihdeger;
    @FXML private TextField tarihonay;
    @FXML private Label ısıdanetkilabel,heateffectlbel,kaynaklabel,weldlabel,kaynakagzılabel,bevellabel;
    @FXML private TextField cihaztext,gaustext,mptext,luxmetertext,ısıktanımtext,demagtext;
    @FXML private TextField magtext,muayeneortamıtext,yüzeytext,uvlighttext;
    @FXML private TextField ısıkmestext,ısıltext,kaldırmatext;
    @FXML private TextField standartsapmatext;
    @FXML private TextField muayenetarihtext;
    @FXML private TextField açıklamatext;
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    private File imageFile;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yuzeytext.getItems().addAll("evet","hayır");
        muayeneasamasıtext.getItems().addAll("iyi","kötü");
        akımtipichoice.getItems().addAll("ac","dc");
        box1.getItems().addAll("ac1","dc1");
        box2.getItems().addAll("ac2","dc2");
        box3.getItems().addAll("ac3","dc3");
        box4.getItems().addAll("ac4","dc4");
        box5.getItems().addAll("ac5","dc5");
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
         //row13 image
         final FileInputStream stream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\9f452b9c-b1d3-4643-9ee1-7883ff191bfa.jpg");
         final CreationHelper helper = workbook.getCreationHelper();
         final Drawing drawing = spreadsheet.createDrawingPatriarch();
         final ClientAnchor anchor = helper.createClientAnchor();
         anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
         final int pictureIndex =
         workbook.addPicture(IOUtils.toByteArray(stream), Workbook.PICTURE_TYPE_PNG);
         anchor.setCol1(0);
         anchor.setRow1(12); // same row is okay
         anchor.setRow2(12);
         anchor.setCol2(6);
         final Picture pict = drawing.createPicture( anchor, pictureIndex );
         pict.resize(0.45,5.5);
         final FileInputStream instream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\a8702a42-03ea-49f4-83d2-5f78fbc679d8.jpg");
         final CreationHelper inhelper = workbook.getCreationHelper();
         final Drawing indrawing = spreadsheet.createDrawingPatriarch();
         final ClientAnchor inanchor = inhelper.createClientAnchor();
         inanchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
         final int pictureIndex2 =
         workbook.addPicture(IOUtils.toByteArray(instream), Workbook.PICTURE_TYPE_PNG);
         inanchor.setCol1(3);
         inanchor.setRow1(12); // same row is okay
         inanchor.setRow2(12);
         inanchor.setCol2(6);
         final Picture inpict = drawing.createPicture( inanchor, pictureIndex2 );
         inpict.resize(0.90,5.5);
         row = spreadsheet.createRow((short) 12);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.süreksizliğinyeri.getText() +this.locaoflabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(12,12,6,10));
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         row = spreadsheet.createRow((short) 13);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.bmlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.anametallabel.getText()+this.basemetallabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(13,13,7,10));
         cell.setCellStyle(style1);
         row = spreadsheet.createRow((short) 14);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.hazlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.ısıdanetkilabel.getText()+this.heateffectlbel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(14,14,7,11));
         cell.setCellStyle(style1);
         row = spreadsheet.createRow((short) 15);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.wlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.kaynaklabel.getText()+this.weldlabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(15,15,7,10));
         cell.setCellStyle(style1);
         row = spreadsheet.createRow((short) 16);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.blabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.kaynakagzılabel.getText()+this.bevellabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(16,16,7,10));
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(7);
         //row19
         row = spreadsheet.createRow((short) 18);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.standartsapmalabel.getText()+"\n"+this.standartdeviatlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(18,18,1,11));
         cell.setCellValue(this.standartsapmatext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row20
         row = spreadsheet.createRow((short) 19);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.muayenetarih.getText()+"\n"+this.inspectiondate.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(19,19,1,11));
         cell.setCellValue(this.muayenetarihtext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row21
         row = spreadsheet.createRow((short) 20);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.açıklama.getText()+"\n"+this.descriptions.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(0);
         
         
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(20,20,1,11));
         cell.setCellValue(this.açıklamatext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row22
         row = spreadsheet.createRow((short) 21);
         cell = (XSSFCell) row.createCell(0);
         spreadsheet.addMergedRegion(new CellRangeAddress(21,21,0,11));
         cell.setCellValue(this.muayenesonuculabel.getText()+this.inspectionresultlabel.getText());
         cell.setCellStyle(style3);
         //row23
         row = spreadsheet.createRow((short) 22);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.sıranolabel.getText()+"\n"+this.serialnolabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(22,22,1,2));
         cell.setCellValue(this.kaynakparçano.getText()+"\n"+this.weldpice.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(2);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.kontroluzun.getText()+"\n"+this.testlength.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(22,22,4,5));
         cell.setCellValue(this.kaynakyöntemi.getText() +"\n"+this.weldingprocess.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(5);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.kalınlık.getText() +"\n"+this.thickness.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.çap.getText() +"\n"+this.diameter.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.hatatipi.getText() +"\n"+this.defecttyp.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.hatanınyeri.getText() +"\n"+this.defectloc.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(22,22,10,11));
         cell.setCellValue(this.sonuc.getText() +"\n"+this.result.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(10);
         cell = (XSSFCell) row.createCell(11);
         cell.setCellStyle(style1);
         //row24
         row = spreadsheet.createRow((short) 23);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri1label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(23,23,1,2));
         cell.setCellValue(this.text1.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text2.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(23,23,4,5));
         cell.setCellValue(this.text3.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.text4.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.text5.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.text6.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.text7.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(23,23,10,11));
         cell.setCellValue((String)box1.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row25
         row = spreadsheet.createRow((short) 24);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri2label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(24,24,1,2));
         cell.setCellValue(this.text8.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text9.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(24,24,4,5));
         cell.setCellValue(this.text10.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.text11.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.text12.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.text13.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.text14.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(24,24,10,11));
         cell.setCellValue((String)box2.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row26
         row = spreadsheet.createRow((short) 25);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri3label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(25,25,1,2));
         cell.setCellValue(this.text15.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text16.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(25,25,4,5));
         cell.setCellValue(this.text17.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.text18.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.text19.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.text20.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.text21.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(25,25,10,11));
         cell.setCellValue((String)box3.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row27
         row = spreadsheet.createRow((short) 26);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri4label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,1,2));
         cell.setCellValue(this.text22.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text23.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,4,5));
         cell.setCellValue(this.text24.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.text25.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.text26.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.text27.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.text28.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,10,11));
         cell.setCellValue((String)box4.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row28
         row = spreadsheet.createRow((short) 27);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri5label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,1,2));
         cell.setCellValue(this.text29.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text30.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,4,5));
         cell.setCellValue(this.text31.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.text32.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.text33.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(7);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellValue(this.text34.getText());
         
         spreadsheet.autoSizeColumn(8);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellValue(this.text35.getText());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(9);
         cell = (XSSFCell) row.createCell(10);
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,10,11));
         cell.setCellValue((String)box5.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row29
         row = spreadsheet.createRow((short) 28);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.personalbilgiler.getText()+"\n"+this.personınfo.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,1,2));
         cell.setCellValue(this.operator1.getText()+this.operater2.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(2);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.degerlendiren.getText()+this.evaluatedby.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,4,5));
         cell.setCellValue(this.onay.getText()+this.confirmation.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(5);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.müşteri.getText()+this.customer.getText());
         cell.setCellStyle(style1);
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,6,11));
         spreadsheet.autoSizeColumn(6);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(8);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(9);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(10);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(11);
         cell.setCellStyle(style1);
         //row30
         row = spreadsheet.createRow((short) 29);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.adsoyad.getText()+"\n"+this.namesur.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,1,2));
         cell.setCellValue(this.adsoyadtextop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.adsoyaddeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,4,5));
         cell.setCellValue(this.adsoyadonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,6,11));
         spreadsheet.autoSizeColumn(6);
         //row31
         row = spreadsheet.createRow((short) 30);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seviye.getText()+"\n"+this.level.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,1,2));
         cell.setCellValue(this.levelop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.leveldeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,4,5));
         cell.setCellValue(this.levelonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,6,11));
         spreadsheet.autoSizeColumn(6);
         //row32
         row = spreadsheet.createRow((short) 31);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.tarih.getText()+"\n"+this.date.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,1,2));
         cell.setCellValue(this.tarihop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.tarihdeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,4,5));
         cell.setCellValue(this.tarihonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,6,11));
         spreadsheet.autoSizeColumn(6);
         //row33
          row = spreadsheet.createRow((short) 32);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.imza.getText()+"\n"+this.signature.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,1,2));
         cell.setCellValue(" ");
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(" ");
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,4,5));
         cell.setCellValue(" ");
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,6,11));
         spreadsheet.autoSizeColumn(6);
         FileOutputStream out = new FileOutputStream(new File("typesofcells.xlsx"));
         workbook.write(out);
         out.close();
         System.out.println("typesofcells.xlsx written successfully");
         
     }
}
