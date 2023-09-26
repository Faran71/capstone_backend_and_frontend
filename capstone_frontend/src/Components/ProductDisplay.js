import { useEffect, useState } from "react";
import "./ProductsPage.css"

const ProductDisplay = ({product}) => {

    const [isHidden, setIsHidden] = useState(true)

    useEffect(() => {
        if(product.availableQuantity === 0){
            setIsHidden(false);
        } else {
            setIsHidden(true);
        }

    },[product.availableQuantity])

    return(
        <div className="display-individual">
                <img src={product.imageURL}/> 
                <h3>{product.name}</h3>
                <p hidden={isHidden}>Sold Out!</p>
        </div>
    )
}

export default ProductDisplay;