package br.com.netservicos.netcrmcore.cliente.util;

public class ValidatorInscricaoEstadual {
	/**
	 * Validação do número de incrição estadual do Acre.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEAC(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 13) {
			return false;
		}
		int b = 4;
		int soma = 0;
		for (int i = 0; i <= 10; i++) {
			soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * b;
			--b;
			if (b == 1) {
				b = 9;
			}
		}
		int dig = 11 - (soma % 11);
		if (dig >= 10) {
			dig = 0;
		}
		if (!(dig == Integer.parseInt(String.valueOf(ie.charAt(11))))) {
			return false;
		} else {
			b = 5;
			soma = 0;
			for (int i = 0; i <= 11; i++) {
				soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * b;
				--b;
				if (b == 1) {
					b = 9;
				}
			}
			dig = 11 - (soma % 11);
			if (dig >= 10) {
				dig = 0;
			}
			if (dig == Integer.parseInt(String.valueOf(ie.charAt(12)))) {
				return true;
			}
				return false;

		}
	} // AC

	/**
	 * Validação do número de incrição estadual do Alagoas.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEAL(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * b;
			--b;
		}
		soma *= 10;
		int aux = soma / 11;
		int dig = soma - aux * 11;
		if (dig == 10) {
			dig = 0;
		}
		return (dig == Integer.parseInt(String.valueOf(ie.charAt(8))));

	}

	/**
	 * Validação do número de incrição estadual do Amazonas.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEAM(String ie) {
		int dig = 0;
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9){
			return false;
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += Integer.parseInt(String.valueOf(ie.charAt(i))) * b;
			b--;
		}

		if (soma < 11) {
			dig = 11 - soma;
		} else {
			int i = soma % 11;
			if (i <= 1) {
				dig = 0;
			} else {
				dig = 11 - i;
			}
		}
		return (dig == Integer.parseInt(String.valueOf(ie.charAt(8))));
	}

	/**
	 * Validação do número de incrição estadual do Amapa.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEAP(String ie) {

		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int p = 0;
		int d = 0;
		int i = Integer.parseInt(ie.substring(1, 8));
		if ((i >= 3000001) && (i <= 3017000)) {
			p = 5;
			d = 0;
		} else if ((i >= 3017001) && (i <= 3019022)) {
			p = 9;
			d = 1;
		}
		int b = 9;
		int soma = p;
		for (int x = 0; i <= 7; i++) {
			soma += Integer.parseInt(String.valueOf(ie.charAt(x))) * b;
			b--;
		}
		int dig = 11 - (soma % 11);
		if (dig == 10) {
			dig = 0;
		} else if (dig == 11) {
			dig = d;
		}
		return (dig == Integer.parseInt(String.valueOf(ie.charAt(8))));
	}

	/**
	 * Validação do número de incrição estadual do Bahia.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEBA(String ie) {

		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 8){
			return false;
		}
		String die = ie.substring(0, 8);
		int[] nro = new int[8];
		int dig = -1;
		for (int i = 0; i <= 7; i++) {
			nro[i] = Integer.parseInt(String.valueOf(die.charAt(i)));
		}
		int numMod = 0;
		if (nro[0] != 7 && nro[0] != 9){
			numMod = 10;
		}else {
			numMod = 11;
		}
		int b = 7;
		int soma = 0;
		for (int i = 0; i <= 5; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % numMod;
		if (numMod == 10) {
			if (i == 0) {
				dig = 0;
			} else {
				dig = numMod - i;
			}
		} else {
			if (i <= 1) {
				dig = 0;
			} else {
				dig = numMod - i;
			}
		}
		boolean resultado = (dig == nro[7]);
		if (!resultado) {
			return false;
		}
		b = 8;
		soma = 0;
		for (i = 0; i <= 5; i++) {
			soma += nro[i] * b;
			b--;
		}
		soma += nro[7] * 2;
		i = soma % numMod;
		if (numMod == 10) {
			if (i == 0) {
				dig = 0;
			} else {
				dig = numMod - i;
			}
		} else {
			if (i <= 1) {
				dig = 0;
			} else {
				dig = numMod - i;
			}
		}
		return (dig == nro[6]);
	} // ba

	/**
	 * Validação do número de incrição estadual do Ceará.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIECE(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() > 9){
			return false;
		}
		String die = ie;
		if (ie.length() < 9) {
			while (die.length() <= 8) {
				die = '0' + die;
			}
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(die.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int dig = 11 - (soma % 11);
		if (dig >= 10){
			dig = 0;
		}
		return (dig == nro[8]);
	} // ce

	/**
	 * Validação do número de incrição estadual do Distrito Federal.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEDF(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 13){
			return false;
		}
		int[] nro = new int[13];
		for (int i = 0; i <= 12; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 4;
		int soma = 0;
		for (int i = 0; i <= 10; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 1){
				b = 9;
			}
		}
		int dig = 11 - (soma % 11);
		if (dig >= 10){
			dig = 0;
		}
		boolean resultado = (dig == nro[11]);
		if (!resultado){
			return false;
		}
		b = 5;
		soma = 0;
		for (int i = 0; i <= 11; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 1) {
				b = 9;
			}
		}
		dig = 11 - (soma % 11);
		if (dig >= 10){
			dig = 0;
		}
		return (dig == nro[12]);
	}

	/**
	 * Validação do número de incrição estadual do Espirito Santo.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIEES(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9){		
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
				soma += nro[i] * b;
				b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i < 2){
			dig = 0;
		} else{
			dig = 11 - i;
		}
		return (dig == nro[8]);
}


	/**
	 * Validação do número de incrição estadual do Espirito Santo.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEGO(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9){
			return false;
		}
		
		int s = Integer.parseInt(ie.substring(0, 2));
		if ((s == 10) || (s == 11) || (s == 15)) {
			int[] nro = new int[9];
			for (int i = 0; i <= 8; i++){
				nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
			}
			int n = new Integer(ie) / 10;
			if (n == 11094402) {
				if ((nro[8] == 0) || (nro[8] == 1)) {
					return true;
				}
			}
			int b = 9;
			int soma = 0;
			for (int i = 0; i <= 7; i++) {
				soma += nro[i] * b;
				b--;
			}
			int i = soma % 11;
			int dig = 0;
			if (i == 0){
				dig = 0;
			} else {
				if (i == 1) {
					if ((n >= 10103105) && (n <= 10119997)){
						dig = 1;
					} else {
						dig = 0;
					}
				} else {
					dig = 11 - i;
				}
			}
			return (dig == nro[8]);
		} else {
			return false;
		}
		
}

	/**
	 * Validação do número de incrição estadual do Maranhão.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEMA(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9){
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Mato Grosso.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEMT(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() < 9) {
			return false;
		}
		String die = ie;
		if (die.length() < 11) {
			while (die.length() <= 10) {
				die = '0' + die;
			}
			int[] nro = new int[11];
			for (int i = 0; i <= 10; i++){
				if (!die.isEmpty()){
				nro[i] = Integer.parseInt(String.valueOf(die.charAt(i)));
				}
			}
			int b = 3;
			int soma = 0;
			for (int i = 0; i <= 9; i++) {
				soma += nro[i] * b;
				b--;
				if (b == 1) {
					b = 9;
				}
			}
			int i = soma % 11;
			int dig = 0;
			if (i <= 1) {
				dig = 0;
			} else {
				dig = 11 - i;
			}
			return (dig == nro[10]);
		} else {
			return false;
		}
	}

	/**
	 * Validação do número de incrição estadual do Mato Grosso do Sul.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEMS(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		if (!ie.substring(0, 2).equals("28")) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Pará.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIEPA(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		if (!ie.substring(0, 2).equals("15")) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Paraíba.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIEPB(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Paraná.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEPR(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 10) {
			return false;
		}
		int[] nro = new int[10];
		for (int i = 0; i <= 9; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 3;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 1) {
				b = 7;
			}
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		boolean resultado = (dig == nro[8]);
		if (!resultado) {
			return false;
		}
		b = 4;
		soma = 0;
		for (i = 0; i <= 8; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 1) {
				b = 7;
			}
		}
		i = soma % 11;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[9]);
	}

	/**
	 * Validação do número de incrição estadual do Pernambuco.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIEPE(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 14) {
			return false;
		}
		int[] nro = new int[14];
		for (int i = 0; i <= 13; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 5;
		int soma = 0;
		for (int i = 0; i <= 12; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 0) {
				b = 9;
			}
		}
		int dig = 11 - (soma % 11);
		if (dig > 9) {
			dig = dig - 10;
		}
		return (dig == nro[13]);
	}

	/**
	 * Validação do número de incrição estadual do Piauí.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIEPI(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Rio de Janeiro.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean CheckIERJ(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 8) {
			return false;
		}
		int[] nro = new int[8];
		for (int i = 0; i <= 7; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 2;
		int soma = 0;
		for (int i = 0; i <= 6; i++) {
			soma += nro[i] * b;
			b--;
			if (b == 1) {
				b = 7;
			}
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[7]);
	}

	/**
	 * Validação do número de incrição estadual do Rio Grande do Norte.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIERN(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		soma *= 10;
		int dig = soma % 11;
		if (dig == 10) {
			dig = 0;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Rio Grande do Sul.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIERS(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 10) {
			return false;
		}
		int i = Integer.parseInt(ie.substring(0, 3));
		if ((i >= 1) && (i <= 467)) {
			int[] nro = new int[10];
			for (int x = 0; i <= 9; i++) {
				nro[x] = Integer.parseInt(String.valueOf(ie.charAt(x)));
			}
			int b = 2;
			int soma = 0;
			for (i = 0; i <= 8; i++) {
				soma += nro[i] * b;
				b--;
				if (b == 1) {
					b = 9;
				}
			}
			int dig = 11 - (soma % 11);
			if (dig >= 10) {
				dig = 0;
			}
			return (dig == nro[9]);
		} else {
			return false;
		}
	}

	/**
	 * Validação do número de incrição estadual do Rondonia Antigo.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEROantigo(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}

		int[] nro = new int[9];
		int b = 6;
		int soma = 0;

		for (int i = 3; i <= 8; i++) {

			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));

			if (i != 8) {
				soma = soma + (nro[i] * b);
				b--;
			}

		}

		int dig = 11 - (soma % 11);
		if (dig >= 10) {
			dig = dig - 10;
		}

		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Rondonia Atual.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIERO(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 14) {
			return false;
		}
		int[] nro = new int[14];
		int b = 6;
		int soma = 0;
		for (int i = 0; i <= 4; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
			soma = soma + (nro[i] * b);
			b--;
		}
		b = 9;
		for (int i = 5; i <= 13; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
			if (i != 13) {
				soma = soma + (nro[i] * b);
				b--;
			}
		}
		int dig = 11 - (soma % 11);
		if (dig >= 10) {
			dig = dig - 10;
		}
		return (dig == nro[13]);
	}

	/**
	 * Validação do número de incrição estadual do Roraima.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIERR(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		if (!ie.substring(0, 2).equals("24")) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int soma = 0;
		int n = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * ++n;
		}
		int dig = soma % 9;
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Santa Catarina.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIESC(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int i = soma % 11;
		int dig = 0;
		if (i <= 1) {
			dig = 0;
		} else {
			dig = 11 - i;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do São Paulo.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIESP(String ie) {
		if (ie.charAt(0) == 'P' || ie.charAt(0) == 'p') {
			char[] removeCharactersEspeciais = ie.toCharArray();
			ie = "";
			for (int i = 0; i < removeCharactersEspeciais.length; i++) {
				if (removeCharactersEspeciais[i] != '-'
						&& removeCharactersEspeciais[i] != '.'
						&& removeCharactersEspeciais[i] != '/') {
					ie += removeCharactersEspeciais[i];
				}
			}
			ie = ie.trim();
			String s = ie.substring(1, 9);
			int[] nro = new int[12];
			for (int i = 0; i <= 7; i++) {
				nro[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
			}
			int soma = (nro[0] * 1) + (nro[1] * 3) + (nro[2] * 4)
					+ (nro[3] * 5) + (nro[4] * 6) + (nro[5] * 7) + (nro[6] * 8)
					+ (nro[7] * 10);
			int dig = soma % 11;
			if (dig >= 10) {
				dig = 0;
			}
			boolean resultado = (dig == nro[8]);
			if (!resultado) {
				return false;
			}
		} else {
			if (ie.length() < 12) {
				return false;
			}
			int[] nro = new int[12];
			for (int i = 0; i <= 11; i++) {
				nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
			}
			int soma = (nro[0] * 1) + (nro[1] * 3) + (nro[2] * 4)
					+ (nro[3] * 5) + (nro[4] * 6) + (nro[5] * 7) + (nro[6] * 8)
					+ (nro[7] * 10);
			int dig = soma % 11;
			if (dig >= 10) {
				dig = 0;
			}
			boolean resultado = (dig == nro[8]);
			if (!resultado) {
				return false;
			}
			soma = (nro[0] * 3) + (nro[1] * 2) + (nro[2] * 10) + (nro[3] * 9)
					+ (nro[4] * 8) + (nro[5] * 7) + (nro[6] * 6) + (nro[7] * 5)
					+ (nro[8] * 4) + (nro[9] * 3) + (nro[10] * 2);
			dig = soma % 11;
			if (dig >= 10) {
				dig = 0;
			}
			return (dig == nro[11]);
		}
		return false;
	}

	/**
	 * Validação do número de incrição estadual do Sergipe.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIESE(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}
		int[] nro = new int[9];
		for (int i = 0; i <= 8; i++) {
			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
		}
		int b = 9;
		int soma = 0;
		for (int i = 0; i <= 7; i++) {
			soma += nro[i] * b;
			b--;
		}
		int dig = 11 - (soma % 11);
		if (dig >= 10) {
			dig = 0;
		}
		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Tocantins Atual.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIETO(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 9) {
			return false;
		}

		int[] nro = new int[9];
		int b = 9;
		int soma = 0;

		for (int i = 0; i <= 8; i++) {

			nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));

			if (i != 8) {
				soma = soma + (nro[i] * b);
				b--;
			}
		}
		int ver = soma % 11;
		int dig = 0;
		if (ver < 2) {
			dig = 0;
		}
		if (ver >= 2) {
			dig = 11 - ver;
		}

		return (dig == nro[8]);
	}

	/**
	 * Validação do número de incrição estadual do Tocantins Antigo.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIETOantigo(String ie) {
		try {
			Long.valueOf(ie);
		} catch (Exception e) {
			return false;
		}
		if (ie.length() != 11) {
			return false;
		}
		int[] nro = new int[11];
		int b = 9;
		int soma = 0;
		String s = ie.substring(2, 4);
		if (!s.equals("01") || !s.equals("02") || !s.equals("03") || !s.equals("99")) {
			for (int i = 0; i <= 10; i++) {
				nro[i] = Integer.parseInt(String.valueOf(ie.charAt(i)));
				if (i != 3 || i != 4) {
					soma = soma + (nro[i] * b);
					b--;
				} // if ( i != 3 || i != 4 )
			} // fecha for
			int resto = soma % 11;
			int dig = 0;
			if (resto < 2) {
				dig = 0;
			}
			if (resto >= 2) {
				dig = 11 - resto;
			}
			return (dig == nro[10]);
		} else {
			return false;
		}
	}

	/**
	 * Validação do número de incrição estadual de Minas Gerais.
	 * 
	 * @param ie
	 * @return
	 */
	public static boolean checkIEMG(String ie) {
		if (ie.substring(0, 2).equals("PR")) {
			return true;
		}
		if (ie.substring(0, 5).equals("ISENT")){
			return true;
		}
		if (ie.length() != 13) {
			return false;
		}
		String dig1 = ie.substring(11, 12);
		String dig2 = ie.substring(12, 13);
		String inscC = ie.substring(0, 3) + "0" + ie.substring(3, 11);
		String[] insc = inscC.split("");
		int npos = 11;
		int i = 1;
		int ptotal = 0;
		int psoma = 0;
		while (npos >= 0) {
			i++;
			psoma = Integer.parseInt(insc[npos]) * i;
			if (psoma >= 10){
				psoma -= 9;
			}
			ptotal += psoma;
			if (i == 2){
				i = 0;
			}
			npos--;
		}
		int nresto = ptotal % 10;
		if (nresto == 0){
			nresto = 10;
		}
		nresto = 10 - nresto;
		if (nresto != Integer.parseInt(dig1)){
			return false;
		}
		npos = 11;
		i = 1;
		ptotal = 0;
		String[] is = ie.split("");
		while (npos >= 0) {
			i++;
			if (i == 12){
				i = 2;
			}
			ptotal += Integer.parseInt(is[npos]) * i;
			npos--;
		}
		nresto = ptotal % 11;
		if ((nresto == 0) || (nresto == 1)) {
			nresto = 11;
		}
		nresto = 11 - nresto;
		return (nresto == Integer.parseInt(dig2));
	}
	
	/**
	 * 
	 * Valida uma Inscrição Estadual conforme o estado do Orgao Expedidor informado.
	 * 
	 * @param ie
	 * @param orgaoExpedidor
	 * @return
	 * 
	 * @since 09/01/2010
	 */
	public static boolean checkIETodos(String ie, String orgaoExpedidor) {
		boolean isValid = false;
		
		if ("SSP-SP".equals(orgaoExpedidor)) {
			isValid = checkIESP(ie);
		} else if ("SSP-RJ".equals(orgaoExpedidor)) {
			isValid = CheckIERJ(ie);
		} else if ("SSP-MG".equals(orgaoExpedidor)) {
			isValid = checkIEMG(ie);
		} else if ("SSP-RS".equals(orgaoExpedidor)) {
			isValid = checkIERS(ie);
		} else if ("SSP-PR".equals(orgaoExpedidor)) {
			isValid = checkIEPR(ie);
		} else if ("SSP-SC".equals(orgaoExpedidor)) {
			isValid = checkIESC(ie);
		} else if ("SSP-ES".equals(orgaoExpedidor)) {
			isValid = CheckIEES(ie);
		} else if ("SSP-BA".equals(orgaoExpedidor)) {
			isValid = checkIEBA(ie);
		} else if ("SSP-SE".equals(orgaoExpedidor)) {
			isValid = checkIESE(ie);
		} else if ("SSP-AL".equals(orgaoExpedidor)) {
			isValid = checkIEAL(ie);
		} else if ("SSP-PE".equals(orgaoExpedidor)) {
			isValid = CheckIEPE(ie);
		} else if ("SSP-PB".equals(orgaoExpedidor)) {
			isValid = CheckIEPB(ie);
		} else if ("SSP-RN".equals(orgaoExpedidor)) {
			isValid = checkIERN(ie);
		} else if ("SSP-CE".equals(orgaoExpedidor)) {
			isValid = checkIECE(ie);
		} else if ("SSP-PI".equals(orgaoExpedidor)) {
			isValid = CheckIEPI(ie);
		} else if ("SSP-MA".equals(orgaoExpedidor)) {
			isValid = checkIEMA(ie);
		} else if ("SSP-AM".equals(orgaoExpedidor)) {
			isValid = checkIEAM(ie);
		} else if ("SSP-TO".equals(orgaoExpedidor)) {
			isValid = checkIETO(ie) || checkIETOantigo(ie);
		} else if ("SSP-DF".equals(orgaoExpedidor)) {
			isValid = checkIEDF(ie);
		} else if ("SSP-AC".equals(orgaoExpedidor)) {
			isValid = checkIEAC(ie);
		} else if ("SSP-MT".equals(orgaoExpedidor)) {
			isValid = checkIEMT(ie);
		} else if ("SSP-MS".equals(orgaoExpedidor)) {
			isValid = checkIEMS(ie);
		} else if ("SSP-GO".equals(orgaoExpedidor)) {
			isValid = checkIEGO(ie);
		} else if ("SSP-RO".equals(orgaoExpedidor)) {
			isValid = checkIERO(ie) || checkIEROantigo(ie);
		} else if ("SSP-RR".equals(orgaoExpedidor)) {
			isValid = checkIERR(ie);
		} else if ("SSP-AP".equals(orgaoExpedidor)) {
			isValid = checkIEAP(ie);
		}
		
		return isValid;
	}
}
