/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ttcsn_nhom7_ford_fulkerson;

import java.util.Scanner;

/**
 *
 * @author DELL 5625
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MaxFlowTest test = new MaxFlowTest();
        boolean check = false;
        do {
            System.out.println("KIEM THU CHUONG TRINH");
            System.out.println("1 : Test 1 : Do thi mau ");
            System.out.println("2 : Test 2 : Khong co duong di ");
            System.out.println("3 : Test 3: Nhieu duong di");
            System.out.println("4 : Test 4 : Ket noi day du");
            System.out.println("5 : Test 5 : Co chu trinh");
            System.out.println("6 : Thoat chuong trinh");
            System.out.println("Vui long nhap lua chon ");
            String luachon = sc.nextLine();
            switch (luachon) {
                case "1":
                    test.testSampleGraph();
                    break;
                case "2":
                    test.testNoPath();
                    break;
                case "3":
                    test.testMultiplePaths();
                    break;
                case "4":
                    test.testFullyConnected();
                    break;
                case "5":
                    test.testWithCycle();
                    break;
                case "6":
                    check = true;
                    System.out.print("Thoat chuong trinh ");
                    break;
                default:
                    System.out.print("Lua chon khong hop le !Vui long nhap lai lua chon ");
            }
        } while (!check);
    }
}
