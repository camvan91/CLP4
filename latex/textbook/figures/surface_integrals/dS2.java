                  /*  File:  dS2.java    */


import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;


public class dS2 extends Template {

     static {templateClass = new dS2() ; }

     public void setup() {
          filePrefix = "dS2" ;    // used as the prefix for any ps, lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 1.0;      // in inches
          ysize = 1.0 ;   // in inches
          xmin = -10 ;
          xmax = 10 ;
          ymin = -10 ;
          ymax = 10 ;
          topmargin = 0.0 ;   // in inches
          bottommargin = 0.0 ;   // in inches
          leftmargin = 0 ;   // in inches
          rightmargin = 0 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          fEnv("lineWidth", 1.0) ;
          double A = -0.025 ; 
          double x1 = -6.0 ; double y1 = -7.0 ;
          double x2 = 5.0 ; double y2 = -5.0 ;
          double x3 = 6.0 ; double y3 = 6.0 ;
          double x4 = -5.0 ; double y4 = 5.0 ;
          double r = 0.6; 
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ; 
          fEnv("headHalfWidth", 2.0*1.2) ;
          fEnv("headLength", 6.0*1.2) ;
          fArrow(x1, y1, x2, y2)  ;
          fArrow(x4, y4, x3, y3)  ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("psFillColor", Blue) ; 
          fArrow(x1, y1, x4, y4)  ;
          fArrow(x2, y2, x3, y3)  ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("psFillColor", Black) ; 
          fDisk(x1,y1, r, r, FILLED) ;
          fDisk(x2,y2, r, r, FILLED) ;
          fDisk(x3,y3, r, r, FILLED) ;
          fDisk(x4,y4, r, r, FILLED) ;
          fTeXlabel(x1-0.7,y1, "br", "$P_0$") ;
          fTeXlabel(x2-0.1,y2+0.8, "br", "$P_1$") ;
          fTeXlabel(x3-0.5,y3+0.8, "br", "$P_3$") ;
          fTeXlabel(x4-0.5,y4+0.3, "br", "$P_2$") ;
          double th1 = Math.atan( (y2-y1)/(x2-x1) )*180/Math.PI ;
          double th2 = Math.atan( (y4-y1)/(x4-x1) )*180/Math.PI ;
          double rr = 2.2 ;
          fEllipticalArc(x1,y1, rr, rr, th1, th2, OPEN) ;
          fTeXlabel(x1+2*0.8, y1+4*0.8, "cl", "$\\theta$") ;
          fTeXlabel(0.5*(x1+x2)-3, 0.5*(y1+y2)-1, "lt", "$\\overrightarrow{P_0P_1}$") ;
          fTeXlabel(0.5*(x1+x4)-0.5, 0.5*(y1+y4)+0.3, "cr", "$\\overrightarrow{P_0P_2}$") ;

     }
}


