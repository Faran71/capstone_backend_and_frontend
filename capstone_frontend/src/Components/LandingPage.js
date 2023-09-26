import CategoriesBox from "./CategoriesBox";
import NavBar from "./NavBar";
import "./LandingPage.css";
import Carousel from "./Carousel";
import images from "../images";



const LandingPage = ({order, products,setProducts, setOrder,filterProducts,setFilterProducts, currentCustomer, setCurrentCustomer}) => {
 

    return(
        <div>
            <NavBar order={order} 
            products={products}
            setOrder={setOrder}
            currentCustomer={currentCustomer}
            setCurrentCustomer={setCurrentCustomer}
            setFilterProducts={setFilterProducts}
            />
            <Carousel className="carousel" images={images} />
            <CategoriesBox setProducts={setProducts}/>
        </div>
    )
}

export default LandingPage;