                  /*  File:  OE16D_4d.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class OE16D_4d extends Template {

     static {templateClass = new OE16D_4d() ; }

     public void setup() {
          filePrefix = "OE16D_4d" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 7.0*0.3 ;   
          ysize = 7.0*0.3 ;   
          xmin = -1.5 ;
          xmax = 1.5 ;
          ymin = -1.5  ;
          ymax = 1.5 ;
          topmargin = 0.1 ;
          bottommargin = 0 ;
          leftmargin = 0.0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          double rho = 0.4 ;
          fEnv("psFillGray", 0.9) ;
          fDisk(0,0, 1, 1, FILLED) ;
          fEnv("psFillGray", 1.0) ;
          fDisk(0,0, rho, rho, FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.03, ymax, "tr", "$y$") ;
          fTeXlabel(0.6, -0.4, "cc", "$R_5$") ;
          fTeXlabel(0.83,  0.83, "cc", "$C_1$") ;
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fEnv("lineWidth", 1.5) ;
          fDisk(0,0, 1, 1, CLOSED) ;
          fDisk(0,0, rho, rho, CLOSED) ;   
 
//          fEnv("arrowHeadColor", Red) ;  
          fEnv("headHalfWidth", 2.0*1.5) ;  
          fEnv("headLength", 6.0*1.5) ;
          fArrowhead(0,1, 180) ;  
          fArrowhead(0,rho, 0) ;  
          fTeXlabel(0.3, rho-0.2, "bl", "$-C_\\rho$") ;
     
     
     }
}
