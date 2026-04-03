package vn.kiemthu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Lớp kiểm thử cho hàm tính phí vận chuyển (ShippingFeeCalculator)
 * Áp dụng độ phủ điều khiển C2 (Branch Coverage - Cả hai nhánh đúng/sai của mỗi điều kiện đều được thực thi)
package vn.kiemthu;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Lớp kiểm thử cho hàm tính phí vận chuyển (ShippingFeeCalculator)
 * Áp dụng độ phủ điều khiển C2 (Branch Coverage - Cả hai nhánh đúng/sai của mỗi điều kiện đều được thực thi)
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ShippingFeeCalculatorTest {

    private static final List<String> results = new ArrayList<>();

    @BeforeAll
    static void setUp() {
        System.out.println("Kết quả kiểm thử:\n");
        System.out.printf("%-4s | %-32s | %-35s | %-35s | %-6s%n", "STT", "Test", "Expected Output", "Actual Output", "Result");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
    }

    @AfterAll
    static void tearDown() {
        for (String result : results) {
            System.out.println(result);
        }
    }

    @Test
    @Order(1)
    @DisplayName("STT 1: Path 1(T) 2 - trongLuong=0, isHoaToc=false -> IllegalArgumentException")
    void testTrongLuongKhongHopLe() {
        double trongLuong = 0.0;
        boolean isHoaToc = false;

        String testInput = "trongLuong = 0, isHoaToc = false";
        String expectedOut = "IllegalArgumentException(\"Invalid\")";
        String actualOut = "";
        String status = "Fail";

        try {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                ShippingFeeCalculator.tinhPhi(trongLuong, isHoaToc);
            });
            assertEquals("Invalid", exception.getMessage());
            actualOut = "IllegalArgumentException(\"Invalid\")";
            status = "Pass";
        } catch (Throwable t) {
            actualOut = t.getClass().getSimpleName();
            throw t;
        } finally {
            results.add(String.format("%-4d | %-32s | %-35s | %-35s | %-6s", 1, testInput, expectedOut, actualOut, status));
        }
    }

    @Test
    @Order(2)
    @DisplayName("STT 2: Path 1(F) 3 4(T) 5 9 10(T) 11 12 - trongLuong=2, isHoaToc=true -> 40000")
    void testTrongLuongNhoHon2_GiaoHoaToc() {
        double trongLuong = 2.0;
        // Chú ý: Tại đề bài test case số 2 có typo là isHoaToc=false, nhưng với kết quả mong muốn 40.000 
        // và Path ghi là 10(T) (nghĩa là chọn giao hỏa tốc = true), thì giá trị đúng phải là true.
        boolean isHoaToc = true; 
        
        long expectedOutVal = 40000;
        String testInput = "trongLuong = 2, isHoaToc = true";
        String expectedOut = "40000";
        String actualOutStr = "";
        String status = "Fail";
        
        try {
            long actualOut = ShippingFeeCalculator.tinhPhi(trongLuong, isHoaToc);
            actualOutStr = String.valueOf(actualOut);
            assertEquals(expectedOutVal, actualOut);
            status = "Pass";
        } catch (Throwable t) {
            actualOutStr = t.getClass().getSimpleName();
            throw t;
        } finally {
            results.add(String.format("%-4d | %-32s | %-35s | %-35s | %-6s", 2, testInput, expectedOut, actualOutStr, status));
        }
    }

    @Test
    @Order(3)
    @DisplayName("STT 3: Path 1(F) 3 4(F) 6(T) 7 9 10(F) 12 - trongLuong=5, isHoaToc=false -> 35000")
    void testTrongLuongNhoHon5_GiaoThuong() {
        double trongLuong = 5.0;
        boolean isHoaToc = false;

        long expectedOutVal = 35000;
        String testInput = "trongLuong = 5, isHoaToc = false";
        String expectedOut = "35000";
        String actualOutStr = "";
        String status = "Fail";
        
        try {
            long actualOut = ShippingFeeCalculator.tinhPhi(trongLuong, isHoaToc);
            actualOutStr = String.valueOf(actualOut);
            assertEquals(expectedOutVal, actualOut);
            status = "Pass";
        } catch (Throwable t) {
            actualOutStr = t.getClass().getSimpleName();
            throw t;
        } finally {
            results.add(String.format("%-4d | %-32s | %-35s | %-35s | %-6s", 3, testInput, expectedOut, actualOutStr, status));
        }
    }

    @Test
    @Order(4)
    @DisplayName("STT 4: Path 1(F) 3 4(F) 6(F) 8 9 10(T) 11 12 - trongLuong=6, isHoaToc=true -> 65000")
    void testTrongLuongLonHon5_GiaoHoaToc() {
        double trongLuong = 6.0;
        boolean isHoaToc = true;

        long expectedOutVal = 65000;
        String testInput = "trongLuong = 6, isHoaToc = true";
        String expectedOut = "65000";
        String actualOutStr = "";
        String status = "Fail";
        
        try {
            long actualOut = ShippingFeeCalculator.tinhPhi(trongLuong, isHoaToc);
            actualOutStr = String.valueOf(actualOut);
            assertEquals(expectedOutVal, actualOut);
            status = "Pass";
        } catch (Throwable t) {
            actualOutStr = t.getClass().getSimpleName();
            throw t;
        } finally {
            results.add(String.format("%-4d | %-32s | %-35s | %-35s | %-6s", 4, testInput, expectedOut, actualOutStr, status));
        }
    }
}
