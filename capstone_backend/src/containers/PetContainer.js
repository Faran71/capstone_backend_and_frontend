import PetList from "../components/PetList";
import PetForm from "../components/PetForm";
import { useState, useEffect } from "react";

const PetContainer = () => {
    const [pets, setPets] = useState([]);

    const fetchPets = async () => {
        const response = await fetch("http://localhost:8080/pets");
        const jsonData = await response.json();
        setPets(jsonData);
    };

    useEffect(() => {
        fetchPets();
    }, []);

    const postPet = async (newPet) => {
        const response = await fetch("http://localhost:8080/pets", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(newPet)
        });

        const savedPet = await response.json();
        setPets([...pets, savedPet]);
    };

    return (
        <>
            <PetForm postPet={postPet} />
            <PetList pets={pets} />
        </>
    );
};

export default PetContainer;
