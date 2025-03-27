package Project.Panel;

import Project.Database.DatabaseConnector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EmployeePanelTest {
    private EmployeePanel employeePanel;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        // Khởi tạo đối tượng EmployeePanel
        employeePanel = new EmployeePanel();
        // Kết nối đến cơ sở dữ liệu
        connection = DatabaseConnector.connectDatabase();

        // Reset bảng Employee trước khi mỗi test chạy
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM employee")) {
            stmt.executeUpdate();
        }
    }

    @After
    public void tearDown() throws SQLException {
        // Đóng kết nối sau mỗi kiểm tra
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    @Test
    public void testSaveButtonActionPerformed() throws SQLException {
        // Thiết lập thông tin nhân viên
        employeePanel.nameTxtField.setText("Nguyễn Văn A");
        employeePanel.telephoneNumberTxtField.setText("0123456789");
        employeePanel.passwordTxtField.setText("password");
        employeePanel.positionComboBox.setSelectedItem("Quản lý");

        // Giả lập hành động nhấn nút Lưu
        employeePanel.saveButton.doClick();

        // Kiểm tra xem nhân viên đã được lưu thành công
        String sql = "SELECT * FROM employee WHERE employee_name = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "Nguyễn Văn A");
            ResultSet rs = pstmt.executeQuery();
            assertTrue(rs.next()); // Kiểm tra có dữ liệu
            assertEquals("0123456789", rs.getString("telephone_number"));
            assertEquals("password", rs.getString("password"));
            assertEquals("Quản lý", rs.getString("position"));
        }
    }

    @Test
    public void testSearchButtonActionPerformed() throws SQLException {
        // Giả lập thêm một nhân viên
        addEmployeeToDatabase("NV0000001", "Nguyễn Văn B", "0987654321", "password", "Tạp vụ");

        // Tìm kiếm nhân viên
        employeePanel.searchByIDTxtField.setText("NV0000001");
        employeePanel.searchButton.doClick();

        // Chờ một chút nếu cần thiết
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kiểm tra thông tin đã được hiển thị đúng
        assertEquals("Nguyễn Văn B", employeePanel.nameTxtField.getText());  // Kiểm tra tên nhân viên
        assertEquals("0987654321", employeePanel.telephoneNumberTxtField.getText()); // Kiểm tra số điện thoại
        assertEquals("Tạp vụ", employeePanel.positionComboBox.getSelectedItem()); // Kiểm tra vị trí

        // Thêm xác nhận rằng không có thông báo lỗi nào xuất hiện
        assertTrue(employeePanel.errorMessageLabel.getText().isEmpty()); // Kiểm tra label hiển thị thông báo lỗi
    }
    @Test
    public void testDeleteButtonActionPerformed() throws SQLException {
        // Giả lập thêm một nhân viên
        addEmployeeToDatabase("NV0000002", "Nguyễn Văn C", "1234567890", "password", "Thu ngân");

        // Xóa nhân viên
        employeePanel.searchByIDTxtField.setText("NV0000002");
        employeePanel.deleteButton.doClick();

        // Kiểm tra xem nhân viên đã bị xóa
        String sql = "SELECT * FROM employee WHERE employee_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "NV0000002");
            ResultSet rs = pstmt.executeQuery();
            assertTrue(!rs.next()); // Kiểm tra không có dữ liệu
        }
    }
    private void addEmployeeToDatabase(String employeeId, String name, String phone, String password, String position) throws SQLException {
        String sql = "INSERT INTO employee (employee_ID, employee_name, telephone_number, password, position) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, employeeId);
            pstmt.setString(2, name);
            pstmt.setString(3, phone);
            pstmt.setString(4, password);
            pstmt.setString(5, position);
            pstmt.executeUpdate();
        }
    }
    @Test
    public void testUpdateButtonActionPerformed() throws SQLException {
        // Giả lập thêm một nhân viênaddEmployeeToDatabase("NV0000003", "Nguyễn Văn D", "2345678901", "password", "Quản lý");
        //
        //        // Cập nhật thông tin nhân viên
        //        employeePanel.searchByIDTxtField.setText("NV0000003");
        //        employeePanel.nameTxtField.setText("Nguyễn Văn E");
        //        employeePanel.telephoneNumberTxtField.setText("9876543210");
        //        employeePanel.passwordTxtField.setText("newpassword");
        //        employeePanel.positionComboBox.setSelectedItem("Thu ngân");
        //        employeePanel.updateButton.doClick();
        //
        //        // Kiểm tra thông tin đã được cập nhật đúng
        //        String sql = "SELECT * FROM employee WHERE employee_ID = ?";
        //        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        //            pstmt.setString(1, "NV0000003");
        //            ResultSet rs = pstmt.executeQuery();
        //            if (rs.next()) {
        //                assertEquals("Nguyễn Văn E", rs.getString("employee_name"));
        //                assertEquals("9876543210", rs.getString("telephone_number"));
        //                assertEquals("newpassword", rs.getString("password"));
        //                assertEquals("Thu ngân", rs.getString("position"));
        //            } else {
        //                assertTrue("Nhân viên không tìm thấy", false);
        //            }
        //        }
        //    }
        //
        //    // Phương thức hỗ trợ để thêm một nhân viên vào cơ sở dữ liệu
        //    private void addEmployeeToDatabase(String employeeId, String name, String phone, String password, String position) throws SQLException {
        //        String sql = "INSERT INTO employee (employee_ID, employee_name, telephone_number, password, position) VALUES (?, ?, ?, ?, ?)";
        //        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        //            pstmt.setString(1, employeeId);
        //            pstmt.setString(2, name);
        //            pstmt.setString(3, phone);
        //            pstmt.setString(4, password);
        //            pstmt.setString(5, position);
        //            pstmt.executeUpdate();
        //        }
    }
}
