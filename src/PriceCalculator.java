public class  PriceCalculator implements Runnable{

    private Invoice _invoice;
    public PriceCalculator(Invoice invoice){
        _invoice = invoice;
    }
    @Override
    public void run() {
        System.out.println("Calculating invoice id:" + _invoice.getId());
        _invoice.setTotalPrice();
        System.out.println("finish calculating invoice id:"+_invoice.getId());
    }
}
