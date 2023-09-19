import Pet from "./Pet";

const PetList = ({ pets }) => {
    const petComponents = pets.map((pet) => {
        return <Pet key={pet.id} pet={pet} />;
    });

    return <div id="pet-list">{petComponents}</div>;
};

export default PetList;
