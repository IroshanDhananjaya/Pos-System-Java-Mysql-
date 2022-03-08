package lk.ijse.pos_system.view.TM;

public class CustomerTM {
    private String custID;
    private String custTitle;
    private String custName;
    private String custAddress;
    private String city;
    private String Province;
    private String postCode;

    public CustomerTM() {
    }

    public CustomerTM(String custID, String custTitle, String custName, String custAddress, String city,
                     String province, String postCode) {
        this.custID = custID;
        this.custTitle = custTitle;
        this.custName = custName;
        this.custAddress = custAddress;
        this.city = city;
        Province = province;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID='" + custID + '\'' +
                ", custTitle='" + custTitle + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", city='" + city + '\'' +
                ", Province='" + Province + '\'' +
                ", postCode='" + postCode + '\'' +
                '}';
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustTitle() {
        return custTitle;
    }

    public void setCustTitle(String custTitle) {
        this.custTitle = custTitle;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
