package com.sist.main;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import com.sist.main.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class recipe {
	List<String> urlList=new ArrayList<String>();
	public recipe() {
		try {
			for(int i=1;i<=7;i++) {
	            String url = "https://www.10000recipe.com/recipe/list.html?q=%EC%BA%A0%ED%95%91&order=reco&page="+i;
	            Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
	            Elements links = doc.select("ul.common_sp_list_ul li.common_sp_list_li div.common_sp_thumb a");
	            
				for(int j=0;j<links.size();j++) {
					System.out.println("https://www.10000recipe.com/" + links.get(j).attr("href"));
					urlList.add("https://www.10000recipe.com/" + links.get(j).attr("href"));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void data() {
		try {
			for(int i=0;i<urlList.size();i++) {
				String url = urlList.get(i);
				Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
				String contents_area="#contents_area_full ";
				Element img=doc.selectFirst(contents_area+".view2_pic .centeredcrop img");
				if(img==null) {
					contents_area="#contents_area ";
					img=doc.selectFirst(contents_area+".view2_pic .centeredcrop img");
				}
				Element title=doc.selectFirst(contents_area+".view2_summary h3");
				
				System.out.println(urlList.size()+"/"+(i+1)+" : "+img.attr("src"));
				System.out.println(title.text());
				
				Element msg=doc.selectFirst(".container #contents_area_full .view2_summary #recipeIntro");
				Element msg2=doc.selectFirst(".container #contents_area_full .view2_summary_info");
				Element ingre=doc.selectFirst(".container #contents_area_full .cont_ingre2");

				
				// 조리순서 + 이미지
				int n = 1;
				Elements allSteps = new Elements();
				Elements allStepsImg = new Elements();
				StringBuilder builderSteps = new StringBuilder();
				StringBuilder builderStepsImg = new StringBuilder();

				while (true) {
				    Element steps = doc.selectFirst(".container .view_step #stepDiv" + n);
				    Element stepsImg = doc.selectFirst(".container .view_step #stepDiv" + n + " img");
				    if (steps == null || stepsImg == null) {
				        break;
				    }

				    builderSteps.append(steps.text());
				    builderStepsImg.append(stepsImg.attr("src"));

			
				    builderSteps.append("|"); // 구분자 추가 
				    builderStepsImg.append("^"); // 구분자 추가
	

				    n++;
				}

				String allStepsText = builderSteps.toString(); // 모든 요소의 텍스트를 구분자와 함께 연결한 문자열
				String allStepsImgText = builderStepsImg.toString(); // 이미지 소스를 구분자와 함께 연결한 문자열

				try {
				// recipeVO 객체 생성 후 필드에 값을 설정
				recipeVO vo = new recipeVO();
				vo.setAllSteps(allStepsText);
				vo.setAllStepsImg(allStepsImgText);
				vo.setMsg(msg.text());
				vo.setMsg2(msg2.text());
				vo.setIngre(ingre.text());

				System.out.println(vo.getMsg());
				System.out.println(vo.getMsg2());
				System.out.println(vo.getAllSteps());
				System.out.println(vo.getIngre());
				System.out.println(vo.getAllStepsImg());

				} catch(Exception ex) {
					System.out.println("값 없음");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		recipe r=new recipe();
		r.data();
		System.out.println("완료");
	}
}
