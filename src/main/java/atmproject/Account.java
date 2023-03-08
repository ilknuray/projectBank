package atmproject;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber;
    private int pinNumber;

    private double savingBalance;
    private double checkingBalance;

    DecimalFormat paraFormati = new DecimalFormat("'$',###,##0.00");


    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    Scanner input = new Scanner(System.in);

    public Account() {

    }

    public Account(int accountNumber, int pinNumber, double savingBalance, double checkingBalance, Scanner input) {
        this.accountNumber = accountNumber;
        this.pinNumber = pinNumber;
        this.savingBalance = savingBalance;
        this.checkingBalance = checkingBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", pinNumber=" + pinNumber +
                ", savingBalance=" + savingBalance +
                ", checkingBalance=" + checkingBalance +
                '}';
    }

    //paraCekmeIslemiSonrasiKalanMiktar
    private double calculateCheckingBalanceAfterWithdraw(double miktar) {

        checkingBalance = checkingBalance - miktar;

        return checkingBalance;
    }
    //para yatirma isleminden sonra kalan bakiyeyi hesapla

    private double calculeteCheckingBalanceAfterDeposit(double yatirilanMiktar) {

        checkingBalance = checkingBalance + yatirilanMiktar;

        return checkingBalance;
    }

    private double calculateSavingBalanceAftrWithdraw(double miktar) {

        savingBalance = savingBalance - miktar;


        return savingBalance;
    }

    private double calculateSavingBalanceAfterDepost(double yatirilanMiktar) {

        savingBalance = savingBalance + yatirilanMiktar;
        return savingBalance;
    }

    //musteri ile para cekmek icin etkilesime girelim
    public void getCheckingWithDraw() {
     bakiyemiGoster(checkingBalance);
        System.out.println("Lutfen cekmek istediginiz para miktarini giriniz");
        double paraMiktari = input.nextDouble();
        if (paraMiktari <= 0) {
            System.out.println("Lutfen gecerli bir miktar giriniz");
            getCheckingWithDraw();//methodun kendisini kendi icinde tekrar cagirarak ona yeni bir hak taniriz==>recursive method(kendini tekrar cagirma)
        } else if (paraMiktari <= checkingBalance) {
            calculateCheckingBalanceAfterWithdraw(paraMiktari);
        }

    }

    public void getCheckingDeposit() {
        bakiyemiGoster(checkingBalance);
        System.out.println("Yatirmak istediginiz bakiyeyi giriniz");
        double paraMiktari = input.nextDouble();
        if (paraMiktari <= 0) {
            System.out.println("gecersiz bakiye girdiniz");
            getCheckingDeposit();
        } else {
            calculeteCheckingBalanceAfterDeposit(paraMiktari);
            System.out.println();
            bakiyemiGoster(checkingBalance);
        }

    }

    public void bakiyemiGoster(double balance) {
        System.out.println("hesabinizda bulunan bakiye : " + paraFormati.format(balance));

    }

    public void getSavingWithdraw() {//savig para cekme
        bakiyemiGoster(savingBalance);
        System.out.println("cekmek istediginizmiktari giriniz");
        double paraMiktari = input.nextDouble();
        if (paraMiktari <= 0) {
            System.out.println("gecersiz bakiye");
            getSavingWithdraw();
        } else if (paraMiktari <= savingBalance) {
            calculateSavingBalanceAftrWithdraw(paraMiktari);
        }
    }

    public void getSavingDeposit() {//saving para yatirma
        bakiyemiGoster(savingBalance);
        System.out.println("yatirmak istediginiz baiyeyi giriniz");
        double paraMiktari = input.nextDouble();
        if (paraMiktari <= 0) {
            System.out.println("gecersiz bakiye");
            getSavingDeposit();
        } else {
            calculateSavingBalanceAfterDepost(paraMiktari);
            System.out.println();
            bakiyemiGoster(savingBalance);
        }
    }

}
