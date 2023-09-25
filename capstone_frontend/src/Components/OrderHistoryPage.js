import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import { useScroll } from "framer-motion";

const OrderHistoryPage = ({order, setOrder, products, allOrders,currentCustomer}) => {

    const [isClicked, setIsClicked] = useState(false);
    const displayOrders = order.map((item) => {
        return(
            <div>
                <p>{item.product.name}-{item.quantitySold}</p>
                
            </div>
        )
    })

    // const postOrder = async () => {
        
    // }

    const putOrder = async () => {
        const newOrderResponse = await fetch(`http://localhost:8080/orders/createOrder/${currentCustomer.id}`,{
            method: "POST",
            headers: {"Content-Type": "application/json"},
        })
        const newOrder = await newOrderResponse.json();

        order.forEach(async (item) => {
            const response = await fetch(`http://localhost:8080/productsOrders/${item.product.id}/${newOrder.id}/${item.quantitySold}`,{
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            })
        })
        
    }

    const handleSubmit = () => {
        putOrder();

    }

    return(
        <div>
            <NavBar order={order} products={products}/>
            <div>
                <h1>Order:</h1>
                {displayOrders}
                <button onClick={handleSubmit}>Buy</button>
            </div>
            
        </div>
    )
}

export default OrderHistoryPage;