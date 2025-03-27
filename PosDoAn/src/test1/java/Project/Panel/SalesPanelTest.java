package Project.Panel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SalesPanelTest {

    private SalesPanel salesPanel;

    @BeforeEach
    public void setUp() {
        salesPanel = new SalesPanel();
    }

    @Test
    public void testAddProduct() throws Exception {
        setComboBoxValue("Product A");
        setTextFieldValue("2");
        invokeButtonClick("addProductButton");

        assertEquals(1, getDataTableRowCount());
    }

    @Test
    public void testRemoveProduct() throws Exception {
        testAddProduct(); // Thêm sản phẩm trước khi xóa

        invokeButtonClick("removeProductButton");

        assertEquals(0, getDataTableRowCount());
    }

    @Test
    public void testRemoveAllProducts() throws Exception {
        testAddProduct(); // Thêm một sản phẩm

        invokeButtonClick("removeAllButton");

        assertEquals(0, getDataTableRowCount());
    }

    @Test
    public void testCalculateChanges() throws Exception {
        setTextFieldValue("20000"); // Số tiền đã trả
        setLabelValue("15000"); // Tổng tiền

        invokeMethod("paidAmountTextFieldKeyReleased", null);

        assertEquals("5,000 đ", getLabelValue("changesNumberLabel"));
    }

    @Test
    public void testProductSelectionUpdatesPrice() throws Exception {
        setComboBoxValue("Product A");
        invokeMethod("productNameComboBoxActionPerformed", null);

        assertNotEquals("0 đ", getLabelValue("productPriceNumberLabel"));
    }

    @Test
    public void testEmptyCartShowsZeroItems() throws Exception {
        assertEquals(0, getDataTableRowCount());
    }

    // Kiểm tra không thể thêm sản phẩm nếu số lượng là 0
    @Test
    public void testAddProductWithZeroQuantity() throws Exception {
        setComboBoxValue("Product B");
        setTextFieldValue("0");
        invokeButtonClick("addProductButton");

        assertEquals(0, getDataTableRowCount());
    }

    // Kiểm tra không thể xóa một sản phẩm nếu giỏ hàng trống
    @Test
    public void testRemoveProductFromEmptyCart() throws Exception {
        invokeButtonClick("removeProductButton");

        assertEquals(0, getDataTableRowCount()); // Vẫn nên là 0
    }

    // Kiểm tra cập nhật số lượng sản phẩm
    @Test
    public void testUpdateProductQuantity() throws Exception {
        setComboBoxValue("Product A");
        setTextFieldValue("1");
        invokeButtonClick("addProductButton");

        setTextFieldValue("3");
        invokeButtonClick("updateProductButton"); // Giả sử có nút để cập nhật sản phẩm

        assertEquals("3", getDataTableValueAt(0, 3)); // Giả sử cột số lượng là 3
    }

    // =========================================
    // Utility methods using reflection
    // =========================================

    private void setComboBoxValue(String value) throws Exception {
        Field field = SalesPanel.class.getDeclaredField("productNameComboBox");
        field.setAccessible(true);
        JComboBox<String> comboBox = (JComboBox<String>) field.get(salesPanel);
        comboBox.setSelectedItem(value);
    }

    private void setTextFieldValue(String value) throws Exception {
        Field field = SalesPanel.class.getDeclaredField("quantityTextField");
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(salesPanel);
        textField.setText(value);
    }

    private void invokeButtonClick(String buttonName) throws Exception {
        Field field = SalesPanel.class.getDeclaredField(buttonName);
        field.setAccessible(true);
        JButton button = (JButton) field.get(salesPanel);
        button.doClick();
    }

    private int getDataTableRowCount() throws Exception {
        Field field = SalesPanel.class.getDeclaredField("dataTable");
        field.setAccessible(true);
        JTable table = (JTable) field.get(salesPanel);
        return table.getRowCount();
    }

    private void setLabelValue(String amount) throws Exception {
        Field field = SalesPanel.class.getDeclaredField("totalAmountNumberLabel");
        field.setAccessible(true);
        JLabel label = (JLabel) field.get(salesPanel);
        label.setText(amount);}

    private String getLabelValue(String labelName) throws Exception {
        Field field = SalesPanel.class.getDeclaredField(labelName);
        field.setAccessible(true);
        JLabel label = (JLabel) field.get(salesPanel);
        return label.getText();
    }

    private String getDataTableValueAt(int row, int column) throws Exception {
        Field field = SalesPanel.class.getDeclaredField("dataTable");
        field.setAccessible(true);
        JTable table = (JTable) field.get(salesPanel);
        return table.getValueAt(row, column).toString();
    }

    private void invokeMethod(String methodName, Object param) throws Exception {
        Method method;
        if (param == null) {
            method = SalesPanel.class.getDeclaredMethod(methodName);
        } else {
            method = SalesPanel.class.getDeclaredMethod(methodName, param.getClass());
        }
        method.setAccessible(true);
        method.invoke(salesPanel, param);
    }
}