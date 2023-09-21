import "./ProductsPage.css"

const ProductDisplay = ({product}) => {

    return(
        <div className="display-individual">
                <img src={product.imageURL}/> 
                <h3>{product.name}</h3>
        </div>
    )
}

export default ProductDisplay;