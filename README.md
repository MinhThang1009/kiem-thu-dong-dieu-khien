```mermaid
flowchart TD
    A["(0) tinhPhi(double trongLuong, boolean isHoaToc)"]
    B{"(1) trongLuong <= 0"}
    C["(2) throw IllegalArgumentException Invalid"]

    D["(3) final long phuPhiHoaToc = 15000; long phiCoBan"]

    E{"(4) trongLuong <= 2"}
    F["(5) phiCoBan = 25000"]

    G{"(6) trongLuong <= 5"}
    H["(7) phiCoBan = 35000"]

    I["(8) phiCoBan = 50000"]

    J["(9) long tongPhi = phiCoBan"]

    K{"(10) isHoaToc"}
    L["(11) tongPhi = tongPhi + phuPhiHoaToc"]

    M["(12) return tongPhi"]
    N["(13) exit"]

    A --> B
    B -- T --> C
    B -- F --> D

    C --> N

    D --> E
    E -- T --> F
    E -- F --> G

    G -- T --> H
    G -- F --> I

    F --> J
    H --> J
    I --> J

    J --> K
    K -- T --> L
    K -- F --> M

    L --> M
    M --> N
