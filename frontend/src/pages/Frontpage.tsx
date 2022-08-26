import {FormEvent, useState} from "react";
import axios from "axios";

export default function Frontpage(){

    const[searchName, setSearchName] = useState("")
    const[searchResult, setSearchResult] = useState("")

    const handleSubmit = (e:FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        axios.get("/api/movie/" + searchName)
            .then(response => response.data)
            .then(axiosResponse => setSearchResult(axiosResponse))
            .catch(error => console.error(error))
    }
    return(
        <>
        <header>Super Krasse Movie DB (SKMDB!)</header>
            <form onSubmit={(e) =>handleSubmit}>
                <p>Search your favourite Movie</p>
                <textarea value={searchName} onChange={(e) => setSearchName(e.target.value)}/>
                <button type={"submit"}>GO!</button>
            </form>
            <h1>{searchResult}</h1>
        </>
    )
}