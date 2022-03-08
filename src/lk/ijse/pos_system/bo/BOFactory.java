package lk.ijse.pos_system.bo;


import lk.ijse.pos_system.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case ADDCUSTOMER:
                return new AddNewCustomerBOImpl();
            case ADDITEM:
                return new AddNewItemBOImpl();
            case CASHIERDASHBOARD:
                return new CashierDashboardBOImpl();
            case CUSTOMERCONTROLLER:
                return new TableControllerBOImpl();
            case EDITCUSTOMER:
                return new EditCustomerBOImpl();
            case MAKEORDER:
                return new MakeOrderBOImpl();
            case MODIFYITEM:
                return new ModifyItemBOImpl();
            case MODIFYORDER:
                return new ModifyOrderBOImpl();
            case REMOVECUSTOMER:
                return new RemoveCustomerBoImpl();
            case REMOVEITEM:
                return new RemoveItemBOImpl();
            case REMOVEORDER:
                return new RemoveOrderImpl();
            case SEARCHCUSTOMER:
                return new SearchCustomerBOImpl();
            case INCOME:
                return new IncomeControllerBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
       ADDCUSTOMER,ADDITEM,CASHIERDASHBOARD,CUSTOMERCONTROLLER,EDITCUSTOMER,MAKEORDER,MODIFYITEM,MODIFYORDER, REMOVECUSTOMER,REMOVEITEM,REMOVEORDER,SEARCHCUSTOMER,INCOME
    }
}
