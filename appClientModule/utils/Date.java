package utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Date {
	public static boolean isValid(int jour, int mois, int annee) {
		final Set<Integer> mois31 = new HashSet<>(Arrays.asList(new Integer[] {1, 3, 5, 7, 8, 10, 12})); 
		final Set<Integer> mois30 = new HashSet<>(Arrays.asList(new Integer[] {4, 6, 9, 11}));
		
		if (mois31.contains(mois)) {
			if( 0 < jour && jour <= 31 ) {
				return true;
			};
		} else if (mois30.contains(mois)) {
			if( 0 < jour && jour <= 30 ) {
				return true;
			};
		} else if (mois == 2) {
			if(annee%4 == 0 && jour > 0 && jour <= 29) {
				return true;
			} else if (jour > 0 && jour <= 28) {
				return true;
			}
		}
		return false;
	}
}
