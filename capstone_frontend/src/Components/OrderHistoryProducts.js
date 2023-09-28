import { useEffect } from "react"
import "./OrderHistoryPage.css"

const OrderHistoryProducts = ({currentCustomer, allOrders}) => {
    let pastOrders;
if(currentCustomer){
    pastOrders = currentCustomer.orders.map((item) => {
         const pro = allOrders.map((temp) => {
            if(item.id === temp.order.id){
                return(
                    <div className="past-order">
                        <h3>{temp.product.name}</h3>
                        <p>Order Time: {temp.order.orderDateTime}</p>
                        <p>Quantity: {temp.quantitySold}</p>
                        <p>Total: £{temp.quantitySold*temp.product.price}</p>
                    </div>
                )
            }
        })
        console.log(item)
        return(
            <div>
                {pro}
            </div>
        )
    })
}

    
    if(currentCustomer){
        return(
            <div>
                <h1>Previous Orders</h1>
                <br></br>
                <hr></hr>
                {currentCustomer.orders.length === 0 ? <p>No Previous Orders</p>: <div>{pastOrders}</div>}
                
            </div>
        )
    } else {
        return(
            <div>
                <h1>Please Log In To see History of Orders</h1>
            </div>
        )
    }
    
}

export default OrderHistoryProducts;