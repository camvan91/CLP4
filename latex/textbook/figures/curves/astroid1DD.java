                  /*  File:  astroid1DD.java    */


import figPac.* ;
import java.applet.* ;
import java.awt.* ;


public class astroid1DD extends Template {

     static {templateClass = new astroid1DD() ; }

     public void setup() {
          filePrefix = "astroid1DD" ;    // used as the prefix for any ps or lbl files written
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 2 ;      // in inches
          ysize = 2 ;   // in inches. 
          xmin = -100 ;
          xmax = 100 ;
          ymin = -100 ;
          ymax = 100 ;
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
          fEnv("useColorPs", "true") ;
          String Red = "0 1 1 0 setcmykcolor  " ;
          String Black = "0 0 0 1 setcmykcolor  " ;
          String Blue = "1 1 0 0 setcmykcolor  " ;
          String Yellow = "0 0 1 0 setcmykcolor  " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fCurve("[80*cos(t)*cos(t)*cos(t) , 80*sin(t)*sin(t)*sin(t)]", 1, 0, 2*Math.PI,                   OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          double th = 3*Math.PI/10.0 ;
          double phi = -3*th ;
          double a = 80 ;
          fEnv("lineWidth", 0.5) ;
          fDisk(0, 0, a, a, CLOSED) ;
          fEnv("lineWidth", 1.0) ;
          fDisk(3*a*Math.cos(th)/4, 3*a*Math.sin(th)/4, a/4, a/4, CLOSED) ;

          fEnv("lineWidth", 0.5) ;
          fLine(0, 0, a*Math.cos(th), a*Math.sin(th)) ;
          double cx = 3*a*Math.cos(th)/4 ;
          double cy = 3*a*Math.sin(th)/4 ;
          double px = cx+a*Math.cos(phi)/4 ;
          double py = cy+a*Math.sin(phi)/4 ;
          fLine(cx, cy, px, py) ;
          canvas.append( new fPsWrite(Red+"\n")) ;
          fEnv("psFillColor", Red) ;
          fDisk(px, py, 4, 4, FILLED) ;
          
//          fTeXlabel(px+3, py-2, "tl", "$P$") ;

     }
}
