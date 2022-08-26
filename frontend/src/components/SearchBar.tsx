import {useState} from "react";

export default function SearchBar() {

    const[searchName, setSearchName] = useState("")

    const handleSubmit = () => {

    }

    return (
        <>
            <form onSubmit={handleSubmit}>
                <p>Search your favourite Movie</p>
                <textarea value={searchName} onChange={(e) => setSearchName(e.target.value)}></textarea>
            <button type={"submit"}>GO!</button>
            </form>
        </>
    )
}