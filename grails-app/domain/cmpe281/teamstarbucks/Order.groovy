package cmpe281.teamstarbucks

class Order {

    String drink
    String yourname
    String shop
    String price
    String amount
    String total
    String date

    static constraints = {
        drink blank:false
        yourname blank:false
        
    }
}
