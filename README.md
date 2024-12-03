# Hệ Thống Quản Lý Thư Viện

## 1. Luồng Mượn Sách
**Mô tả:** Người dùng mượn sách từ thư viện.

**Các bước:**
1. Người dùng tìm sách cần mượn. (Xem được các thông tin cơ bản về sách và số lượng sách, ...)
2. Mượn sách
    - Giảm số lượng sách.
    - Ghi nhận thông tin mượn sách vào hệ thống.
    - Nếu số lượng = 0 thì không cho mượn.
    - Gửi thông báo đến người dùng.

## 2. Luồng Trả Sách
**Mô tả:** Người dùng trả sách đã mượn.

**Các bước:**
1. Người dùng chọn sách cần trả từ danh sách sách đã mượn.
2. Trả sách
    - Kiểm tra thời gian trả để xác định có quá hạn hay không.
    - Nếu quá hạn, tính phí phạt và cập nhật tài khoản người dùng (rule tính phạt).
    - Ghi nhận thông tin trả sách vào hệ thống.
    - Số lượng sách vừa trả trong thư viện tăng lên.
    - Gửi thông báo xác nhận trả sách.
    - Cập nhật thống kê việc trả sách.

## 3. Luồng Đăng Ký Thành Viên
**Mô tả:** Người dùng mới đăng ký làm thành viên thư viện.

**Các bước:**
1. Người dùng điền thông tin cá nhân và gửi yêu cầu đăng ký.
2. Hệ thống kiểm tra thông tin và xác minh.
3. Tạo tài khoản người dùng trong cơ sở dữ liệu.
4. Cấp quyền sử dụng thư viện và gửi thông báo thành công.

## 4. Luồng Quản Lý Sách
**Mô tả:** Quản trị viên quản lý thông tin sách trong thư viện.

**Các bước:**

### Thêm sách mới:
1. Nhập thông tin sách (tựa đề, tác giả, thể loại, số lượng).
2. Lưu thông tin sách vào cơ sở dữ liệu.

### Cập nhật thông tin sách:
1. Sửa thông tin sách (ví dụ: số lượng, giá, tình trạng).

### Xóa sách:
1. Xóa thông tin sách khỏi hệ thống (nếu không còn tồn tại hoặc bị hư hỏng).

## 5. Luồng Quản Lý Người Dùng
**Mô tả:** Quản trị viên theo dõi và quản lý tài khoản người dùng.

**Các bước:**
1. Xem danh sách người dùng.
2. Cập nhật thông tin người dùng (tên, địa chỉ, trạng thái tài khoản).
3. Khóa/mở khóa tài khoản người dùng nếu có vi phạm hoặc cần xác minh.

## 6. Luồng Tìm Kiếm và Tra Cứu
**Mô tả:** Người dùng tìm kiếm thông tin sách.

**Các bước:**
1. Nhập từ khóa tìm kiếm (tựa đề, tác giả, thể loại).
2. Hệ thống tìm kiếm trong cơ sở dữ liệu và trả về kết quả.
3. Người dùng chọn sách từ danh sách kết quả.
4. Hiển thị chi tiết sách, bao gồm: số lượng có sẵn, trạng thái.

**Status:**
- todo
- đã đặt
- đã tới lấy sách

## 7. Luồng Thống Kê Hoạt Động
**Mô tả:** Theo dõi và thống kê các hoạt động của thư viện.

**Các bước:**

### Thống kê sách mượn:
1. Số lượt mượn theo ngày/tuần/tháng.
2. Các sách được mượn nhiều nhất.

### Thống kê sách trả:
1. Tỷ lệ trả đúng hạn.
2. Các trường hợp vi phạm (quá hạn, mất sách).

### Thống kê người dùng:
1. Số lượng thành viên hoạt động.
2. Người dùng tích cực nhất.

## 8. Luồng Xử Lý Vi Phạm
**Mô tả:** Quản lý các trường hợp vi phạm quy định của thư viện.

**Các bước:**
1. Phát hiện vi phạm (quá hạn, mất sách, hư hỏng sách).
2. Gửi cảnh báo hoặc thông báo phạt đến người dùng.
3. Ghi nhận vi phạm vào hệ thống.
4. Quản trị viên xử lý vi phạm (tính phí phạt, cấm mượn sách, khóa tài khoản).

## 9. Luồng Báo Cáo Sự Cố
**Mô tả:** Người dùng hoặc quản trị viên báo cáo sự cố liên quan đến sách hoặc hệ thống.

**Các bước:**
1. Người dùng gửi báo cáo sự cố (sách hư hỏng, hệ thống lỗi).
2. Hệ thống lưu thông tin báo cáo.
3. Quản trị viên tiếp nhận và xử lý sự cố.
4. Gửi phản hồi đến người dùng.

## 10. Báo cáo thống kê
**Mô tả:** Admin muốn xem thống kê xuất - nhập sách và doanh thu trong tháng.

**Các bước:**
1. Báo cáo xuất
2. Báo cáo nhập
3. Báo cáo doanh thu