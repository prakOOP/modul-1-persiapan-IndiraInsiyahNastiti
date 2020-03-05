
/**
 * Enumeration class PaymentType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum PaymentType
{
    Cashless("Cashless"),
    Cash("Cash");
    private String paymentType;
    PaymentType(String paymentType){
       this.paymentType=paymentType;
    }
    public String toString(){
        return paymentType;
    }
}
