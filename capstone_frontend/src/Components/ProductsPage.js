import NavBar from "./NavBar";
import ProductDisplay from "./ProductDisplay";
import "./ProductsPage"
import { useNavigate, } from "react-router-dom";
import SideBar from "./SideBar";
import { useEffect, useState } from "react";

const ProductsPage = ({products, order, category,  setOrder, setCategory,originalProducts, setOriginalProducts, setProducts,setCurrentProduct, currentCustomer, setCurrentCustomer}) => {
    const navigate = useNavigate();

    const [searchInput, setSearchInput] = useState("");

    const displayProducts = products.map((product) => {
        return <div onClick={() => {setCurrentProduct(product); navigate("/OneProduct");}}><ProductDisplay product={product} /></div>;
    })

    const fetchProducts = async (searchInput) => {
        setProducts([]);

        const responseName = await fetch(`http://localhost:8080/products/search?&name=${searchInput}&category=&description=`);
        const dataName = await responseName.json()
        console.log(dataName);
        setProducts([...products,dataName]);
                

        const responseCategory = await fetch(`http://localhost:8080/products/search?&name=&category=${searchInput}&description=`);
        const dataCategory = await responseCategory.json()
        setProducts([...products,dataCategory]);

        const responseDescription = await fetch(`http://localhost:8080/products/search?&name=&category=&description=${searchInput}`);
        const dataDescription = await responseDescription.json()
        setProducts([...products,dataDescription]);


        // setProducts(products.reduce((product, curr) => {
        //     return product.includes(curr) ? product : [...product, curr];
        // }, []))
        // console.log(products);
    }

    const handleSubmit = () => {
        fetchProducts(searchInput);
    }

    
    

    const [sidebarOpen, setSideBarOpen] = useState(false);
    const handleViewSidebar = () => {
        setSideBarOpen(!sidebarOpen);
    };

    

    

    return(
        <div>
            <NavBar order={order} 
            products={products}
            setOrder={setOrder}
            currentCustomer={currentCustomer}
            setCurrentCustomer={setCurrentCustomer}
            originalProducts={originalProducts}
            setOriginalProducts={setOriginalProducts}
            setProducts={setProducts}
            />
            <div>
                <form onSubmit={handleSubmit}>
                    <input type="text" 
                    name="searchInput"
                    placeholder="Search Products..."
                    value={searchInput}
                    onChange={(e) => setSearchInput(e.target.value)}
                    />
                    <button type="submit">search</button>
                </form>
            
            </div>

            <SideBar isOpen={sidebarOpen} toggleSidebar={handleViewSidebar}/>
            
            <div className="outer">
                <div className="display">
                    {displayProducts}
                </div>
            </div>
            
        </div>
    )
}

export default ProductsPage;