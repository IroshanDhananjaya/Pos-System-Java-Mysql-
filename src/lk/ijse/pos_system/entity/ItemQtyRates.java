package lk.ijse.pos_system.entity;

public class ItemQtyRates {
    private String itemCode;
    private int qty;

    public ItemQtyRates() {
    }

    public ItemQtyRates(String itemCode, int qty) {
        this.itemCode = itemCode;
        this.qty = qty;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
