package hrt;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.json.JSONArray;
import org.json.JSONObject;


public class r3 {

	private static String folder="th_bsm_1.10/th_bsm/script/th_bsm";
	private static String newfolder="fw/xx";
	private static String retfolder="fw/xaax";
	private static String fromfolder="fw/xx/xrrx";
	
	

	
	public static void main(String[] args) {
		System.out.println("start:");
		try {
			getwiki();
			bsmtask();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("finish:");
	}
	private static byte[] rimg;
	static{
		try {
			rimg = toByteArray2("ccc/ooo/img.dat");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void img3()throws Exception{
		handleimg("ccc/img 00210.png");
		FileOutputStream fo = new FileOutputStream("ccc/img3.dat");
		fo.write(rimg);
		fo.close();
	}
	
	public static void listimg(String path)throws Exception{
		File f = null;
		f = new File(path);
		//System.out.println(f);
		File[] files = f.listFiles(); 
		
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = path+"/"+files[i].getName();
				//System.out.println("folder:"+newfolderpath);
				listimg(newfolderpath);
			}else{
				handleimg(files[i].getAbsolutePath());
			}
		}
		FileOutputStream fo = new FileOutputStream("ccc/img.dat");
		fo.write(rimg);
		fo.close();
	}
	
	public static void handleimg(String path)throws Exception{
		byte[] newimg = toByteArray2(path);
		byte[] oriimg = toByteArray2("ccc/eee/"+new File(path).getName());
		byte[] matchimg = new byte[1000];
		System.arraycopy(oriimg, 0, matchimg, 0, 1000);
		if(newimg.length>oriimg.length){
			System.out.println("img too large!!"+new File(path).getParentFile().getName()+"/"+new File(path).getName());
			System.out.println("size:"+newimg.length+",max size:"+oriimg.length+"\n");
			FileOutputStream fo = new FileOutputStream("ccc/bigimg/"+new File(path).getName());
			fo.write(newimg);
			fo.close();
			handleimg("ccc/bigimg/new/"+new File(path).getName());
		}else{
			int x=KMP_Index(rimg, oriimg);
			if(x==-1){
				//System.out.println(newimg.length+","+oriimg.length);
				System.out.println("img index match error:"+new File(path).getParentFile().getName()+"/"+new File(path).getName());
			}else{
				byte[] cr = new byte[oriimg.length];
				System.out.println("writing:"+new File(path).getParentFile().getName()+"/"+new File(path).getName());
				System.out.println("startindex:"+x+",length:"+oriimg.length);
				System.arraycopy(newimg, 0, cr, 0, newimg.length);
				System.arraycopy(cr, 0,rimg, x, cr.length);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void imgtest()throws Exception{
		System.out.println("333:");
		byte[] dt = toByteArray2(folder+"/img/img.dat");
		byte[] ct = toByteArray2("ccc/ccc/img 00088.png");
		System.out.println(KMP_Index(dt, ct));
	}
	
	public static void search(byte[] a,byte[] b){
		
	}
	public static String b2str(byte[] x,int max){
		String r="";
		for(int i=0;i<x.length;i++){
			if(r.length()<1){
				r=r+x[i];
			}else{
				r=r+","+x[i];
			}
		}
		return r;
	}
	
	public static void bsmtask() throws Exception{
		hm.put("魔理沙", "魔理沙");
		hm.put("一曜", "一曜");
		hm.put("諏訪子", "诹访子");
		hm.put("神奈子", "神奈子");
		hm.put("早苗", "早苗");
		hm.put("イフォーニア", "伊芙妮娅");
		hm.put("ファブリティス", "法布丽蒂丝");
		hm.put("禰津", "祢津‎");
		hm.put("正邪", "正邪");
		hm.put("菫子", "堇子");
		hm.put("霊夢", "灵梦");
		hm.put("ドレミー", "哆来咪");
		hm.put("フーマ", "芙玛");
		hm.put("上下キー:ステージ＆スペル選択[r]左右キー:難易度選択", "上下键:选择关卡和符卡[r]左右键:选择难度");
		hr.put("上下キー:ステージ＆スペル選択", "上下键:选择关卡和符卡");
		hr.put("左右キー:難易度選択", "左右键:选择难度");
		loadwikifiles();
		listloadfiles(folder,1);
		listloadfiles(folder,2);
		listloadfiles(folder,3);
		
		String bret = "function gettxt(id,type)\r\n";
		bret = bret + "{\r\n";
		bret = bret + "	alternative(id)\r\n";
		bret = bret + cret;
		bret = bret + "}";
		
		File f = new File("xxx/rrr/th_bsm/script/th_bsm/lib/txt.dnh");
		f.getParentFile().mkdirs();
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
	                        new FileOutputStream(f), "x-UTF-16LE-BOM"));  
                writer.write(bret);  
                writer.close(); 
		
	}
	
	public static void getwiki()throws Exception{
		String url1 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E5%8D%9A%E4%B8%BD%E7%81%B5%E6%A2%A6&action=edit&viewsource=1";
		String url2 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E9%9B%BE%E9%9B%A8%E9%AD%94%E7%90%86%E6%B2%99&action=edit&viewsource=1";
		String url3 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E4%B8%9C%E9%A3%8E%E8%B0%B7%E6%97%A9%E8%8B%97&action=edit&viewsource=1";
		String url4 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E5%8D%9A%E4%B8%BD%E7%81%B5%E6%A2%A6Ex&action=edit&viewsource=1";
		String url5 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E9%9B%BE%E9%9B%A8%E9%AD%94%E7%90%86%E6%B2%99Ex&action=edit&viewsource=1";
		String url6="http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%AE%BE%E5%AE%9A%E4%B8%8E%E5%89%A7%E6%83%85/%E4%B8%9C%E9%A3%8E%E8%B0%B7%E6%97%A9%E8%8B%97Ex&action=edit&viewsource=1";
		savewiki(url1, 0);
		savewiki(url2, 0);
		savewiki(url3, 0);
		
		savewiki(url4, 0);
		savewiki(url5, 0);
		savewiki(url6, 0);
		
		String s1 = "http://thwiki.cc/index.php?title=%E6%B3%95%E5%B8%83%E4%B8%BD%E8%92%82%E4%B8%9D&action=edit&viewsource=1";
		String s2 = "http://thwiki.cc/index.php?title=%E9%B9%B0%E8%97%A4%E9%B8%A2%E5%AD%90&action=edit&viewsource=1";
		String s3 = "http://thwiki.cc/index.php?title=%E8%B0%A2%E8%8E%89%E4%BA%9A%C2%B7%E8%8E%B1%E6%8B%89%E5%85%8B&action=edit&viewsource=1";
		String s4 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E8%A7%92%E8%89%B2%E8%AE%BE%E5%AE%9A/%E8%97%A4%E5%8E%9F%E5%A6%B9%E7%BA%A2&action=edit&viewsource=1";
		String s5 = "http://thwiki.cc/index.php?title=%E6%9C%9B%E6%9C%88%E4%B8%80%E6%9B%9C&action=edit&viewsource=1";
		String s6 = "http://thwiki.cc/index.php?title=%E6%98%8E%E6%B4%A5%E7%A5%A2%E6%B4%A5&action=edit&viewsource=1";
		String s7 = "http://thwiki.cc/index.php?title=%E8%8A%99%E7%8E%9B%C2%B7%E7%B1%B3%E7%8F%8A%E6%9C%B5%E6%8B%89&action=edit&viewsource=1";
		
		savespell(s1,1);
		savespell(s2,1);
		savespell(s3,1);
		savespell(s4,1);
		savespell(s5,1);
		savespell(s6,1);
		savespell(s7,1);
		
		String m1 = "http://thwiki.cc/index.php?title=%E6%9D%B1%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E_%EF%BD%9E_Book_of_Star_Mythology./%E9%9F%B3%E4%B9%90&action=edit&viewsource=1";
		String c1 = "http://thwiki.cc/index.php?title=%E6%A8%A1%E6%9D%BF:%E4%B8%9C%E6%96%B9%E9%AD%94%E5%AE%9D%E5%9F%8E%E9%9F%B3%E4%B9%90%E5%90%8D/%E4%B8%AD%E6%96%87&action=edit&viewsource=1";
		
		savespell(m1,2);
		savespell(c1,3);
	}
	
	private static int cc=0;
	private static int cs=10;
	
	public static void savespell(String url,int type)throws Exception{
		System.out.println("loading:"+type+":"+cs);
		String wikihtml = HttpGet(url, "");
		int n1 = wikihtml.indexOf("<textarea");
		int n2 = wikihtml.indexOf("</textarea>");
		String s1 = wikihtml.substring(n1, n2);
		int n3 = s1.indexOf(">");
		String s2 = s1.substring(n3+1);
		String s3 = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4(s2);
		String filepath="xxx/wiki/err.txt";
		if(type==1){
			cs=cs+1;
			filepath = "xxx/wiki/"+cs+".txt";
		}
		if(type==2){
			filepath = "xxx/wiki/"+22+".txt";
		}
		if(type==3){
			filepath = "xxx/wiki/"+23+".txt";
		}
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
	                        new FileOutputStream(filepath)));  
                writer.write(s3);  
                writer.close(); 


	}
	

	public static void savewiki(String url,int type)throws Exception{
		System.out.println("loading:"+cc);
		String wikihtml = HttpGet(url, "");
		int n1 = wikihtml.indexOf("<textarea");
		int n2 = wikihtml.indexOf("</textarea>");
		String s1 = wikihtml.substring(n1, n2);
		int n3 = s1.indexOf(">");
		String s2 = s1.substring(n3+1);
		String s3 = org.apache.commons.lang3.StringEscapeUtils.unescapeHtml4(s2);
		cc=cc+1;
		String filepath = "xxx/wiki/"+cc+".txt";
	        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
	                        new FileOutputStream(filepath)));  
                writer.write(s3);  
                writer.close(); 
	}
	
	public static void loadwikifiles()throws Exception{
		
		loadzhmusicwiki("xxx/wiki/23.txt");
		loadmusicwiki("xxx/wiki/22.txt");
		loadwiki("xxx/wiki/1.txt");
		loadwiki("xxx/wiki/2.txt");
		loadwiki("xxx/wiki/3.txt");
		
		loadwiki("xxx/wiki/6.txt");
		
		loadspellwiki("xxx/wiki/11.txt");
		loadspellwiki("xxx/wiki/12.txt");
		loadspellwiki("xxx/wiki/13.txt");
		loadspellwiki("xxx/wiki/14.txt");
		loadspellwiki("xxx/wiki/15.txt");
		loadspellwiki("xxx/wiki/16.txt");
		loadspellwiki("xxx/wiki/17.txt");
		
		
		

	}
	
	private static HashMap<String, String> hm=new HashMap<>(); 
	private static HashMap<String, String> hr=new HashMap<>(); 
	private static HashMap<String, String> hf=new HashMap<>(); 
	private static HashMap<String, String> zm=new HashMap<>(); 

	private static String cret="";
	
	private static Map<String, String> im = new HashMap<>();
	private static Map<String, Integer> fm = new HashMap<>(); 
	
	private static Map<String, String> sm = new HashMap<>(); 

	private static HashSet<String> ddd = new HashSet<String>(); 
	
	
	public static void readchat() throws Exception{
		String jstr = new String(toByteArray2("fw/2"));
		JSONObject j = new JSONObject(jstr);
		JSONArray ja = j.getJSONArray("d");
		String r = "";
		for(int i=0;i<ja.length();i++){
			JSONArray jda = ja.getJSONArray(i);
			for(int x=0;x<jda.length();x++){
				JSONObject jd = jda.getJSONObject(x);
				r=r+"from:"+jd.getString("h")+"\t";
				r=r+"to:"+jd.getString("to")+"\t";
				r=r+"内容:"+jd.getString("d").replaceAll("\n"," ").replaceAll("\r", " ")+"\t";
				r=r+"时间:"+new Date(jd.getLong("ts")).toLocaleString()+"\t";
				r=r+"\r\n";
				ddd.add(jd.getString("h"));
				ddd.add(jd.getString("to"));
			}
			r=r+"\r\n";
		}
		System.out.println(ddd);
	}
	
	public static void listloadfiles(String folderpath,int step)throws Exception{
		File f = null;
		f = new File(folderpath);
		//System.out.println(f);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				//System.out.println("folder:"+newfolderpath);
				listloadfiles(newfolderpath,step);
			}else{
				if(files[i].getName().endsWith(".txt")||files[i].getName().endsWith(".dnh")){
					if(step==1){
						String ret = readbsm(files[i]);
						if(ret.length()<5){
							
						}else{
							String newpath = files[i].getAbsolutePath().replaceAll("th_bsm_1.10","xxx");
							new File(new File(newpath).getParent()).mkdirs();
						        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
						                        new FileOutputStream(newpath), "utf-8"));  
					                writer.write(ret);  
					                writer.close(); 
						}
					}else if(step==2){
						String newpath = files[i].getAbsolutePath().replaceAll("th_bsm_1.10","xxx");
						File ff= new File(newpath);
						if(ff.exists()){
							loadhr(new File(newpath));
						}
					}else if(step==3){
						String ret = writebsm2(files[i]);
						if(ret.length()<5){
							
						}else{
							String newpath = files[i].getAbsolutePath().replaceAll("th_bsm_1.10","xxx/rrr");
							new File(new File(newpath).getParent()).mkdirs();
						        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(  
						                        new FileOutputStream(newpath),"shift-JIS"));  
					                writer.write(ret);  
					                writer.close(); 
						}
					}
					
				}
			}
		}
	}
	
	public static String togbk(File f) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"shift-JIS"));
		String s;
		String r="";
		while ((s = br.readLine()) != null) {
			r=r+s+"\r\n";
		}
		br.close();
		return r;
	}
	
	public static void loadhr(File f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s;
		while ((s = br.readLine()) != null) {
			int n = s.indexOf("||||");
			String front = s.substring(0,n-1).trim();
			String back = s.substring(n+4).trim();
			if(hm.get(back)==null){
				//System.out.println("not hit!\n"+front);
				//System.out.println(f.getParentFile().getParentFile().getName()+"/"+f.getName());
				hr.put(back, front);
			}else{
				hr.put(back, hm.get(back));
				//System.out.println("hit!\n"+front+"\n"+hm.get(back));
			}
		}
		br.close();
	}
	
	public static void loadzhmusicwiki(String f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s;
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			if(x.startsWith("|")){
				String x1 = x.substring(1).trim();
				if(x1.length()==2){
					String nr =  br.readLine().trim();
					String[] na = nr.split("=");
					if(na.length==2){
						String trans = na[1].trim();
						zm.put("{{东方魔宝城音乐名/中文|"+x1+"}}", trans);
					}else{
						System.out.println("err load zhmusic"+nr);
					}
				}
			}

		}
		br.close();
	}
	
	public static String rmbr(String x){
		String nx="";
		for(int i=0;i<x.length();i++){
			if((x.charAt(i)+"").equals("<")&&((x.charAt(i+1)+"").equals("b"))&&((x.charAt(i+2)+"").equals("r"))){
				int k=0;
				while(!(x.charAt(i+k)+"").equals(">")){
					k++;
				}
				i=i+k;
			}else{
				nx=nx+x.charAt(i);
			}
		}
		return nx;
	}
	
	public static void loadmusicwiki(String f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s;
		String jt=null;
		String jc=null;
		String zc=null;
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			x=rmbr(x);
			
			if(x.startsWith("|")){
				String x1 = x.substring(1).trim();
				if(jc!=null&&zc!=null&&(!x1.startsWith("comment"))&&!x1.startsWith("translation")){
//					System.out.println("jc:"+jc);
//					System.out.println("zc:"+zc);
					hm.put(jc, zc);
					jc=null;
					zc=null;
				}
				if(x1.startsWith("title")){
					String[] x1a = x1.split("=");
					if(x1a.length==2){
						String mtj = x1a[1];
						if(!x1.startsWith("titleZH")){ 
							jt=mtj;
						}else{
//							System.out.println("xxxxxxx"+jt+":"+mtj+":"+zm.get(mtj));
							hm.put(jt, zm.get(mtj));
						}
					}else{
						System.out.println("error x1a");
					}
				}
				if(x1.startsWith("comment")){
					String[] x1a = x1.split("=");
					if(x1a.length==2){
						String mtj = x1a[1];
						jc=mtj;
					}else{
						System.out.println("error x1a");
					}
				}
				if(x1.startsWith("translation")){
					String[] x1a = x1.split("=");
					if(x1a.length==2){
						String mtj = x1a[1];
						zc=mtj;
					}else{
						System.out.println("error x1a");
					}
				}

				
			}else{
				if(jc!=null&&zc==null){
					jc=jc+"[r]"+x;
				}
				if(jc!=null&&zc!=null){
					zc=zc+"[r]"+x;
				}
			}


		}
		br.close();
	}
	
	
	public static void loadspellwiki(String f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s;
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			if(x.indexOf("符卡信息")>0){
				String s1;
				String zs="x";
				String js="x";
				while ((s1 = br.readLine()) != null) {
					if(s1.startsWith("}}")){
						break;
					}
					String s2;
					if(s1.indexOf("<ref")<0){
						s2=s1;
					}else{
						int n1 = s1.indexOf("<ref");
						int n2 = s1.indexOf("</ref>");
						String tails="xxx";
						if(n1>=0&&n2<0){
							String sss;
							while ((sss = br.readLine()) != null) {
								if(sss.indexOf("</ref>")>=0){
									tails = sss.substring(sss.indexOf("</ref>")+6);
									break;
								}
							}
						}else{
							tails = s1.substring(n2+6);
						}
						if(tails.equals("xxx")){
							System.out.println("error tail!!!!!!!!!!!!");
						}
						s2 = s1.substring(0, n1)+tails;
					}
					
					if(s2.indexOf("中文名")>-1){
						int n3 = s2.indexOf("=");
						String s3 = s2.substring(n3+1).trim();
						if(s3.indexOf("color:")>0){
							int n4 = s3.indexOf("|");
							String s4 = s3.substring(n4+1);
							s4=s4.substring(0, s4.length()-2);
							s3=s4;
						}
						
						zs=s3;
					}else if(s2.indexOf("日文名")>-1){
						int n3 = s2.indexOf("=");
						String s3 = s2.substring(n3+1).trim();
						if(s3.indexOf("color:")>0){
							int n4 = s3.indexOf("|");
							String s4 = s3.substring(n4+1);
							s4=s4.substring(0, s4.length()-2);
							s3=s4;
						}
						js=s3;
					}
				}
				sm.put(js, zs);
			}

		}
		br.close();
	}
	
	public static void loadwiki(String f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		String s;
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			ArrayList<String> jt = new ArrayList<String>();
			ArrayList<String> zt = new ArrayList<String>();
			if(x.equals("ja")){
				String s1;
				int ct=0;
				while ((s1 = br.readLine()) != null) {
					if(s1.trim().equals("zh")){
						break;
					}else{
						ct++;
						String z1=s1;
						String z2;
						if(z1.indexOf("<ref")>0){
							int n1 = z1.indexOf("<ref");
							int n2 = z1.indexOf("</ref>");
							z2 = z1.substring(0, n1)+z1.substring(n2+6);
						}else{
							z2 = s1;
						}
						jt.add(z2.trim());
					}
				}
				for(int i=0;i<ct;i++){
					s1 = br.readLine();
					String sr1 = s1.trim();
					String z1 = sr1;
					String z2;
					String z3;
					if(z1.indexOf("<ref")>0){
						int n1 = z1.indexOf("<ref");
						int n2 = z1.indexOf("</ref>");
						z2 = z1.substring(0, n1)+z1.substring(n2+6);
						
//						System.out.println(z1);
//						System.out.println(z2);
					}else{
						z2 = s1;
					}
					
					if(z2.indexOf("<ref")>0){
						int n1 = z2.indexOf("<ref");
						int n2 = z2.indexOf("</ref>");
						z3 = z2.substring(0, n1)+z2.substring(n2+6);
					}else{
						z3 = z2;
					}

					zt.add(z3.trim());
				}
			}
			for(int i=0;i<jt.size();i++){
				String xj = jt.get(i);
				String xz = zt.get(i);
				if(xz.startsWith("BGM: {{")){
//					System.out.println(xz);
//					System.out.println(hm);
//					if(hm.get(xj)!=null){
////						xz=zm.get(xz.substring(4));
//						System.out.println(xj);
//						System.out.println(hm.get(xj));
//					}
					xj="eee";
					xz="eee";
				}
				if(xz.indexOf("<br>")>=0){
					int nz=xz.indexOf("<br>");
					xz = xz.substring(nz+4);
				}
				if(xj.indexOf("ruby")>-1){
					int jn1 = xj.indexOf("{ruby-ja");
					int jn2 = xj.indexOf("}}");
					String front = xj.substring(0, jn1-1);
					String back = xj.substring(jn2+2);
					String middle = xj.substring(jn1+9,jn2);
					String mj1,mj2;
					int mnj = middle.indexOf("|");
					mj1 = middle.substring(0, mnj);
					mj2 = middle.substring(mnj+1);
					
					int zn1 = xz.indexOf("{ruby-cn");
					if(zn1<0){
						String rbj = front + "[ruby rb=\\\""+mj1+"\\\" rt=\\\""+mj2+"\\\"]"+back;
						//System.out.println("ruby not complete:\n"+xj+"\n"+xz+"\n");
						hm.put(rbj, zt.get(i));
					}else{
						int zn2 = xz.indexOf("}}");
						String frontz = xz.substring(0,zn1-1);
						String backz = xz.substring(zn2+2);
						String middlez = xz.substring(zn1+9,zn2);
						String mz1,mz2;
						int mnz = middlez.indexOf("|");
						mz1 = middlez.substring(0, mnz);
						mz2 = middlez.substring(mnz+1);
//						System.out.println(xj);
//						System.out.println(front+","+mj1+","+mj2+","+back);
//						System.out.println(xz);
//						System.out.println(frontz+","+mz1+","+mz2+","+backz);
						
//						私たちの[ruby rb=\"優性遺伝結界\" rt=\"　メンデルス・ゾーン　\"]の中で、
						String rbj = front + "[ruby rb=\\\""+mj1+"\\\" rt=\\\""+mj2+"\\\"]"+back;
						String rbz = frontz + "[ruby rb=\\\""+mz1+"\\\" rt=\\\""+mz2+"\\\"]"+backz;
						hm.put(rbj,rbz);
					}
					
				}else if(xz.indexOf("ruby")>-1){
					int zn1 = xz.indexOf("{ruby-cn");
					int zn2 = xz.indexOf("}}");
					String frontz = xz.substring(0,zn1-1);
					String backz = xz.substring(zn2+2);
					String middlez = xz.substring(zn1+9,zn2);
					String mz1,mz2;
					int mnz = middlez.indexOf("|");
					mz1 = middlez.substring(0, mnz);
					mz2 = middlez.substring(mnz+1);
//					System.out.println(xj);
//					System.out.println(front+","+mj1+","+mj2+","+back);
//					System.out.println(xz);
//					System.out.println(frontz+","+mz1+","+mz2+","+backz);
					
					String rbz = frontz + "[ruby rb=\\\""+mz1+"\\\" rt=\\\""+mz2+"\\\"]"+backz;
					hm.put(xj,rbz);
				}else{
					hm.put(jt.get(i), xz);
				}
				
			}
		}
		br.close();
//		Iterator<String> it = hm.keySet().iterator();
//		while (it.hasNext()) {
//			String key = (String) it.next();
//			String value = hm.get(key);
//			System.out.println(key);
//			System.out.println(value);
//		}
	}
	
	public static void listfiles(String folderpath)throws Exception{
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
//				System.out.println("folder:"+newfolderpath);
				listfiles(newfolderpath);
			}else{
				if(files[i].getName().endsWith(".txt")||files[i].getName().endsWith(".dnh")){
					String r=readbsm(files[i]);
					if(r.length()>2){
						String newpath = files[i].getAbsolutePath().replaceAll(folder, newfolder);
						new File(new File(newpath).getParent()).mkdirs();
						FileWriter fw = new FileWriter(newpath);
						fw.write(r);
						fw.close();
					}
				}
			}
		}
	}
	
	public static String readbsm(File f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"shift-JIS"));
		String s;
		String r= new String();
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			if((x.indexOf("sysBaseFont")>-1)){
				System.out.println(x);
				System.out.println(f.getAbsolutePath());
			}
			if(f.getName().equals("MusicData.dnh")){
				if(x.startsWith("\"")){
					String[] xa = x.split("\"");
					if(xa.length==3){
						String trans = xa[1];
						String u = trans;

						String uret = search(u);
						r=r+uret+"				||||"+u+"\r\n";
					}else{
						System.out.println("err music:"+x);
					}
				}else if(x.startsWith("Obj_SetValue(obj")&&x.split("\"").length==5){
					String trans = x.split("\"")[3];
					String u = trans;
					System.out.println(u);
					System.out.println(hm.get(u));
					String uret = search(u);
					r=r+uret+"				||||"+u+"\r\n";
				}
			}
			if(f.getName().equals("SceneSpellSelect.dnh")&&x.startsWith("TMenuItemInfo")){
				String tr=x;
				String trans = "";
				if(tr.split("\"").length!=3){
					int n1 = tr.indexOf("\"");
					int n2 = tr.lastIndexOf("\"");
					trans = tr.substring(n1+1, n2);
				}else{
					trans = tr.split("\"")[1];
				}
				String u = trans;
				String uret = search(u);
				r=r+uret+"				||||"+u+"\r\n";
				System.out.println(r);
			}
			if(x.startsWith("SetTalkEx")||x.startsWith("_SetTalk(cutin")){
				String tr=x;
				String trans = "";
				if(tr.split("\"").length!=3){
					int n1 = tr.indexOf("\"");
					int n2 = tr.lastIndexOf("\"");
					trans = tr.substring(n1+1, n2);
				}else{
					trans = tr.split("\"")[1];
				}
				int n;
				String u = trans;
				while((n=u.indexOf("[r]"))>-1){
					String rx = u.substring(0, n).trim();
					String uret;
					uret = search(rx);
					u=u.substring(n+3);
					r=r+uret+"				||||"+rx+"\r\n";
				}
				String uret;
				uret = search(u);
				r=r+uret+"				||||"+u+"\r\n";
			}
			if(f.getName().equals("SpellData.dnh")){
				if(x.indexOf("\"")>-1){
					String[] xa = x.split("\"");
					if(xa.length==3){
						String uret;
						uret = searchspell(xa[1]);
						r=r+uret+"				||||"+xa[1]+"\r\n";
					}else{
//						System.out.println("error:"+x);
					}
				}
			}
			
			
		}
		br.close();
		return r;
	}
	
	public static String searchspell(String u){
		if(sm.get(u)!=null){
			return sm.get(u);
		}else{
			System.out.println("spell not found : " + u);
			Iterator<String> it = sm.keySet().iterator();
			double similar = 0.45;
			while (it.hasNext()) {
				String key = (String) it.next();
				float dsm = dt(u, key);
				if(dsm<similar){
					
//					if(dsm>0.2){
//						System.out.println(u);
//						System.out.println(key);
//						System.out.println(hm.get(key));
//						System.out.println("similar:"+(1-dsm));
//						System.out.println();
//					}
					System.out.println(u);
					System.out.println(key);
					System.out.println(sm.get(key));
					System.out.println("similar:"+(1-dt(u, key)));
					System.out.println();

					return sm.get(key);
				}
			}
			
			
			return u;
		}
	}
	
	public static String search(String u){
		if(hm.get(u)!=null){
			return hm.get(u);
		}else{
			Iterator<String> it = hm.keySet().iterator();
			double similar = 0.45;
			while (it.hasNext()) {
				String key = (String) it.next();
				float sm = dt(u, key);
				if(sm<similar){
					if(("　"+key).equals(u)){
						return "　"+hm.get(key);
					}else if(("　　"+key).equals(u)){
						return "　　"+hm.get(key);
					}else if(("　　　"+key).equals(u)){
						return "　　　"+hm.get(key);
					}else if(("　　　　"+key).equals(u)){
						return "　　　　"+hm.get(key);
					}else if(("　　　　　"+key).equals(u)){
						return "　　　　　"+hm.get(key);
					}else if(("　　　　　　"+key).equals(u)){
						return "　　　　　　"+hm.get(key);
					}else if(("　　　　　　　"+key).equals(u)){
						return "　　　　　　　"+hm.get(key);
					}else if(("　　　　　　　　"+key).equals(u)){
						return "　　　　　　　　"+hm.get(key);
					}
					if(sm>0.2){
//						System.out.println(u);
//						System.out.println(key);
//						System.out.println(hm.get(key));
//						System.out.println("similar:"+(1-sm));
//						System.out.println();
					}
//					System.out.println(u);
//					System.out.println(key);
//					System.out.println(hm.get(key));
//					System.out.println("similar:"+(1-dt(u, key)));
//					System.out.println();

					return hm.get(key);
				}
			}
			System.out.println("not hit:"+u);
			return u;
		}
	}
	private static String allspell="";
	public static String writebsm2(File f)throws Exception{
		byte[] bstr = toByteArray2(f.getAbsolutePath());
		String allstr = new String(bstr,"shift-JIS");
		String allstro = new String(bstr,"shift-JIS");
		boolean changed=false;
		String[] strja = allstr.split("\n");
		String[] stroa = allstro.split("\n");
		if(strja.length!=stroa.length){
			System.err.println("error:!!!diff line!!!!");
		}
		String ret="";
		boolean cmk=false;
		int inccount =0;
		String incstr="";
		for(int i=0;i<strja.length;i++){
			String x = strja[i].trim();
			if((f.getName().indexOf("_Talk0")>0)&&x.indexOf("#include")>-1){
				inccount=inccount+1;
				incstr = incstr + x + "\r\n";
				if(x.indexOf("Ichiyou")>0){
					String istr = "#include\"script/th_bsm/stg/stage4/boss/lib_Ichiyou.dnh\"";
					ret = ret +istr+"\r\n";
					continue;
				}
				if(x.indexOf("Nezu")>0){
					String istr = "#include\"script/th_bsm/stg/stage5/boss/lib_Nezu.dnh\"";
					ret = ret +istr+"\r\n";
					continue;
				}
			}
			if(f.getName().equals("06b_Spell07_Enter.dnh")){
				if(x.indexOf("lib_Mishandra")>0){
					String istr = "#include\"script/th_bsm/stg/stage6/boss/lib_Mishandra.dnh\"";
					ret = ret +istr+"\r\n";
					continue;
				}
				if(x.indexOf("06b_Spell07_Func")>0){
					String istr = "#include\"script/th_bsm/stg/stage6/boss/06b_Spell07_Func.dnh\"";
					ret = ret +istr+"\r\n";
					continue;
				}
				if(x.indexOf("LoadScript(GetCurrentScriptDirectory()")>0){
					String istr = "let idBG = LoadScript(GetCurrentScriptDirectory()~\"../stg/stage6/boss/06c_Background.dnh\");";
					ret = ret +istr+"\r\n";
					continue;
				}
			}
			if(f.getName().equals("lib_Fukidashi.dnh")){
				if(x.indexOf("MS Gothic")>0){
					String rrstr = "let tmp_key = GetAreaCommonData(CAREA_CONFIG, \"AccKey\", 0);\r\n";
					rrstr = rrstr + "let baseFont = \"simhei\";\r\n";
					rrstr = rrstr + "if(tmp_key==0){baseFont = \"simhei\";}\r\n";
					rrstr = rrstr + "else{baseFont = \"MS Gothic\";}\r\n";
					ret = ret +rrstr+"\r\n";
					continue;
				}
			}
			if(f.getName().equals("SpellData.dnh")){
				if(x.indexOf("\"")>-1){
					String[] xa = x.split("\"");
					if(xa.length==3){
						String uret;
						uret = searchspell(xa[1]);
						
						String nm = getNumberAndSaveMap(f,xa[1],uret);
						ret=ret+"			"+xa[0]+"gettxt(\""+nm+"\",GetAreaCommonData(\"Config\", \"AccKey\", 0))"+xa[2]+"\r\n";
					}else{
						ret = ret + stroa[i]+"\r\n";
					}
				}else{
					ret = ret + stroa[i]+"\r\n";
				}
				continue;
			}
			
			if(f.getName().equals("MusicData.dnh")){
				if(x.startsWith("\"")){
					String[] xa = x.split("\"");
					if(xa.length==3){
						String trans = xa[1];
						String u = trans;
						String uret = search(u);
						String nm = getNumberAndSaveMap(f,xa[1],uret);
						ret=ret+"			"+xa[0]+"gettxt(\""+nm+"\",GetAreaCommonData(\"Config\", \"AccKey\", 0))"+xa[2]+"\r\n";
					}else{
						System.out.println("err music:"+x);
					}
				}else if(x.startsWith("Obj_SetValue(obj")&&x.split("\"").length==5){
					String[] xa = x.split("\"");
					String trans = x.split("\"")[3];
					String uret;
					if(trans.startsWith("♪")){
						String uu = trans.substring(4).trim();
						uret = trans.substring(0,4)+search(uu);
					}else{
						String u = trans;
						uret = search(u);
					}

					String nm = getNumberAndSaveMap(f,xa[3],uret);
					ret=ret+"			"+xa[0]+"\""+xa[1]+"\""+xa[2]+"gettxt(\""+nm+"\",GetAreaCommonData(\"Config\", \"AccKey\", 0))"+xa[4]+"\r\n";
				}else if(x.startsWith("let musicDir")){
					ret = ret + "let musicDir =  \"script/th_bsm/music/\";"+"\r\n";
				}else{
					ret = ret + stroa[i]+"\r\n";
				}
				continue;
				
			}
			

			
			
			if(x.startsWith("SetTalkEx")||x.startsWith("_SetTalk(cuti")||(f.getName().equals("SceneSpellSelect.dnh")&&x.startsWith("TMenuItemInfo"))){
				changed=true;
				String tr=x;
				String trans = "";
				String front;
				String back;
				if(tr.split("\"").length!=3){
					int n1 = tr.indexOf("\"");
					int n2 = tr.lastIndexOf("\"");
					trans = tr.substring(n1+1, n2);
					front = tr.substring(0, n1);
					back = tr.substring(n2+1);
				}else{
					front = tr.split("\"")[0];
					trans = tr.split("\"")[1];
					back = tr.split("\"")[2];
				}
				int n;
				String u = trans;
				String retline="";
				while((n=u.indexOf("[r]"))>-1){
					String rx = u.substring(0, n).trim();
					u=u.substring(n+3);
					String tr2;
					if(hr.get(rx)==null){
						if(hr.get(rx.trim())==null){
							System.out.println("no hit!\n"+rx);
							tr2 = rx;
						}else{
							tr2=hr.get(rx.trim());
						}
					}else{
						tr2 = hr.get(rx);
					}
					if(retline.length()<2){
						retline = tr2;
					}else{
						retline = retline + "[r]"+tr2;
					}
				}
				String rx = u;
				String tr2;
				if(hr.get(rx)==null){
					if(hr.get(rx.trim())==null){
						System.out.println("no hit!\n"+rx);
						tr2 = rx;
					}else{
						tr2=hr.get(rx.trim());
					}
				}else{
					tr2 = hr.get(rx);
				}
				if(retline.length()<2){
					retline = tr2;
				}else{
					retline = retline + "[r]"+tr2;
				}
				
				String nm = getNumberAndSaveMap(f,trans,retline);
				String rline =  front +"gettxt(\""+nm+"\",GetAreaCommonData(\"Config\", \"AccKey\", 0))" + back;
//				r= r + rline + "\r\n";
				ret = ret + rline + "\r\n";
			}else{
				if(f.getName().equals("lib_CommonDataManager.dnh")&&stroa[i].indexOf("SetSkipModeKey")>0){
					if(cmk==false){
						ret = ret + "SetSkipModeKey(KEY_LCONTROL);" + "\r\n";
						cmk=true;
					}
				}else if(f.getName().equals("ControlMusic.dnh")&&stroa[i].indexOf("./lib/lib_Common.dnh")>0){
					ret = ret + "#include \"script/th_bsm/title/lib/lib_Common.dnh\""+"\r\n";
				}else if(f.getName().equals("Title.dnh")){
					if(stroa[i].indexOf("SceneMusicRoom.dnh")>0){
						cmk=true;
					}else if(cmk==true&&!stroa[i].startsWith("#include")){
						ret = ret + "#include \"script/th_bsm/title/scene/SceneMusicRoom.dnh\""+"\r\n";
						ret = ret + stroa[i]+"\r\n";
						cmk=false;
					}else{
						ret = ret + stroa[i]+"\r\n";
					}
				}else if(f.getName().equals("lib_Talk_ed.dnh")){
					if( stroa[i].indexOf("Meiryo")>0){
						ret = ret + stroa[i].replaceAll("Meiryo", "simkai")+"\r\n";
					}else{
						ret = ret + stroa[i]+"\r\n";
					}
				}else if(f.getName().equals("lib_SystemAll.dnh")){
					if( stroa[i].indexOf("Meiryo")>0){
						ret = ret + stroa[i].replaceAll("Meiryo", "simkai")+"\r\n";
					}else{
						ret = ret + stroa[i]+"\r\n";
					}
				}else{
					ret = ret + stroa[i]+"\r\n";
				}

			}
		}
		if(inccount>2){
			//System.out.println("inc count:"+f.getName()+":"+inccount);
			//System.out.println(incstr);
		}
		if(f.getName().equals("lib_Talk.dnh")){
			return "#include \"./txt.dnh\"\r\n"+ret;
		}else if(f.getName().equals("ControlMusic.dnh")){
			return ret;
		}else if(f.getName().equals("MusicData.dnh")){
			return "#include \"script/th_bsm/lib/txt.dnh\"\r\n"+ret;
		}else if(f.getName().equals("lib_Talk_ed.dnh")){
			return "#include \"./txt.dnh\"\r\n"+ret;
		}else if(f.getName().equals("SpellData.dnh")){
			return "#include \"../../lib/txt.dnh\"\r\n"+ret;
		}else if(f.getName().equals("lib_CommonDataManager.dnh")){
			return ret;
		}else if(f.getName().equals("lib_Fukidashi.dnh")){
			return ret;
		}else if(f.getName().equals("lib_SystemAll.dnh")){
			return ret;
		}else if(f.getName().equals("Title.dnh")){
			return ret;
		}else if(changed==false){
			return "";
		}else{
			
			return ret;
		}
	}
	

	public static String getNumberAndSaveMap(File f,String jstr,String zstr){
		String filestr = f.getName();
		Object number = fm.get(filestr);
		int nm;
		if(number==null){
			nm=1;
		}else{
			nm=Integer.valueOf(number.toString())+1;
		}
		String ret = filestr+"."+nm;
		fm.put(filestr, nm);
		
		cret = cret + "\tcase(\""+ret+"\")\r\n";
		cret = cret + "\t{\r\n";
		cret = cret + "\t\tif(type==0){return \""+zstr+"\"}\r\n";
		cret = cret + "\t\telse {return \""+jstr+"\";}\r\n";
		cret = cret + "\t}\r\n";
		
		return ret;
	}
	
	
	
	
	public static void listwritefiles(String folderpath)throws Exception{
		File f = null;
		f = new File(folderpath);
		File[] files = f.listFiles(); 
		for(int i=0;i<files.length;i++)
		{
			if(files[i].isDirectory()){
				String newfolderpath = folderpath+"/"+files[i].getName();
				listwritefiles(newfolderpath);
			}else{
				if(files[i].getName().endsWith(".txt")||files[i].getName().endsWith(".dnh")){
					String r=readbsm(files[i]);
					if(r.length()>-2){
						String ret = writexxz(files[i]);
						String newpath = files[i].getAbsolutePath().replaceAll(folder, retfolder);
						new File(new File(newpath).getParent()).mkdirs();
						FileWriter fw = new FileWriter(newpath);
						fw.write(ret);
						fw.close();
					}
				}
			}
		}
	}	
	
	public static String writexxz(File f)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"shift-JIS"));
		String s;
		String r= new String();
		while ((s = br.readLine()) != null) {
			String x=s.trim();
			if(x.startsWith("TextOut(\"")){
				String tr=x;
				while(tr.split("\"").length!=3){
					tr=tr+br.readLine().trim();
				}
				String text = tr.split("\"")[1];
				String trans = hr.get(text);
				if(trans==null){
					System.out.println("err");
					r=r+s+"\r\n";
				}else{
					r=r+tr.split("\"")[0]+"\""+trans+"\""+tr.split("\"")[2]+"\r\n";
				}
				
			}else{
				r=r+s+"\r\n";
			}
		}
		br.close();
		return r;
	}
	
	
	

	


	
	

	
	private static Map<String, ArrayList<String>> sss = new HashMap<String, ArrayList<String>>();
	public static void repo() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fw/4195sk.txt")));
		String s;
		String r= new String();
		while ((s = br.readLine()) != null) {
			if(s.indexOf("||||")<0&&s.length()>5){
				String[] sa = s.trim().split(",");
				if(sa.length!=2){
					System.out.println("err: no 2"+s);
				}else{
					int st = Integer.valueOf(sa[0]);
					int len = Integer.valueOf(sa[1]);
					byte[] tm = new byte[len];
					String txt = br.readLine();
					int n1 = txt.indexOf("||||");
					String hh = txt.substring(0,n1).trim();
					String oh = txt.substring(n1+5).trim();
					ArrayList<String> ssaa = sss.get(oh);
					if(ssaa==null){
						ssaa = new ArrayList<String>();
						ssaa.add(s);
						sss.put(oh, ssaa);
					}else{
						ssaa.add(s);
						sss.put(oh, ssaa);
					}
					
				}
			}
		}
		br.close();
		
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream("fw/4195o.txt")));
		while ((s = br.readLine()) != null) {
			if(s.indexOf("||||")<0&&s.length()>5){
				String[] sa = s.trim().split(",");
				if(sa.length!=2){
					System.out.println("err: no 2"+s);
				}else{
					int st = Integer.valueOf(sa[0]);
					int len = Integer.valueOf(sa[1]);
					byte[] tm = new byte[len];
					String txt = br.readLine();
					int n1 = txt.indexOf("||||");
					String hh = txt.substring(0,n1).trim();
					String oh = txt.substring(n1+5).trim();
					ArrayList<String> oo = sss.get(oh);
					if(oo==null){
						System.out.println(oh);
					}else{
						for(int i=0;i<oo.size();i++){
							String nl = sss.get(oh).get(i);
							r=r+nl+"\r\n";
							r=r+txt+"\r\n";
							r=r+"\r\n";
						}
						sss.remove(oh);
					}


				}
			}
		}
		br.close();
		System.out.println(sss);
		
		FileWriter fw= new FileWriter("fw/4195n.txt");
		fw.write(r);
		fw.close();
			
	}
	
	
	public static void pre() throws Exception{
		String r = new String();
		r=r+prewrite("fw/4044-"+1+".txt");
		r=r+prewrite("fw/4044-"+2+".txt");
		r=r+prewrite("fw/4044-"+3+".txt");
		r=r+prewrite("fw/4044-"+4+".txt");
		FileWriter fw = new FileWriter("fw/4195o.txt");
		fw.write(r);
		fw.close();
	}
	
	public static String  prewrite(String fn) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fn)));
		String s;
		String r= new String();
		while ((s = br.readLine()) != null) {
			r = r + s + "\r\n";
		}
		br.close();
		return r+ "\r\n";
	}
	
	
	public static void write() throws Exception{
		byte[] x = toByteArray2("fw/o");
		byte[] x1 = writehht(x, 4195);
		byte[] x2 = writehht(x1, 4196);
		FileOutputStream fo = new FileOutputStream("fw/e");
		fo.write(x2);
		fo.close();
		
		FileOutputStream fo2 = new FileOutputStream("fw/thhht/e.exe");
		fo2.write(x2);
		fo2.close();
	}
	
	
	
	public static byte[] writehht(byte[] x,int line)throws Exception{
		int c=0;
		int r=0;
		int ts=0;
		int te=0;
		for(int i=0;i<x.length;i++){
			if(x[i]==10){
				c++;
				if(c==line-1){
					ts=i+1;
				}
				if(c==line){
					System.out.println(r);
					te=i-1;
				}
				r=0;
			}
			r++;
		}
		System.out.println(ts);
		System.out.println(te);
		int len = te-ts;
		byte[] mu = new byte[len];
		System.arraycopy(x, ts, mu, 0, len);
		
		
		byte[] nm = replacemubyte(line,mu);
		
		System.arraycopy(nm, 0, x, ts, nm.length);
		return x;
//		FileOutputStream fo = new FileOutputStream("fw/e");
//		fo.write(x);
//		fo.close();
	}
	
	private static ArrayList<String> forbidchar = new ArrayList<String>();
	static{
		forbidchar.add("£");
		forbidchar.add("〜");
		forbidchar.add("　");
	}
	public static byte[] replacemubyte(int line,byte[] mu) throws Exception{
		byte[] r = new byte[mu.length];
		System.arraycopy(mu, 0, r, 0, mu.length);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fw/"+line+"n.txt")));
		String s;
		while ((s = br.readLine()) != null) {
			if(s.indexOf("||||")<0&&s.length()>5){
				String[] sa = s.trim().split(",");
				if(sa.length!=2){
					System.out.println("err: no 2"+s);
				}else{
					int st = Integer.valueOf(sa[0]);
					int len = Integer.valueOf(sa[1]);
					byte[] tm = new byte[len];
					String txt = br.readLine();
					int n1 = txt.indexOf("||||");
					String hh = txt.substring(0,n1).trim();
					String oh = txt.substring(n1+5).trim();

					
					boolean dir=true;
					if(st>=1679&&st<=1795){
						dir=false;
					}
					if(st==5289||st==7397||st==21663||st==17835){
						dir=false;
					}
					
					if(hh.equals(oh)&&dir){
//						System.out.println("same:"+hh+","+st);
					}else{
						
						for(int i=0;i<forbidchar.size();i++){
							String fc = forbidchar.get(i);
							int nnn = hh.indexOf(fc);
							if(nnn>-1){
//								System.out.println("has forbid char:"+hh);
							}
						}
						if(line==4196){
							hh = hh.replaceAll("　", " 0");
						}else{
							hh = hh.replaceAll("　", " ");
						}
						byte[] bh = hh.getBytes("gbk");
						if(bh.length>tm.length){
							System.arraycopy(bh, 1, tm, 0, len-1);
							tm[0]=(byte)65;
							System.arraycopy(tm, 0, r, st, len);
							System.out.println("exceed:"+hh+","+oh+","+bh.length+","+tm.length);
						}else{
							System.arraycopy(bh, 0, tm, 0, bh.length);
							System.arraycopy(tm, 0, r, st, len);
						}
					}
							
				}
			}
		}
		br.close();
		return r;
	}
	
	
	public static void readhht(int line) throws Exception{
		byte[] x = toByteArray2("fw/thl");
		int c=0;
		int r=0;
		int ts=0;
		int te=0;
		for(int i=0;i<x.length;i++){
			if(x[i]==10){
				c++;
				if(c==line-1){
					ts=i+1;
				}
				if(c==line){
					System.out.println(r);
					te=i-1;
				}
				r=0;
			}
			r++;
		}
		System.out.println(ts);
		System.out.println(te);
		int len = te-ts;
		System.out.println(len);
		byte[] mu = new byte[len];
		System.arraycopy(x, ts, mu, 0, len);
		int lz=-1;
		ArrayList<Section> stt= new ArrayList<Section>();
		for(int i=0;i<mu.length;i++){
			if(mu[i]==0){
				if(i-lz==1){
					lz=i;
				}else{
					int ss=lz+1;
					int slen = i-lz-1;
					byte[] st = new byte[slen];
					System.arraycopy(mu, lz+1, st, 0, slen);
					lz=i;
					Section tss = new Section(st);
					tss.start=ss;
					tss.len=slen;
					stt.add(tss);
				}
			}else{
				
			}
		}
		String ret = new String();
		for(int i=0;i<stt.size();i++){
			byte[] tt = stt.get(i).data;
			String ss = new String(tt,"shift-JIS");
			String trr = stt.get(i).start+","+stt.get(i).len+"\r\n"+ss + "				||||				"+ss+"\r\n";
			ret = ret + trr + "\r\n";
		}
		FileWriter fw = new FileWriter("fw/"+line+"sk.txt");
		fw.write(ret);
		fw.close();
	}
	
	
	public static byte[] getnewbyte(byte[] x){
		ArrayList<Byte> xi = new ArrayList<Byte>();
		for(int i=0;i<x.length;i++){
			if(x[i]!=(byte)0xC2&&x[i]!=(byte)0xC3){
				xi.add(x[i]);
			}
		}
		byte[] r = new byte[xi.size()];
		for(int i=0;i<r.length;i++){
			r[i]=xi.get(i);
		}
		return r;
		
	}
	
	public static void pt(byte[] x){
		for(int i=0;i<x.length;i++){
			if(i==0){
				System.out.print(x[i]);
			}else{
				System.out.print(","+x[i]);
			}
		}
		System.out.println();
	}
	

	
	public static void pthex(byte[] x){
		String sr = DatatypeConverter.printHexBinary(x);
		
		for(int i=0;i<sr.length();i=i+2){
			System.out.print(sr.substring(i, i+2)+",");
		}
		System.out.println();
	}
	
	public static float dt(String a,String b){
		return (float)distance(a, b)/Math.max(a.length(), b.length());
	}
	
	    public static int distance(String a, String b) {
		        a = a.toLowerCase();
		        b = b.toLowerCase();
		        // i == 0
		        int [] costs = new int [b.length() + 1];
		        for (int j = 0; j < costs.length; j++)
		            costs[j] = j;
		        for (int i = 1; i <= a.length(); i++) {
		            // j == 0; nw = lev(i - 1, j)
		            costs[0] = i;
		            int nw = i - 1;
		            for (int j = 1; j <= b.length(); j++) {
		                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
		                nw = costs[j];
		                costs[j] = cj;
		            }
		        }
		        return costs[b.length()];
		    }
	
	
	
	 public static String readOriginal2Hex(String filename) throws IOException {
		        FileInputStream fin = new FileInputStream(new File(filename));
		        StringWriter sw = new StringWriter();

		        int len = 1;
		        byte[] temp = new byte[len];

		       /*16进制转化模块*/
		        for (; (fin.read(temp, 0, len)) != -1;) {
		            if (temp[0] > 0xf && temp[0] <= 0xff) { 
		                sw.write(Integer.toHexString(temp[0]));
		            } else if (temp[0] >= 0x0 && temp[0] <= 0xf) {//对于只有1位的16进制数前边补“0”
		                sw.write("0" + Integer.toHexString(temp[0]));
		            } else { //对于int<0的位转化为16进制的特殊处理，因为Java没有Unsigned int，所以这个int可能为负数
		                sw.write(Integer.toHexString(temp[0]).substring(6));
		            }
		        }

		        return sw.toString();
		    }
	
	public static byte[] toByteArray2(String filename) throws IOException {  
		  
	        File f = new File(filename);  
	        if (!f.exists()) {  
	            throw new FileNotFoundException(filename);  
	        }  
	  
	        FileChannel channel = null;  
	        FileInputStream fs = null;  
	        try {  
	            fs = new FileInputStream(f);  
//	            byte[] bb = new byte[100];
//	            fs.read(bb);
//	            pthex(bb);
	            channel = fs.getChannel();
	            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());  
	            while ((channel.read(byteBuffer)) > 0) {  
	                // do nothing  
	                // System.out.println("reading");  
	            }  
	            return byteBuffer.array();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	            throw e;  
	        } finally {  
	            try {  
	                channel.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	            try {  
	                fs.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	
	
	public static String HttpGet(String urlStr,String param){
		if(param == null || param.trim().length()<1){
            
	        }else{
	            urlStr +="?"+param;
	        }   
		try {
			URL url = new URL(urlStr);
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
	        conn.setConnectTimeout(10000);
	        conn.setReadTimeout(12000);
	        conn.setDoOutput(true);
	        conn.setRequestMethod("GET");
	        if(conn.getResponseCode() ==200){
	        	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line ;
	            String result ="";
	            while( (line =br.readLine()) != null ){
	                result += line + "\n";
	            }
	            return result;
	        }else{
	            System.out.println("3failed"+conn.getResponseCode()+conn.getResponseMessage());
	        }
		} catch (Exception e) {
			System.out.println("exception in httpget reinstate mail");
			e.printStackTrace();
		}
		return "";
	}
	
	
	    public static int[] next(byte[] t) {  
		        int[] next = new int[t.length];  
		        next[0] = -1;  
		        int i = 0;  
		        int j = -1;  
		        while (i < t.length - 1) {  
		            if (j == -1 || t[i] == t[j]) {  
		                i++;  
		                j++;  
		                if (t[i] != t[j]) {  
		                    next[i] = j;  
		                } else {  
		                    next[i] = next[j];  
		                }  
		            } else {  
		                j = next[j];  
		            }  
		        }  
		        return next;  
		    }  
		  
		    /** 
		     * KMP匹配字符串 
		     *  
		     * @param s 
		     *            主串 
		     * @param t 
		     *            模式串 
		     * @return 若匹配成功，返回下标，否则返回-1 
		     */  
		    public static int KMP_Index(byte[] s, byte[] t) {  
		        int[] next = next(t);  
		        int i = 0;  
		        int j = 0;  
		        while (i <= s.length - 1 && j <= t.length - 1) {  
		            if (j == -1 || s[i] == t[j]) {  
		                i++;  
		                j++;  
		            } else {  
		                j = next[j];  
		            }  
		        }  
		        if (j < t.length) {  
		            return -1;  
		        } else  
		            return i - t.length; // 返回模式串在主串中的头下标  
		    }  
	
	
	
	
	
	
	
}
