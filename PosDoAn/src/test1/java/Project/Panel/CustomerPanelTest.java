package Project.Panel;

import Project.Database.DatabaseConnector;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class CustomerPanelTest {
    private CustomerPanel customerPanel;
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        customerPanel = new CustomerPanel(); // Khởi tạo đối tượng CustomerPanel
        connection = DatabaseConnector.connectDatabase(); // Kết nối đến cơ sở dữ liệu

        // Giả lập bảng để kiểm tra
        DefaultTableModel model = (DefaultTableModel) customerPanel.dataTable.getModel();
        model.setRowCount(0);

        // Reset bảng Customer trước khi mỗi test chạy
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM customer")) {
            stmt.executeUpdate();
        }
    }

    @Test
    public void testSaveButtonActionPerformed() throws SQLException {
        // Thiết lập giá trị cho các trường nhập liệu
        setFieldValue("nameTxtField", new JTextField("John Doe"));
        setFieldValue("telephoneNumberTxtField", new JTextField("0123456789"));

        // Giả lập hành động khi nhấn nút "Lưu"
        customerPanel.saveButton.doClick(); // Gọi sự kiện nhấn nút

        // Kiểm tra xem bảng đã được cập nhật chưa
        DefaultTableModel model = (DefaultTableModel) customerPanel.dataTable.getModel();
        assertEquals(1, model.getRowCount()); // Kiểm tra số dòng trong bảng
        assertEquals("John Doe", model.getValueAt(0, 1)); // Kiểm tra tên khách hàng
        assertEquals("0123456789", model.getValueAt(0, 2)); // Kiểm tra số điện thoại
    }

    @Test
    public void testSearchButtonActionPerformed() throws SQLException {
        // Thêm một khách hàng vào bảng
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (customer_name, telephone_number) VALUES (?, ?)")) {
            stmt.setString(1, "John Doe");
            stmt.setString(2, "0123456789");
            stmt.executeUpdate();
        }

        // Giả sử ID được tạo là KH0000001, bạn cần kiểm tra ID này trong cơ sở dữ liệu
        String customerId = getCustomerId("John Doe", "0123456789");

        // Thiết lập giá trị cho trường tìm kiếm
        setFieldValue("searchByIDTxtField", new JTextField(customerId)); // Sử dụng ID vừa tạo

        // Giả lập hành động khi nhấn nút "Tìm"
        customerPanel.searchButton.doClick(); // Gọi sự kiện nhấn nút

        // Kiểm tra xem giá trị đã được thiết lập không
        assertEquals("John Doe", customerPanel.nameTxtField.getText()); // Kiểm tra tên
        assertEquals("0123456789", customerPanel.telephoneNumberTxtField.getText()); // Kiểm tra số điện thoại
    }

    @Test
    public void testDeleteButtonActionPerformed() throws SQLException {
        // Thêm một khách hàng vào bảng
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (customer_name, telephone_number) VALUES (?, ?)")) {
            stmt.setString(1, "John Doe");
            stmt.setString(2, "0123456789");
            stmt.executeUpdate();
        }

        // Lấy ID khách hàng
        String customerId = getCustomerId("John Doe", "0123456789");

        // Thiết lập giá trị cho trường tìm kiếm
        setFieldValue("searchByIDTxtField", new JTextField(customerId)); // Sử dụng ID vừa tạo

        // Giả lập hành động khi nhấn nút "Xóa"
        customerPanel.deleteButton.doClick(); // Gọi sự kiện nhấn nút

        // Kiểm tra xem bảng đã được cập nhật chưa
        DefaultTableModel model = (DefaultTableModel) customerPanel.dataTable.getModel();
        assertEquals(0, model.getRowCount()); // Kiểm tra số dòng trong bảng sau khi xóa
    }

    @Test
    public void testUpdateButtonActionPerformed() throws SQLException {
        // Thêm một khách hàng vào bảng
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (customer_name, telephone_number) VALUES (?, ?)")) {
            stmt.setString(1, "John Doe");
            stmt.setString(2, "0123456789");
            stmt.executeUpdate();
        }

        // Lấy ID khách hàng
        String customerId = getCustomerId("John Doe", "0123456789");

        // Thiết lập giá trị cho các trường nhập liệu
        setFieldValue("searchByIDTxtField", new JTextField(customerId)); // Sử dụng ID vừa tạo
        setFieldValue("nameTxtField", new JTextField("Jane Doe"));
        setFieldValue("telephoneNumberTxtField", new JTextField("0987654321"));

        // Giả lập hành động khi nhấn nút "Cập nhật"
        customerPanel.updateButton.doClick(); // Gọi sự kiện nhấn nút

        // Kiểm tra xem bảng đã được cập nhật chưa
        DefaultTableModel model = (DefaultTableModel) customerPanel.dataTable.getModel();
        assertEquals(1, model.getRowCount()); // Kiểm tra số dòng trong bảng
        assertEquals("Jane Doe", model.getValueAt(0, 1)); // Kiểm tra tên đã được cập nhật
        assertEquals("0987654321", model.getValueAt(0, 2)); // Kiểm tra số điện thoại đã được cập nhật
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null) {
            connection.close(); // Đóng kết nối sau khi test
        }
    }

    // Phương thức để thiết lập giá trị cho thuộc tính private
    private void setFieldValue(String fieldName, Object value) {
        try {
            Field field = CustomerPanel.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(customerPanel, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức để lấy customer_ID từ cơ sở dữ liệu
    private String getCustomerId(String name, String phone) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT customer_ID FROM customer WHERE customer_name = ? AND telephone_number = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("customer_ID");
            }
        }
        return null; // Nếu không tìm thấy
    }
}