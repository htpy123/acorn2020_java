package main.marin;

import java.util.Scanner;

import main.marin_status.Marine_My_HP;

public class Main_Marine {
	public static void main(String[] args) {
		System.out.println("--야생의 포켓몬을 만났다--");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		Marine_My_HP marine = new Marine_My_HP();
		marine.marin();
	}
}
