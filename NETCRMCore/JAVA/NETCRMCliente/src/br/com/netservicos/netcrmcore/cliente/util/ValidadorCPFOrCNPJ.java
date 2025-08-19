package br.com.netservicos.netcrmcore.cliente.util;

import br.com.netservicos.netcrmcore.geral.util.GeralUtil;

public class ValidadorCPFOrCNPJ {
	
	private static final int CPFLENGTH = 11;
	private static final int CNPJLENGTH = 14;
	
	public static boolean isValidCPF(String cpf) {
		return isCPF(cpf) && isValid(cpf);
	}
	
	public static boolean isValidCNPJ(String cnpj) {
		return isCNPJ(cnpj) && isValid(cnpj);
	}

	private static boolean isCPF(String cpf) {
		String n = removerFormatacao(cpf);
		boolean isCpf = n.length() == CPFLENGTH;
		
		return isCpf;
	}
	
	private static boolean isCNPJ(String cnpj) {
		String n = removerFormatacao(cnpj);
		boolean isCnpj = n.length() == CNPJLENGTH;
		
		return isCnpj;
	}
	
	public static String removerFormatacao(String cpfOrCnpj) {
		if (cpfOrCnpj != null) {
			return cpfOrCnpj.replaceAll("[-./]*", "");
		}
		return null;
	}
	
	private static boolean isValid(String cpfOrCnpj) {
		try{
			if (GeralUtil.isNull(cpfOrCnpj)){
				return false;
			}			
			String n = removerFormatacao(cpfOrCnpj);
			boolean isCnpj = n.length() == CNPJLENGTH;
			boolean isCpf = n.length() == CPFLENGTH;
			if (!isCpf && !isCnpj){
				return false;
			}		
			int i;
			int j; // just count
			int digit; // A number digit
			int coeficient; // A coeficient
			int sum; // The sum of (Digit * Coeficient)
			int[] foundDv = { 0, 0 }; // The found Dv1 and Dv2
			int dv1 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 2)));
			int dv2 = Integer.parseInt(String.valueOf(n.charAt(n.length() - 1)));
			for (j = 0; j < 2; j++) {
				sum = 0;
				coeficient = 2;
				for (i = n.length() - 3 + j; i >= 0; i--) {
					digit = Integer.parseInt(String.valueOf(n.charAt(i)));
					sum += digit * coeficient;
					coeficient++;
					if (coeficient > 9 && isCnpj){
						coeficient = 2;
					}
				}
				foundDv[j] = 11 - sum % 11;
				if (foundDv[j] >= 10){
					foundDv[j] = 0;
				}
			}
			return dv1 == foundDv[0] && dv2 == foundDv[1];
		
		}catch (Exception ex){
			return false;
		}
	}
}
