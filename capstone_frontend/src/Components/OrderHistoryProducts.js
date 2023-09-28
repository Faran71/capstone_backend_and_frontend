import { useEffect } from "react"

const OrderHistoryProducts = ({currentCustomer, allOrders}) => {
    let pastOrders;
if(currentCustomer){
    pastOrders = currentCustomer.orders.map((item) => {
        allOrders.map((temp) => {
            if(item.id === temp.order.id)
        })
        console.log(item)
        return(
            <div>
                <p>{item.id}</p>
                <p>{item.orderDateTime}</p>
            </div>
        )
    })
}

    
    if(currentCustomer){
        return(
            <div>
                <h1>Previous Orders</h1>
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