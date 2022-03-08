package lk.ijse.pos_system.view.TM;

public class CartTM {
    private String itemCode;
    private String discription;
    private int QTY;
    private double unitPrice;
    private double Discount;
    private double total;



    public CartTM(String itemCode, String discription, int QTY, double unitPrice, double discount, double total) {
        this.itemCode = itemCode;
        this.discription = discription;
        this.QTY = QTY;
        this.unitPrice = unitPrice;
        Discount = discount;
        this.total = total;
    }

    @Override
    public String toString() {
        return "CartTM{" +
                "itemCode='" + itemCode + '\'' +
                ", discription='" + discription + '\'' +
                ", QTY='" + QTY + '\'' +
                ", unitPrice=" + unitPrice +
                ", Discount=" + Discount +
                ", total=" + total +
                '}';
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
