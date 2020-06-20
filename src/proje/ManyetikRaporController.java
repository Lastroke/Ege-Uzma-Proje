/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * FXML Controller class
 *
 * @author egeuzma
 */
public class ManyetikRaporController implements Initializable ,ControllerClass {
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
    @FXML private Label anabaslık;
    @FXML private Label altbaslık;
    @FXML private Label altaltbaslık;
    @FXML private Label errorlabel;
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
    private Mitarbeiter calisan ;
    private Mitarbeiter calisan2 ;
    private Mitarbeiter calisan3;
    private Ekipman ekipman1;
    private Firma firma1;
    @FXML private RadioButton check2;
   @FXML private RadioButton check3;
   private ToggleGroup favLangToggleGroup;
    @FXML CheckBox check;
    @FXML CheckBox check1;
    @FXML ScrollPane deneme;
    @FXML AnchorPane deneme1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        yuzeytext.getItems().addAll("evet","hayır");
        muayeneasamasıtext.getItems().addAll("iyi","kötü");
        akımtipichoice.getItems().addAll("ac","dc");
        box1.getItems().addAll("OK","RED");
        box2.getItems().addAll("OK","RED");
        box3.getItems().addAll("OK","RED");
        box4.getItems().addAll("OK","RED");
        box5.getItems().addAll("OK","RED");
        favLangToggleGroup = new ToggleGroup();
       this.check2.setToggleGroup(favLangToggleGroup);
       this.check3.setToggleGroup(favLangToggleGroup);
       
      
      
    } 
 
   public void PDFbutton(ActionEvent event){
        AnchorPane root = new AnchorPane();
        root = deneme1 ;
      try {
            WritableImage nodeshot = root.snapshot(new SnapshotParameters(), null);

            // store image in-memory
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ImageIO.write(SwingFXUtils.fromFXImage(nodeshot, null), "png", output);
            output.close();

            PDDocument pddoc = new PDDocument();
            PDPage pdpage = new PDPage();
            PDImageXObject pdimagexObject;
            PDPageContentStream contentstream;

            pdimagexObject = PDImageXObject.createFromByteArray(pddoc, output.toByteArray(), "png");
            contentstream = new PDPageContentStream(pddoc, pdpage);
            contentstream.drawImage(pdimagexObject,-3,-30,630,822);
            contentstream.close();
            pddoc.addPage(pdpage);

            File outputFile = new File("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\Pdf.pdf");
            pddoc.save(outputFile);
            pddoc.close();
            System.out.println("deneme1.pdf written successfully");
        } catch (Exception e) {
            
        }
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
        String cbox1 =(String) this.box1.getSelectionModel().getSelectedItem();
        String cbox2 =(String) this.box2.getSelectionModel().getSelectedItem();
        String cbox3 =(String) this.box3.getSelectionModel().getSelectedItem();
        String cbox4 =(String) this.box4.getSelectionModel().getSelectedItem();
        String cbox5 =(String) this.box5.getSelectionModel().getSelectedItem();
        
         if((cbox1.equals("RED")&&this.text6.getText().equals("")&&this.text7.getText().equals(""))||(cbox2.equals("RED")&&this.text13.getText().equals("")&&this.text14.getText().equals(""))
                 ||(cbox3.equals("RED")&&this.text20.getText().equals("")&&this.text21.getText().equals(""))||(cbox4.equals("RED")&&this.text27.getText().equals("")&&this.text28.getText().equals("")
                 ||(cbox5.equals("RED")&&this.text34.getText().equals("")&&this.text35.getText().equals("")))
                 ){
             errorlabel.setText("Hata Tipi veya Hatanın Yeri boş olamaz");
         }else{
             errorlabel.setText("");
         XSSFWorkbook workbook = new XSSFWorkbook(); 
         XSSFSheet spreadsheet = workbook.createSheet("cell types");
        
         CellStyle style1 = workbook.createCellStyle();
         style1.setBorderRight(BorderStyle.THICK);
         style1.setBorderBottom(BorderStyle.THICK);
         style1.setFillForegroundColor(IndexedColors.ROSE.getIndex());
         style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
         style1.setRightBorderColor(IndexedColors.BLACK.getIndex());
         style1.setWrapText(true);
         CellStyle style3 = workbook.createCellStyle();
         style3.setAlignment(HorizontalAlignment.CENTER);
         style3.setVerticalAlignment(VerticalAlignment.CENTER);
         style3.setFillForegroundColor(IndexedColors.ROSE.getIndex());
         style3.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
         
         XSSFRow row = spreadsheet.createRow((short) 0);
         XSSFCell cell = (XSSFCell) row.createCell(2);
         cell.setCellValue(anabaslık.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(0,1,2,11));
         cell.setCellStyle(style3);
         row = spreadsheet.createRow((short) 1);
         for(int i=2;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 2);
         cell = (XSSFCell) row.createCell(2);
         cell.setCellValue(altbaslık.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(2,2,2,11));
         cell.setCellStyle(style3);
         row = spreadsheet.createRow((short) 3);
         cell = (XSSFCell) row.createCell(2);
         cell.setCellValue(altaltbaslık.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(3,3,2,11));
         cell.setCellStyle(style3);
         for(int i=3;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 4);
         row.setHeight((short) 800);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(musterilabel.getText() +"\n"+customerlabel.getText());

         cell.setCellStyle(style1);
         
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,1,2));
         cell.setCellValue(customertext.getText());
         CellStyle style2 = workbook.createCellStyle();
         style2.setAlignment(HorizontalAlignment.CENTER);
         style2.setVerticalAlignment(VerticalAlignment.CENTER);
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayeneprosedurlabel.getText() +"\n"+muayeneprocedurelabel.getText());
         cell.setCellStyle(style1);
         
         
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,4,5));
         cell.setCellValue(muayeneproceduretext.getText());
         cell.setCellStyle(style2);
       
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(sayfano.getText() +"\n"+pageno.getText());
         cell.setCellStyle(style1);
         
         
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(4,4,7,11));
         cell.setCellValue(sayfanotext.getText());
         cell.setCellStyle(style2);
         
         // row 2 
         row = spreadsheet.createRow((short) 5);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(projeadılabel.getText() +"\n"+projectnamelabel.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(5,5,1,2));
         cell.setCellValue(projetext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayenekapsamılabel.getText() +"\n"+inspectionscopelabel.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(5,5,4,5));
         cell.setCellValue(muayenekapsamıtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(raporno.getText() +"\n"+reportno.getText());
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(5,5,7,11));
         cell.setCellValue(raportext.getText());
         cell.setCellStyle(style2);
         
         //row 3
         row = spreadsheet.createRow((short )6);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(testyerilabel.getText()+"\n"+inspectionplacelabel.getText());
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,1,2));
         cell.setCellValue(testyeritext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(resimnolabel.getText() +"\n"+drawnolabel.getText());
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,4,5));
         cell.setCellValue(resimtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(raportarihi.getText() +"\n"+reportdate.getText());
       
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(6,6,7,11));
         cell.setCellValue(raportarihitext.getText());
         cell.setCellStyle(style2);
         
         //row 4
         row = spreadsheet.createRow((short) 7);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(muayenestandartilabel.getText()+"\n"+inspectionstandartlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,7,1,2));
         cell.setCellValue(standarttext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(yüzeydurumulabel.getText() +"\n"+surfacecondlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,7,4,5));
         cell.setCellValue((String)yuzeytext.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(isemri.getText() +"\n"+joborder.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(7,7,7,11));
         cell.setCellValue(isemritext.getText());
         cell.setCellStyle(style2);
         //row5
         row = spreadsheet.createRow((short) 8);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(Degerlenstandlabel.getText()+"\n"+this.Evalutionstandlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(8,8,1,2));
         cell.setCellValue(degerstandarttext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(muayeneasamasılabel.getText() +"\n"+stageofexamlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(8,8,4,5));
         cell.setCellValue((String)muayeneasamasıtext.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(teklifno.getText() +"\n"+offerno.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(8,8,7,11));
         cell.setCellValue(tekliftext.getText());
         cell.setCellStyle(style2);
         //ekipman bilgilerine gecis row 6
         row = spreadsheet.createRow((short) 9);
         spreadsheet.addMergedRegion(new CellRangeAddress(9,9,0,11));
         
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(ekipmanbilgiler.getText()+equipmentınfo.getText());
         cell.setCellStyle(style3);
         for(int i=1;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         //row7
         row = spreadsheet.createRow((short) 10);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(kutupmesafesilabel.getText()+"\n"+this.poledistancelabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,1,2));
         cell.setCellValue(this.kutuptext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.muayenebölgesilabel.getText() +"\n"+examarealabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,4,5));
         cell.setCellValue(this.muayenebölgesitext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.yüzeysıcaklıgı.getText() +"\n"+this.surfacetemp.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(10,10,7,11));
         cell.setCellValue(this.sıcaktext.getText());
         cell.setCellStyle(style2);
         //row8
         row = spreadsheet.createRow((short) 11);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(cihazlabel.getText()+"\n"+cihaz1label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,11,1,2));
         cell.setCellValue(cihaztext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.akımtipilabel.getText() +"\n"+this.currentypelabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,11,4,5));
         cell.setCellValue((String)akımtipichoice.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.muayenebölgesi.getText() +"\n"+this.alansiddeti.getText()+"\n"+this.gausfield.getText());
   
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(11,12,7,11));
         cell.setCellValue(gaustext.getText());
         cell.setCellStyle(style2);
         //row 9
         row = spreadsheet.createRow((short) 12);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.MPtasıyıcıortamlabel.getText()+"\n"+this.MPcariermediumlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(12,12,1,2));
         cell.setCellValue(this.mptext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.luxmetrelabel.getText() +"\n"+luxmeter.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(12,12,4,5));
         cell.setCellValue(this.luxmetertext.getText());
         cell.setCellStyle(style2);
         //row 10
         row = spreadsheet.createRow((short) 13);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.Mıknatısteklabel.getText()+"\n"+this.magtechlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(13,13,1,2));
         cell.setCellValue(this.magtext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.muayeneortamılabel.getText() +"\n"+testmediumlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(13,13,4,5));
         cell.setCellValue(this.muayeneortamıtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.yüzeylabel.getText() +"\n"+this.surfacelabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(13,13,7,11));
         cell.setCellValue(this.yüzeytext.getText());
         cell.setCellStyle(style2);
         //row11
         row = spreadsheet.createRow((short) 14);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.uvısıksiddeti.getText()+"\n"+this.uvlightıntensity.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(14,14,1,2));
         cell.setCellValue(this.uvlighttext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.mıknatısgiderimilabel.getText() +"\n"+this.demaglabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(14,14,4,5));
         cell.setCellValue(this.demagtext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.ısıktanımlabel.getText() +"\n"+this.ıdentificationlabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(14,14,7,11));
         cell.setCellValue(this.ısıktanımtext.getText());
         cell.setCellStyle(style2);
         //row12
         row = spreadsheet.createRow((short) 15);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.ısıkmesafesilabel.getText()+"\n"+this.lightdistancelabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(15,15,1,2));
         cell.setCellValue(this.ısıkmestext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.ısılislemlabel.getText() +"\n"+this.heattreatlabel.getText());
         
         spreadsheet.autoSizeColumn(3);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(15,15,4,5));
         cell.setCellValue(this.ısıltext.getText());
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.kaldırmatestilabel.getText() +"\n"+this.liftingtestlabel.getText());
         
         spreadsheet.autoSizeColumn(6);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         spreadsheet.addMergedRegion(new CellRangeAddress(15,15,7,11));
         cell.setCellValue(this.kaldırmatext.getText());
         cell.setCellStyle(style2);
         //row13 image
         final FileInputStream stream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\a8702a42-03ea-49f4-83d2-5f78fbc679d8.jpg");
         final CreationHelper helper = workbook.getCreationHelper();
         final Drawing drawing = spreadsheet.createDrawingPatriarch();
         final ClientAnchor anchor = helper.createClientAnchor();
         anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
         final int pictureIndex =
         workbook.addPicture(IOUtils.toByteArray(stream), Workbook.PICTURE_TYPE_PNG);
         anchor.setCol1(0);
         anchor.setRow1(16); // same row is okay
         anchor.setRow2(16);
         anchor.setCol2(6);
         final Picture pict = drawing.createPicture( anchor, pictureIndex );
         pict.resize(0.45,5);
         if(favLangToggleGroup.getSelectedToggle().equals(check2)){
            final FileInputStream outstream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\checkbox.jpg");
            final CreationHelper outhelper = workbook.getCreationHelper();
            final Drawing drawing1 = spreadsheet.createDrawingPatriarch();
            final ClientAnchor anchor1 = outhelper.createClientAnchor();
            anchor1.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

            final int pictureIndex1 =
            workbook.addPicture(IOUtils.toByteArray(outstream), Workbook.PICTURE_TYPE_PNG);
            anchor1.setCol1(2);
            anchor1.setRow1(21); // same row is okay
            anchor1.setRow2(21);
            anchor1.setCol2(2);
            final Picture pict1 = drawing1.createPicture( anchor1, pictureIndex1 );
            pict1.resize(0.3,0.5);
         }else{
             final FileInputStream outstream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\checkbox.jpg");
            final CreationHelper outhelper = workbook.getCreationHelper();
            final Drawing drawing1 = spreadsheet.createDrawingPatriarch();
            final ClientAnchor anchor1 = outhelper.createClientAnchor();
            anchor1.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

            final int pictureIndex1 =
            workbook.addPicture(IOUtils.toByteArray(outstream), Workbook.PICTURE_TYPE_PNG);
            anchor1.setCol1(5);
            anchor1.setRow1(21); // same row is okay
            anchor1.setRow2(21);
            anchor1.setCol2(5);
            final Picture pict1 = drawing1.createPicture( anchor1, pictureIndex1 );
            pict1.resize(0.3,0.5);
         }
         
         final FileInputStream instream = new FileInputStream("C:\\Users\\egeuzma\\Documents\\NetBeansProjects\\Proje\\src\\proje\\View\\9f452b9c-b1d3-4643-9ee1-7883ff191bfa.jpg");
         final CreationHelper inhelper = workbook.getCreationHelper();
         final Drawing indrawing = spreadsheet.createDrawingPatriarch();
         final ClientAnchor inanchor = inhelper.createClientAnchor();
         inanchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
         final int pictureIndex2 =
         workbook.addPicture(IOUtils.toByteArray(instream), Workbook.PICTURE_TYPE_PNG);
         inanchor.setCol1(3);
         inanchor.setRow1(16); // same row is okay
         inanchor.setRow2(16);
         inanchor.setCol2(6);
         final Picture inpict = indrawing.createPicture( inanchor, pictureIndex2 );
         inpict.resize(0.90,5);
         row = spreadsheet.createRow((short) 16);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.süreksizliğinyeri.getText() +this.locaoflabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(16,16,6,11));
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         for(int i=7;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 17);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.bmlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.anametallabel.getText()+this.basemetallabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(17,17,7,11));
         cell.setCellStyle(style1);
         for(int i=8;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 18);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.hazlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.ısıdanetkilabel.getText()+this.heateffectlbel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(18,18,7,11));
         cell.setCellStyle(style1);
         for(int i=8;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 19);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.wlabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.kaynaklabel.getText()+this.weldlabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(19,19,7,11));
         cell.setCellStyle(style1);
         for(int i=8;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         row = spreadsheet.createRow((short) 20);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.blabel.getText());
         spreadsheet.autoSizeColumn(6);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(7);
         cell.setCellValue(this.kaynakagzılabel.getText()+this.bevellabel.getText());
         spreadsheet.addMergedRegion(new CellRangeAddress(20,20,7,11));
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(7);
         for(int i=8;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         //row19
         row = spreadsheet.createRow((short) 22);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.standartsapmalabel.getText()+"\n"+this.standartdeviatlabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(22,22,1,11));
         cell.setCellValue(this.standartsapmatext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row20
         row = spreadsheet.createRow((short) 23);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.muayenetarih.getText()+"\n"+this.inspectiondate.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(23,23,1,11));
         cell.setCellValue(this.muayenetarihtext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row21
         row = spreadsheet.createRow((short) 24);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.açıklama.getText()+"\n"+this.descriptions.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(0);
         
         
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(24,24,1,11));
         cell.setCellValue(this.açıklamatext.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         //row22
         row = spreadsheet.createRow((short) 25);
         cell = (XSSFCell) row.createCell(0);
         spreadsheet.addMergedRegion(new CellRangeAddress(25,25,0,11));
         cell.setCellValue(this.muayenesonuculabel.getText()+this.inspectionresultlabel.getText());
         cell.setCellStyle(style3);
         for(int i=1;i<=11;i++){
           cell = (XSSFCell) row.createCell(i);
           cell.setCellStyle(style1);
         }
         //row23
         row = spreadsheet.createRow((short) 26);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.sıranolabel.getText()+"\n"+this.serialnolabel.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,1,2));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(26,26,10,11));
         cell.setCellValue(this.sonuc.getText() +"\n"+this.result.getText());
         cell.setCellStyle(style1);
         spreadsheet.autoSizeColumn(10);
         cell = (XSSFCell) row.createCell(11);
         cell.setCellStyle(style1);
         //row24
         row = spreadsheet.createRow((short) 27);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri1label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,1,2));
         cell.setCellValue(this.text1.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text2.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(27,27,10,11));
         cell.setCellValue((String)box1.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row25
         row = spreadsheet.createRow((short) 28);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri2label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,1,2));
         cell.setCellValue(this.text8.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text9.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(28,28,10,11));
         cell.setCellValue((String)box2.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row26
         row = spreadsheet.createRow((short) 29);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri3label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,1,2));
         cell.setCellValue(this.text15.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text16.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(29,29,10,11));
         cell.setCellValue((String)box3.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row27
         row = spreadsheet.createRow((short) 30);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri4label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,1,2));
         cell.setCellValue(this.text22.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text23.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(30,30,10,11));
         cell.setCellValue((String)box4.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row28
         row = spreadsheet.createRow((short) 31);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seri5label.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,1,2));
         cell.setCellValue(this.text29.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.text30.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,4,5));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(31,31,10,11));
         cell.setCellValue((String)box5.getSelectionModel().getSelectedItem());
         cell.setCellStyle(style2);
         spreadsheet.autoSizeColumn(10);
         //row29
         row = spreadsheet.createRow((short) 32);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.personalbilgiler.getText()+"\n"+this.personınfo.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,1,2));
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
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,4,5));
         cell.setCellValue(this.onay.getText()+this.confirmation.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(5);
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(this.müşteri.getText()+this.customer.getText());
         cell.setCellStyle(style1);
         spreadsheet.addMergedRegion(new CellRangeAddress(32,32,6,11));
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
         row = spreadsheet.createRow((short) 33);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.adsoyad.getText()+"\n"+this.namesur.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(33,33,1,2));
         cell.setCellValue(adsoyadtextop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(adsoyaddeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(33,33,4,5));
         cell.setCellValue(adsoyadonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(33,33,6,11));
         spreadsheet.autoSizeColumn(6);
         //row31
         row = spreadsheet.createRow((short) 34);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.seviye.getText()+"\n"+this.level.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(34,34,1,2));
         cell.setCellValue(this.levelop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.leveldeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(34,34,4,5));
         cell.setCellValue(this.levelonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(34,34,6,11));
         spreadsheet.autoSizeColumn(6);
         //row32
         row = spreadsheet.createRow((short) 35);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.tarih.getText()+"\n"+this.date.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(35,35,1,2));
         cell.setCellValue(this.tarihop.getText());
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(this.tarihdeger.getText());
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(35,35,4,5));
         cell.setCellValue(this.tarihonay.getText());
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(35,35,6,11));
         spreadsheet.autoSizeColumn(6);
         //row33
          row = spreadsheet.createRow((short) 36);
         cell = (XSSFCell) row.createCell(0);
         cell.setCellValue(this.imza.getText()+"\n"+this.signature.getText());
         
         spreadsheet.autoSizeColumn(0);
         
         cell.setCellStyle(style1);
         cell = (XSSFCell) row.createCell(1);
         spreadsheet.addMergedRegion(new CellRangeAddress(36,36,1,2));
         cell.setCellValue(" ");
         spreadsheet.autoSizeColumn(1);
         cell.setCellStyle(style2);
      
         cell = (XSSFCell) row.createCell(3);
         cell.setCellValue(" ");
         spreadsheet.autoSizeColumn(3);
         cell.setCellStyle(style2);
         cell = (XSSFCell) row.createCell(4);
         spreadsheet.addMergedRegion(new CellRangeAddress(36,36,4,5));
         cell.setCellValue(" ");
         
         spreadsheet.autoSizeColumn(4);
         
         cell.setCellStyle(style2);
         
         cell = (XSSFCell) row.createCell(6);
         cell.setCellValue(" ");
         cell.setCellStyle(style2);
         spreadsheet.addMergedRegion(new CellRangeAddress(36,36,6,11));
         spreadsheet.autoSizeColumn(6);
         
         
         FileOutputStream out = new FileOutputStream(new File("typesofcells.xlsx"));
         workbook.write(out);
         out.close();
         System.out.println("typesofcells.xlsx written successfully");
         }
     }

    @Override
    public void preloaddata(Mitarbeiter mitarbeiter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void preloaddataEkipman(Ekipman ekipman) {
        this.ekipman1=ekipman;
        this.kutuptext.setText(ekipman.getKutupMesafesi());
        this.cihaztext.setText(ekipman.getCihaz());
        this.mptext.setText(ekipman.getMPTasıyıcıOrtam());
        this.magtext.setText(ekipman.getMıknatıslamaTek());
        this.uvlighttext.setText(ekipman.getUVIsıkSiddeti());
        this.ısıkmestext.setText(ekipman.getIsıkMesafesi());
    }

    @Override
    public void preloaddataFirma(Firma firma) {
        this.firma1=firma;
        this.customertext.setText(firma.getFirmaAdı());
        this.testyeritext.setText(firma.getIl());
        this.isemritext.setText(firma.getIsEmriNo());
        this.tekliftext.setText(firma.getTeklifNo());
    }
    @Override
    public void preloadmitarbeiter(Mitarbeiter mitarbeiter, Mitarbeiter mitarbeiter2, Mitarbeiter mitarbeiter3) {
        this.calisan=mitarbeiter;
        this.adsoyadtextop.setText(mitarbeiter.getFirstName());
        this.levelop.setText(mitarbeiter.getLevel());
        this.calisan2=mitarbeiter2;
        this.adsoyaddeger.setText(mitarbeiter2.getFirstName());
        this.leveldeger.setText(mitarbeiter2.getLevel());
        this.calisan3=mitarbeiter3;
        this.adsoyadonay.setText(mitarbeiter3.getFirstName());
        this.levelonay.setText(mitarbeiter3.getLevel());
    }
}
