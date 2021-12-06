import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import facade from "../ApiFacade";

const AllMovies = () => {
    const [moviesList, setMovieList] = useState([]);
    useEffect(() => {
        facade.fetchData("movies")
            .then(data => {
                setMovieList(data);
            })
    }, []);

    const [query, setQuery] = useState("");

    return (
            <div className="">
                <input className="search-bar mt-3 form-control w-50 search" type="search" placeholder="Search for a movie" aria-label="Search" onChange={event => setQuery(event.target.value)} />
                {

                    moviesList.filter(movie => {
                        if (query === '') {
                            return movie;
                        } else if (movie.title.toLowerCase().includes(query.toLowerCase())) {
                            return movie;
                        }
                    }).map((movie, index) => (
                        <div className="container movies">
                            <div className="row">
                                <div className="mt-4 card-group">
                                    <div className="search" key={index}>
                                        <h5 className="card-title">{movie.title}</h5>
                                        <Link to={`/moviepage/${movie.id}`}>
                                            <img src={`/images/${movie.images}`} className="card-img-top" alt="..." />
                                        </Link>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))
                }
            </div>
    )
}



export default AllMovies;