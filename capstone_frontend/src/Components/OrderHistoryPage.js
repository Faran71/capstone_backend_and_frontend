import NavBar from "./NavBar";

const OrderHistoryPage = ({order, setOrder, products, postOrder, putOrder, allOrders}) => {

    
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

    const handleSubmit = () => {
        order.map((item) => {
            postOrder();
            putOrder(item.productId, allOrders[allOrders.length-1], item.quantitySold );
        })
        
    }
    return(
        <div>
            <NavBar />
            <div>
                <h1>Order:</h1>
                {displayOrders}
                <button onClick={handleSubmit()}>Buy</button>
            </div>
            
        </div>
    )
}

export default OrderHistoryPage;