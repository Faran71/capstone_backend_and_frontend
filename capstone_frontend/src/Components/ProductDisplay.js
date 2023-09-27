import { useEffect, useState } from "react";
import "./ProductsPage.css"

const ProductDisplay = ({product}) => {

    const [isHidden, setIsHidden] = useState(true)

    const isSoldOut = () => {
        if(product.availableQuantity === 0){
            return <p style={{color:"red"}}>Sold Out!</p>
        } 
    }

    return(
        <div className="display-individual">
                <img src={product.imageURL}/> 
                <h3>{product.name}</h3>
                <p>£{product.price}</p>
                {isSoldOut()}
                
        </div>
    )
}

export default ProductDisplay;