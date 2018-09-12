package com.dao;

import java.util.Scanner;

public class SchoolController {
	private Scanner scanner;
	private SchoolDAO schoolDAO;
	private boolean stopMenu = false;
	private boolean stop = false;
	
	public SchoolController() {
		scanner = new Scanner(System.in);
		schoolDAO = new SchoolDAO();
	}
	
	public void menu() {
		while(!stopMenu) {
			stop = false;
			System.out.println("관리");
			System.out.println("1.입력");
			System.out.println("2.검색");
			System.out.println("3.삭제");
			System.out.println("4.종료");
			System.out.print("번호선택 : ");
			int num = Integer.parseInt(scanner.next());
			
			switch(num) {
			case 1:insert();break;
			case 2:select();break;
			case 3:delete();break;
			case 4:exit();break;
			}
		}
		scanner.close();
	}

	private void insert() {
		while(!stop) {
			System.out.println("1.학생");
			System.out.println("2.교수");
			System.out.println("3.관리자");
			System.out.println("4.이전메뉴");
			System.out.print("번호 선택 : ");
			int num = Integer.parseInt(scanner.next());
			
			switch(num) {
			case 1:insertStudent();break;
			case 2:insertProf();break;
			case 3:insertAd();break;
			case 4:toMainMenu();break;
			}
		}
	}

	public void insertStudent() {
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("학번 입력 : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 1);
	}

	public void insertProf() {
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("과목 입력 : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 2);
	}

	public void insertAd() {
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("부서 입력 : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 3);
	}

	public void toMainMenu() {
		stop = true;
	}

	public void select() {
		while(!stop) {
			System.out.println("1. 이름 검색");
			System.out.println("2. 전체 검색");
			System.out.println("3. 이전 메뉴");
			System.out.print("번호 선택 : ");
			int num = Integer.parseInt(scanner.next());
			
			switch(num) {
			case 1: selectByName();break;
			case 2: selectAll();break;
			case 3: toMainMenu();break;
			}
		}
	}

	public void selectByName() {
		System.out.print("검색할 이름을 입력 : ");
		String name = scanner.next();
		schoolDAO.selectArticleByName(name);
	}

	public void selectAll() {
		schoolDAO.selectArticle();
	}

	public void delete() {
		System.out.print("삭제할 이름 입력 : ");
		String name = scanner.next();
		schoolDAO.deleteArticle(name);
	}

	public void exit() {
		stopMenu = true;
	}
}
