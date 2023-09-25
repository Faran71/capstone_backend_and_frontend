import { useState } from "react";
import NavBar from "./NavBar";
import "./OneProductPage.css"

const OneProductPage = ({currentProduct, order, setOrder, products}) => {

    const [tempQuantity, setTempQuantity] = useState("");

    const handleFormSubmit = (event) => {
        event.preventDefault();
        if(tempQuantity!==""){
            let tempOrder = {
                productId : currentProduct.id,
                quantitySold: tempQuantity,
            }
            setOrder([...order,tempOrder]);
        }
    }
    
    return(
        <div>
            <NavBar order={order} products={products}/>
            <div className="oneproduct">
                <div>
                    <h2>{currentProduct.name}</h2>
                    <img src={currentProduct.imageURL} />
                    <p>Price: £{currentProduct.price}</p>
                    <form onSubmit={handleFormSubmit}>
                        <input type="number" 
                        min={0}
                        name="quantity"
                        placeholder="Quantity"
                        value={tempQuantity}
                        onChange={(e) => setTempQuantity(e.target.value)}
                        />

                        <button type="submit">Buy</button>
                    </form>
                </div>
                <div>
                    <p>{currentProduct.description}</p>
                </div>
            </div>
            
        </div>
    )
}

export default OneProductPage;