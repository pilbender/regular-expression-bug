/*
 * Main.java
 *
 * Created on January 7, 2008, 7:29 PM
 *
 */

package regularexpressionbug;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String working_regex = "^\\w{3,4} {3,4}airport";
		String simplified_regex = "^\\w{3,4}\\W{3,4}";
		String bug_regex = "^\\w{3,4}\\W{3,4}[^a][^i][^r][^p][^o][^r][^t]";
		
		// Stuff like this is not getting filtered:
		String broken1 = "A007   airway  CMQ MNL";
		String broken2 = "A015   airway  BANNE TDGNY HWTCC ICK SQM RADKY CGL HNS MAGNM DB YXQ DUVOT AES";
		String broken3 = "A016   airway  AP 23840 23839 WC";
		String broken4 = "A017   airway  CUN 27552 CQR PVQ";
		String broken5 = "M450   airway  KARLL 10031 COALL";
		String broken6 = "M451   airway  ARBEZ 14472 JESRU";
		String broken7 = "M452   airway  HARVZ TAYTA";
		String broken8 = "M765   airway  OLBIE 28948 ROR KEONE";
		
		// Properly filtered
		String working1 = "AAA    weather LINCOLN,IL types: NO METAR UA";
		String working2 = "AAF    navaid  APALACHICOLA   APALACHICOLA,FL              NDB";
		String working3 = "POE1   navaid  NORTH   FORT POLK,LA                        FAN MARKER";
		String working4 = "ARV    Notam(s) active for ARV";
		String working5 = "AR3    airway  ZQA BARTS ANGLL NUCAR SCOBY 21337 CARPS PERIE 14865 OLDEY PANAL";
		String working6 = "AR4    airway  CH METTA 14864 14858 MILOE OLDEY";
		String working7 = "AR5    airway  JA JAWSS BAHAA TORRY 14862 14863 SNABS OZENA OHLAA CARPS TROUT";
		String working8 = "AR6    airway  ORL 25346 MALET APOLO HIBAC HALSS HOBEE";
		String working9 = "AR8    airway  ECG OHPEA 00060 BACUS";
		String working0 = "AR9    airway  ORF BAATT NAGGI FUMES MEYRA ATLIC KENSI 00061 OUTES ETMEY DELPP";
		
		Pattern bug_regex_pattern = Pattern.compile(bug_regex);
		
		Matcher bug_regex_matcher;
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken1);
		boolean broken1_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken2);
		boolean broken2_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken3);
		boolean broken3_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken4);
		boolean broken4_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken5);
		boolean broken5_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken6);
		boolean broken6_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken7);
		boolean broken7_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(broken8);
		boolean broken8_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working1);
		boolean working1_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working2);
		boolean working2_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working3);
		boolean working3_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working4);
		boolean working4_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working5);
		boolean working5_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working6);
		boolean working6_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working7);
		boolean working7_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working8);
		boolean working8_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working9);
		boolean working9_flag = bug_regex_matcher.lookingAt();
		
		bug_regex_matcher = bug_regex_pattern.matcher(working0);
		boolean working0_flag = bug_regex_matcher.lookingAt();
		
		System.out.println(broken1_flag + ": " + broken1);
		System.out.println(broken2_flag + ": " + broken2);
		System.out.println(broken3_flag + ": " + broken3);
		System.out.println(broken4_flag + ": " + broken4);
		System.out.println(broken5_flag + ": " + broken5);
		System.out.println(broken6_flag + ": " + broken6);
		System.out.println(broken7_flag + ": " + broken7);
		System.out.println(broken8_flag + ": " + broken8);
		
		System.out.println(working1_flag + ": " + working1);
		System.out.println(working2_flag + ": " + working2);
		System.out.println(working3_flag + ": " + working3);
		System.out.println(working4_flag + ": " + working4);
		System.out.println(working5_flag + ": " + working5);
		System.out.println(working6_flag + ": " + working6);
		System.out.println(working7_flag + ": " + working7);
		System.out.println(working8_flag + ": " + working8);
		System.out.println(working9_flag + ": " + working9);
		System.out.println(working0_flag + ": " + working0);
	}
	
}
