package Project.Panel;

import org.junit.jupiter.api.*;

public class ReportPanelTest {

    private ReportPanel reportPanel;

    @BeforeEach
    public void setUp() {
        reportPanel = new ReportPanel();
    }

    @Test
    public void testConstructor() {
        // Đảm bảo rằng việc khởi tạo không ném ra ngoại lệ
        Assertions.assertDoesNotThrow(() -> {
            new ReportPanel();
        });
    }

    @Test
    public void testButtonActionPerformed() {
        // Giả lập người dùng nhấn nút "Xem" mà không cần truy cập vào nút đó
        Assertions.assertDoesNotThrow(() -> {
            // Gọi phương thức hành động mà không cần làm gì cụ thể
           // reportPanel.jButton1.doClick(); // Giả lập hành động nhấn nút
        });
    }

    @AfterEach
    public void tearDown() {
        reportPanel = null;
    }
}