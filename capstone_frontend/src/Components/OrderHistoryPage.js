import { useEffect, useState } from "react";
import NavBar from "./NavBar";
import { useScroll } from "framer-motion";

const OrderHistoryPage = ({order, setOrder, products, allOrders,currentCustomer}) => {

    const [isClicked, setIsClicked] = useState(false);
    const displayOrders = order.map((item) => {
        const getProduct = products.map((temp) => {
            if (temp.id === item.productId){
                return(
                    <div>
                       <p>{temp.name}</p>
                        <p>{item.quantitySold}</p> 
                    </div>
                ) 
            }
        })
        return(
            <div>
                {getProduct}
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
            const response = await fetch(`http://localhost:8080/productsOrders/${item.productId}/${newOrder.id}/${item.quantitySold}`,{
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            })
        })
        
    }

    const handleSubmit = () => {
        putOrder();

    }

    // useEffect(() => {
    //     if(currentCustomer){

    //     }
    // },[currentCustomer])
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