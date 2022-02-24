package co.edu.unbosque.model;

/**
 * The type Transaction.
 */
public class Transaction {

    /**
     * Invoice number from csv
     */

    private String invoiceNumber;

    /**
     * Stock number of a product from csv
     */

    private String stockCode;

    /**
     * Description of the csv product
     */

    private String description;

    /**
     * Quantity of a product
     */

    private String quantity;

    /**
     * Invoice date form csv
     */

    private String invoiceDate;

    /**
     * Unit price of a sale in csv
     */

    private String unitPrice;

    /**
     * Id to identify a customer in the csv
     */

    private String customerId;

    /**
     * To identify which country the invoice is from
     */

    private String country;

    /**
     * Instantiates a new Transaction.
     *
     * @param invoiceNumber the invoice number
     * @param stockCode     the stock code
     * @param description   the description
     * @param quantity      the quantity
     * @param invoiceDate   the invoice date
     * @param unitPrice     the unit price
     * @param customerId    the customer id
     * @param country       the country
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
     * Gets invoice number.
     *
     * @return the invoice number
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * Sets invoice number.
     *
     * @param invoiceNumber the invoice number
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * Gets stock code.
     *
     * @return the stock code
     */
    public String getStockCode() {
        return stockCode;
    }

    /**
     * Sets stock code.
     *
     * @param stockCode the stock code
     */
    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets invoice date.
     *
     * @return the invoice date
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets invoice date.
     *
     * @param invoiceDate the invoice date
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * Gets unit price.
     *
     * @return the unit price
     */
    public String getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets unit price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }
}