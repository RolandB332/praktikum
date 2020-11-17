package de.hfu;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	String text;
    	Scanner tastatur = new Scanner(System.in);
        System.out.println( "Zeichenkette eingebe" );
        text = tastatur.next();
        System.out.println( text.toUpperCase() );
    }
}
