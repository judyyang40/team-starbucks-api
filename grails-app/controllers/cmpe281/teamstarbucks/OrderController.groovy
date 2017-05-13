package cmpe281.teamstarbucks


import grails.rest.*
import grails.converters.*

class OrderController extends RestfulController {
    static responseFormats = ['json', 'xml', 'String']
    OrderController() {
        super(Order)
    }
    def getorder() {
        if(request.JSON.yourname) {
            def order = Order.findAllByYourname(request.JSON.yourname)
            if(order)
                render order as JSON
            else    respond([])
        } else {
            respond([])
        }
    }
    def update() {
        if(request.JSON.date) {
            def order = Order.findByDate(request.JSON.date)
            if(order) {
                order.amount = request.JSON.amount
                order.drink = request.JSON.drink
                order.price = request.JSON.price
                order.shop = request.JSON.shop
                order.total = request.JSON.total
                order.save(flush: true)
            }
        }
        respond([])
    }
    def delete() {
        if(request.JSON.date) {
            def order = Order.findByDate(request.JSON.date)
            if(order) {
                order.delete(flush:true)
            }
        }
        respond([])
    }
}