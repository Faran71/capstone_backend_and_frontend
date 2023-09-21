const ProductDisplay = ({product}) => {

    return(
        <div>
            <img src={product.imageUrl}/> 
            <h3>{product.name}</h3>
        </div>
    )
}

export default ProductDisplay;