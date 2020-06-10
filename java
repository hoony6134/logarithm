import java.io.*;
import java.text.*;

public class logtab {
  
/*method*/ public static void main(String args[]) {
  try {

DecimalFormat df=new DecimalFormat("###.########");

DataOutput f2=new DataOutputStream(new FileOutputStream(args[0]));

f2.writeBytes(" x         log(x)\r\n");

double x=1.0;
double dx=0.001;
double dx2=dx*dx;
double dx3=dx2*dx;
double dx4=dx3*dx;
double dx5=dx4*dx;
double dx6=dx5*dx;
double dx7=dx6*dx;

double nlog=0.0; /*natural logarithm*/
 
for (int i=1; i<=9001; i++) {
  double x2=x*x;
  double x3=x2*x;
  double x4=x3*x;
  double x5=x4*x;
  double x6=x5*x;
  double x7=x6*x;

  double log10=nlog*0.434294482; /*convert natural logarithm 
                                   to base 10 logarithm*/ 

  String xs=df.format(x);
       if (xs.length()==1) {xs+="    ";}
  else if (xs.length()==2) {xs+="   ";}
  else if (xs.length()==3) {xs+="  ";}
  else if (xs.length()==4) {xs+=" ";}

  /*output*/
  f2.writeBytes(xs+"    "+df.format(log10)+"\r\n");

  if ((i%10)==0) f2.writeBytes(" \r\n");

  /*natural logarithm approximation using Taylor series*/ 
  nlog+=dx/x-dx2/(2*x2)+dx3/(3*x3)-dx4/(4*x4)+dx5/(5*x5)
                        -dx6/(6*x6)+dx7/(7*x7);

  x+=dx;
                  } /*end i loop*/

       } catch (Exception ex) {String err=ex.toString();
                               System.out.print(err);}
} /*end main*/
} /*end logtab*/
