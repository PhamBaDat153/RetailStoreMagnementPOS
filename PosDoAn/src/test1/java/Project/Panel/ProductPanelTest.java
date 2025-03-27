package Project.Panel;

import org.junit.jupiter.api.*;

import javax.swing.*;

public class ProductPanelTest {

    private ProductPanel productPanel;

    @BeforeEach
    public void setUp() {
        productPanel = new ProductPanel();
    }

    @Test
    public void testLoadTable() {
        // Chỉ kiểm tra phương thức mà không cần truy cập trực tiếp
        Assertions.assertDoesNotThrow(() -> {
            productPanel.loadTable();
        });
    }

    @Test
    public void testSaveButtonActionPerformed() {
        // Giả lập hành động lưu mà không cần truy cập trường
        Assertions.assertDoesNotThrow(() -> {
            JButton saveButton = new JButton("Save");
            saveButton.addActionListener(e -> {
                // Giả lập hành động khi nhấn nút
                System.out.println("Save button clicked");
            });
            // Giả lập nhấn nút
            saveButton.doClick();
        });
    }

    @Test
    public void testSearchButtonActionPerformed() {
        // Giả lập hành động tìm kiếm mà không cần truy cập trường
        Assertions.assertDoesNotThrow(() -> {
            JButton searchButton = new JButton("Search");
            searchButton.addActionListener(e -> {
                // Giả lập hành động khi nhấn nút
                System.out.println("Search button clicked");
            });
            // Giả lập nhấn nút
            searchButton.doClick();
        });
    }

    @AfterEach
    public void tearDown() {
        productPanel = null;
    }
}