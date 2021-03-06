                  /*  File:  OE15A_3b1.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class OE15A_3b1 extends Template {

     static {templateClass = new OE15A_3b1() ; }

     public void setup() {
          filePrefix = "OE15A_3b1" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.2*0.4 ;      // in inches
          ysize = 5.0*0.4 ;   // in inches. 
          xmin = -2.1 ;
          xmax =  2.1 ;
          ymin = -2.2 ;
          ymax =  2.8 ;
          topmargin = 0 ;   // in inches
          bottommargin = 0 ;   // in inches
          leftmargin = -0.1 ;   // in inches
          rightmargin = -0.1 ;   // in inches
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;   
     }
     
     public  void prepareFigure(Figure canvas) {
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;

          fEnv("psFillGray", 0.9) ;
          fCurve("[t , t*t-2]", 1, -2, 2,   FILLED) ;


          fEnv("lineWidth", 0.5) ;
          fLine(xmin, 0.0, xmax, 0.0) ;
          fLine(0.0, ymin, 0.0, ymax) ;
          fTeXlabel(xmax, -0.07, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fEnv("psFillColor", Red) ;
          fEnv("useColorPs", "true") ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("lineWidth", 2.0) ;
          fCurve("[t , t*t-2]", 1, -2, 2,   OPEN) ;

          fEnv("headLength", 6.0*1.7) ;
          fEnv("headHalfWidth", 2.0*1.7) ;

          double t = 0.85 ;
          double x0 = t ;
          double y0 = t*t-2 ;
          double x1 = t+0.05 ;
          double y1 = (t+0.05)*(t+0.05)-2 ;
          fArrow(x0,y0, x1,y1) ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fLine(-2,2, 2,2) ;
          fEnv("psFillColor", Blue) ;
          fArrowhead(0.5,2, 180) ;
          fTeXlabel(x0, (y0+2)/2.0+0.5, "cc", "$R$") ;
          fTeXlabel(-x0, y0-0.1, "rt", "$C$") ;
          fTeXlabel(-x0, 2.1, "rb", "$L$") ;
          fTeXlabel(-2.1, 2, "cr", "$(-2,2)$") ;
          fTeXlabel( 2.1, 2, "cl", "$(2,2)$") ;
          fTeXlabel( x1+0.1, y1, "cl", "$y=x^2-2$") ;



     }
}
