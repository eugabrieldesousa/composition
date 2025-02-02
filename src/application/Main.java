package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Department name: ");
        String department = sc.nextLine();
        System.out.println("Enter the user data: ");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Level: ");
        String level = sc.nextLine();
        System.out.println("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(new Department(department), baseSalary, WorkerLevel.valueOf(level), name);

        System.out.println("How many contracts? ");
        int numberOfContracts = sc.nextInt();
        sc.nextLine();  // This line is added to consume the newline character after the number input.

        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println("Enter the data for contract number " + (i+1) + ": ");

            System.out.println("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.nextLine());
            System.out.println("Hourly rate: ");
            double hourlyRate = sc.nextDouble();
            sc.nextLine();
            System.out.println("Duration: hours: ");
            int hours = sc.nextInt();
            sc.nextLine();

            HourContract contract = new HourContract(contractDate, hourlyRate, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.println("Month and year: ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}
