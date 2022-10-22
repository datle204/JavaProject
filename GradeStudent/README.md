
I. Interface Design

Simple console interface
Display information in a clear and easy-to-see block

![image1 (1)](https://user-images.githubusercontent.com/35893418/197316396-388fa692-61dc-41cb-91f6-0fc3136bacd5.png)

II. Basic Functional Requirements

1. When the program is run, it will first display a brief description of the program so that the user can understand how the system will work and what functions it has. For example, in the above log, the message displayed is: “This program reads exam/homework scores and reports your overall course grade”.

2. Then, the user will enter the midterm exam score - Midterm: In the midterm exam score, the information to enter is:

+ Weight (0-100): ie the weight of the midterm exam score, and the weight has a positive integer value between 0 and 100. The example in this is 20.
+ Score earned: is the score that the user has achieved. The example in this is 78.
+ Were scores shifted (1 = yes, 2=no): is your score increased, choose 1 if yes, select 2 if not. The example in this is 2, which means not incremented. Since it is not incremented, the following line will always display total points.
+ Total points: is the total number of points, including the initial score and the number of additional points, the maximum point of total point is 100. For example in this point will be 78 + 0 = 78.
+ Weighted score: Is the score calculated based on weights. The example in this would be weighted score = (78/100) * 20 = 15.6 . 15.6 is a score on a 20-point scale.

3. Next, the user will enter the final exam score - Final: In the final exam score, the information to enter is:

+ Weight (0-100): ie the weight of the midterm exam score, and the weight has a positive integer value between 0 and 100. The example in this is 35.
+ Score earned: is the score that the user has achieved. The example in this is 95.
+ Were scores shifted (1 = yes, 2=no): is your score increased, choose 1 if yes, select 2 if not. The example in this is 1, which means incremented. Because it is incremented, after this line there will be a line to enter Shift amount.
+ Shift amount: is the number of points that have been increased. The example in this is 10.
+ Total points: is the total number of points, including the initial score and the number of additional points, the maximum point of total points is 100. For example in this point will be 95 + 10 = 105. But the maximum of total points is 100 only. , so total will only be counted as 100.
+ Weighted score: Is the score calculated based on weights. The example in this would be weighted score = (100/100) * 35 = 35.0/35 . 35 is a score on a 35-point scale.

4. Finally, the user will enter the homework score- Homework: In the homework score, the information to enter is:

- Weight (0-100): ie the weight of the homework score, and the weight has a positive integer value that will range from 0 to 100. The example in this is 45. (must make sure the sum is total. 3 weights are exactly 100).

- Number of assignments: is the total number of homework to do. The example in this is 3 assignments.

- Accordingly, the number of points to enter is the first 3 points of assignment. For each assignment, students need to enter both parameters, score and max.

Assignment 1 score and max: 18 20 where 18 is the actual score achieved by the student, and 20 is the maximum score of assignment 1.
Assignment 2 score and max: 29 32 where 29 is the actual score achieved by the student, and 32 is the maximum score of assignment 2.
Assignment 3 score and max: 31 40 where 31 is the actual score achieved by the student, and 40 is the maximum score of assignment 3.

- How many sections did you attend: 4 is the number of sessions the student attended and took attendance. This score can be understood as calculating the attendance score for the student.

- Section points: Is the total number of points of attendance of the student, with each attendance session, the student will be counted 5 points. And the maximum score for this attendance is 30. In this case the student's attendance score is: 4 x 5 = 20. Total section points is 20/30.

- Total points: is the total score of the student. For example in this case the total score of the student is total = 18 + 29 + 31 + 20 = 98. The maximum score of the exercise part is: 20 + 32 + 40 + 30 = 122.

- Weighted score: is the actual weighted score. For example in this weighted score = 98/122 * 45 = 36.1/45

![image2](https://user-images.githubusercontent.com/35893418/197316530-68198ad1-6023-4748-b0c8-7db47119e1be.png)

5. Show total results by subject

- Overall percentage: 86.7 This is the total score achieved by students of 3 subjects on a 100-point scale. For example, in this example, overall percentage = 20 + 35 + 45

- Your grade will be at least: 3.0 is the minimum grade students can achieve based on the average score. Grade max is 4.0. Minimum grade (min grade) based on overall percentage According to the following formula:

- Rules for calculating min grade: 85% and above: 3.0; 84.99% - 75%: 2.0; 74.99% - 60%: 0.7; under 60%: 0.0. In this example it's 86.7, which is greater than 85%, so the min GPA would be 3.0.

- After the display of min GPA you can display an arbitrary notice (comment) based on the student's GPA.

Conditions that need to be met

Total weighted score: the weight of the 3 test scores must sum exactly 100. Less than or greater than 100 is not allowed. The example in this is 20 + 35 + 45 = 100.
The maximum score of the Assignment section is 150, if exceeded, it will only be counted as 150 points.
The maximum score of the Attend section is 30, if it exceeds 30, it will still be counted as 30.
The Weighted score part will be rounded to 1 digit after the decimal point.

Part 2. Code organization

All the code will be placed in the file GradeStudent.java

The program will have a main() function that controls the main flow of the program. In the main function will call the subfunctions as follows:

+ begin() function to display the welcome message.
+ midterm() function to enter and calculate midterm exam scores.
+ finalterm() function to enter and calculate the final exam score.
+ homework() function to enter and calculate homework scores.
+ report() function to calculate the display of GPA results as well as the corresponding comment message.

[VI]

Phần 1: Chức năng và yêu cầu cơ bản

1. Thiết kế giao diện

Giao diện đơn thuần dạng console 
Hiển thị thông tin thành khối rõ ràng và dễ nhìn

![image1 (1)](https://user-images.githubusercontent.com/35893418/197316615-eba1efff-3437-4ee8-a7ad-c5ebbde500af.png)


Hình trên là màn hình là ví dụ một log console của hệ thống.

2. Yêu cầu chức năng cơ bản

1. Khi chương trình được chạy, thì đầu tiên, sẽ hiển thị thông báo mô tả ngắn gọn về chương trình để người dùng hiểu được hệ thống này sẽ hoạt động thế nào, có chức năng gì. Ví dụ trong log trên thì thông báo hiển thị là: “This program reads exam/homework scores and reports your overall course grade”. 

2. Sau đó, người dùng sẽ nhập điểm thi giữa kỳ - Midterm: Trong điểm thi giữa kỳ thì thông tin cần nhập là: 

Weight (0-100): tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 20.
Score earned: là điểm số mà người dùng đã đạt được. Ví dụ trong này là 78. 
Were scores shifted (1 = yes, 2=no): là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không. Ví dụ trong này là 2, có nghĩa là không được tăng.  Vì không được tăng, nên dòng thông tin sau sẽ hiển thị luôn total points. 
Total points: là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100. Ví dụ trong này điểm sẽ là 78 + 0  = 78. 
Weighted score: Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (78/100) * 20 = 15.6 . 15.6 là điểm số tính trên thang điểm 20. 
3. Tiếp theo, người dùng sẽ nhập điểm thi cuối kỳ - Final: Trong điểm thi cuối kỳ thì thông tin cần nhập là:

Weight (0-100): tức là trọng số của điểm thi giữa kỳ, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 35.
Score earned: là điểm số mà người dùng đã đạt được. Ví dụ trong này là 95. 
Were scores shifted (1 = yes, 2=no): là điểm thi bạn có được tăng không, chọn 1 nếu có, chọn 2 nếu không. Ví dụ trong này là 1, có nghĩa là được tăng. Vì là được tăng, nên sau dòng này sẽ có dòng nhập Shift amount. 
Shift amount:  là số điểm mà đã được tăng. Ví dụ trong này là 10. 
Total points: là tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm, điểm tối đa của total point là 100. Ví dụ trong này điểm sẽ là 95 + 10 = 105. Nhưng maximum của total points là 100 thôi, nên total sẽ chỉ được tính là 100. 
Weighted score: Là điểm số đã tính dựa trên trọng số. Ví dụ trong này sẽ là weighted score =  (100/100) * 35 = 35.0/35 . 35 là điểm số tính trên thang điểm 35. 
4. Cuối cùng, người dùng sẽ nhập điểm bài tập về nhà- Homework: Trong điểm bài tập về  thì thông tin cần nhập là:

- Weight (0-100): tức là trọng số của điểm bài tập về nhà, và trọng số có giá trị là số nguyên dương sẽ nằm trong khoảng từ 0 tới 100. Ví dụ trong này là 45. (phải đảm bảo tổng 3 trọng số chính xác là 100).

- Number of assignments: là tổng số bài tập về nhà cần làm. Ví dụ trong này là 3 assignment. 

- Theo đó số lượng đầu điểm cần nhập là 3 đầu điểm assignment. Với mỗi đầu điểm assignment thì sinh viên cần nhập cả 2 tham số là score và max. 

Assignment 1 score and max:  18 20 trong đó 18 là điểm số thực của sinh viên đạt được, và 20 là điểm tối đa của bài assignment 1. 
Assignment 2 score and max:  29 32 trong đó 29 là điểm số thực của sinh viên đạt được, và 32 là điểm tối đa của bài assignment 2. 
Assignment 3 score and max:  31 40 trong đó 31 là điểm số thực của sinh viên đạt được, và 40 là điểm tối đa của bài assignment 3. 
- How many sections did you attend: 4 là số lượng buổi học sinh viên đã đi học và được điểm danh. Điểm này có thể hiểu là tính điểm chuyên cần cho sinh viên. 

- Section points: Là tổng số điểm chuyên cần của sinh viên, với mỗi buổi được điểm danh, thì sinh viên sẽ được tính 5 điểm. Và tối đa điểm tính cho phần chuyên cần (attend) này là 30. Trong trường hợp này điểm chuyên cần của sinh viên là: 4 x 5 = 20. Total section points là 20/30. 

- Total points: là tổng điểm số của sinh viên. Ví dụ trong trường hợp này tổng số điểm số của sinh viên đạt được là total = 18 + 29 + 31 + 20 = 98. Điểm tối đa của phần bài tập là: 20 + 32 + 40 + 30 = 122. 

- Weighted score: là điểm tính theo trọng số thực tế. Ví dụ trong này weighted score = 98/122 * 45 =  36.1/45

Có thể tham khảo cách tính tổng quát trong công thức sau: 

![image2](https://user-images.githubusercontent.com/35893418/197316623-58beeae6-e6fa-477c-b1a2-a3679707a365.png)


5. Hiển thị kết quả tổng cộng theo môn

- Overall percentage: 86.7 đây là tổng điểm sinh viên đạt được của 3 môn tính theo thang điểm 100. Ví dụ trong này thì overall percentage = 20 + 35 + 45

- Your grade will be at least: 3.0 là grade tối thiểu sinh viên có thể đạt được dựa vào điểm số trung bình. Grade max là 4.0. Grade tối thiểu (min grade) dựa vào overall percentage Theo công thức sau: 

- Quy tắc tính min grade: 85% and above: 3.0; 84.99% - 75%: 2.0; 74.99% - 60%: 0.7; under 60%: 0.0. Trong ví dụ này là 86.7, tức là rơi vào khoảng lớn hơn 85%, nên min GPA sẽ là 3.0. 

- Sau phần hiển thị min GPA bạn có thể hiển thị thông báo (nhận xét) tuỳ ý dựa vào GPA của sinh viên. 

Các điều kiện cần đảm bảo

Tổng điểm trọng số: trọng số của 3 phần điểm thi phải có tổng chính xác là 100. Nhỏ hơn hoặc lớn hơn 100 đều không được. Ví dụ trong này là 20 + 35 + 45 = 100. 
Điểm tối đa của phần Assignment là 150, nếu vượt quá thì cũng chỉ tính là 150 điểm. 
Điểm tối đa của phần Attend là 30, nếu vượt quá 30 thì vẫn chỉ tính là 30. 
Phần Weighted score sẽ được làm tròn tới 1 chữ số đằng sau dấu thập phân. 
Phần 2. Tổ chức code

Toàn bộ code sẽ đặt trong file GradeStudent.java 

Chương trình sẽ có hàm main() điều khiển luồng chính của chương trình. Trong hàm main sẽ gọi các hàm con như sau: 

Hàm begin() để hiển thị thông điệp chào mừng.

Hàm midterm() để nhập và tính toán điểm thi giữa kỳ.

Hàm finalterm() để nhập và tính toán điểm thi cuối kỳ. 

Hàm homework() để nhập và tính toán điểm bài tập về nhà.

Hàm report() để tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét tương ứng. 
