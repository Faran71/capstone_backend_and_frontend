import { useEffect } from "react"

const OrderHistoryProducts = ({currentCustomer}) => {
    let pastOrders;
if(currentCustomer){
    pastOrders = currentCustomer.orders.map((item) => {
        console.log(item)
        return(
            // <p>hi</p>
            <div>
                {/* <p>hi</p> */}
                <p>{item.id}</p>
                <p>{item.orderDateTime}</p>
            </div>
        )
    })
}




    // useEffect(() => {
    //     showOldOrders()
    // },[currentCustomer])
    
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