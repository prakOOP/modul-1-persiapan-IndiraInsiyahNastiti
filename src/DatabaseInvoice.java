import java.security.PublicKey;
import java.util.ArrayList;

public class DatabaseInvoice {
    private static ArrayList<Invoice> INVOICE_DATABASE = new ArrayList();
    private static int lastId=0;

    public static ArrayList<Invoice> getInvoiceDatabase()
    {
        return INVOICE_DATABASE;
    }
    public static int getLastId()
    {
        return lastId;
    }
    public static Invoice getInvoiceById(int id)
    {
        for(Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id){
                return invoice;
            }
        }
        return null;
    }
    public static ArrayList<Invoice> getInvoiceByCustomer(int customerId)
    {
        ArrayList<Invoice> list = new ArrayList<>();
        for(Invoice invoice : INVOICE_DATABASE){
            if (invoice.getCustomer().getId() == customerId){
                list.add(invoice);
            }
            return list;
        }
        return null;
    }
    public static boolean addInvoice(Invoice invoice)
    {
        for (Invoice _invoice : INVOICE_DATABASE){
            if(_invoice.getInvoiceStatus()!=InvoiceStatus.Ongoing){
                INVOICE_DATABASE.add(_invoice);
                lastId = _invoice.getId();
                return true;

            }
        }
        return false;

    }
    public static boolean changeInvoiceStatus(int id, InvoiceStatus invoiceStatus) {
        for (Invoice _invoice : INVOICE_DATABASE) {
            if (_invoice.getId() == id && _invoice.getInvoiceStatus() == InvoiceStatus.Ongoing) {
                _invoice.setInvoiceStatus(invoiceStatus);
                return true;

            }
        }
        return false;
    }
    public static boolean removeInvoice(int id)
    {
        for (Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id){
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        return false;
    }
}
