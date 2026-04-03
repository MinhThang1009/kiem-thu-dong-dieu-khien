package vn.kiemthu;

public class ShippingFeeCalculator {

    /**
     * Hàm tính phí vận chuyển dựa trên trọng lượng gói hàng và loại hình giao hàng
     *
     * @param trongLuong Trọng lượng của gói hàng (kg)
     * @param isHoaToc   Có chọn giao hỏa tốc hay không (true/false)
     * @return Tổng phí vận chuyển (long)
     * @throws IllegalArgumentException Nếu trọng lượng <= 0
     */
    public static long tinhPhi(double trongLuong, boolean isHoaToc) {
        // (1) Kiểm tra điều kiện trọng lượng không hợp lệ
        if (trongLuong <= 0) {
            // (2) Ném ngoại lệ
            throw new IllegalArgumentException("Invalid");
        }

        // (3) Khởi tạo cấu hình phụ phí và biến lưu phí cơ bản
        final long phuPhiHoaToc = 15000;
        long phiCoBan;

        // (4) Mốc trọng lượng từ 0 < trongLuong <= 2
        if (trongLuong <= 2) {
            // (5) Phí cơ bản là 25.000
            phiCoBan = 25000;
        } else {
            // (6) Mốc trọng lượng từ 2 < trongLuong <= 5
            if (trongLuong <= 5) {
                // (7) Phí cơ bản là 35.000
                phiCoBan = 35000;
            } else {
                // (8) Mốc trọng lượng > 5
                phiCoBan = 50000;
            }
        }

        // (9) Gán phí cơ bản vào tổng phí
        long tongPhi = phiCoBan;

        // (10) Kiểm tra nếu có chọn giao hỏa tốc
        if (isHoaToc) {
            // (11) Cộng thêm phụ phí hỏa tốc
            tongPhi = tongPhi + phuPhiHoaToc;
        }

        // (12) Trả về kết quả tổng phí vận chuyển
        return tongPhi;
    }
}
