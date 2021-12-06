import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import facade from "../ApiFacade";

const AllMovies = () => {
    const [moviesList, setMovieList] = useState([]);
    useEffect(() => {
        facade.fetchData("movie")
            .then(data => {
                setMovieList(data);
            })
    }, []);


    return (
            <div className="">
                 {moviesList.map(movie => {
                     return (
                         <div className="container movie">
                             <div className="row">
                                     <div className="mt-4 card-group">
                                        <div className="card border-0">
                                            <h5 className="card-title">{movie.title}</h5>
                                            <Link to={`/moviepage/${movie.id}`}>
                                             <img src={`/images/${movie.images}`} className="card-img-top" alt="..." />
                                                <div className="card-body">
                                                        {/*<p className="card-text">{movie.description}</p>*/}
                                                </div>
                                            </Link>
                                            </div>
                                     </div>
                             </div>
                         </div>
                     )
                 })}
            </div>
    )
}



export default AllMovies;