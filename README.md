# bai-toan-cong-ty-truelove
bai toan cong ty truelove- HaUI
BÁO CÁO BÀI TẬP NHÓM 5 BÀI 8 PHIẾU 4

I.	 Bài toán
1.	Công ty TrueLove cần lưu tên của các nhân viên của mình. Mỗi tháng một nhân viên sẽ được chọn ngẫu nhiên để nhận một quà tặng. Hãy dùng tuyển tập để viết chương trình quản lý danh sách nhân viên. 
2.	Công ty TrueLove cần đặt tên cho sản phẩm mới, tên sản phẩm được chọn từ tên của nhân viên, vì vậy tên không được trùng, tên chỉ được dùng có 1 lần. Hãy dùng tuyển tập để viết chương trình cung cấp tên cho sản phẩm mới. 
3.	Công ty TrueLove muốn dùng tên phổ biến nhất cho sản phẩm của họ, tên phổ biến là tên giống nhau nhiều nhất. Hãy dùng tuyển tập để viết chương trình cung cấp tên cho sản phẩm. 
4.	Công ty TrueLove muốn cho nhân viên đi du lịch, chính sách được tạo ra là ưu tiên cho những người đăng ký trước. Hãy dùng tuyển tập để viết chương trình đăng ký du lịch. 
5.	Công ty TrueLove muốn tạo danh sách các khách hàng theo thứ tự tăng dần theo doanh số. Hãy dùng tuyển tập để viết chương trình quản lý danh sách khách hàng: thêm/ sửa/xóa/ tìm kiếm/ sắp xếp.
II.	Yêu cầu bài toán
-	Lựa chọn cấu trúc tập hợp nào để lưu trữ và xử lý dữ liệu 
-	Liệt kê các phép toán được sử dụng để hoàn thành yêu cầu kể trên 
-	Mô tả lớp và mối quan hệ lớp biểu diễn bài toán trên. 
-	Đưa ra mô hình tổ chức và đóng gói mã lệnh (Vẽ sơ đồ hoặc liệt kê giả mã lệnh) 
-	Thực hiện nội dung hàm main thực thi yêu cầu bài toán. 
-	Cài đặt bài toán thực hiện yêu cầu trên. 
 
III.	Phân công công việc
Nội dung thực hiện	Thành viên thực hiện
Quản lý nhân viên, quản lý sản phẩm	Chu Văn Mạnh, Nguyễn Viết Dương
Bài toán I.1, I.2	Chu Văn Mạnh
Bài toán I.3, I.4	Nguyễn Viết Dương
Bài toán I.5, Đọc ghi file	Đặng Đức Thọ
Main	Nguyễn Viết Dương, Chu Văn Mạnh, Đặng Đức Thọ
IV.	Chức năng:
-	Hiển thị danh sách nhân viên
-	Quản lí danh sách nhân viên:
o	Thêm một nhân viên
o	Hiển thị tất cả nhân viên
o	Sửa thông tin nhân viên theo mã nhân viên
o	Tìm kiếm theo mã nhân viên
o	Xoá nhân viên theo mã nhân viên
o	Trở về menu chính
-	Nhân viên ngẫu nhiên được tặng quà trong tháng
-	Cung cấp tên cho sản phẩm
-	Tên phổ biến cho sản phẩm
-	Hiển thị danh sách nhân viên đăng kí du lịch
-	Hiển thị danh sách khách hàng tăng dần doanh thu
-	Quản lí danh sách khách hàng
o	Thêm một khách hàng
o	In danh sách khách hàng
o	Sửa thông tin khách hàng theo mã khách hàng
o	Tìm kiếm theo mã khách hàng
o	Tìm kiếm theo doanh số
o	Xoá khách hàng theo mã khách hàng
o	Trở về menu chính
-	Đọc ghi file
o	Xuất thông tin nhân viên ra file
o	Đọc thông tin nhân viên từ file
o	Xuất thông tin sản phẩm ra file
o	Đọc thông tin sản phẩm từ file
o	Xuất thông tin khách hàng ra file
o	Đọc thông tin khách hàng từ file
o	Trở về menu chính
V.	Mô hình tổ chức




VI.	 Phân tích chi tiết
1.	Phân lớp: 7 class
-	Employee
-	Customer
-	Product
-	ListEmployee
-	ListCustomer
-	ListProduct
-	Main
2.	Cấu trúc tập hợp lưu trữ
-	Cấu trúc tập hợp lưu trữ nhân viên: ArrayList( hoặc LinkedList)
-	Cấu trúc tập hợp lưu trữ sản phẩm: HashSet
-	Cấu trúc tập hợp lưu trưc khách hàng: TreeMap
3.	Các phép toán thực hiện
-	Chọn nhân viên ngẫu nhiên để nhận một quà tặng
Ta khởi tạo một mảng bằng collection ArrayList để lưa trữ danh sách nhân viên đã được nhận quà (Mỗi nhân viên chỉ được nhận quà may mắn 1 lần)
Sử dụng một hàm check để kiểm tra nhân viên ngẫu nhiên đã được nhận quà chưa. Nếu đã nhận quà thì bỏ qua, còn nếu chưa nhận thì thêm vào danh sách nhân viên đã nhận quà. Khi tất cả nhân viên đã được nhận quà thì thông báo.
-	Cung cấp tên cho sản phẩm:
Ta sử dụng collection HashSet để lưu trữ tên sản phẩm (Tên sản phẩm không được trùng lặp)
Vì tên sản phẩm dựa trên tên nhân viên, tên bước đầu chúng ta sẽ chuyển danh sách lưu trữ nhân viên thành Set để loại trừ những nhân viên có tên trùng lặp. Sau đó, ta sẽ chọn ngẫu nhiên trong khoảng 0 đến độ rộng của collection Set này để lấy ra tên nhân viên để cung cấp cho sản phẩm.
Trước khi thêm tên vừa lấy vào danh sách sản phẩm thì ta sẽ kiểm tra xem tên đó đã có trong danh sách chưa, nếu chưa có thì ta thêm mới và hiển thị danh sách ra màn hình
Khi tất cả tên nhân viên đã được sử dụng thì thông báo ra màn hình.
-	Cung cấp tên phổ biến nhất cho sản phẩm
Vì tên sản phẩm được dựa trên tên nhân viên nên ta sẽ thao tác bên danh sách nhân viên rồi gán cho tên sản phẩm phổ biến nhất.
Đầu tiên ta khởi tạo 1 danh sách HashTable với key là tên nhân viên và value là số nhân viên có tên trùng.
Sau đó ta duyệt từng phần tử trong sanh sách nhân viên, sau mỗi lần duyệt, ta lưu cặp giá trị <tên, số lần trùng lặp> vào danh sách HashTable ở trên.
Sau khi duyệt hết toàn bộ các phần tử, ta kiểm tra số lần trùng lặp lớn nhất ở trong danh sách HashTable rồi trả về key tương ứng và đó cũng chính là tên nhân viên được trùng nhiều nhất.
Sau đó ta trở lại danh sách sản phẩm và gán tên phổ biến cho sản phẩm.
-	Danh sách nhân viên đăng kí du lịch
Ta dùng ArrayList để lưu trữ nhân viên đăng kí du lịch.
Đầu tiên ta sẽ duyệt toàn bộ nhân viên trong danh sách nhân viên, sau đó ta sẽ thêm những nhân viên có thuộc tính dangKyDL là 1 và thêm vào danh sách đăng kí du lịch.
Để đảm bảo tính ưu tiên cho những ai đăng kí trước, ta sắp xếp danh sách đăng kí du lịch tăng dần theo ngày đăng kí. 
-	Quản lí danh sách khách hàng tăng dần theo doanh số
Sử dụng cấu trúc tập hợp TreeMap để lưu trữ danh sách khách hàng trên do TreeMap lưu trữ dữ liệu dưới dạng cặp key và value, các key được thêm vào theo thứ tự key tăng dần. Với các đặc điểm trên TreeMap là lựa chọn phù hợp cho bài toán.
Danh sách khách hàng sẽ được lưu trữ với cặp key là doanh số và value là Khách hàng.


![image](https://user-images.githubusercontent.com/89138046/171241392-a8a41592-60c3-47fb-9120-ae17141fadc0.png)
