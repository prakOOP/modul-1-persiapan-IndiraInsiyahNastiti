package MarwahZulfannyAlief.jfood;
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
    public static Invoice getInvoiceById(int id) throws InvoiceNotFoundException
    {
        for(Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id){
                return invoice;
            }
        }
        throw new InvoiceNotFoundException(id);
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
    public static boolean addInvoice(Invoice invoice) throws OngoingInvoiceAlreadyExistsException
    {
        for (Invoice _invoice : INVOICE_DATABASE){
            if(_invoice.getInvoiceStatus().equals(InvoiceStatus.Ongoing) && _invoice.getCustomer().getId() == invoice.getCustomer().getId()){
                throw new OngoingInvoiceAlreadyExistsException(invoice);
            }
        }
        INVOICE_DATABASE.add(invoice);
        lastId = invoice.getId();
        return true;

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
    public static boolean removeInvoice(int id) throws InvoiceNotFoundException
    {
        for (Invoice invoice : INVOICE_DATABASE){
            if (invoice.getId() == id){
                INVOICE_DATABASE.remove(invoice);
                return true;
            }
        }
        throw new InvoiceNotFoundException(id);
    }
}
