import java.util.*;

public class GradeStudent {

    private static double percentTotalMid;
    private static double percentTotalFinal;
    private static double percentTotalHomeWork;

    private static int shiftAmountMid = 0;
    private static int shiftAmountFinal = 0;

    private static int weightMid;
    private static int weightFinal;

    public static void main(String[] args) {
        begin();
        midTerm();
        finalTerm();
        homeWork();
        report(percentTotalMid, percentTotalFinal, percentTotalHomeWork);
    }

    // Thông báo chào mừng
    public static void begin() {
        System.out.println("This program reads exam/homework scores");
        System.out.println("and reports your overall course grade.");
        System.out.println();
    }

    // Nhập và tính toán điểm thi giữa kỳ
    public static int midTerm() {

        Scanner console = new Scanner(System.in);
        System.out.println("Midterm:");
        System.out.print("Weight (0-100)? ");
        // Trọng số của điểm thi giữa kỳ (0-100);
        weightMid = console.nextInt();
        if (weightMid < 0 || weightMid > 100) {
            System.out.println("Weight must be in between 0 and 100. You must restart and type again!");
            System.exit(0);
        }
        System.out.print("Score earned? ");
        // Điểm số mà người dùng đã đạt được
        int scoreEarnedMid = console.nextInt();
        if(scoreEarnedMid > 100){
            scoreEarnedMid = Math.min(100, scoreEarnedMid);
        }
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int answerMid = console.nextInt();
        if(answerMid == 1){
            System.out.print("Shift amount? ");
            // Điểm được tăng
            shiftAmountMid = console.nextInt();
            
        }
        int totalPointsMid = Math.min(100, (scoreEarnedMid + shiftAmountMid));
        System.out.println("Total points = " + totalPointsMid + " / 100");
        percentTotalMid = ((double) totalPointsMid) * weightMid / 100;
        System.out.println("Weighted score = " + percentTotalMid + " / " + weightMid);

        System.out.println();
        return weightMid;
    }

    // Nhập và tính toán điểm thi cuối kỳ
    public static int finalTerm() {
        Scanner console = new Scanner(System.in);
        System.out.println("Final:");
        System.out.print("Weight (0-100)? ");
        // Trọng số của điểm thi cuối kỳ (0-100);
        weightFinal = console.nextInt();
        if (weightFinal < 0 || weightFinal > 100) {
            System.out.println("Weight must be in between 0 and 100. You must restart and type again!");
            System.exit(0);
        }
        System.out.print("Score earned? ");
        // Điểm số mà người dùng đã đạt được
        int scoreEarnedFinal = console.nextInt();

        if(scoreEarnedFinal > 100){
            scoreEarnedFinal = Math.min(100, scoreEarnedFinal);
        }

        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int answerFinal = console.nextInt();

        if(answerFinal == 1){
            System.out.print("Shift amount? ");
            // Điểm được tăng
            shiftAmountFinal = console.nextInt();
        }
        int totalPointsFinal = Math.min(100, (scoreEarnedFinal + shiftAmountFinal));
        System.out.println("Total points = " + totalPointsFinal + " / 100");
        percentTotalFinal = ((double) totalPointsFinal) * weightFinal / 100;
        System.out.println("Weighted score = " + percentTotalFinal + " / " + weightFinal);
        System.out.println();
        return weightFinal;
    }

    // Nhập và tính toán điểm bài tập về nhà
    public static int homeWork() {
        Scanner console = new Scanner(System.in);
        System.out.println("Homework:");
        System.out.print("Weight (0-100)? (The total of 3 weights must be 100): ");
        // Trọng số của điểm bài tập về nhà (0-100);
        int weightHome = console.nextInt();
        if(weightHome > (100-weightFinal-weightMid) || weightHome < (100-weightFinal-weightMid)){
           System.out.println("The total of 3 weights must be 100. You must restart and type again!");
           System.exit(0);
        }
        System.out.print("Number of assignments? ");
        // Số lượng Assignment
        int totalAsm = console.nextInt();
        int totalScoreHome = 0;
        int totalScoreHomeMax = 0;
        for (int i = 1; i <= totalAsm; i++) {
            System.out.print("Assignment " + i + " score and max? ");
            int scoreHome = console.nextInt();
            int scoreHomeMax = console.nextInt();
            totalScoreHome += scoreHome;
            totalScoreHomeMax += scoreHomeMax;
        }
        // Số lần tham gia học
        System.out.print("How many sections did you attend (0-6)? ");
        int sections = console.nextInt();
        // Tổng điểm sections, mỗi section đc 5 điểm
        int totalSectionPoints = Math.min(5 * sections, 30);
        // Max điểm section là 30;
        System.out.println("Section points = " + totalSectionPoints + " / 30");

        int totalScoreHomeWork = Math.min(totalScoreHome, 150) + totalSectionPoints;
        int totalScoreHomeWorkMax = Math.min(150, totalScoreHomeMax) + 30;

        System.out.println("Total points = " + totalScoreHomeWork + " / " + totalScoreHomeWorkMax);

        percentTotalHomeWork = Math.round(((double) totalScoreHomeWork) * weightHome *10.0/ totalScoreHomeWorkMax)/10.0;
        System.out.println("Weighted score = " + percentTotalHomeWork + " / " + weightHome);
        System.out.println();
        return weightHome;
    }

    // Tính toán và hiển thị kết quả GPA và thông báo nhận xét tương ứng
    public static void report(double percentTotalMid, double percentTotalFinal, double percentTotalHomeWork) {
        double percentage =  percentTotalMid + percentTotalFinal + percentTotalHomeWork;
        System.out.println("Overall percentage = "+ percentage);
        if(percentage >= 85){
            System.out.println("Your grade will be at least: 3.0");
            System.out.println("Your grade is very good.");

        }else if(percentage >= 75 && percentage < 85){
            System.out.println("Your grade will be at least: 2.0");
            System.out.println("Your grade is good.");
        }else if(percentage >= 60 && percentage < 75){
            System.out.println("Your grade will be at least: 1.0");
            System.out.println("Your grade is oK.");
        }else{
            System.out.println("Your grade will be : 0.0");
            System.out.println("Your need study again.");
        }
    }
}
