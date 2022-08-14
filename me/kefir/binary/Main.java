package me.kefir.binary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	/**
	 * COPYRIGHT
	 * 
	 * This code is created by kefir#7178
	 * any distribution of this code without
	 * mentioning author is illegal!
	 */
	
	public static void main(String[] args) throws IOException {
		File f = new File("binaryResult.txt");
		if(!f.exists()) f.createNewFile();
		FileWriter fw = new FileWriter(f);
		fw.append(convertToBinary("Siemano, jezeli wkleisz to w https://www.rapidtables.com/convert/number/binary-to-ascii.html i wyjdzie ci to samo, to znaczy ze to dziala!"));
		fw.close();
		System.out.println("Result saved to "+f.getAbsolutePath());
	}
	
	public static String convertToBinary(String text) {
		StringBuilder sb = new StringBuilder();
		
		for(int i : text.chars().toArray()) {
			sb.append(binaryOf((char)i)+" ");
		}
		
		return sb.toString();
	}
	
	public static int symbolAmount(int charint) {
		int amt = 1;
		int maxamt = 1;
		while(charint>maxamt) {
			amt++;
			maxamt+=Math.pow(2, amt-1);
		}
		while(amt%4!=0) {
			amt++;
			maxamt+=Math.pow(2, amt-1);
		}
		return amt;
	}
	
	public static String binaryOf(char symbol) {
		StringBuilder sb = new StringBuilder();
		int length = symbolAmount(symbol);
		int id = symbol;
		int r = id;
		int rl = length;
		
		while(rl != 0) {
			int pow = (int) Math.pow(2, rl-1);
			sb.append(pow<=r?"1":"0");
			if(pow<=r) r-=pow;
			rl--;
		}
		
		return sb.toString();
	}
}
