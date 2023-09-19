const Pet = ({ pet }) => {
    return (
        <div className="pet">
            <h4>{pet.name}</h4>
            <p>Animal: {pet.type}</p>
            <p>Breed: {pet.breed}</p>
            <p>Age: {pet.age}</p>
        </div>
    );
};

export default Pet;
