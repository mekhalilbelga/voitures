// for more information, please visit : http://prodageo.insa-rouen.fr/wiki/pmwiki.php?n=FilRouge.CoderTransactionScript

package com.hellokoding.persistance;

import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

// types retournés par les opérations JDBC
import java.sql.ResultSet;
import java.sql.SQLException;

// pour simuler la presence d'un SGBD et de la base (mock) 
import commondb.mock.CSVLineSplitter ;
import commondb.mock.MockResultSet ;
import java.io.StringReader;

// pour journaliser
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

public class txnscript {

	int compteurAssocies = 3 ; // nombre d'enregistrements de la table Associes au démarrage (cf nombre de associesTableLine[xx dans remonterEnrAssocies)
	int compteurReservations = 0 ;
	Logger logger = LoggerFactory.getLogger(txnscript.class);
	
 // Pour la syntaxe et la sémantique des noms des opérations, voir
 // http://prodageo.insa-rouen.fr/wiki/pmwiki.php?n=FilRouge.CoderTransactionScript

 // des exemples de fonctions attendus dans de ce fichier sont fournis dans
 // http://prodageo.insa-rouen.fr/wiki/pmwiki.php?n=Umlp.EXU9912txnscript
 

   // ******************* simulation de la table Associes ************************************** //
   String associesTableHeader ;   
   private static HashMap<Integer, String> associesTableLine = new HashMap<Integer, String>();
   

   public txnscript()
   {
	associesTableHeader = "\"id\",\"birthdate\",\"firstname\",\"surname\",\"email_address\"\r" ;   

	// on suppose que la base contient 3 associés
	associesTableLine.put ( 1, "1,2000-03-01,\"Mickey\",\"DISNEY\",\"mickey@example.com\"" ) ;
	associesTableLine.put ( 2, "2,2000-05-06,\"Minnie\",\"DISNEY\",\"minnie@example.com\"" ) ;
	associesTableLine.put ( 3, "3,2010-12-21,\"Junior\",\"DISNEY\",\"junior@example.com\"" ) ;
	associesTableLine.put ( 4, "4,2020-11-09,\"Lucky\",\"LUKE\",\"luvky@example.com\"" ) ;
   }


 

   
  public int creerAssocie ( String firstname, String lastname, String email_address ) 
  {
	compteurAssocies = compteurAssocies + 1 ;
	Integer newid = compteurAssocies ;
	// pour simplifier l'exemple, on met toujours la même date de naissance : 2000-03-01
	String newline = newid + "," + "2000-03-01," + "\"" + firstname + "\",\"" + lastname + "\",\"" + email_address + "\"" ;
	associesTableLine.put ( newid, newline ) ;	
    return newid ; // id de la nouvelle ligne
  }
	
  public int detruireAssocie ( Integer id ) 
  {
	String removedLine = associesTableLine.remove(id) ;
    return id ;
  }


	public ResultSet remonterEnrAssocies ( ) throws Exception
	{


	  // exemple d'utilisation a faire dans HelloController.java
	  /*
		 ResultSet rsTestLocal = new MockResultSet( associesTableHeader , associesTableLine.get(1) , associesTableLine.get(2) , associesTableLine.get(3) ); 
  
	  logger.info( "remonterEnrReservation : ResultSet rsTestLocal initialized" ) ;
	  while ( rsTestLocal.next() )
	  {
	   String email_address = rsTestLocal.getString ( "email_address" ) ;
	   logger.info( "remonterEnrReservation email_address : " + email_address);
	  }
	  rsTestLocal.close() ;
	  */
  
	  String all_lines = "" ;
	  for (Integer i : associesTableLine.keySet()) 
	  {
		all_lines = all_lines + associesTableLine.get(i) + "\n"  ;
	  }

	  ResultSet rs = new MockResultSet( associesTableHeader , all_lines ); 
	  return rs ;

	}
  // ******************* fin de simulation de la table Associes ************************************** //  


  // ******************* simulation de la table Reservations ************************************** //


  public int creerEnrReservation ( String id_associe, Date date_arrivee ) 
  {
	compteurReservations = compteurReservations + 1 ;
        return compteurReservations ;
  }

  public ResultSet remonterEnrReservation ( String emailAddress ) throws Exception
  {
   	ResultSet rs = null ; 
	return rs ;
  }

  // ******************* fin de simulation de la table Reservations ************************************** //



  
}
