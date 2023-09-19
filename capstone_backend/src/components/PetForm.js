import { useState } from "react";
const PetForm = ({ postPet }) => {
    const [statePet, setStatePet] = useState({
        name: "",
        type: "",
        breed: "",
        age: 0
    });

    const handleChange = (e) => {
        let propertyName = e.target.name;
        let clonedPet = { ...statePet };
        clonedPet[propertyName] = e.target.value;
        setStatePet(clonedPet);
    };

    const handleFormSubmit = (e) => {
        e.preventDefault();
        postPet(statePet);
        setStatePet({
            name: "",
            type: "",
            breed: "",
            age: 0
        });
    };

    return (
        <form id="pet-form" onSubmit={handleFormSubmit}>
            <h3>Add a new pet</h3>
            <label htmlFor="pet-name">Pet Name:</label>
            <input
                id="pet-name"
                name="name"
                type="text"
                value={statePet.name}
                onChange={handleChange}
            />
            <label htmlFor="pet-type">Pet Type:</label>
            <input
                id="pet-type"
                name="type"
                type="text"
                value={statePet.type}
                onChange={handleChange}
            />
            <label htmlFor="pet-breed">Pet Breed:</label>
            <input
                id="pet-breed"
                name="breed"
                type="text"
                value={statePet.breed}
                onChange={handleChange}
            />
            <label htmlFor="pet-age">Pet Age:</label>
            <input
                id="pet-age"
                name="age"
                type="number"
                value={statePet.age}
                onChange={handleChange}
            />

            <input type="submit" value="Add Pet" />
        </form>
    );
};

export default PetForm;
