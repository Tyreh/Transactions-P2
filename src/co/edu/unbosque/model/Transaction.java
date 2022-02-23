package co.edu.unbosque.model;

public class Transaction {

    private String invoiceNumber;
    private String stockCode;
    private String description;
    private String quantity;
    private String invoiceDate;
    private String unitPrice;
    private String customerId;
    private String country;

    /**
     *  Constructor of the class.
     * @param invoiceNumber number of a current invoice
     * @param stockCode stock code for an invoice
     * @param description partial / complete description of a invoice
     * @param quantity quantity of a current invoice
     * @param invoiceDate current date of a invoice
     * @param unitPrice unit price of a transaction
     * @param customerId customer to identify a client
     * @param country boolean to show by country
     */

    public Transaction(String invoiceNumber, String stockCode, String description, String quantity, String invoiceDate, String unitPrice, String customerId, String country) {
        this.invoiceNumber = invoiceNumber;
        this.stockCode = stockCode;
        this.description = description;
        this.quantity = quantity;
        this.invoiceDate = invoiceDate;
        this.unitPrice = unitPrice;
        this.customerId = customerId;
        this.country = country;
    }

    /**
     * get invoicenumber method
     * @return invoice number
     */

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * set invoicenumber method
     * @param invoiceNumber invoicenumber to set
     */

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * get stockcode method
     * @return stockcode
     */

    public String getStockCode() {
        return stockCode;
    }

    /**
     * set stockcode method
     * @param stockCode stockcode to set
     */

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * get Description method
     * @return description
     */

    public String getDescription() {
        return description;
    }

    /**
     * set description method
     * @param description description to set
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get quantity method
     * @return quantity
     */

    public String getQuantity() {
        return quantity;
    }

    /**
     * set quantity method
     * @param quantity quantity to set
     */

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * get invoicedate method
     * @return invoice date
     */

    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * set invoice date method
      * @param invoiceDate invoicedate string to set
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * get unit price method
     * @return unit price
     */

    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * set unit price method
     * @param unitPrice unit price to set
     */

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * get customerid method
     * @return customerid
     */


    public String getCustomerId() {
        return customerId;
    }

    /**
     * set customerid method
     * @param customerId customerid to set
     */

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * get country method
     * @return country
     */

    public String getCountry() {
        return country;
    }

    /**
     * set country method
     * @param country country to set
     */

    public void setCountry(String country) {
        this.country = country;
    }
}