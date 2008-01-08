/*
 * Main.java
 *
 * Created on January 7, 2008, 7:29 PM
 *
 */

package regularexpressionbug;

/**
 *
 * @author scott
 */
public class Main {
	
	/** Creates a new instance of Main */
	public Main() {
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		private String beginAirport = "^\\w{3,4} {3,4}airport";
	private boolean isInAirport = false;
	private String endAirport = "^\\w{3,4} {3,4}"
	    
	    
	    Found a bug in the Java regular expression engine!  One of my regular 
expressions was matching "airway"s which is bogus because there was no way 
the regular expression could match that.

Here's what I had it set to:
"^\\w{3,4} {3,4}[^a][^i][^r][^p][^o][^r][^t]"

And stuff like this was not getting filtered:
A007   airway  CMQ MNL
A015   airway  BANNE TDGNY HWTCC ICK SQM RADKY CGL HNS MAGNM DB YXQ DUVOT AES
               DJN
A016   airway  AP 23840 23839 WC
A017   airway  CUN 27552 CQR PVQ

So I ended up changing it to:
"^\\w{3,4} {3,4}"

I like the other version better because it was more precise but the engine was 
obviously not working right because it wasn't matching on 4 letter "airway"s.  
Basically the first expression above means any 3 or 4 letters or numbers 
followed by 3 or 4 spaces and then the word "airport" cannot follow.  So it 
was matching things like:
AAA    weather LINCOLN,IL types: NO METAR UA
AAF    navaid  APALACHICOLA   APALACHICOLA,FL              NDB
       L/L: 2943N/08502W LRN/GPS: 29-43.40N/085-01.68W Elev: 18
       fss: GNV(GAINESVILLE) artcc: JACKSONVILLE Notams: GNV
       Freq: 349 Mag Var: 02W
POE1   navaid  NORTH   FORT POLK,LA                        FAN MARKER
       L/L: 3107N/09313W LRN/GPS: 31-06.66N/093-13.19W Elev: 0
       fss: DRI(DE RIDDER) artcc: HOUSTON Notams: DRI
       Freq:   Mag Var: 07E
ARV    Notam(s) active for ARV
AR3    airway  ZQA BARTS ANGLL NUCAR SCOBY 21337 CARPS PERIE 14865 OLDEY PANAL
               14857 21333 CLB
AR4    airway  CH METTA 14864 14858 MILOE OLDEY
AR5    airway  JA JAWSS BAHAA TORRY 14862 14863 SNABS OZENA OHLAA CARPS TROUT
AR6    airway  ORL 25346 MALET APOLO HIBAC HALSS HOBEE
AR8    airway  ECG OHPEA 00060 BACUS
AR9    airway  ORF BAATT NAGGI FUMES MEYRA ATLIC KENSI 00061 OUTES ETMEY DELPP
               CUMBY CROAK ZIBUT


But not matching things like:
A015   airway  BANNE TDGNY HWTCC ICK SQM RADKY CGL HNS MAGNM DB YXQ DUVOT AES
               DJN
A016   airway  AP 23840 23839 WC
A017   airway  CUN 27552 CQR PVQ
M450   airway  KARLL 10031 COALL
M451   airway  ARBEZ 14472 JESRU
M452   airway  HARVZ TAYTA
M765   airway  OLBIE 28948 ROR KEONE


I may see if there is a bug fix version that's been released and if not report 
it to Sun Microsystems.  What a pain tracking that one down!

I'm attaching another filtered file.  Throw the other one out.  Sorry for the 
mistake.  Hopefully I won't catch any others.  This file size is slightly 
smaller, 8,339,393 bytes which seems to match what I saw compared to the 
previous file at 8,397,820 bytes.  

It was weird because not all airways got through.  Only 4 letter ones.  3 
letter ones properly matched and were filtered.  Strange.  I can see why this 
one got through QA.  It's very subtle.
	}
	
}
