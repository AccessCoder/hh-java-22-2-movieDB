import {FormEvent, useState} from "react";
import axios from "axios";
import {Movie} from "../model/Movie";

export default function Frontpage(){

    const[searchName, setSearchName] = useState("")
    const[searchResult, setSearchResult] = useState<Movie>()

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
            <form onSubmit={handleSubmit}>
                <p>Search your favourite Movie</p>
                <textarea value={searchName} onChange={(e) => setSearchName(e.target.value)}/>
                <button type={"submit"}>GO!</button>
            </form>
            { searchResult ? <h1>{searchResult.Title}</h1> : <h1>Not Found</h1>}
        </>
    )
}