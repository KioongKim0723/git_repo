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
			System.out.println("����");
			System.out.println("1.�Է�");
			System.out.println("2.�˻�");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.print("��ȣ���� : ");
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
			System.out.println("1.�л�");
			System.out.println("2.����");
			System.out.println("3.������");
			System.out.println("4.�����޴�");
			System.out.print("��ȣ ���� : ");
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
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("�й� �Է� : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 1);
	}

	public void insertProf() {
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("���� �Է� : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 2);
	}

	public void insertAd() {
		System.out.print("�̸� �Է� : ");
		String name = scanner.next();
		System.out.print("�μ� �Է� : ");
		String value = scanner.next();
		
		schoolDAO.insertArticle(name, value, 3);
	}

	public void toMainMenu() {
		stop = true;
	}

	public void select() {
		while(!stop) {
			System.out.println("1. �̸� �˻�");
			System.out.println("2. ��ü �˻�");
			System.out.println("3. ���� �޴�");
			System.out.print("��ȣ ���� : ");
			int num = Integer.parseInt(scanner.next());
			
			switch(num) {
			case 1: selectByName();break;
			case 2: selectAll();break;
			case 3: toMainMenu();break;
			}
		}
	}

	public void selectByName() {
		System.out.print("�˻��� �̸��� �Է� : ");
		String name = scanner.next();
		schoolDAO.selectArticleByName(name);
	}

	public void selectAll() {
		schoolDAO.selectArticle();
	}

	public void delete() {
		System.out.print("������ �̸� �Է� : ");
		String name = scanner.next();
		schoolDAO.deleteArticle(name);
	}

	public void exit() {
		stopMenu = true;
	}
}
