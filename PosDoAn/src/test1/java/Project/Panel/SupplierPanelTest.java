package Project.Panel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Statement;

public class SupplierPanelTest {

    private SupplierPanel supplierPanel;

    @BeforeEach
    public void setUp() {
        supplierPanel = new SupplierPanel(); // Khởi tạo đối tượng SupplierPanel trước mỗi bài kiểm tra
    }

    @Test
    public void testAddSupplier() throws Exception {
        setTextFieldValue("Supplier A", "nameTxtField");
        setTextFieldValue("1234567890", "telephoneNumberTxtField");
        invokeButtonClick("saveButton");

        assertEquals(1, getDataTableRowCount()); // Kiểm tra rằng đã thêm nhà cung cấp thành công
    }

    @Test
    public void testUpdateSupplier() throws Exception {
        // Trước tiên thêm nhà cung cấp
        setTextFieldValue("Supplier A", "nameTxtField");
        setTextFieldValue("1234567890", "telephoneNumberTxtField");
        invokeButtonClick("saveButton");

        // Cập nhật thông tin
        setTextFieldValue("Supplier B", "nameTxtField");
        setTextFieldValue("0987654321", "telephoneNumberTxtField");

        setTextFieldValue("NCU0000001", "searchByIDTxtField"); // Giả sử ID đầu tiên là NCU0000001
        invokeButtonClick("updateButton");

        // Kiểm tra xem thông tin đã được cập nhật
        assertEquals("Supplier B", getTextFieldValue("nameTxtField"));
        assertEquals("0987654321", getTextFieldValue("telephoneNumberTxtField"));
    }

    @Test
    public void testDeleteSupplier() throws Exception {
        // Thêm nhà cung cấp để xóa
        setTextFieldValue("Supplier A", "nameTxtField");
        setTextFieldValue("1234567890", "telephoneNumberTxtField");
        invokeButtonClick("saveButton");

        // Xóa nhà cung cấp
        setTextFieldValue("NCU0000001", "searchByIDTxtField"); // ID giả định
        invokeButtonClick("deleteButton");

        // Kiểm tra rằng nhà cung cấp đã bị xóa
        assertEquals(0, getDataTableRowCount());
    }

    @Test
    public void testSearchSupplier() throws Exception {
        // Thêm nhà cung cấp để tìm kiếm
        setTextFieldValue("Supplier A", "nameTxtField");
        setTextFieldValue("1234567890", "telephoneNumberTxtField");
        invokeButtonClick("saveButton");

        // Tìm kiếm nhà cung cấp
        setTextFieldValue("NCU0000001", "searchByIDTxtField");
        invokeButtonClick("searchButton");

        // Kiểm tra thông tin đã được đưa vào các trường
        assertEquals("Supplier A", getTextFieldValue("nameTxtField"));
        assertEquals("1234567890", getTextFieldValue("telephoneNumberTxtField"));
    }

    // Phương thức tiện ích
    private void setTextFieldValue(String value, String fieldName) throws Exception {
        Field field = SupplierPanel.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(supplierPanel);
        textField.setText(value);
    }

    private void invokeButtonClick(String buttonName) throws Exception {
        Field field = SupplierPanel.class.getDeclaredField(buttonName);
        field.setAccessible(true);
        JButton button = (JButton) field.get(supplierPanel);
        button.doClick();
    }

    private int getDataTableRowCount() throws Exception {
        Field field = SupplierPanel.class.getDeclaredField("dataTable");
        field.setAccessible(true);
        JTable table = (JTable) field.get(supplierPanel);
        return table.getRowCount();
    }

    private String getTextFieldValue(String fieldName) throws Exception {
        Field field = SupplierPanel.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(supplierPanel);
        return textField.getText();
    }
}