import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ReplaceRegex {
	public static void main (String[] args)throws IOException{
		File companyFile=new File("C:\\OnWork\\被收购公司名.txt");
		FileReader rd = new FileReader(companyFile);
		BufferedReader br = new BufferedReader(rd);
		String line = null;
		Pattern p = Pattern.compile("\\D{1,10}(\\d{1,3}.*\\d{0,2}%\\D{0,5}((股份)|(股权)))");
		File outputFile = new File("C:\\OnWork\\被收购公司名_processed.txt");
		outputFile.delete();
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true));
		String testInvisibleString ="上海天衍禾律师事务所 \n";
		String testInvisibleString1="北京华联律师事务所郑州分所　";

		while((line = br.readLine())!=null){
			Matcher matcher = p.matcher(line);			
			bw.newLine();
			if(matcher.find()){
				StringBuffer sb = new StringBuffer(matcher.group(1));
				matcher.appendReplacement(sb, "");	
				line=line.replace(matcher.group(1), "");
			}
			bw.write(line);		
		}		
	}
}
