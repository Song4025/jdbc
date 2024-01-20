package com.song.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.song.app.entity.Notice;
import com.song.app.service.NoticeService;

public class NoticeConsole {

	//	출력을 구현하기 위한 데이터서비스
	private NoticeService service;
	private int page;
	// 게시글의 개수
	private int count;
	private String searchField;
	private String searchWord;
	
	public NoticeConsole() {
		service = new NoticeService();
		page = 1;
		count = 0;
		searchField = "TITLE";
		searchWord = "";
	}
	// 데이터 출력
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		List<Notice> list = service.getList(page, searchField, searchWord);
		count = service.getCount();
		int lastPage = count/10; // 100 -> 10, 90 -> 9
		lastPage = count%10 == 0? lastPage : lastPage+1;
		
		System.out.println("────────────────────────────────");
		System.out.printf("<공지사항> 총 %d 게시글\n", count);
		System.out.println("────────────────────────────────");
		
		for(Notice n : list) {
			System.out.printf("%s. %s / %s / %s\n", 
					n.getId(), n.getTitle(), n.getWriter_id(), n.getRegdate());
		}
		System.out.println("────────────────────────────────");
		System.out.printf("            %d/%d pages\n", page, lastPage);
	}

	public int inputNoticeMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. 상세조회/ 2.이전/ 3. 다음/4.글쓰기 / 5.검색 / 6.종료 >");
		String menu_ = scan.nextLine();
		int menu = Integer.parseInt(menu_);
		
		return menu;
	}


	public void movePrevList() {
		if(page == 1) {
			System.out.println("================");
			System.out.println("  첫번째 페이지입니다.");
			System.out.println("================");
			return;
		}
		page--;
	}
	
	public void moveNextList() throws ClassNotFoundException, SQLException {
		int count = service.getCount();
		int lastPage = count/10; // 100 -> 10, 90 -> 9
		lastPage = count%10 == 0? lastPage : lastPage+1;
		if(lastPage == page) {
			System.out.println("================");
			System.out.println("  마지막 페이지입니다.");
			System.out.println("================");
			return;
		}
		page++;
	}
	public void inputSearchWord() {
//		지역변수로 사용하는것은 좋은방법이아님 멤버는 다른것들과 공유되기 위한것만 할것.
		Scanner scan = new Scanner(System.in);
		System.out.println("검색범주(title/content/writerId)중에 하나를 입력하세요");
		System.out.println(" > ");
		searchField = scan.nextLine();
		System.out.println("검색어 > ");
		searchWord = scan.nextLine();
	}
	
}
